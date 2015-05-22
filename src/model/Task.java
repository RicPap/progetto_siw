package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiration;
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date completionDate;
	
	@Column(nullable = true)
	boolean isComplete;
	
	@ManyToOne
	private Activity activityCreator;
	
	@ManyToOne
	private Member userCreator;
	
	//Costruttore
	public Task()  {}
	
	public Task(String name,String description,Date expiration) {
		this.name = name;
		this.description = description;
		this.isComplete = false;
		this.expiration = expiration;
		this.creationDate = new Date();
	}
	
	public Task(String name, String description, Date expiration, Member assignTo) {
		this(name,description,expiration);
		this.userCreator = assignTo;
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
	
	public Activity getActivityCreator() {
		return activityCreator;
	}

	public void setActivityCreator(Activity activityCreator) {
		this.activityCreator = activityCreator;
	}

	public Member getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(Member userCreator) {
		this.userCreator = userCreator;
	}

	public Long getId() {
		return id;
	}	
}