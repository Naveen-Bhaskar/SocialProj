package niit.org.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.h2.engine.User;

@Entity
@Table(name="friend")
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private User  fromid;
	@ManyToOne
	private User told;
	private char status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getFromid() {
		return fromid;
	}
	public void setFromid(User fromid) {
		this.fromid = fromid;
	}
	public User getTold() {
		return told;
	}
	public void setTold(User told) {
		this.told = told;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}

}
