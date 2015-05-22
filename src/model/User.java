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
	private String name;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false)
	private String email;
	
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
	public User() {}
	
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

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String cognome) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
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
		User other = (User) obj;
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
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Long getId() {
		return id;
	}
}
