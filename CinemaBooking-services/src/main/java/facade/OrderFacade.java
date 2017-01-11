package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.OrderDAOInterface;
import interfacesFacade.OrderFacadeInterface;
import model.Order;

@Stateless
@LocalBean
public class OrderFacade extends AbstractFacade<Order> implements OrderFacadeInterface {

	@EJB 
	OrderDAOInterface entityDAO;

	@Override
	protected boolean isDataValid(Order entity) {
		
		return false;
	}
}
