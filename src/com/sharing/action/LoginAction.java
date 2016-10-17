package com.sharing.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharing.entities.dto.LoginDto;
import com.sharing.service.LoginService;

@Controller("loignAction")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -2106361677667031907L;

	@Autowired
	private LoginService userService;
	private LoginDto loginDto;

	public LoginDto getLoginDto() {
		return loginDto;
	}

	public void setLoginDto(LoginDto loginDto) {
		this.loginDto = loginDto;
	}
	/**
	 * 验证用户名密码是否为空
	 */
	public void validate() {
		if (loginDto.getUsername().equals("")) {
			addFieldError("username", "*用户名不能为空");
		}
		if (loginDto.getPassword().equals("")) {
			addFieldError("password", "*密码不能为空");
		}
	}

	/**
	 * 此处还没做一些验证。详细验证等之后统一一起做需要实现
	 * 
	 * @return
	 */
	public String login() {
		System.out.println("username " + loginDto.getUsername() + "  password  " + loginDto.getPassword());
		System.out.println("LoginAction login method");
		boolean result = userService.login(loginDto);
		if (result) {
			// 登录成功
			return SUCCESS;
		} else {
			// 登录失败
			return INPUT;
		}
	}

}
