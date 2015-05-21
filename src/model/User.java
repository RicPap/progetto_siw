package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "findAllUsers", query = "SELECT u FROM User u")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	
	@OneToMany(mappedBy="userCreator")
	private List<Activity> myActivities;
	
	@OneToMany(mappedBy="userCreator")
	private List<Task> toDoTask;
	
	//Costruttore
	public User(String name,String lastName,String nickname,String email,String password,Date birth)
	{
		this.name = name;
		this.lastname = lastName;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.registrationDate = new Date();
		this.birthDay = birth;
		this.myActivities = new LinkedList<Activity>();
	}
	//Metodi
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String cognome) {
		this.lastname = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setBirthDay(Date bday) {
		this.birthDay = bday;
	}

	public Date getBirthDay() {
		return birthDay;
	}
	
	public void setNickName(String nname) {
		this.nickname = nname;
	}
	
	public String getNickName() {
		return this.nickname;
	}
	
	@Override
	public boolean equals(Object o) {
		User that = (User)o;
		if(this.id.equals(that.getId()))
				return true;
		return false;
	}
	public Long getId() {
		return id;
	}
}
