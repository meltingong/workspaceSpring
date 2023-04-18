package com.springboot.security.oauth.common.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * 
CREATE TABLE blog_comment(
		comment_seq                   		NUMBER(20)		 NULL ,
		comment_content               		VARCHAR2(50)		 NULL ,
		comment_date                  		DATE		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL ,
		blog_seq                      		NUMBER(20)		 NOT NULL
);
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BlogCommentDto {
	private long id;
	private String commentContent;
	private LocalDateTime commentDate;
	private int userSeq;
	private int blogSeq;
}
