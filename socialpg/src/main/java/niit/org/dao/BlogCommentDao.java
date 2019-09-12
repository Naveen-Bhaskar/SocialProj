package niit.org.dao;

import java.util.List;

import niit.org.model.BlogComment;

public interface BlogCommentDao {
void addBlogComment(BlogComment blogComment);
List<BlogComment> getBlogComment(int blogPostId);
void deleteBlogComment(BlogComment blogComment);
}
