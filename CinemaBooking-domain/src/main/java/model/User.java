package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.Set;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findUserByEmail", query = "SELECT u FROM User u WHERE u.email = :email")})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_EMAIL = "User.findUserByEmail";
	
	@Id
	@SequenceGenerator(name="USER_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ID_GENERATOR")
	private int id;
	
	@Column(name = "email")
	@NotNull
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surename")
	private String surename;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private Set<Order> orders;

	public User() {
	}
	
	public User(String email, String name, String surename) {
		this.email = email;
		this.name = name;
		this.surename = surename;
	}
	
	public void addOrders(Order...orders) {
		this.orders.addAll(Arrays.asList(orders));
		for (Order order : orders) {
			order.setUser(this);
		}
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return this.surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

}