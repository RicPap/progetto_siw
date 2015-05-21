package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class GroupActivity extends Activity {
	
	
	@OneToMany(mappedBy="activityCreator")
	private List<Task> inTask;
	@ManyToMany
	private List<User> UserGroup;
	
	public GroupActivity(String name, String description, Date expiration, User creator) {
		super(name, description, expiration, creator);
		this.inTask = new LinkedList<Task>();
		this.UserGroup = new LinkedList<User>();
		this.UserGroup.add(creator);
	}
}
