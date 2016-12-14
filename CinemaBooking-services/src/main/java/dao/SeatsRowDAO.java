package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.SeatsrowDAOInterface;
import model.Seatsrow;

@Stateless
public class SeatsRowDAO extends AbstractDAO<Seatsrow> implements SeatsrowDAOInterface {
	
	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	public SeatsRowDAO() {
		super(Seatsrow.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
