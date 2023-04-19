package com.itwill.ilhajob.common.dto;

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
public class RecruitTagDto {
		private long id;
		private long recruitId;
		private long tagId;
	}

