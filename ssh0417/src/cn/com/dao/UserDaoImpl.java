package cn.com.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.com.pojo.User;

public class UserDaoImpl implements UserDao{
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	@Override
	public void delete(Serializable id) {
		hibernateTemplate.delete(findbyid(id));
	}

	@Override
	public User findbyid(Serializable id) {
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	public List<User> findall() {
		return (List<User>) hibernateTemplate.find("from User",null);
	}

}
