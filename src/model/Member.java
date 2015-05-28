package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
		@NamedQuery(name = "findMemberByEmail", query = "SELECT m FROM Member m where m.email = :email")})
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
	
	@OneToMany(mappedBy="userCreator",fetch=FetchType.EAGER)
	private List<Activity> myActivities;
	
	@OneToMany(mappedBy="userCreator")
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
