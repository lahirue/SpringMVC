package org.iconnectel.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lahirue on 5/22/18.
 */
@Entity
public class UserDetails {

	@Id
	private int userId;
	private String userName;

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
