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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "findUndoneTask", query = "SELECT t FROM Task t where t.activityCreator.id = :id"
		+ " and t.isComplete = false"),
				@NamedQuery(name = "findDoneTask", query = "SELECT t FROM Task t where t.activityCreator.id = :id"
				+ " and t.isComplete = true")})
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
	@JoinColumn(name="creator")
	private Member userCreator;
	
	@OneToMany(mappedBy="activityCreator",fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Task> inTask;
	
	
	//Costruttore
	public Activity() { }
	
	public Activity(String name,String description,Date expiration,Member creator) {
		this.name = name;
		this.description = description;
		this.isComplete = false;
		this.expiration = expiration;
		this.creationDate = new Date();
		this.userCreator = creator;
		this.inTask = new LinkedList<Task>();
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

	public List<Task> getInTask() {
		return inTask;
	}

	public void setInTask(List<Task> inTask) {
		this.inTask = inTask;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Activity other = (Activity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
