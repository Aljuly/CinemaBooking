package interfacesDAO;

import java.util.List;

public interface AbstractDAOInterface<T> {
 
	// abstract interface

    public void save(T entity);
 
    public void delete(T entity);
 
    public T update(T entity);
    
	public int count();
    
    public T find(int entityID);
 
    public List<T> findAll();

}
