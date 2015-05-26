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
		Query query = em.createNamedQuery("findMemberByEmail");
		query.setParameter("email", email);
		Member u = (Member) query.getSingleResult();
		return u;
	}

	public List<Member> getAllMembers() {
		Query query = em.createNamedQuery("findAllMember");
        @SuppressWarnings("unchecked")
		List<Member> users = query.getResultList();
		return users;
	}
}
