package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.SessionDAOInterface;
import model.Session;

@Stateless
public class SessionDAO extends AbstractDAO<Session> implements SessionDAOInterface {

	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	public SessionDAO() {
		super(Session.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}