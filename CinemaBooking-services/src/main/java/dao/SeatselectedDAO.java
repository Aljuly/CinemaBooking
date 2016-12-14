package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.SeatselectedDAOInterface;
import model.Seatselected;

@Stateless
public class SeatselectedDAO extends AbstractDAO<Seatselected> implements SeatselectedDAOInterface {

	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	public SeatselectedDAO() {
		super(Seatselected.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}