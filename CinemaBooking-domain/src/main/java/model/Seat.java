package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the seat database table.
 * 
 */
@Entity
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s")
public class Seat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEAT_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEAT_ID_GENERATOR")
	private int id;
	
	//bi-directional many-to-one association to SeatsRow
	@ManyToOne
	@JoinColumn(name="idRow")
	private Seatsrow seatsrow;
	
	@Column(name = "placeNumber")
	private String placeNumber;

	//bi-directional many-to-one association to Pricegroup
	@ManyToOne
	@JoinColumn(name="idPriceGrouop")
	private Pricegroup pricegroup;

	//bi-directional many-to-one association to Seatselected
	@OneToMany(mappedBy="seat")
	private Set<Seatselected> seatselecteds;

	public Seat() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Seatsrow getSeatsrow() {
		return this.seatsrow;
	}

	public void setSeatsrow(Seatsrow seatsrow) {
		this.seatsrow = seatsrow;
	}

	public String getPlaceNumber() {
		return this.placeNumber;
	}

	public void setPlaceNumber(String placeNumber) {
		this.placeNumber = placeNumber;
	}

	public Pricegroup getPricegroup() {
		return this.pricegroup;
	}

	public void setPricegroup(Pricegroup pricegroup) {
		this.pricegroup = pricegroup;
	}

	public Set<Seatselected> getSeatselecteds() {
		return this.seatselecteds;
	}

	public void setSeatselecteds(Set<Seatselected> seatselecteds) {
		this.seatselecteds = seatselecteds;
	}

	public Seatselected addSeatselected(Seatselected seatselected) {
		getSeatselecteds().add(seatselected);
		seatselected.setSeat(this);

		return seatselected;
	}

	public Seatselected removeSeatselected(Seatselected seatselected) {
		getSeatselecteds().remove(seatselected);
		seatselected.setSeat(null);

		return seatselected;
	}

}