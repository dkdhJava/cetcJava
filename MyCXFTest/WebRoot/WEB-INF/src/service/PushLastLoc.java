/**
 * 
 */
package service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;
import po.TLastLoc;
import dao.LastLocationDao;


public class PushLastLoc {
	
	public static long gpsTime = 0;

	public static class PushLastLocation extends EventPullSource implements Serializable {

		private static final long serialVersionUID = -1763858663525225516L;

		protected long getSleepTime() {
			return 5000;
		}

		protected Event pullEvent() {
			Event event = Event.createDataEvent("/changedLastLoc");
			LastLocationDao lldao = new LastLocationDao();
			String data = "";
			TLastLoc lastLoc;
			lastLoc = lldao.getLastLoc("13739796488");

			try {
				
				if (gpsTime == 0l) {
					gpsTime = lastLoc.getGpstime().getTime();
					data = "0";
					event.setField("hw", data);
				} else {
					
					if (gpsTime != lastLoc.getGpstime().getTime()) {
						data = lastLoc.getOLng() + "," + lastLoc.getOLat();
						gpsTime = lastLoc.getGpstime().getTime();
					} else {
						data = "0";
					}
				}
				data = new String(data.getBytes("UTF-8"), ("ISO-8859-1"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				data = "Error";
			}
			event.setField("hw", data);
			return event;
		}

	}
}
