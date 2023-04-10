package com.itwill.ilhajob.corp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/*
		corp_image_seq                		NUMBER(20)		 NULL ,
		corp_image                    		VARCHAR2(50)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CorpImageDto {
	int corpImageSeq;
	String corpImage;
	String corpId;
}
