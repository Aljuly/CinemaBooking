package interfacesFacade;

import model.Pricegroup;

public interface PricegroupFacadeInterface extends AbstractFacadeInterface<Pricegroup> {
	
	@javax.ejb.Remote
	interface Remote extends PricegroupFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends PricegroupFacadeInterface {
	}
}
