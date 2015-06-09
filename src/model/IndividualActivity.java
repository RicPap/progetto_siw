package model;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class IndividualActivity extends Activity {
	
	public IndividualActivity() {}
	
	public IndividualActivity(String name, String description, Date expiration, Member creator) {
		super(name, description, expiration, creator);
	}
}
