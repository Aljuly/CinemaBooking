package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import facade.AbstractFacade;
import interfacesFacade.PricegroupFacadeInterface;
import model.Pricegroup;

@ManagedBean(name = "Pricegroup")
@SessionScoped
public class PgBean extends GenericBean<Pricegroup>{

	@EJB
	PricegroupFacadeInterface pgFacade;
	
	public PgBean() {
		super();
		delInitPage = "pricegroups";
		createInitPage = "pricegroups";
		updateInitPage = "pricegroups";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected AbstractFacade<Pricegroup> getFacade() {
		return (AbstractFacade<Pricegroup>) pgFacade;
	}

}
