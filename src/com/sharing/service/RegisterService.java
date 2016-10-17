package com.sharing.service;

import com.sharing.entities.dto.CarDto;
import com.sharing.entities.dto.RegisterDto;

public interface RegisterService {
	public boolean register(RegisterDto registerDto);
	
	public int saveCarInfo(CarDto carDto);
	
	public int selectUserId();

}
