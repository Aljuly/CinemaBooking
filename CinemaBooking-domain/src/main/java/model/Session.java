package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SESSION_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SESSION_ID_GENERATOR")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sessionTime;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="session")
	private Set<Order> orders;

	//bi-directional many-to-one association to Moovie
	@ManyToOne
	@JoinColumn(name="idMovie")
	private Movie movie;

	//bi-directional many-to-one association to Hall
	@ManyToOne
	@JoinColumn(name="idHall")
	private Hall hall;

	//bi-directional many-to-one association to Sessionprice
	@OneToMany(mappedBy="session")
	private Set<Sessionprice> sessionprices;

	public Session() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSessionTime() {
		return this.sessionTime;
	}

	public void setSessionTime(Date sessionTime) {
		this.sessionTime = sessionTime;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setSession(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setSession(null);

		return order;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie moovie) {
		this.movie = moovie;
	}

	public Hall getHall() {
		return this.hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Set<Sessionprice> getSessionprices() {
		return this.sessionprices;
	}

	public void setSessionprices(Set<Sessionprice> sessionprices) {
		this.sessionprices = sessionprices;
	}

	public Sessionprice addSessionprice(Sessionprice sessionprice) {
		getSessionprices().add(sessionprice);
		sessionprice.setSession(this);

		return sessionprice;
	}

	public Sessionprice removeSessionprice(Sessionprice sessionprice) {
		getSessionprices().remove(sessionprice);
		sessionprice.setSession(null);

		return sessionprice;
	}

}