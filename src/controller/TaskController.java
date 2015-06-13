 package controller;

import java.util.Date;

import javax.ejb.EJB;

import model.Activity;
import model.GroupActivity;
import model.IndividualActivity;
import model.Member;
import model.Task;
import model.TaskFacade;

public class TaskController {
	
	@EJB(beanName="taskFacade")
	private TaskFacade taskFacade;
	private Long id;
	private String name;
	private String description;
	private Date expiration;
	private Date creationDate;
	private Date completionDate;
	private boolean isComplete;
	private Task task;
	private Long targetId;
	private SuperController superC;
	
	public String createTargetTask() {
		Member currentMember = superC.getCurrentMember();
		Activity creatorActivity = superC.getCurrentActivity();
		Member target = taskFacade.findTargetMember(targetId);
		this.task = taskFacade.createTask(name, description, expiration, target, creatorActivity);
		superC.getUnDoneTask().add(task);
		if(target.equals(currentMember))
			currentMember.getToDoTask().add(task);
		if(creatorActivity.getClass().equals(IndividualActivity.class)) {
			return "individualActivity";
		}
		return "groupActivity";
	}
	
	public String updateTask() {
		Task currentTask = superC.getCurrentTask();
		superC.getUnDoneTask().remove(currentTask);
		taskFacade.updateTask(currentTask);
		superC.getUnDoneTask().add(currentTask);
		return "task";
	}
 	
	public String setTaskCompletition() {
		Member currentMember = superC.getCurrentMember();
		Activity creatorActivity = superC.getCurrentActivity();
		this.task = taskFacade.getTask(targetId);
		task.setIsComplete(true);
		task.setCompletionDate(new Date());
		superC.getUnDoneTask().remove(task);
		taskFacade.updateTask(task);
		superC.getDoneTask().add(task);
		if(currentMember.equals(task.getPushTo()))
			currentMember.getToDoTask().remove(task);
		if(creatorActivity.getClass().equals(GroupActivity.class))
			return "groupActivity";
		return "individualActivity";
	}
	
	public String createIndividualTask() {
		Activity creatorActivity = superC.getCurrentActivity();
		Member target = superC.getCurrentMember();
		this.task = taskFacade.createTask(name, description, expiration, target, creatorActivity);
		target.getToDoTask().add(task);
		superC.getUnDoneTask().add(task);
		if(creatorActivity.getClass().equals(IndividualActivity.class)) {
			return "individualActivity";
		}
		return "groupActivity";
	}
	
	public String getCreator() {
		Activity a = superC.getCurrentTask().getActivityCreator();
		if(a.getClass().equals(IndividualActivity.class))
			return "individualActivity.jsp";
		return "groupActivity.jsp";
	}
	
	public String findTask() {
		this.task = taskFacade.getTask(id);
		superC.setCurrentTask(task);
		return "task";
	}
	
	public String removeTask() {
		Member currentMember = superC.getCurrentMember();
		Task currentTask = taskFacade.getTask(this.id);
		if (currentMember.equals(currentTask.getPushTo())) 
			currentMember.getToDoTask().remove(currentTask);
		this.taskFacade.removeTask(this.id);
		return "member";
	}
	
	public String findTargetMember() {
		Member target = taskFacade.findTargetMember(targetId);
		superC.setCurrentMember(target);
		return "infoMember";
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

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
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

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public SuperController getSuperC() {
		return superC;
	}

	public void setSuperC(SuperController superC) {
		this.superC = superC;
	}
}
