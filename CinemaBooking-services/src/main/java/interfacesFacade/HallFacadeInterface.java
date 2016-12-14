package interfacesFacade;

import model.Hall;

public interface HallFacadeInterface extends AbstractFacadeInterface<Hall> {
	
	@javax.ejb.Remote
	interface Remote extends HallFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends HallFacadeInterface {
	}
}
