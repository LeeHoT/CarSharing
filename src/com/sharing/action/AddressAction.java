package com.sharing.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharing.entities.dto.AddressDto;
import com.sharing.service.AddressService;

@Controller("addressAction")
public class AddressAction extends ActionSupport {

	@Autowired
	private AddressService addressService;
	private AddressDto addressDto;
	private Integer id;
	private List<AddressDto> list = new ArrayList<AddressDto>();

	public List<AddressDto> getList() {
		return list;
	}

	public void setList(List<AddressDto> list) {
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	private static final long serialVersionUID = 3986921179603045428L;

	public String addAddress() {
		int res = addressService.saveAddress(addressDto);

		if (res > 0) {
			System.out.println("添加地址成功");
			return SUCCESS;
		} else {
			System.out.println("添加地址失败");
			return INPUT;
		}
	}

	public String deleteAddress() {
		int res = addressService.deleteAddress(id);
		if (res > 0) {
			System.out.println("删除地址成功");
			return SUCCESS;
		} else {
			System.out.println("删除地址失败");
			return INPUT;
		}
	}

	public String changeAddress() {
		int res = addressService.updateAddress(addressDto);
		if (res > 0) {
			System.out.println("更新地址成功");
			return SUCCESS;
		} else {
			System.out.println("更新地址失败");
			return INPUT;
		}
	}

	public String selectAddress() {
		System.out.println(addressService);
		System.out.println(addressDto);
		System.out.println("00000000" + list.size());
		list = addressService.selectAddressById(addressDto.getUserId());
		for (AddressDto l : list) {
			System.out.println("action detailadd" + l.getDetailAdd());
		}
		System.out.println("当前用户" + addressDto.getUserId() + "有" + list.size() + "个地址");
		return SUCCESS;
	}

	public String setDefaultAddress() {
		System.out.println("设置默认地址成功");
		return SUCCESS;
	}
}
