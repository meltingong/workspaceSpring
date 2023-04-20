package com.itwill.ilhajob.common.dto;


import com.itwill.ilhajob.corp.dto.CorpDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CorpTagWithNameDto {
	private long id;
	private CorpDto corp;
	private long tagId;
	private String tagName;
}
