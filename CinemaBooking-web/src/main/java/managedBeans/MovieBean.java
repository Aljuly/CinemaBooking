package managedBeans;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import facade.AbstractFacade;
import interfacesFacade.MovieFacadeInterface;
import model.Movie;

@ManagedBean(name="Movie")
@SessionScoped
public class MovieBean extends GenericBean<Movie>{
	
	@EJB
	private MovieFacadeInterface mf;
	
	private Part moviePoster;
	
	private int hours;

	private int minutes;
	
	public MovieBean() {
		super();
		delInitPage = "moviesList";
		createInitPage = "movieDescEdit";
		updateInitPage = "viewMovieDesc";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected AbstractFacade<Movie> getFacade() {
		return (AbstractFacade<Movie>) mf;
	}
	
	public Part getMooviePoster() {
		return this.moviePoster;
	}
	
	public void setMooviePoster(Part poster) {
		this.moviePoster = poster;
	}
	
	public int getHours() {
		return this.hours;
	}
	
	public int getMinutes() {
		return this.minutes;
	} 
	
	public void setHours(int h) {
		this.hours = h;
	}
	
	public void setMinutes(int m) {
		this.minutes = m;
	}
	
	public String uploadPoster() throws IOException {
		Path file = Files.createTempFile(Paths.get("/var/webapp/images"), "tempfilename-", ".jpg");
		try (InputStream input = moviePoster.getInputStream()) {
		    Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
		}
		this.entity.setPosterImage(file.getFileName().toString()); 
		return "success";
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String create() {
		Date duration = new Date();
		duration.setHours(hours);
		duration.setMinutes(minutes);
		this.entity.setDuration(duration);
		return super.create();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String update() throws NoSuchMethodException, SecurityException, IllegalAccessException, 
								IllegalArgumentException, InvocationTargetException {
		Date duration = new Date();
		duration.setHours(hours);
		duration.setMinutes(minutes);
		this.entity.setDuration(duration);
		return super.update();
	}
}
