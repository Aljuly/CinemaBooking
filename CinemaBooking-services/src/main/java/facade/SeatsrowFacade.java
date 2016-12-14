package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.SeatsrowDAOInterface;
import interfacesFacade.SeatsrowFacadeInterface;
import model.Seatsrow;

@Stateless
@LocalBean
public class SeatsrowFacade extends AbstractFacade<Seatsrow> implements SeatsrowFacadeInterface {

	@EJB 
	SeatsrowDAOInterface entityDAO;

	@Override
	protected boolean isDataValid(Seatsrow entity) {
		
		return false;
	}

}