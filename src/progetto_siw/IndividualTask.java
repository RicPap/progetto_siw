package progetto_siw;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class IndividualTask extends Task {
	
	@OneToOne
	private User assignTo;
	
	public IndividualTask(String name, String description,Date expiration) {
		super(name, description, expiration);
		this.assignTo = this.getCreator().getCreator();
	}
}
