package managedBeans;

import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import facade.AbstractFacade;
import interfacesFacade.SessionFacadeInterface;
import model.Session;

@ManagedBean(name = "sesBean")
@SessionScoped
public class SesBean extends GenericBean<Session> {
	
    private Locale locale;
    private boolean popup;
    private String pattern;
    private boolean showApply = true;
	
	@EJB
	SessionFacadeInterface sesFacade;
	
	public SesBean() {
		super();
		delInitPage = "sessions";
		createInitPage = "sessions";
		updateInitPage = "sessions";
		locale = Locale.US;
        popup = true;
        pattern = "d/M/yy HH:mm";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected AbstractFacade<Session> getFacade() {
		return (AbstractFacade<Session>) sesFacade;
	}
	
	public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public boolean isPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    
    public boolean isShowApply() {
        return showApply;
    }

    public void setShowApply(boolean showApply) {
        this.showApply = showApply;
    }


}
