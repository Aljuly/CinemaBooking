package dao;

import java.util.HashMap;
import java.util.Map;
 
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.UserDAOInterface;
import model.User;
 
@Stateless
public class UserDAO extends AbstractDAO<User> implements UserDAOInterface {
	
	@PersistenceContext(unitName="Tickets")
    private EntityManager em;
	
    public UserDAO() {
        super(User.class);
    }
 
    public User findUserByEmail(String email){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("email", email);     
        return super.findOneResult("User.findUserByEmail", parameters);
    }

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
