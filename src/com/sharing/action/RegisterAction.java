package com.sharing.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharing.entities.dto.CarDto;
import com.sharing.entities.dto.RegisterDto;
import com.sharing.service.RegisterService;

@Controller("registerAction")
public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = -1842962207541874648L;
	@Autowired
	private RegisterService registerService;
	private RegisterDto registerDto;
	private CarDto carDto;

	public CarDto getCarDto() {
		return carDto;
	}

	public void setCarDto(CarDto carDto) {
		this.carDto = carDto;
	}

	public RegisterDto getRegisterDto() {
		return registerDto;
	}

	public void setRegisterDto(RegisterDto registerDto) {
		this.registerDto = registerDto;
	}

	public void validate() {
		System.out.println("validate");
		if (registerDto.getUsername().trim().equals("")) {
			System.out.println(1);
			addFieldError("username", "*用户名不能为空");
		}
		if (registerDto.getPassword_first().trim().equals("")) {
			System.out.println(2);
			addFieldError("password_first", "*密码不能为空");
		} else if (registerDto.getPassword_second().trim().equals("")) {
			System.out.println(3);
			addFieldError("password_second", "*密码不能为空");
		} else if (!registerDto.getPassword_first().trim().equals(registerDto.getPassword_second().trim())) {
			System.out.println(4);
			addFieldError("password_second", "*两次输入密码不一致");
		}
		if (registerDto.getSex().trim().equals("")) {
			System.out.println(5);
			addFieldError("sex", "*性别不能为空");
		}else if (registerDto.getSex().trim().equals("男"))  {
			System.out.println("........");
		}else if(!registerDto.getSex().trim().equals("女")){
			System.out.println(registerDto.getSex()+"  "+registerDto.getSex().trim());
			addFieldError("sex", "*性别必须为男或者女");
			
		}
	}

	public String register() {
		System.out.println(registerService);
		boolean flag = registerService.register(registerDto);
		carDto.setUserId(registerService.selectUserId());
		registerService.saveCarInfo(carDto);
		if (flag) {
			System.out.println("用户注册成功");
		} else {
			System.out.println("用户注册失败");
		}
		return SUCCESS;
	}

}
