package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import facade.AbstractFacade;
import interfacesFacade.SessionPriceFacadeInterface;
import model.Sessionprice;

@ManagedBean(name="spBean")
@SessionScoped
public class SpBean extends GenericBean<Sessionprice> {
	
	@EJB
	private SessionPriceFacadeInterface spf;
	
	private int sessionId;
	
	private boolean editTable;
	
	public SpBean() {
		super();
		setEditTable(false);
		delInitPage = "sessionPrice";
		createInitPage = "sessionPrice";
		updateInitPage = "sessionPrice";
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractFacade<Sessionprice> getFacade() {
		return (AbstractFacade<Sessionprice>) spf;
	}
	
	@Override
	public void loadElements() {
		this.entities = spf.findBySessionId(sessionId);
	}

	public boolean isEditTable() {
		return editTable;
	}

	public void setEditTable(boolean editTable) {
		this.editTable = editTable;
	}

}
