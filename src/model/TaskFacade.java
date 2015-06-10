package model;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="taskFacade")
public class TaskFacade {
	
	@PersistenceContext(unitName="model-unit")
	private EntityManager em;
	
	public Task createTask(String name, String description,Date expiration,Member target,Activity createdBy) {
		Task t = new Task(name,description,expiration,target,createdBy);
		em.persist(t);
		return t;
	}
	
	public void removeTask(Long id) {
		em.remove(em.find(Task.class, id));
	}
	
	public Task getTask(Long id) {
		Task t = em.find(Task.class,id);
		return t;
	}

	public Member findTargetMember(Long targetId) {
		Member m = em.find(Member.class,targetId);
		return m;
	}

	public void updateTask(Task task) {
		em.merge(task);
	}
}
