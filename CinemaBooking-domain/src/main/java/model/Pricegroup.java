package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the pricegroup database table.
 * 
 */
@Entity
@NamedQuery(name="Pricegroup.findAll", query="SELECT p FROM Pricegroup p")
public class Pricegroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRICEGROUP_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRICEGROUP_ID_GENERATOR")
	private int id;

	private String color;

	private String description;

	//bi-directional many-to-one association to Seat
	@OneToMany(mappedBy="pricegroup")
	private Set<Seat> seats;

	//bi-directional many-to-one association to Sessionprice
	@OneToMany(mappedBy="pricegroup")
	private Set<Sessionprice> sessionprices;

	public Pricegroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Seat> getSeats() {
		return this.seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Seat addSeat(Seat seat) {
		getSeats().add(seat);
		seat.setPricegroup(this);

		return seat;
	}

	public Seat removeSeat(Seat seat) {
		getSeats().remove(seat);
		seat.setPricegroup(null);

		return seat;
	}

	public Set<Sessionprice> getSessionprices() {
		return this.sessionprices;
	}

	public void setSessionprices(Set<Sessionprice> sessionprices) {
		this.sessionprices = sessionprices;
	}

	public Sessionprice addSessionprice(Sessionprice sessionprice) {
		getSessionprices().add(sessionprice);
		sessionprice.setPricegroup(this);

		return sessionprice;
	}

	public Sessionprice removeSessionprice(Sessionprice sessionprice) {
		getSessionprices().remove(sessionprice);
		sessionprice.setPricegroup(null);

		return sessionprice;
	}

}