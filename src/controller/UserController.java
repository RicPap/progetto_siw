package controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import model.User;
import model.UserFacade;

@ManagedBean
public class UserController {
	
	@EJB(beanName="userFacade")
	private UserFacade userFacade;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private String nickname;
	private Date birthDay;
	private Date registrationDate;
	private User user;
	
	public String createUser() {
		this.user = userFacade.createUser(name, lastName,"goFace", email, password, new Date());
		return "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setNickName(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setBirthDay(Date bday) {
		this.birthDay = bday;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}
}
