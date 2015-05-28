package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Member;
import model.MemberFacade;

@ManagedBean
public class MemberController {
	
	@EJB(beanName="memberFacade")
	private MemberFacade memberFacade;
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private String nickName;
	private Date birthDay;
	private Date registrationDate;
	@ManagedProperty(value="#{param.currentMember}")
	private Member member;
	private boolean passCorrect = true;
	private List<Member> members;
	
	public String createMember() {
		this.member = memberFacade.createMember(name, lastName,nickName, email, password,birthDay);
		return "logIn";
	}
	
	public String logIn() {
		this.member = memberFacade.getMember(this.email);
		if (this.member != null) {
			if (this.member.validatePwd(this.password)) {
				return "member";
			}
		}
		passCorrect = false;
		return "logIn";
	}
	
	public String listMembers() {
		this.members = memberFacade.getAllMembers();
		return "allMembers";
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member user) {
		this.member = user;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> users) {
		this.members = users;
	}
	
	public String findMember() {
		this.member = memberFacade.getMember(id);
		return "member";
	}

	public boolean isPassCorrect() {
		return passCorrect;
	}

	public void setPassCorrect(boolean isPassCorrect) {
		this.passCorrect = isPassCorrect;
	}
}
