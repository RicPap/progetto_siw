package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class GroupTask extends Task {
	
	@ManyToOne
	private List<User> assignTo;
	
	public GroupTask(String name, String description, Date expiration) {
		super(name, description, expiration);
		this.assignTo = new LinkedList<User>();
		assignTo.add(this.getCreator().getCreator());
	}
	
	public GroupTask(String name, String description, Date expiration,User target) {
		super(name, description, expiration);
		this.assignTo = new LinkedList<User>();
		assignTo.add(target);
	}
}
