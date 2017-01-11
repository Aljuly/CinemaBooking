package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.SessionPriceDAOInterface;
import interfacesFacade.SessionPriceFacadeInterface;
import model.Sessionprice;

@Stateless
@LocalBean
public class SessionPriceFacade extends AbstractFacade<Sessionprice> implements SessionPriceFacadeInterface {

	@EJB 
	SessionPriceDAOInterface entityDAO;
	
	public List<Sessionprice> findBySessionId(int id) {
		return entityDAO.findBySessionId(id);
	}
	
	@Override
	protected boolean isDataValid(Sessionprice entity) {
		if (entity == null) return false;
		if (entity.getPrice()<10) return false;		//price is too low!!
		if (entity.getPrice()>300) return false;	//price is too high!!
		return true;
	}

}