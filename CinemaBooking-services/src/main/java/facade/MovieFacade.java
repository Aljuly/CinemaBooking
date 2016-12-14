package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import interfacesDAO.MovieDAOInterface;
import interfacesFacade.MovieFacadeInterface;
import model.Movie;

@Stateless
@LocalBean
public class MovieFacade extends AbstractFacade<Movie> implements MovieFacadeInterface {
	
	@EJB
	MovieDAOInterface entityDAO;

	@Override
	protected boolean isDataValid(Movie movie) {
		if (movie == null) return false;
		if (entityDAO.findMovieByDesignation(movie.getDesignation()) == null) {
			if (movie.getDesignation() == null || "".equals(movie.getDesignation().trim())) return false;
		}
		return true;
	}
}
