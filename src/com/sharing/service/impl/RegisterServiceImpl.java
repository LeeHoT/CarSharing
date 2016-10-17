package com.sharing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharing.dao.RegisterDao;
import com.sharing.entities.dto.CarDto;
import com.sharing.entities.dto.RegisterDto;
import com.sharing.service.RegisterService;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public boolean register(RegisterDto registerDto) {
		boolean flag = false;
		synchronized (registerDao) {// 保证同一时间只有一个用户进行注册
			System.out.println(registerDao);
			flag = registerDao.saveUserInfo(registerDto);
			if (flag) {
				// 已成功添加用户基本信息
				// 开始添加用户车辆信息
				// 先获取当前注册用户的id
				// int userId = registerDao.selectUserId();
				// 添加用户车辆信息
				// int res = saveCarInfo(carDto);
				// if (res > 0) {
				System.out.println("用户 " + registerDto.getUsername() + "注册成功！");
				// flag = true;
				// }
				// flag = false;
			}
		}
		return flag;
	}

	@Override
	public int saveCarInfo(CarDto carDto) {
		int res = registerDao.saveCarInfo(carDto);
		if (res <= 0) {
			System.out.println("id为" + carDto.getUserId() + "用户添加汽车信息失败。");
		}
		System.out.println("添加汽车信息失败。");
		return res;
	}
	@Override
	public int selectUserId(){
		return registerDao.selectUserId();
	}
}
