package com.sharing.dao;

import com.sharing.entities.dto.CarDto;
import com.sharing.entities.dto.RegisterDto;

/**
 * 用户注册所需要的方法，共有三个方法
 * 1. 保存用户基本信息
 * 2. 获取User表中最大的id值,即为当前注册用户的id
 * 3. 保存用户汽车信息
 * @author leehot(李慧婷)
 *
 */
public interface RegisterDao {
	
	/**
	 * 添加用户基本信息
	 * @param registerDto  注册信息的数据传输对象
	 * @return  true 添加成功   false 添加失败
	 */
	public boolean saveUserInfo(RegisterDto registerDto);
	/**
	 * 直接查询最新插入的最大id值，后
	 * @return 返回当前注册用户的id 
	 */
	public int selectUserId();
	
	/**
	 * 添加当前注册用户的车辆信息
	 * @param registerDto  注册信息的数据传输对象
	 * @param userId  当前注册用户的id,由selectUserId获取
	 * @return  大于0 添加成功  否则添加失败
	 */
	public int saveCarInfo(CarDto carDto);

}
