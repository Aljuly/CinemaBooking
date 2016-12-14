package facade;

import java.util.List;

import javax.ejb.Local;
 
import model.Hall;

@Local
public interface HallFacadeLocal {
	
	public abstract void save(Hall hall);
	
	public abstract Hall update(Hall hall);
	
	public abstract void delete(Hall hall);
	
	public abstract Hall find(int hallID);
	
	public abstract List<Hall> findAll();
	
}
