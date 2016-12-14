package facade;

import java.util.List;

import model.Hall;
import dao.HallDAO;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class HallFacade_old implements HallFacadeLocal{

	@PersistenceContext(unitName = "Tickets")
    private EntityManager em;
	
	@Resource
	SessionContext context;
	
	@EJB
	HallDAO hallDAO;
	
	public HallFacade() {}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Hall hall) {
		try {
			if (isHallDataValid(hall)) {
				@SuppressWarnings("rawtypes")
				List resultList = em.createNamedQuery("Hall.findHall").setParameter("number", hall.getNumber()).getResultList();
				if (resultList.size() == 0) {
					hallDAO.save(hall);
				}
			} 
		} catch (Exception e) {
			context.setRollbackOnly();
			e.printStackTrace();
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Hall update(Hall hall) {
		try {
			if (isHallDataValid(hall)) {
				hallDAO.update(hall);
			}
		} catch (Exception e) {
			context.setRollbackOnly();
			e.printStackTrace();
		}
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Hall hall) {
		hallDAO.delete(hall);		
	}

	public Hall find(int hallID) {
		return hallDAO.find(hallID);
	}

	public List<Hall> findAll() {
		return hallDAO.findAll();
	}
	
	private boolean isHallDataValid(Hall hall) {
		if (hall == null) return false;
		if (hall.getNumber() == null || "".equals(hall.getNumber().trim()))	return false;
		if (hall.getDescription() == null || "".equals(hall.getDescription().trim())) return false;
		return true;
	}

}
