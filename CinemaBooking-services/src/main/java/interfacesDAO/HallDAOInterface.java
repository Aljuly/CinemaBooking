package interfacesDAO;

import model.Hall;

public interface HallDAOInterface extends AbstractDAOInterface<Hall> {
	
	@javax.ejb.Remote
	interface Remote extends HallDAOInterface {
	}
	
	@javax.ejb.Local
	interface Local extends HallDAOInterface {
	}
}
