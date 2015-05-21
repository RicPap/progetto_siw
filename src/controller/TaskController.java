package controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import model.Task;
import model.TaskFacade;

@ManagedBean
public class TaskController {
	
	@EJB(beanName="taskFacade")
	private TaskFacade taskFacade;
	private String name;
	private String description;
	private Date expiration;
	private Date creationDate;
	private Date completionDate;
	private boolean isComplete;
	private Task task;
	
	public String createIndividualTask() {
		this.task = taskFacade.createTask(name, description, expiration);
		return "task";
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
}
