package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.SessionDAOInterface;
import interfacesFacade.SessionFacadeInterface;
import model.Session;

@Stateless
@LocalBean
public class SessionFacade extends AbstractFacade<Session> implements SessionFacadeInterface {

	@EJB 
	SessionDAOInterface entityDAO;

	@Override
	protected boolean isDataValid(Session entity) {
		
		return false;
	}

}
