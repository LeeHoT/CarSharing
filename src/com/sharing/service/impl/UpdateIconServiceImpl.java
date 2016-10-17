package com.sharing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sharing.dao.UpdateIconDao;
import com.sharing.entities.Icon;
import com.sharing.service.UpdateIconService;

public class UpdateIconServiceImpl implements UpdateIconService {

	@Autowired
	private UpdateIconDao updateIcon;
	
	@Override
	public int updateIcon(Icon icon) {
		int res = updateIcon.updateIcon(icon);
		return res;
	}

}
