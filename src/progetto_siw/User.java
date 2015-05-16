package progetto_siw;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	//Attributi
	@Id
	private String email;
	private String name;
	private String surname;
	private String nickname;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date dataInscrizione;
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	@OneToMany(mappedBy="creator")
	private List<Activity> myActivities;
	@ManyToMany(mappedBy="relatedTo")
	private List<Activity> toDoTask;
	
	//Costruttore
	public User(String name,String lastName,String nickname,String email,String password,Date nascita)
	{
		this.name = name;
		this.surname = lastName;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.dataInscrizione = new Date();
		this.dataNascita = nascita;
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
		return surname;
	}

	public void setLastName(String cognome) {
		this.surname = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public String getNickName() {
		return this.nickname;
	}
	
	@Override
	public boolean equals(Object o) {
		User that = (User)o;
		if(this.email.equals(that.getEmail()))
				return true;
		return false;
	}
}
