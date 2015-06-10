package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name = "findMember2Activity", query = "SELECT m FROM Member m,GroupActivity a"
		+ " where m.id = a.UserGroup.id and m.id = :mid and a.id = :aid")})
public class GroupActivity extends Activity {
	
	@ManyToMany(fetch = FetchType.LAZY)
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
