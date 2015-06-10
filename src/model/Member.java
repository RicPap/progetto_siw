package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "findAllMember", query = "SELECT m FROM Member m"),
		@NamedQuery(name = "findMemberByEmail", query = "SELECT m FROM Member m where m.email = :email"),
		@NamedQuery(name = "findAllActivities", query = "SELECT a FROM Activity a where a.userCreator.id = :id"),
		@NamedQuery(name = "findAllTask", query = "SELECT t FROM Task t where t.pushTo.id = :id"),
		@NamedQuery(name = "findMemberById", query = "SELECT m FROM Member m where m.id = :id")})
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false,length=30)
	private String name;
	
	@Column(nullable = false,length=30)
	private String lastName;
	
	@Column(nullable = false,length=30,unique = true)
	private String email;
	
	@Column(nullable = false,length=30,unique = true)
	private String nickName;
	
	@Column(nullable = false,length=30)
	private String password;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	
	@OneToMany(mappedBy="userCreator",fetch=FetchType.EAGER, cascade={CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE})
	private List<Activity> myActivities;
	
	@OneToMany(mappedBy="pushTo",fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Task> toDoTask;
	
	//Costruttore
	public Member() {}
	
	public Member(String name,String lastName,String nickName,String email,String password,Date birth)
	{
		this.name = name;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.registrationDate = new Date();
		this.birthDay = birth;
		this.myActivities = new LinkedList<Activity>();
		this.toDoTask = new LinkedList<Task>();
	}
	
	//Metodi
	
	public boolean validatePwd(String pwd) {
		return password.equals(pwd);
	}
	
	public Long getId() {
		return id;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public List<Activity> getMyActivities() {
		return myActivities;
	}

	public void setMyActivities(List<Activity> myActivities) {
		this.myActivities = myActivities;
	}

	public List<Task> getToDoTask() {
		return toDoTask;
	}

	public void setToDoTask(List<Task> toDoTask) {
		this.toDoTask = toDoTask;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
