package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDER_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_ID_GENERATOR")
	private int id;

	private String orderCod;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="idSession")
	private Session session;

	//bi-directional many-to-one association to Seatselected
	@OneToMany(mappedBy="order")
	private Set<Seatselected> seatselecteds;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderCod() {
		return this.orderCod;
	}

	public void setOrderCod(String orderCod) {
		this.orderCod = orderCod;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Set<Seatselected> getSeatselecteds() {
		return this.seatselecteds;
	}

	public void setSeatselecteds(Set<Seatselected> seatselecteds) {
		this.seatselecteds = seatselecteds;
	}

	public Seatselected addSeatselected(Seatselected seatselected) {
		getSeatselecteds().add(seatselected);
		seatselected.setOrder(this);

		return seatselected;
	}

	public Seatselected removeSeatselected(Seatselected seatselected) {
		getSeatselecteds().remove(seatselected);
		seatselected.setOrder(null);

		return seatselected;
	}

}