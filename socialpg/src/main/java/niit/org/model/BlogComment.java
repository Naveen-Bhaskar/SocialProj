package niit.org.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.h2.engine.User;

@Entity
@Table(name="blogcomment")
public class BlogComment {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@ManyToOne
private BlogPost blogpost;
@ManyToOne
private User commentedBy;
private String commentTxt;
private Date commentedOn;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public BlogPost getBlogpost() {
	return blogpost;
}
public void setBlogpost(BlogPost blogpost) {
	this.blogpost = blogpost;
}
public User getCommentedBy() {
	return commentedBy;
}
public void setCommentedBy(User commentedBy) {
	this.commentedBy = commentedBy;
}
public String getCommentTxt() {
	return commentTxt;
}
public void setCommentTxt(String commentTxt) {
	this.commentTxt = commentTxt;
}
public Date getCommentedOn() {
	return commentedOn;
}
public void setCommentedOn(Date commentedOn) {
	this.commentedOn = commentedOn;
}


}
