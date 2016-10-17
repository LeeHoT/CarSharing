package com.sharing.dao;

import com.sharing.entities.User;
import com.sharing.entities.dto.LoginDto;

/**
 * 用于用户进行登录，登录只需输入用户名密码，，正确后即可登录
 * 
 * @author leehot
 *
 */
public interface LoginDao {

	/**
	 * 用户登录方法
	 * 
	 * @param loginDto
	 *            登录信息的数据传输对象
	 * @return 返回当前登录用户的基本信息
	 */
	public User login(LoginDto loginDto);

}
