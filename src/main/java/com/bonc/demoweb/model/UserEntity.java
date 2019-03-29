package com.bonc.demoweb.model;

import java.util.List;

/**
 * <p>Title: UserEntity</p>
 * <p>Description: </p>
 * @author zwd
 * @date 2018年10月11日
 */
public class UserEntity {
	private String userName;
	private String password;
	private List<UserEntity> userList;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<UserEntity> getUserList() {
		return userList;
	}
	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}
	

}
