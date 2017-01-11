package interfacesDAO;

import java.util.List;

import javax.ejb.Local;

import model.Sessionprice;

@Local
public interface SessionPriceDAOInterface extends AbstractDAOInterface<Sessionprice> {
	public List<Sessionprice> findBySessionId(int id);
}
