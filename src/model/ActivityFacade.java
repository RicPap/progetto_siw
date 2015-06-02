package model;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="activityFacade")
public class ActivityFacade {
	
	@PersistenceContext(unitName="model-unit")
	private EntityManager em;
	
	public Activity createIndividualActivity(String name, String description, Date expiration, Member creator) {
		Activity a = new IndividualActivity(name,description,expiration,creator);
		em.persist(a);
		return a;
	}
	
	public Activity createGroupActivity(String name, String description, Date expiration, Member creator) {
		Activity a = new GroupActivity(name,description,expiration,creator);
		em.persist(a);
		return a;
	}
	
	public Activity getActivity(Long id) {
		Activity a = em.find(Activity.class,id);
		return a;
	}
}
