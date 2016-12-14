package interfacesFacade;

import model.Sessionprice;

public interface SessionPriceFacadeInterface extends AbstractFacadeInterface<Sessionprice> {
	
	@javax.ejb.Remote
	interface Remote extends SessionPriceFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends SessionPriceFacadeInterface {
	}
}