package model;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="taskFacade")
public class TaskFacade {
	
	@PersistenceContext(unitName="model-unit")
	private EntityManager em;
	
	public Task createIndividualTask(String name, String description,Date expiration) {
		Task t = new IndividualTask(name,description,expiration);
		em.persist(t);
		return t;
	}
	
	public Task createIndividualTask(String name, String description,Date expiration,User target) {
		Task t = new IndividualTask(name,description,expiration,target);
		em.persist(t);
		return t;
	}
	
	public Task createGroupTask(String name, String description, Date expiration) {
		Task t = new GroupTask(name,description,expiration);
		em.persist(t);
		return t;
	}
	
	public Task createGroupTask(String name, String description, Date expiration,User target) {
		Task t = new GroupTask(name,description,expiration,target);
		em.persist(t);
		return t;
	}
	
	public Task getTask(Long id) {
		Task t = em.find(Task.class,id);
		return t;
	}
}
