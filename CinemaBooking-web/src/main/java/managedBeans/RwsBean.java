package managedBeans;

import java.lang.reflect.InvocationTargetException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import facade.AbstractFacade;
import interfacesFacade.HallFacadeInterface;
import interfacesFacade.SeatsrowFacadeInterface;
import model.Hall;
import model.Seatsrow;

@ManagedBean(name="rwsBean")
@SessionScoped
public class RwsBean extends GenericBean<Seatsrow>{

	private int hallId;
	private Hall hall;
	
	@EJB
	SeatsrowFacadeInterface sr;
	
	@EJB
	HallFacadeInterface hallFacade;
	
	public RwsBean() {
		super();
		delInitPage = "rowsManage";
		createInitPage = "rowsManage";
		updateInitPage = "rowsManage";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected AbstractFacade<Seatsrow> getFacade() {
		return (AbstractFacade<Seatsrow>) sr;
	}

	public int getHallId() {
		return hallId;
	}

	public void setHallId(int hallId) {
		this.hallId = hallId;
		hall = hallFacade.find(hallId);
	}
	
	@Override
	public void loadElements() {
		this.entities = hall.getSeatsrows();
	}
	
	@Override
	public String create() {
		this.entity.setHall(hall);
		return super.create();
	}
	
	@Override
	public String update() throws NoSuchMethodException, SecurityException, 
									IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.entity.setHall(hall);
		return super.update();
 	}

}
