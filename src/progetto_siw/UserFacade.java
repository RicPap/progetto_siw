package progetto_siw;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="userFacade")
public class UserFacade {

	@PersistenceContext(unitName="unit")
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
}
