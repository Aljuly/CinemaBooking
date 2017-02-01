package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the seatsrow database table.
 * 
 */
@Entity
@NamedQuery(name="Seatsrow.findAll", query="SELECT s FROM Seatsrow s")
public class Seatsrow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEATSROW_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEATSROW_ID_GENERATOR")
	private int id;
	
	//bi-directional many-to-one association to Hall
	@ManyToOne
	@JoinColumn(name="hallid")
	private Hall hall;
	
	//bi-directional one-to-many association to Seatsrow
	@OneToMany(mappedBy="seatsrow")
	private List<Seat> seats;
	
	@Column(name = "rownumber")
	private String rownumber;

	public Seatsrow() {
	}
	
	public Seatsrow(String number) {
		this.rownumber = number;
	}

	public void addSeats(Seat... seats) {
		this.seats.addAll(Arrays.asList(seats));
		for (Seat seat : seats) {
			seat.setSeatsrow(this);
		}
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Hall getHall() {
		return this.hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public String getRownumber() {
		return this.rownumber;
	}

	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}
	
	// Working with a seats in this row
	public List<Seat> getSeats() {
		return this.seats;
	}
	
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	public Seat addSeat(Seat seat) {
		getSeats().add(seat);
		seat.setSeatsrow(this);
		return seat;
	}
	
	public Seat removeSeat(Seat seat) {
		getSeats().remove(seat);
		seat.setSeatsrow(null);
		return seat;
	}
	//---------------------------------

}