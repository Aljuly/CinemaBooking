package dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfacesDAO.MovieDAOInterface;
import model.Movie;

@Stateless
public class MovieDAO extends AbstractDAO<Movie> implements MovieDAOInterface  {
	
	@PersistenceContext(unitName="CinemaBooking")
    private EntityManager em;
	
	public MovieDAO() {
		super(Movie.class);
	}
	
	public Movie findMovieByDesignation(String designation) {
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("designation", designation);     
        return super.findOneResult("Movie.findMovie", parameters);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
