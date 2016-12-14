package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.PricegroupDAOInterface;
import interfacesFacade.PricegroupFacadeInterface;
import model.Pricegroup;

@Stateless
@LocalBean
public class PricegroupFacade extends AbstractFacade<Pricegroup> implements PricegroupFacadeInterface {

	@EJB 
	PricegroupDAOInterface entityDAO;

	@Override
	protected boolean isDataValid(Pricegroup entity) {
		
		return false;
	}

}
