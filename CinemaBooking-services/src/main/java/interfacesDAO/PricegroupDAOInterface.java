package interfacesDAO;

import model.Pricegroup;

public interface PricegroupDAOInterface extends AbstractDAOInterface<Pricegroup> {
	
	@javax.ejb.Remote
	interface Remote extends PricegroupDAOInterface {
	}
	
	@javax.ejb.Local
	interface Local extends PricegroupDAOInterface {
	}
}
