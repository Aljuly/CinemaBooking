package managedBeans;

import java.lang.reflect.InvocationTargetException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import facade.SeatFacade;
import interfacesFacade.SeatFacadeInterface;
import interfacesFacade.SeatsrowFacadeInterface;
import model.Pricegroup;
import model.Seat;
import model.Seatsrow;

@ManagedBean(name="stBean")
@SessionScoped
public class StBean extends GenericBean<Seat> {

	private int from;
	private int to;
	private int pricegroupId;
	private int seatsrowId;
	private Seatsrow row;
	private Pricegroup pricegroup;
	
	@EJB
	SeatFacadeInterface seat;
	
	@EJB
	SeatsrowFacadeInterface seatsrowFacade;
	
	public StBean() {
		super();
		delInitPage = "seatsManage";
		createInitPage = "seatsManage";
		updateInitPage = "seatsManage";
	}
	
	@Override
	protected SeatFacade getFacade() {
		return (SeatFacade) seat;
	}

	public Seatsrow getRow() {
		return row;
	}

	public void setRow(Seatsrow row) {
		this.row = row;
	}


	public int getPricegroupId() {
		return pricegroupId;
	}


	public void setPricegroupId(int pricegroupId) {
		this.pricegroupId = pricegroupId;
		this.row = seatsrowFacade.find(seatsrowId);
	}


	public int getTo() {
		return to;
	}


	public void setTo(int to) {
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}
	
	@Override
	public void loadElements() {
		this.entities = row.getSeats();
	}
	
	@Override
	public String create() {
		this.entity.setSeatsrow(row);
		return super.create();
	}
	
	@Override
	public String update() throws NoSuchMethodException, SecurityException, 
									IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.entity.setSeatsrow(row);
		return super.update();
	}
	
	public String deleteAll() {
		try {
			getFacade().deleteAllSeatsInRow(seatsrowId);
			MessageUtil.addSuccessMessage("successfully deleted.");
		} catch (Exception e) {
			MessageUtil.addErrorMessage("Could not delete!");
		}
		return delInitPage;
	}
	
	public String addGroup() {
		for (int i = from; i <= to; i++) {
			newEntityInstance();
			this.entity.setPlaceNumber(Integer.toString(i));
			this.entity.setSeatsrow(row);
			this.entity.setPricegroup(pricegroup);
			getFacade().save(this.entity);
		}
		return createInitPage;
	}

}
