package cn.com.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import cn.com.pojo.User;
import cn.com.service.UserService;
@ParentPackage("json-default")
@Namespace("p2")
@Results({
	@Result(name="success"),
	@Result(name="error",location="/error.jsp")
})
public class UserAction {
	private User user;
	private List<User> userList;
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Resource
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Action("saveUser")
	public String saveUser() {
		userService.addUser(user);
		return "success";
	}
	@Action("showUser")
	public String showUser() {
		userList = userService.userList();
		return "success";
	}
}
