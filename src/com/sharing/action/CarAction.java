package com.sharing.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("carAction")
public class CarAction extends ActionSupport{
	private static final long serialVersionUID = 3108537543227135642L;
	
	public String addCarInfo(){
		return SUCCESS;
	}
	
	public String deleteCarInfo(){
		return SUCCESS;
	}
	
	public String selectCarInfo(){
		return SUCCESS;
	}

}
