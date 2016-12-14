package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.SeatselectedDAOInterface;
import interfacesFacade.SeatselectedFacadeInterface;
import model.Seatselected;

@Stateless
@LocalBean
public class SeatselectedFacade extends AbstractFacade<Seatselected> implements SeatselectedFacadeInterface {

	@EJB 
	SeatselectedDAOInterface entityDAO;

	@Override
	protected boolean isDataValid(Seatselected entity) {
		
		return false;
	}

}