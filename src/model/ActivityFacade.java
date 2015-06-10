package model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="activityFacade")
public class ActivityFacade {
	
	@PersistenceContext(unitName="model-unit")
	private EntityManager em;
	
	public IndividualActivity createIndividualActivity(String name, String description, Date expiration, Member creator) {
		IndividualActivity a = new IndividualActivity(name,description,expiration,creator);
		em.persist(a);
		return a;
	}
	
	public GroupActivity createGroupActivity(String name, String description, Date expiration, Member creator) {
		GroupActivity a = new GroupActivity(name,description,expiration,creator);
		em.persist(a);
		return a;
	}
	
	public void removeActivity(Long id) {
		em.remove(em.find(Activity.class, id));
	}
	
	public Activity getActivity(Long id) {
		Activity a = em.find(Activity.class,id);
		return a;
	}

	public List<Member> findMember2Activity(Member currentMember, Activity activity) {
		Query query = em.createNamedQuery("findMember2Activity");
		query.setParameter("mid",currentMember.getId());
		query.setParameter("aid",activity.getId());
        @SuppressWarnings("unchecked")
		List<Member> members = query.getResultList();
		return members;
	}

	public Collection<Task> findDoneTask(Activity activity) {
		Query query = em.createNamedQuery("findDoneTask");
		query.setParameter("id",activity.getId());
        @SuppressWarnings("unchecked")
		List<Task> tasks = query.getResultList();
		return tasks;
	}

	public Collection<Task> findUnDoneTask(Activity activity) {
		Query query = em.createNamedQuery("findUndoneTask");
		query.setParameter("id",activity.getId());
        @SuppressWarnings("unchecked")
		List<Task> tasks = query.getResultList();
		return tasks;
	}

	public void upDateActivity(Activity currentActivity) {
		em.merge(currentActivity);
	}

	public Collection<Member> findAllMembers() {
		Query query = em.createNamedQuery("findAllMember");
        @SuppressWarnings("unchecked")
		List<Member> users = query.getResultList();
		return users;
	}
}
