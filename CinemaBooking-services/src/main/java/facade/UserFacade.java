package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import interfacesDAO.UserDAOInterface;
import interfacesFacade.UserFacadeInterface;
import model.User;

@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeInterface {

	@EJB 
	UserDAOInterface entityDAO;
	
	@EJB
	EmailValidator ev;

	@Override
	protected boolean isDataValid(User entity) {
		if (entity == null ) return false;
		// Email validation
		if (entity.getEmail() == null || "".equals(entity.getEmail().trim())){
			return false;
        } else {
        	if (!ev.validate(entity.getEmail())) return false;
        }
		// User's name validation
		if (entity.getName()== null || "".equals(entity.getName().trim())) {
			return false;
		}
		// Does user selected any seats?
		if (entity.getOrders().isEmpty()) return false;
		return true;
	}

}