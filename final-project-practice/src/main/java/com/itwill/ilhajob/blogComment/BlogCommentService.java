package com.itwill.ilhajob.blogComment;

import java.util.List;

public interface BlogCommentService {
	
	/*
	 * findBlogComment(블로그댓글seq로 찾기)
	 */
	BlogComment findBlogComment(int commentSeq);
	
	/*
	 * selectAll(블로그댓글list)
	 */
	List<BlogComment> selectAll();
	
	/*
	 * selectByBlogComment(블로그seq로 찾기)
	 */
    List<BlogComment> selectByBlogComment(int blogSeq);
    
    /*
     * blogComment insert
     */
    int insertBlogComment(BlogComment blogComment);
    
    /*
     * blogComment update
     */
    int updateBlogComment(BlogComment blogComment);
    
    /*
     * blogComment delete
     */
    int deleteBlogComment(int commentSeq);

	List<BlogComment> findByUserSeqCommnt(int userSeq);
}
