package interfacesFacade;

import java.util.List;

public interface AbstractFacadeInterface<T> {
	
	// abstract interface
	public void save(T entity);
	void delete(T entity);
	T update(T entity);
	T find(int id);
	List<T> findAll();
	long count();
}
