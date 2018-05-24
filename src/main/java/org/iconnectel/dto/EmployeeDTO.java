package org.iconnectel.dto;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by lahirue on 5/22/18.
 */

//@Table (name="USER_DETAILS") // adding specific name to the table name instead of class name
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EmployeeDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
	private int age;
	@Transient // not going to add into the table
	private String address;

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
