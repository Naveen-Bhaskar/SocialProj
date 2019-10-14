package com.niit.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="friend")
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private User fromid;
	@ManyToOne
	private User toid;
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
	public void setFromid(User fromId) {
		this.fromid = fromId;
	}
	public User getToid() {
		return toid;
	}
	public void setToid(User toid) {
		this.toid = toid;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}

}

