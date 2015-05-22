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
	private List<Member> UserGroup;
	
	public GroupActivity() {}
	
	public GroupActivity(String name, String description, Date expiration, Member creator) {
		super(name, description, expiration, creator);
		this.inTask = new LinkedList<Task>();
		this.UserGroup = new LinkedList<Member>();
		this.UserGroup.add(creator);
	}
}
