package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="memberFacade")
public class MemberFacade {

	@PersistenceContext(unitName="model-unit")
	private EntityManager em;
	
	public Member createMember(String name,String lastName,String nickName,String email,String password,Date nascita) {
		Member u = new Member(name,lastName,nickName,email,password,nascita);
		em.persist(u);
		return u;
	}
	
	public Member getMember(Long id) {
		Member u = em.find(Member.class, id);
		return u;
	}
	
	public Member getMember(String email) {
		Member u;
		Query query = em.createNamedQuery("findMemberByEmail");
		query.setParameter("email", email);
		try {
			u = (Member) query.getSingleResult();
		}
		catch(Exception e) {
			u = null;
		}
		return u;
	}

	public List<Member> getAllMembers() {
		Query query = em.createNamedQuery("findAllMember");
        @SuppressWarnings("unchecked")
		List<Member> users = query.getResultList();
		return users;
	}
	
	public List<Activity> findAllActivities(Member currentMember) {
		Query query = em.createNamedQuery("findAllActivities");
		query.setParameter("id",currentMember.getId());
        @SuppressWarnings("unchecked")
		List<Activity> activities = query.getResultList();
		return activities;
	}

	public List<Task> findAllTask(Member member) {
		Query query = em.createNamedQuery("findAllTask");
		query.setParameter("id", member.getId());
		@SuppressWarnings("unchecked")
		List<Task> tasks = query.getResultList();
		return tasks;
	}
}
