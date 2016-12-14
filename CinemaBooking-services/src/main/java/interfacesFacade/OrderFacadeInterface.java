package interfacesFacade;

import model.Order;

public interface OrderFacadeInterface extends AbstractFacadeInterface<Order> {
	
	@javax.ejb.Remote
	interface Remote extends OrderFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends OrderFacadeInterface {
	}
}
