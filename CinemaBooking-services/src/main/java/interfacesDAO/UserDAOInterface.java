package interfacesDAO;

import javax.ejb.Local;

import model.User;

@Local
public interface UserDAOInterface extends AbstractDAOInterface<User> {

}
