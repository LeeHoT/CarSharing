package com.sharing.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sharing.dao.RegisterDao;
import com.sharing.entities.dto.CarDto;
import com.sharing.entities.dto.RegisterDto;
import com.sharing.exception.SaveCarInfoException;

public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private SessionFactory sessionFactory;
	Query query = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * 插入user表，添加用户基本信息
	 */
	@Override
	public boolean saveUserInfo(RegisterDto registerDto) {
		String ssql = "from User u where u.username = ?";
		query = getSession().createQuery(ssql);
		query.setString(0, registerDto.getUsername());
		int l = query.list().size();
		if (l>0) {
			System.out.println(registerDto.getUsername());
			System.out.println("用户名已存在");
			return false;
		}
		boolean flag = false;
		String usql = "INSERT INTO USERS(USERNAME,PASSWORD,REALNAME,SEX,BIRTHDAY,IDCARD,PROFESSION,PHONENUM,EMAIL) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		query = getSession().createSQLQuery(usql);
		query.setString(0, registerDto.getUsername());
		query.setString(1, registerDto.getPassword_first());
		query.setString(2, registerDto.getRealName());
		query.setString(3, registerDto.getSex());
		query.setString(4, registerDto.getBirthday());
		query.setString(5, registerDto.getIdCard());
		query.setString(6, registerDto.getProfession());
		query.setString(7, registerDto.getPhoneNum());
		query.setString(8, registerDto.getEmail());
		int res = query.executeUpdate();
		if (res > 0) {
			System.out.println("Updata " + res + "line in Users table!");
			flag = true;
		}
		return flag;
	}

	/**
	 * 查询当前最大id值,即为正再注册用户的id,此方法并不是安全,操作时还请注意
	 * 
	 * @return 返回最新注册用户的id
	 */
	@Override
	public int selectUserId() {
		String hql = "select max(u.id) from User u";
		query = getSession().createQuery(hql);
		int userId = (int) query.uniqueResult();
		return userId;
	}

	/**
	 * 插入用户汽车信息，其中userId通过selectUserId方法获取
	 * 
	 * @return 更新的行数
	 */
	@Override
	public int saveCarInfo(CarDto carDto) {
		int res = 0;
		if(carDto.getBrand().length()>20){
			throw new SaveCarInfoException("保存汽车信息数百");
		}
		String sql = "INSERT INTO CAR(USERID,BRAND,MODEL,LICENSENUM,MOTORCYCLETYPE,DRIVINGLICENSENUM,REGISTRATIONNUM,EXPECTPEOPLENUM) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		query = getSession().createSQLQuery(sql);
		query.setInteger(0, carDto.getUserId());
		query.setString(1, carDto.getBrand());
		query.setString(2, carDto.getModel());
		query.setString(3, carDto.getLicenseNum());
		query.setString(4, carDto.getMotorcycleType());
		query.setString(5, carDto.getDrivingLicenseNum());
		query.setString(6, carDto.getRegistrationNum());
		query.setInteger(7, carDto.getExpectPeopleNum());
		res = query.executeUpdate();// 保存更新的行数
		return res;
	}

}
