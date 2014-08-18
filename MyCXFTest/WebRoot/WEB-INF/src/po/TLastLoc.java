package po;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * TLastLoc entity. @author MyEclipse Persistence Tools
 */

public class TLastLoc implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer deviceId;
	private Timestamp gpstime;
	private BigDecimal lng;
	private BigDecimal lat;
	private BigDecimal speed;
	private BigDecimal power;
	private String address;
	private Timestamp createtime;
	private String reserve1;
	private String reserve2;
	private Integer locationType;
	private BigDecimal status;
	private BigDecimal OLat;
	private BigDecimal OLng;

	// Constructors

	/** default constructor */
	public TLastLoc() {
	}

	/** minimal constructor */
	public TLastLoc(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TLastLoc(Integer id, Integer deviceId, Timestamp gpstime, BigDecimal lng, BigDecimal lat, BigDecimal speed, BigDecimal power,
			String address, Timestamp createtime, String reserve1, String reserve2, Integer locationType, BigDecimal status, BigDecimal OLat,
			BigDecimal OLng) {
		this.id = id;
		this.deviceId = deviceId;
		this.gpstime = gpstime;
		this.lng = lng;
		this.lat = lat;
		this.speed = speed;
		this.power = power;
		this.address = address;
		this.createtime = createtime;
		this.reserve1 = reserve1;
		this.reserve2 = reserve2;
		this.locationType = locationType;
		this.status = status;
		this.OLat = OLat;
		this.OLng = OLng;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTDevice() {
		return this.deviceId;
	}

	public void setTDevice(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Timestamp getGpstime() {
		return this.gpstime;
	}

	public void setGpstime(Timestamp gpstime) {
		this.gpstime = gpstime;
	}

	public BigDecimal getLng() {
		return this.lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getSpeed() {
		return speed;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	public BigDecimal getPower() {
		return power;
	}

	public void setPower(BigDecimal power) {
		this.power = power;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getReserve1() {
		return this.reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return this.reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public Integer getLocationType() {
		return this.locationType;
	}

	public void setLocationType(Integer locationType) {
		this.locationType = locationType;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getOLat() {
		return this.OLat;
	}

	public void setOLat(BigDecimal OLat) {
		this.OLat = OLat;
	}

	public BigDecimal getOLng() {
		return this.OLng;
	}

	public void setOLng(BigDecimal OLng) {
		this.OLng = OLng;
	}

}