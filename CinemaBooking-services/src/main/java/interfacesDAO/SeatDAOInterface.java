package interfacesDAO;

import model.Seat;

public interface SeatDAOInterface extends AbstractDAOInterface<Seat> {
	
	public int deleteAllSeatsInRow(int idRow);
	
	@javax.ejb.Remote
	interface Remote extends SeatDAOInterface {
	}
	
	@javax.ejb.Local
	interface Local extends SeatDAOInterface {
	}
}
