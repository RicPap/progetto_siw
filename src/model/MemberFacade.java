package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

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

	public List<Member> getAllMembers() {
		CriteriaQuery<Member> cq = em.getCriteriaBuilder().createQuery(Member.class);
        cq.select(cq.from(Member.class));
        List<Member> users = em.createQuery(cq).getResultList();
		return users;
	}
}
