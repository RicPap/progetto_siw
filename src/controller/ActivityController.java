package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;

import model.Activity;
import model.ActivityFacade;
import model.GroupActivity;
import model.IndividualActivity;
import model.Member;
import model.Task;

public class ActivityController {

	@EJB(beanName="activityFacade")
	private ActivityFacade activityFacade;
	private Long id;
	private String name;
	private String description;
	private Date expiration;
	private Date creationDate;
	private Date completionDate;
	private boolean isComplete;
	private Activity activity;
	private SuperController superC;
	
	public String createIndividualActivity() {
		Member currentMember = superC.getCurrentMember();
		this.activity = activityFacade.createIndividualActivity(name, description, expiration, currentMember);
		currentMember.getMyActivities().add(activity);
		return "member";
	}
	
	public String upDateActivity() {
		Member currentMember = superC.getCurrentMember();
		Activity currentActivity = superC.getCurrentActivity();
		currentMember.getMyActivities().remove(currentActivity);
		activityFacade.upDateActivity(currentActivity);
		currentMember.getMyActivities().add(currentActivity);
		if(currentActivity.getClass().equals(IndividualActivity.class))
			return "individualActivity";
		return "groupActivity";
	}
	
	public String backIn() {
		Activity currentActivity = superC.getCurrentActivity();
		if(currentActivity.getClass().equals(IndividualActivity.class))
			return "individualActivity";
		return "groupActivity";
	}
	
	public String createGroupActivity() {
		Member currentMember = superC.getCurrentMember();
		this.activity = activityFacade.createGroupActivity(name, description, expiration, currentMember);
		currentMember.getMyActivities().add(activity);
		return "member";
	}
	
	public String removeActivity() {
		Member currentMember = superC.getCurrentMember();
		Activity currentActivity = activityFacade.getActivity(this.id);
		currentMember.getMyActivities().remove(currentActivity);
		for(Task t : currentActivity.getInTask()) {
			if (t.getPushTo().equals(currentMember))
				currentMember.getToDoTask().remove(t);
		}
		this.activityFacade.removeActivity(this.id);
		return "member";
	}
	
	public String findActivity() {
		this.activity = activityFacade.getActivity(id);
		List<Task> undone = new LinkedList<Task>();
		List<Task> done = new LinkedList<Task>();
		done.addAll(activityFacade.findDoneTask(activity));
		undone.addAll(activityFacade.findUnDoneTask(activity));
		superC.setUnDoneTask(undone);
		superC.setDoneTask(done);
		superC.setCurrentActivity(activity);
		if(activity.getClass().equals(IndividualActivity.class))
			return "individualActivity";
		else {
			GroupActivity currentActivity = (GroupActivity)activity;
			List<Member> allmembers = new ArrayList<Member>();
			allmembers.addAll(activityFacade.findAllMembers());
			superC.setEntryId(new Long[allmembers.size()]);
			superC.setActivityGroup(currentActivity.getUserGroup());
			superC.setAllMember(allmembers);
			return "groupActivity";
		}
	}
	
	public String setActivityCompletition() {
		Member currentMember = superC.getCurrentMember();
		this.activity = activityFacade.getActivity(this.id);
		activity.setIsComplete(true);
		activity.setCompletionDate(new Date());
		currentMember.getMyActivities().remove(activity);
		activityFacade.upDateActivity(activity);
		currentMember.getMyActivities().add(activity);
		return "member";
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SuperController getSuperC() {
		return superC;
	}

	public void setSuperC(SuperController superC) {
		this.superC = superC;
	}
}