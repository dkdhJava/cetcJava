$(document).ready(function(){
    initialize();
   
});

var map = null;
var mapcenter = null;

function initialize() {
  mapcenter = new google.maps.LatLng(13.75, 100.51666);
  var mapOptions = {
      center: mapcenter,
      zoom: 8,
      mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);
  PL._init();
  PL.joinListen('/changedLastLoc');
}

function onData(event) {
	var data = event.get('hw');
	if(data != "0")
	{
		addUserMarker(data);
	}
  }

function findPoi(type){
  var request = {
    location: mapcenter,
    radius: '500',
    types: [type]
  };

  service = new google.maps.places.PlacesService(map);
  service.search(request, findPoicallback);
}

var markersArray = [];

function clearOverlays() {
  if (markersArray) {
    for (i in markersArray) {
      markersArray[i].setMap(null);
    }
  }
}

function findPoicallback(results, status) {
  if (status == google.maps.places.PlacesServiceStatus.OK) {
    clearOverlays();
    markersArray = [];
    for (var i = 0; i < results.length; i++) {
      var place = results[i];
      createMarker(results[i]);
    }
  }
  else
  {
    if (status == google.maps.places.PlacesServiceStatus.ZERO_RESULTS) {
      alert('Sorry,No Results.');
    };
    if(status == google.maps.places.PlacesServiceStatus.UNKNOWN_ERROR){
      alert('google server cannot be reached');
    }
  }
}


var curMarker = null;
function createMarker(result){
  var marker = new google.maps.Marker({
      position: result.geometry.location,
      map: map
  });
  markersArray.push(marker);
  marker.setMap(map);
  google.maps.event.addListener(marker, 'click', function(){
    curMarker = marker;
    var request = {
      reference: result.reference
    };
    service = new google.maps.places.PlacesService(map);
    service.getDetails(request, findDetailscallback);
  });
}

function findDetailscallback(place, status) {
    if (status == google.maps.places.PlacesServiceStatus.OK) {
      var contentHTML = '<div id="content"><p>NAME:'+place.name+'</p><p>ADDR:'+place.formatted_address+'></p><p>PHONE:'+place.international_phone_number+'</p></div>'
      var infowindow = new google.maps.InfoWindow({
          content: contentHTML
      });
      infowindow.close();
      infowindow.open(map,curMarker);
    }
}

function searchUserLoc(){
	var phoneNum=$("#phoneNum").val();
	$.ajax({  
		url:"/EasyToTravel/GetLastLocation", 
		dataType:"json",
		type: "get",
		data:"phoneNum="+phoneNum,
		success:addUserMarker,
		error:ajaxOnError
	});
}
function addUserMarker(data){
	var point=data;
	var lat=point.split(",")[1];
	var lng=point.split(",")[0];
	mapcenter = new google.maps.LatLng(lat, lng);
	map.panTo(mapcenter);
	map.setZoom(16);
	var marker = new google.maps.Marker({
	      position: mapcenter,
	      map: map
	  });
	marker.setMap(map);
	var contentHTML = '<div id="content"><button>接听</button><button>忽略</button></div>'
    var infowindow = new google.maps.InfoWindow({
        content: contentHTML
    });
    infowindow.close();
    infowindow.open(map,marker);
}
function ajaxOnError(error){	
	alert("ajax fails"+error);
}

