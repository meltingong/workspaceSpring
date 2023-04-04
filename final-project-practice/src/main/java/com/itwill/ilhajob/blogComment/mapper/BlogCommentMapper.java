package com.itwill.ilhajob.blogComment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.itwill.ilhajob.blogComment.BlogComment;

@Mapper
public interface BlogCommentMapper {
	
	public BlogComment findBlogComment(int commentSeq);
    /*
    <select id="findBlogComment" parameterType="int" resultType="com.itwill.ilhajob.blogComment.BlogComment">
        select * from blog_comment where comment_seq = #{commentSeq}
    </select> 
    */
	
	public List<BlogComment> selectAll();
    /*
    <select id="selectAll" resultType="com.itwill.ilhajob.blogComment.BlogComment">
        select * from blog_comment 
    </select> 
    */ 
 
	public List<BlogComment> selectByBlogComment(int blogSeq);
	/*
	<select id="selectByBlogComment" parameterType="int" resultType="com.itwill.ilhajob.blogComment.BlogComment">
        select * from blog_comment where blog_seq = #{blogSeq}
    </select>
	*/
	

	public List<BlogComment> findByUserSeqCommnt(int userSeq);
	
	
	public int insertBlogComment(BlogComment blogComment);	
    /*
    <insert id="insertBlogComment" parameterType="com.itwill.ilhajob.blogComment.BlogComment">
        <selectKey>
            select blog_comment_comment_seq_SEQ.nextval from dual
        </selectKey>
        insert into blog_comment (comment_seq, comment_content, comment_date, user_seq, blog_seq)
        values(#{commentSeq}, #{commentContent}, #{commentDate}, #{userSeq}, #{blogSeq})    
    </insert>  
    */
	
	public int updateBlogComment(BlogComment blogComment);	
	/*
	<update id="updateBlogComment" parameterType="com.itwill.ilhajob.blogComment.BlogComment">
        update blog_comment set comment_seq = #{commentSeq}, comment_content=#{commentContent},
        comment_date=#{commentDate}, user_seq=#{userSeq}, blog_seq=#{blogSeq} where comment_seq=#{commentSeq} 
    </update>	
	*/
	
	public int deleteBlogComment(int commentSeq);
	/*
	<delete id="deleteBlogComment" parameterType="com.itwill.ilhajob.blog.Blog">
        delete from blog_comment where comment_seq = #{commentSeq}
    </delete>  
	*/
}
