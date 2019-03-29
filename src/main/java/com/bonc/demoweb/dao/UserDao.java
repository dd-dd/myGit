package com.bonc.demoweb.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Title: UserDao</p>
 * <p>Description: </p>
 * @author zwd
 * @date 2018年10月10日
 */
@Mapper
public interface UserDao {

	/**
	 * <p>Title: getUserName</p>
	 * <p>Description: </p>
	 * @return
	 */
	String getUserName();

}
