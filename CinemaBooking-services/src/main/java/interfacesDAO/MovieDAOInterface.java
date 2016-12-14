package interfacesDAO;

import javax.ejb.Local;

import model.Movie;

@Local
public interface MovieDAOInterface extends AbstractDAOInterface<Movie> {
	
	public Movie findMovieByDesignation(String designation);
	
}
