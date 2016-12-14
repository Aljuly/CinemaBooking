package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.OrderDAOInterface;
import model.Order;

@Stateless
public class OrderDAO extends AbstractDAO<Order> implements OrderDAOInterface {

	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	public OrderDAO() {
		super(Order.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
