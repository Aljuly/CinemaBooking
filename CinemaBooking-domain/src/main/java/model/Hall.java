package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Arrays;
import java.util.List;

//http://www.developerscrappad.com/435/java/java-ee/ejb-3-x-jpa-bean-managed-transaction-with-javax-ejb-usertransaction/
//http://docs.oracle.com/javaee/6/tutorial/doc/giqst.html
//http://www.tutorialspoint.com/ejb/ejb_transactions.htm

//https://habrahabr.ru/post/249073/
//http://myblog-itsolutions.rhcloud.com/pages/java-ee-6/ear-maven-jboss.xhtml?postId=9


/**
 * The persistent class for the hall database table.
 * 
 */
@Entity
@NamedQuery(name="Hall.findAll", query="SELECT h FROM Hall h")
public class Hall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HALL_ID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HALL_ID_GENERATOR")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "number")
	private String number;

	//bi-directional many-to-one association to Seatsrow
	@OneToMany(mappedBy="hall")
	private List<Seatsrow> seatsrows;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="hall")
	private List<Session> sessions;

	public Hall() {
	}
	
	public Hall(String number, String desc) {
		this.description = desc;
		this.number = number;
	}
	
	public void addSeatsrows(Seatsrow... rows) {
		this.seatsrows.addAll(Arrays.asList(rows));
		for (Seatsrow row : rows) {
			row.setHall(this);
		}
	}
	
	public void addSessions(Session... sessions) {
		this.sessions.addAll(Arrays.asList(sessions));
		for (Session session : sessions) {
			session.setHall(this);
		}
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Seatsrow> getSeatsrows() {
		return this.seatsrows;
	}

	public void setSeatsrows(List<Seatsrow> seatsrows) {
		this.seatsrows = seatsrows;
	}

	public Seatsrow addSeatsrow(Seatsrow seatsrow) {
		getSeatsrows().add(seatsrow);
		seatsrow.setHall(this);
		return seatsrow;
	}

	public Seatsrow removeSeatsrow(Seatsrow seatsrow) {
		getSeatsrows().remove(seatsrow);
		seatsrow.setHall(null);
		return seatsrow;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setHall(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setHall(null);

		return session;
	}

}