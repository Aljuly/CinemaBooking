package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the moovie database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m"),
	@NamedQuery(name = "Movie.findMovie", query = "SELECT m FROM Movie m WHERE m.designation = :designation")})
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOOVIE_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOOVIE_ID_GENERATOR")
	private int id;
	
	private String designation;
	
	private String posterImage;

	private String actors;

	private String ageRestrictions;

	private String country;

	@Lob
	private String description;

	private String director;
	
	@Temporal(TemporalType.TIME)
	private java.util.Date duration;   //http://www.developerscrappad.com/228/java/java-ee/ejb3-jpa-dealing-with-date-time-and-timestamp/

	private String genre;

	private String language;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="moovie")
	private Set<Session> sessions;

	public Movie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDesignation() {
		return this.designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getPosterImage() {
		return this.posterImage;
	}
	
	public void setPosterImage(String name) {
		this.posterImage = name;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getAgeRestrictions() {
		return this.ageRestrictions;
	}

	public void setAgeRestrictions(String ageRestrictions) {
		this.ageRestrictions = ageRestrictions;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public java.util.Date getDuration() {
		return this.duration;
	}

	public void setDuration(java.util.Date duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setMovie(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setMovie(null);

		return session;
	}

}