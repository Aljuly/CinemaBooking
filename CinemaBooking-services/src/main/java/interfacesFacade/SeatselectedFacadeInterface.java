package interfacesFacade;

import model.Seatselected;

public interface SeatselectedFacadeInterface extends AbstractFacadeInterface<Seatselected> {
	
	@javax.ejb.Remote
	interface Remote extends SeatselectedFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends SeatselectedFacadeInterface {
	}
}