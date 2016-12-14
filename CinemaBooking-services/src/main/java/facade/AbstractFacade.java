package facade;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import dao.AbstractDAO;

@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class AbstractFacade<T> {
	
	@EJB
	AbstractDAO<T> entityDAO;
	
	@Resource
	SessionContext context;
	
	protected abstract boolean isDataValid(T entity);
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(T entity) {
		try {
			if (isDataValid(entity)) entityDAO.save(entity);
		} catch (Exception e) {
			context.setRollbackOnly();
			e.printStackTrace();
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public T update(T entity) {
		try {
			if (isDataValid(entity)) entityDAO.update(entity);
		} catch (Exception e) {
			context.setRollbackOnly();
			e.printStackTrace();
		}
		return null;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(T entity) {
		entityDAO.delete(entity);		
	}

	public T find(int id) {
		return entityDAO.find(id);
	}

	public List<T> findAll() {
		return entityDAO.findAll();
	}
	
	public long count() {
		return entityDAO.count();
	}
}
