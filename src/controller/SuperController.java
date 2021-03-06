package controller;

import java.util.List;

import model.Activity;
import model.IndividualActivity;
import model.Member;
import model.Task;

public class SuperController {
	private Member currentMember;
	private Activity currentActivity;
	private Task currentTask;
	private List<Member> activityGroup;
	private List<Task> unDoneTask;
	private List<Task> doneTask;
	private List<Member> allMember;
	private Long[] entryId;
	private boolean adding = false;
	private boolean sameEmail = false;;
	
	public Member getCurrentMember() {
		return currentMember;
	}
	public void setCurrentMember(Member currentMember) {
		this.currentMember = currentMember;
	}
	public Activity getCurrentActivity() {
		return currentActivity;
	}
	public void setCurrentActivity(Activity currentActivity) {
		this.currentActivity = currentActivity;
	}
	public Task getCurrentTask() {
		return currentTask;
	}
	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	public List<Member> getActivityGroup() {
		return activityGroup;
	}

	public void setActivityGroup(List<Member> activityGroup) {
		this.activityGroup = activityGroup;
	}
	
	public boolean verifyActivity() {
		if(currentMember.getMyActivities().isEmpty())
			return false;
		return true;
	}
	
	public boolean verifyTask() {
		if(currentMember.getToDoTask().isEmpty())
			return false;
		return true;
	}
	
	public boolean verifyDoneTaskInActivity() {
		if(this.getDoneTask().isEmpty())
			return false;
		return true;
	}
	
	public boolean verifyUnDoneTaskInActivity() {
		if(this.getUnDoneTask().isEmpty())
			return false;
		return true;
	}
	
	public boolean verifyBothInTask() {
		if(this.getDoneTask().isEmpty() && this.getUnDoneTask().isEmpty())
			return false;
		return true;
	}
	
	public List<Task> getUnDoneTask() {
		return unDoneTask;
	}
	public void setUnDoneTask(List<Task> unDoneTask) {
		this.unDoneTask = unDoneTask;
	}
	public List<Task> getDoneTask() {
		return doneTask;
	}
	public void setDoneTask(List<Task> doneTask) {
		this.doneTask = doneTask;
	}
	public List<Member> getAllMember() {
		return allMember;
	}
	public void setAllMember(List<Member> allMember) {
		this.allMember = allMember;
	}
	public Long[] getEntryId() {
		return entryId;
	}
	public void setEntryId(Long[] entryId) {
		this.entryId = entryId;
	}
	
	public boolean veryActivityCompletition() {
		if(currentActivity.getIsComplete())
			return false;
		return true;
	}
	
	public boolean veryTaskCompletition() {
		if(currentTask.getIsComplete())
			return false;
		return true;
	}
	public boolean isAdding() {
		return adding;
	}
	public void setAdding(boolean adding) {
		this.adding = adding;
	}
	
	public String addingMember() {
		this.adding = true;
		if(currentActivity.getClass().equals(IndividualActivity.class))
			return "individualActivity";
		return "groupActivity";
	}
	public boolean isSameEmail() {
		return sameEmail;
	}
	public void setSameEmail(boolean sameEmail) {
		this.sameEmail = sameEmail;
	}
	}
