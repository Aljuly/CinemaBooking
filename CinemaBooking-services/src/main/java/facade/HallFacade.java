package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.HallDAOInterface;
import interfacesFacade.HallFacadeInterface;
import model.Hall;

@Stateless
@LocalBean
public class HallFacade extends AbstractFacade<Hall> implements HallFacadeInterface {

	@EJB 
	HallDAOInterface entityDAO;

	@Override
	protected boolean isDataValid(Hall entity) {
		
		return false;
	}
}
