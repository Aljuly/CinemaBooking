package interfacesFacade;

import model.Seat;

public interface SeatFacadeInterface extends AbstractFacadeInterface<Seat> {
	
	public int deleteAllSeatsInRow(int idRow);
	
	@javax.ejb.Remote
	interface Remote extends SeatFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends SeatFacadeInterface {
	}
}