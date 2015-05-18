package progetto_siw;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="activityFacde")
public class ActivityFacade {
	
	@PersistenceContext(unitName="")
	private EntityManager em;
	
	public Activity createIndividualActivity(String name, String description, Date expiration, User creator) {
		Activity a = new IndividualActivity(name,description,expiration,creator);
		em.persist(a);
		return a;
	}
	
	public Activity createGroupActivity(String name, String description, Date expiration, User creator) {
		Activity a = new GroupActivity(name,description,expiration,creator);
		em.persist(a);
		return a;
	}
	
	public Activity getActivity(Long id) {
		Activity a = em.find(Activity.class,id);
		return a;
	}
}
