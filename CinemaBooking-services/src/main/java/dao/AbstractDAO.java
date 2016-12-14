package dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import interfacesDAO.AbstractDAOInterface;
 
public abstract class AbstractDAO<T> implements AbstractDAOInterface<T> {
    private final static String UNIT_NAME = "CinemaBooking";
 
    @PersistenceContext(unitName = UNIT_NAME)
    protected abstract EntityManager getEntityManager();
    
    private Class<T> entityClass;
 
    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
 
    public void save(T entity) {
    	getEntityManager().persist(entity);
    }
 
    public void delete(T entity) {
    	getEntityManager().remove(getEntityManager().merge(entity));
    }
 
    public T update(T entity) {
        return getEntityManager().merge(entity);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    } 
    
    public T find(int entityID) {
        return getEntityManager().find(entityClass, entityID);
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
    	javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
 
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;
 
        try {
            Query query = getEntityManager().createNamedQuery(namedQuery);
 
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
 
            result = (T) query.getSingleResult();
 
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
 
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
 
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
    
    
}
