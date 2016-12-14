package facade;

import java.util.List;

import model.User;
import service.EmailValidator;
import dao.UserDAO;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserFacade implements UserFacadeLocal {
	
	@PersistenceContext(unitName = "Tickets")
    private EntityManager em;
	
	@EJB
	private UserDAO userDAO;
	
	@Resource
	private SessionContext context;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(User user) {
		try {
			if(isUserDataValid(user)) {
				@SuppressWarnings("rawtypes")
				List resultList = em.createNamedQuery("User.findUserByEmail").setParameter("email", user.getEmail()).getResultList();
				if (resultList.size() == 0){
					userDAO.save(user);
				}
			}
		} catch (Exception e) {
			context.setRollbackOnly();
			e.printStackTrace();
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public User update(User user) {
		try {
			if(isUserDataValid(user)) {
				return userDAO.update(user);
			}
		} catch (Exception e) {
			context.setRollbackOnly();
			e.printStackTrace();
		}
		return null;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(User user) {
		userDAO.delete(user);
	}

	public User find(int userID) {
		return userDAO.find(userID);
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}
	
	private boolean isUserDataValid(User user) {
		EmailValidator ev = new EmailValidator();
		if (user == null ) return false;
		// Email validation
		if (user.getEmail() == null || "".equals(user.getEmail().trim())){
			return false;
        } else {
        	if (!ev.validate(user.getEmail())) return false;
        }
		// User's name validation
		if (user.getName()== null || "".equals(user.getName().trim())) {
			return false;
		}
		// Does user select any seats?
		if (user.getOrders().isEmpty()) return false;
		return true;
	}

}
