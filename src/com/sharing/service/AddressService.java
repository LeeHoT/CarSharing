package com.sharing.service;

import java.util.List;

import com.sharing.entities.dto.AddressDto;

public interface AddressService {

	public int saveAddress(AddressDto addressDto);

	public int deleteAddress(int id);

	public int updateAddress(AddressDto addressDto);

	/**
	 * 根据用户id查询地址信息
	 * @param userId
	 * @return  返回当前用户所有的地址信息
	 */
	public List<AddressDto> selectAddressById(int userId);
	
	/**
	 * 查询地址信息,供管理员使用
	 * @return  返回所有用户的所有的地址信息
	 */
	public List<AddressDto> selectAddress();

}
