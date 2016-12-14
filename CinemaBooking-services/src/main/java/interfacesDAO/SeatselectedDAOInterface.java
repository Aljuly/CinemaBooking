package interfacesDAO;

import model.Seatselected;

public interface SeatselectedDAOInterface extends AbstractDAOInterface<Seatselected> {
	
	@javax.ejb.Remote
	interface Remote extends PricegroupDAOInterface {
	}
	
	@javax.ejb.Local
	interface Local extends PricegroupDAOInterface {
	}
}
