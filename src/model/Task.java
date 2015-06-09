package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	Boolean isComplete;
	
	@ManyToOne
	@JoinColumn(name="activity_creator")
	private Activity activityCreator;
	
	@ManyToOne
	@JoinColumn(name="assign_to")
	private Member pushTo;
	
	//Costruttore
	public Task()  {}
	
	public Task(String name,String description,Date expiration,Member assignTo,Activity createdBy) {
		this.name = name;
		this.description = description;
		this.isComplete = false;
		this.expiration = expiration;
		this.creationDate = new Date();
		this.pushTo = assignTo;
		this.activityCreator = createdBy;
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

	public Long getId() {
		return id;
	}

	public Member getPushTo() {
		return pushTo;
	}

	public void setPushTo(Member pushTo) {
		this.pushTo = pushTo;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
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
		Task other = (Task) obj;
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