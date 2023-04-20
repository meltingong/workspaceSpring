package com.itwill.ilhajob.common.dto;

import java.util.List;

import com.itwill.ilhajob.corp.dto.RecruitDto;

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
public class RecruitTagWithNameDto {
		private long id;
		private RecruitDto recruit;
		private long tagId;
		private List<String> tagNameList;
	}

