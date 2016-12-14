package interfacesFacade;

import model.Session;

public interface SessionFacadeInterface extends AbstractFacadeInterface<Session> {
	
	@javax.ejb.Remote
	interface Remote extends SessionFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends SessionFacadeInterface {
	}
}