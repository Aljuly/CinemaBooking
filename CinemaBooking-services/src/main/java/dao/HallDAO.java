package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.HallDAOInterface;
import model.Hall;

@Stateless
public class HallDAO extends AbstractDAO<Hall> implements HallDAOInterface {

	public HallDAO() {
		super(Hall.class);
	}

	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	protected EntityManager getEntityManager() {
        return em;
    }

}
