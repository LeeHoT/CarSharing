package com.sharing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sharing.dao.AddressDao;
import com.sharing.entities.Address;
import com.sharing.entities.dto.AddressDto;
import com.sharing.service.AddressService;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	@Autowired
	private Address address;
	@Autowired
	private AddressDto addressDto;

	@Override
	public int saveAddress(AddressDto addressDto) {
		System.out.println(address);
		//默认设置为默认地址
		address.setDefault(true);
		// 检查用户是否拥有地址
		List<Address> list = addressDao.selectAddressByUserId(addressDto.getUserId());
		if (list.size() > 0) {
			System.out.println("设置地址为非默认地址");
			// 如果已经有地址，则不设置为默认地址
			address.setDefault(false);
			;
		}
		// 查询省份id
		int provinceId = addressDao.selectProvinceId(addressDto.getProvince());
		// 查询城市id
		int cityId = addressDao.selectCityId(addressDto.getCity());
		address.setUserId(addressDto.getUserId());
		address.setProvinceId(provinceId);
		address.setCityId(cityId);
		address.setDetailAdd(addressDto.getDetailAdd());
		int res = addressDao.saveAddress(address);
		return res;
	}

	@Override
	public int updateAddress(AddressDto addressDto) {
		addressDao.updateAddress(address);
		return 0;
	}

	@Override
	public List<AddressDto> selectAddressById(int userId) {
		List<Address> list = addressDao.selectAddressByUserId(userId);
		List<AddressDto> listD = new ArrayList<AddressDto>() ;
		for (Address add : list) {
			addressDto = new AddressDto();
			addressDto.setId(add.getId());
			addressDto.setUserId(add.getUserId());
			addressDto.setDefault(add.isDefault());
			addressDto.setProvince(addressDao.selectProvinceById(add.getProvinceId()));
			addressDto.setCity(addressDao.selectCityById(add.getCityId()));
			addressDto.setDetailAdd(add.getDetailAdd());
			listD.add(addressDto);
		}
		
		return listD;
	}

	@Override
	public int deleteAddress(int id) {
		// 检查数据库中书否存在该地址
		int addId = addressDao.selectAddressId(id);
		System.out.println("当前请求地址的id : " + addId);
		if (addId <= 0) {
			System.out.println("当前地址不存在");
			return -1;
		}
		int res = addressDao.deleteAddress(id);
		return res;
	}

	@Override
	public List<AddressDto> selectAddress() {
		List<Address> list = addressDao.selectAddress();
		List<AddressDto> listD = new ArrayList<>();
		for (Address add : list) {
			addressDto.setId(add.getId());
			
			addressDto.setUserId(add.getUserId());
			addressDto.setDefault(add.isDefault());
			addressDto.setProvince(addressDao.selectProvinceById(add.getProvinceId()));
			addressDto.setCity(addressDao.selectCityById(add.getCityId()));
			addressDto.setDetailAdd(add.getDetailAdd());
			listD.add(addressDto);
		}
		
		return listD;
	}

}
