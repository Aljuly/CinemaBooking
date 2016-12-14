package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.SeatDAOInterface;
import model.Seat;

@Stateless
public class SeatDAO extends AbstractDAO<Seat> implements SeatDAOInterface {

	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	public SeatDAO() {
		super(Seat.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
