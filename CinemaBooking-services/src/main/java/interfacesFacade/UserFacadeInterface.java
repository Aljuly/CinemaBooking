package interfacesFacade;

import model.User;

public interface UserFacadeInterface extends AbstractFacadeInterface<User> {
	
	@javax.ejb.Remote
	interface Remote extends UserFacadeInterface {
	}
	
	@javax.ejb.Local
	interface Local extends UserFacadeInterface {
	}
}