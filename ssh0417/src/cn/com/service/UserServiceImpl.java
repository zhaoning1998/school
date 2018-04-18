package cn.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.dao.UserDao;
import cn.com.pojo.User;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> userList() {
		return userDao.findall();
	}

}
