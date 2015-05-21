package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="userFacade")
public class UserFacade {

	@PersistenceContext(unitName="model-unit")
	private EntityManager em;
	
	public User createUser(String name,String lastName,String nickname,String email,String password,Date nascita) {
		User u = new User(name,lastName,nickname,email,password,nascita);
		em.persist(u);
		return u;
	}
	
	public User getUser(Long id) {
		User u = em.find(User.class, id);
		return u;
	}

	public List<User> getAllUsers() {
		CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
        cq.select(cq.from(User.class));
        List<User> users = em.createQuery(cq).getResultList();
		return users;
	}
}
