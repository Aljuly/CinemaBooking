package interfacesFacade;

import model.Seat;

public interface SeatFacadeInterface extends AbstractFacadeInterface<Seat> {
	
	@javax.ejb.Remote
	interface Remote extends SeatFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends SeatFacadeInterface {
	}
}