package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.SeatDAOInterface;
import interfacesFacade.SeatFacadeInterface;
import model.Seat;

@Stateless
@LocalBean
public class SeatFacade extends AbstractFacade<Seat> implements SeatFacadeInterface {

	@EJB 
	SeatDAOInterface entityDAO;

	@Override
	protected boolean isDataValid(Seat entity) {
		
		return false;
	}

	@Override
	public int deleteAllSeatsInRow(int idRow) {
		return entityDAO.deleteAllSeatsInRow(idRow);
	}

}