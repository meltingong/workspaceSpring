package com.itwill.ilhajob.corpBookmark;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CorpBookmark {
	String user_email;
	String corp_id;
}
