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
	private Member userCreator;
	
	//Costruttore
	public Activity() { }
	
	public Activity(String name,String description,Date expiration,Member creator) {
		this.name = name;
		this.description = description;
		this.isComplete = false;
		this.expiration = expiration;
		this.creationDate = new Date();
		this.userCreator = creator;
	}
	
	//Metodi
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Member getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(Member userCreator) {
		this.userCreator = userCreator;
	}
}
