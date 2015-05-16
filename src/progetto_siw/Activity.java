package progetto_siw;

import java.util.Date;
import javax.persistence.*;

public abstract class Activity {
	
	//Attributi
	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiration;
	@Temporal(TemporalType.DATE)
	private Date completionDate;
	boolean isComplete;
	@OneToOne
	private User creator;
	
	//Costruttore
	public Activity(String name,String description,Date expiration,User creator) {
		this.name = name;
		this.description = description;
		this.isComplete = false;
		this.expiration = expiration;
		this.creationDate = new Date();
		this.creator = creator;
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
		return creator;
	}
}
