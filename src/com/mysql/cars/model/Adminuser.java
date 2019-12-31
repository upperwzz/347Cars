package com.mysql.cars.model;

import java.io.Serializable;

/**
 * Adminuser 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Adminuser implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** userid. */
	private Integer userid;

	/** username. */
	private String username;

	/** password. */
	private String password;

	/**
	 * 僐儞僗僩儔僋�?.
	 */
	public Adminuser() {
	}

	/**
	 * userid 傪愝掕偟傑偡.
	 * 
	 * @param userid
	 *            userid
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * userid 傪庢摼偟傑偡.
	 * 
	 * @return userid
	 */
	public Integer getUserid() {
		return this.userid;
	}

	/**
	 * username 傪愝掕偟傑偡.
	 * 
	 * @param username
	 *            username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * username 傪庢摼偟傑偡.
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * password 傪愝掕偟傑偡.
	 * 
	 * @param password
	 *            password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * password 傪庢摼偟傑偡.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return this.password;
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
		Adminuser other = (Adminuser) obj;
		if (userid == null) {
			if (other.userid != null) {
				return false;
			}
		} else if (!userid.equals(other.userid)) {
			return false;
		}

		return true;
	}

}
