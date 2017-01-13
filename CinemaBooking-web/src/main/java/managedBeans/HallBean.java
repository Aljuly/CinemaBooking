package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import facade.AbstractFacade;
import interfacesFacade.HallFacadeInterface;
import model.Hall;

@ManagedBean(name="hallBean")
@SessionScoped
public class HallBean extends GenericBean<Hall> {
	
	@EJB
	HallFacadeInterface hallService;
	
	public HallBean() {
		super();
		delInitPage = "index";
		createInitPage = "index";
		updateInitPage = "view";
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractFacade<Hall> getFacade() {
		return (AbstractFacade<Hall>) hallService;
	}


}
