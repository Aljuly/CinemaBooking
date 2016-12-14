package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sessionprice database table.
 * 
 */
@Entity
@NamedQuery(name="Sessionprice.findAll", query="SELECT s FROM Sessionprice s")
public class Sessionprice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SESSIONPRICE_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SESSIONPRICE_ID_GENERATOR")
	private int id;

	private int price;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="idSession")
	private Session session;

	//bi-directional many-to-one association to Pricegroup
	@ManyToOne
	@JoinColumn(name="idPriceGroup")
	private Pricegroup pricegroup;

	public Sessionprice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Pricegroup getPricegroup() {
		return this.pricegroup;
	}

	public void setPricegroup(Pricegroup pricegroup) {
		this.pricegroup = pricegroup;
	}

}