package model;

import java.util.Date;

import javax.persistence.*;

@Entity
public abstract class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//Attributi
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Column(nullable = true)  //non necessaria la scadenza
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiration;
	
	@Column(nullable = true)  //non necessariamanete completato
	@Temporal(TemporalType.DATE)
	private Date completionDate;
	
	@Column(nullable = true)
	boolean isComplete;
	
	@ManyToOne
	private User userCreator;
	
	//Costruttore
	public Activity(String name,String description,Date expiration,User creator) {
		this.name = name;
		this.description = description;
		this.isComplete = false;
		this.expiration = expiration;
		this.creationDate = new Date();
		this.userCreator = creator;
	}
	
	//Metodi
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date scadenza) {
		this.expiration = scadenza;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public User getCreator() {
		return userCreator;
	}

	public Long getId() {
		return id;
	}
}
