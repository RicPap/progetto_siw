package controller;

import java.util.Date;

import javax.ejb.EJB;

import model.Activity;
import model.ActivityFacade;

public class ActivityController {

	@EJB(beanName="activityFacade")
	private ActivityFacade activityFacade;
	private String name;
	private String description;
	private Date expiration;
	private Date creationDate;
	private Date completionDate;
	private boolean isComplete;
	private Activity activity;
	
	public String createIndividualActivity() {
		this.activity = activityFacade.createIndividualActivity(name, description, expiration, activity.getCreator());
		return "activity";
	}
	
	public String createGroupActivity() {
		this.activity = activityFacade.createGroupActivity(name, description, expiration, activity.getCreator());
		return "activity";
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}