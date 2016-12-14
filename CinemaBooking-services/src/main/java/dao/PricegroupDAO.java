package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.PricegroupDAOInterface;
import model.Pricegroup;

@Stateless
public class PricegroupDAO extends AbstractDAO<Pricegroup> implements PricegroupDAOInterface {

	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	public PricegroupDAO() {
		super(Pricegroup.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
