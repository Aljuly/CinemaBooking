package interfacesDAO;

import model.Order;

public interface OrderDAOInterface extends AbstractDAOInterface<Order> {
	
	@javax.ejb.Remote
	interface Remote extends OrderDAOInterface {
	}
	
	@javax.ejb.Local
	interface Local extends OrderDAOInterface {
	}
}