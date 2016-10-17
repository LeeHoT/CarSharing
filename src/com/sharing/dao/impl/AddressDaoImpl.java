package com.sharing.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sharing.dao.AddressDao;
import com.sharing.entities.Address;
import com.sharing.entities.City;

public class AddressDaoImpl implements AddressDao {
	@Autowired
	private SessionFactory sessionFactory;
	Query query = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveAddress(Address address) {
		//保存地址信息
		String sql = "insert into address(userId,isDefault,provinceId,cityId,detailAdd) values(?,?,?,?,?)";
		query =getSession().createSQLQuery(sql);
		query.setInteger(0, address.getUserId());
		query.setBoolean(1, address.isDefault());
		query.setInteger(2, address.getProvinceId());
		query.setInteger(3, address.getCityId());
		query.setString(4, address.getDetailAdd());
		int res = query.executeUpdate();
		return res;
	}

	@Override
	public int deleteAddress(int id) {
		String hql = "DELETE FROM Address a where a.id = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, id);
		int res = query.executeUpdate();
		return res;
	}

	@Override
	public int updateAddress(Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> selectAddressByUserId(int userId) {
		String hql ="from Address a where a.userId = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, userId);
		List<Address> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> selectAddress() {
		String hql ="from Address a";
		query = getSession().createQuery(hql);
		List<Address> list = query.list();
		return list;
	}
	@Override
	public int selectAddressId(int id) {
		String hql = "select a.id from Address a where a.id = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, id);
		int addId = (int) query.uniqueResult();
		return addId;
	}

	@Override
	public int selectProvinceId(String province) {
		String hql = "select p.id from Province p where p.province = ?";
		query = getSession().createQuery(hql);
		query.setString(0, province);
		int res = (int) query.uniqueResult();
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String  selectProvinceById(int provinceId) {
		String hql = "select p.province from Province p where p.id = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, provinceId);
		List<String> lr = query.list();
		for(String res:lr){
			return res;
		}
		return null;
		
	}

	@Override
	public int selectCityId(String city) {
		String hql = "select c.id from City c where c.city = ?";
		query = getSession().createQuery(hql);
		query.setString(0, city);
		int res = (int) query.uniqueResult();
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String selectCityById(int cityId) {
		String hql = "select c.city from City c where c.id = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, cityId);
		List<String> lr = query.list();
		for(String res:lr){
			return res;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> selectCityByProvinceId(int provinceId) {
		String hql = "from City c where c.provinceId = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, provinceId);
		List<City> list = query.list();
		return list;
	}

}