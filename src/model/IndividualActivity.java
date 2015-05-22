package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class IndividualActivity extends Activity {
	
	public IndividualActivity() {}

	@OneToMany(mappedBy="activityCreator")
	private List<Task> inTask;
	
	public IndividualActivity(String name, String description, Date expiration, User creator) {
		super(name, description, expiration, creator);
		this.inTask = new LinkedList<Task>();
	}
}
