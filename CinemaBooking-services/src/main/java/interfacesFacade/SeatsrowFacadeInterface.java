package interfacesFacade;

import model.Seatsrow;

public interface SeatsrowFacadeInterface extends AbstractFacadeInterface<Seatsrow> {
	
	@javax.ejb.Remote
	interface Remote extends SeatsrowFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends SeatsrowFacadeInterface {
	}
}