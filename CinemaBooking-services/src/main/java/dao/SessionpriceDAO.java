package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.SessionPriceDAOInterface;
import model.Sessionprice;

@Stateless
public class SessionpriceDAO extends AbstractDAO<Sessionprice> implements SessionPriceDAOInterface {

	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	public SessionpriceDAO() {
		super(Sessionprice.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Sessionprice> findBySessionId(int id) {
		return em.createNamedQuery("Sessionprice.findPrices").setParameter("sessionId", id).getResultList();
	}

}