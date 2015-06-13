package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class GroupActivity extends Activity {
	
	@OneToMany(fetch = FetchType.EAGER,cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(name="member2activity", 
	joinColumns={@JoinColumn(name="member_id")}, inverseJoinColumns={@JoinColumn(name="activity_id")})
	private List<Member> UserGroup;
	
	public GroupActivity() {}
	
	public GroupActivity(String name, String description, Date expiration, Member creator) {
		super(name, description, expiration, creator);
		this.UserGroup = new LinkedList<Member>();
		this.UserGroup.add(creator);
	}

	public List<Member> getUserGroup() {
		return UserGroup;
	}

	public void setUserGroup(List<Member> userGroup) {
		UserGroup = userGroup;
	}
}
