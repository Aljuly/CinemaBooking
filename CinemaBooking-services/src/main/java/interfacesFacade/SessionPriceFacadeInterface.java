package interfacesFacade;

import java.util.List;

import model.Sessionprice;

public interface SessionPriceFacadeInterface extends AbstractFacadeInterface<Sessionprice> {
	
	public List<Sessionprice> findBySessionId(int id);
	
	@javax.ejb.Remote
	interface Remote extends SessionPriceFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends SessionPriceFacadeInterface {
	}
}