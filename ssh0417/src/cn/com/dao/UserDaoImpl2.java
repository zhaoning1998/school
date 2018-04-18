package cn.com.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.pojo.User;
@Repository
public class UserDaoImpl2 extends HibernateDaoSupport implements UserDao{

	@Override
	public void save(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().delete(findbyid(id));
	}

	@Override
	public User findbyid(Serializable id) {
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public List<User> findall() {
		return (List<User>) getHibernateTemplate().find("from User", null);
	}

}
