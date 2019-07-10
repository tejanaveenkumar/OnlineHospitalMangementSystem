package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="usrtab")
public class User {
    @Id
	@GeneratedValue(generator="usrgen")
	@GenericGenerator(name="usrgen",strategy="increment")
    @Column(name = "user_id")
	private Integer userId;
	@Column(name = "name")
	private String userName;
	@Column(name = "email",unique=true)
	private String userEmail;
	@Column(name = "password")
	private String userPwd;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="usr_roles_tab1",joinColumns=@JoinColumn(name="uidFk"))
	@Column(name="roleName")
	private Set<String> roles=new HashSet<String>(0);
	public User() {
		super();
	}
	public User(Integer userId) {
		super();
		this.userId = userId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public User(Integer userId, String userName, String userEmail, String userPwd, Set<String> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPwd=" + userPwd
				+ ", roles=" + roles + ", getUserId()=" + getUserId() + ", getUserName()=" + getUserName()
				+ ", getUserEmail()=" + getUserEmail() + ", getUserPwd()=" + getUserPwd() + ", getRoles()=" + getRoles()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
