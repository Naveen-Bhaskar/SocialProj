package niit.org.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import niit.org.model.BlogComment;

@Repository
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addBlogComment(BlogComment blogComment) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogComment);
	}

	public List<BlogComment> getBlogComment(int blogPostId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogComment where blogPost=?");
		query.setInteger(0, blogPostId);
		List<BlogComment> blogComments=query.list();
		return blogComments;
	}

	public void deleteBlogComment(BlogComment blogComment) {
		Session session=sessionFactory.getCurrentSession();		
		session.delete(blogComment);		
	}

}
