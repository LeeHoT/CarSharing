package com.sharing.dao;

import java.util.List;

import com.sharing.entities.Address;
import com.sharing.entities.City;

public interface AddressDao {
	
	/**
	 * 添加地址信息，如果地址该用户已存在地址，则不再设置为默认地址，若没有旧地址，则设置为默认地址。
	 * provinceId cityId 均从数据库中取得
	 * @param addressDto  添加的地址的数据传输对象
	 * @return   返回更新行数
	 */
	public int saveAddress(Address address);
	
	/**
	 * 根据地址的id删除相应的地址，因地址id唯一，故未与用户id作为共同条件
	 * @param id  地址id
	 * @return  返回更新的行数 > 0 则表明删除成功
	 */
	public int deleteAddress(int id);//id为地址id
	
	/**
	 * 根据地址的id，有选择新的更新地址信息
	 * @param addressDto  
	 * @param id  地址id
	 * @return  返回更新的行数
	 */
	public int updateAddress(Address address);
	
	/**
	 * 根据用户id查询用户的所有地址
	 * @param userId 当前用户id
	 * @return 用户地址list对象
	 */
	public List<Address> selectAddressByUserId(int userId);
	
	/**
	 * 主要用户管理员查询所有用户的地址信息，且该功能仅供管理员使用
	 * @return  返回所有用户的地址信息的list对象
	 */
	public List<Address> selectAddress(); 
	
	/**
	 * 检测当前数据库中是否存在id未  id  的地址信息, 保证update的准确性
	 * @param id
	 * @return  若存在，返回当前id，否则返回空
	 */
	public int selectAddressId(int id);
	
	/**
	 * 根据省份名查询省份id
	 * @param province  string 省份名
	 * @return  省份名对应的id
	 */
	public int selectProvinceId(String province);
	
	/**
	 * 根据省份id查询省份名
	 * @param provinceId  int型   省份id
	 * @return  id对应的省份名
	 */
	public String selectProvinceById(int provinceId);
	/**
	 * 根据城市名查询城市id
	 * @param province  string 城市名
	 * @return  城市名对应的id
	 */
	public int selectCityId(String city);
	
	/**
	 * 根据城市id查询城市名
	 * @param cityId  int型   城市id
	 * @return  id对应的城市名
	 */
	public String selectCityById(int cityId);
	
	/**
	 * 根据身份名查询城市名
	 * @param provinceId
	 * @return
	 */
	public List<City> selectCityByProvinceId(int provinceId);
	
	


}
