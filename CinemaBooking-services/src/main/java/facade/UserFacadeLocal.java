package facade;

import java.util.List;

import javax.ejb.Local;
 
import model.User;

@Local
public interface UserFacadeLocal {
	
	public abstract void save(User user);
	
	public abstract User update(User user);
	
	public abstract void delete(User user);
	
	public abstract User find(int userID);
	
	public abstract List<User> findAll();
}
