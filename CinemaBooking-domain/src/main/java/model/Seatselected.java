package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seatselected database table.
 * 
 */

@Entity
@NamedQuery(name="Seatselected.findAll", query="SELECT s FROM Seatselected s")
public class Seatselected implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEATSELECTED_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEATSELECTED_ID_GENERATOR")
	private int id;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="idOrder")
	private Order order;

	//bi-directional many-to-one association to Seat
	@ManyToOne
	@JoinColumn(name="idSeat")
	private Seat seat;

	public Seatselected() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}