package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.User;
import model.UserFacade;

@ManagedBean
public class UserController {
	
	@EJB(beanName="userFacade")
	private UserFacade userFacade;
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private String nickname;
	private Date birthDay;
	private Date registrationDate;
	private User user;
	
	//per test
	private List<User> users;
	
	public String createUser() {
		this.user = userFacade.createUser(name, lastName,"goFace", email, password, new Date());
		return "index";
	}
	
	public String listUsers() {
		this.users = userFacade.getAllUsers();
		return "allUsers";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
