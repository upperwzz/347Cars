package com.mysql.cars.model;

import java.io.Serializable;


/**
 * service 鍎屽儴鍎栧儖鍎斿儣.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Service implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** userid. */
	private Integer userid;

	/** username. */
	private String username;

	/** zhaopian. */
	private String zhaopian;

	/** pingpaiming. */
	private String pingpaiming;

	/** xilie. */
	private String xilie;

	/** baoxian. */
	private String baoxian;

	/** fuzeren. */
	private String fuzeren;

	/**
	 * 鍍愬劄鍍楀儵鍎斿儖鍍�.
	 */
	public Service() {
	}

	/**
	 * userid 鍌劃鎺曞仧鍌戝仭.
	 * 
	 * @param userid
	 *            userid
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * userid 鍌孩鎽煎仧鍌戝仭.
	 * 
	 * @return userid
	 */
	public Integer getUserid() {
		return this.userid;
	}

	/**
	 * username 鍌劃鎺曞仧鍌戝仭.
	 * 
	 * @param username
	 *            username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * username 鍌孩鎽煎仧鍌戝仭.
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * zhaopian 鍌劃鎺曞仧鍌戝仭.
	 * 
	 * @param zhaopian
	 *            zhaopian
	 */
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}

	/**
	 * zhaopian 鍌孩鎽煎仧鍌戝仭.
	 * 
	 * @return zhaopian
	 */
	public String getZhaopian() {
		return this.zhaopian;
	}

	/**
	 * pingpaiming 鍌劃鎺曞仧鍌戝仭.
	 * 
	 * @param pingpaiming
	 *            pingpaiming
	 */
	public void setPingpaiming(String pingpaiming) {
		this.pingpaiming = pingpaiming;
	}

	/**
	 * pingpaiming 鍌孩鎽煎仧鍌戝仭.
	 * 
	 * @return pingpaiming
	 */
	public String getPingpaiming() {
		return this.pingpaiming;
	}

	/**
	 * xilie 鍌劃鎺曞仧鍌戝仭.
	 * 
	 * @param xilie
	 *            xilie
	 */
	public void setXilie(String xilie) {
		this.xilie = xilie;
	}

	/**
	 * xilie 鍌孩鎽煎仧鍌戝仭.
	 * 
	 * @return xilie
	 */
	public String getXilie() {
		return this.xilie;
	}

	/**
	 * baoxian 鍌劃鎺曞仧鍌戝仭.
	 * 
	 * @param baoxian
	 *            baoxian
	 */
	public void setBaoxian(String baoxian) {
		this.baoxian = baoxian;
	}

	/**
	 * baoxian 鍌孩鎽煎仧鍌戝仭.
	 * 
	 * @return baoxian
	 */
	public String getBaoxian() {
		return this.baoxian;
	}

	/**
	 * fuzeren 鍌劃鎺曞仧鍌戝仭.
	 * 
	 * @param fuzeren
	 *            fuzeren
	 */
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}

	/**
	 * fuzeren 鍌孩鎽煎仧鍌戝仭.
	 * 
	 * @return fuzeren
	 */
	public String getFuzeren() {
		return this.fuzeren;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Service other = (Service) obj;
		if (userid == null) {
			if (other.userid != null) {
				return false;
			}
		} else if (!userid.equals(other.userid)) {
			return false;
		}

		return true;
	}

	public void setFuzeren(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public void setBaoxain(String baoxian2) {
		// TODO Auto-generated method stub
		
	}

}