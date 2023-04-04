package com.itwill.ilhajob.blogComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCommentDao {
	
    /*
    블로그 댓글 번호로 해당하는 댓글 리스트 조회
    */
	BlogComment findBlogComment(int commentSeq);
	
	/*
	블로그가 가지고 있는 댓글 리스트 모두조회
	*/	
	List<BlogComment> selectAll();
	
	/*
	블로그 번호로 해당하는 댓글 리스트 조회
	 */
    List<BlogComment> selectByBlogComment(int blogSeq);
    
    /*
	블로그 댓글테이블에 새로운댓글생성
	*/
	int insertBlogComment(BlogComment blogComment);
	
	/*
	기존의 블로그댓글을 수정
	*/
    int updateBlogComment(BlogComment blogComment);
    
    /*
    블로그 댓글번호에 해당하는 댓글 삭제
    */
    int deleteBlogComment(int commentSeq);
    
    List<BlogComment> findByUserSeqCommnt(int userSeq);
    
}
