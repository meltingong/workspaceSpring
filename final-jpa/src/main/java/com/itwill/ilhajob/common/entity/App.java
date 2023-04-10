package com.itwill.ilhajob.common.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.itwill.ilhajob.corp.entity.Corp;
import com.itwill.ilhajob.corp.entity.Recruit;
import com.itwill.ilhajob.user.entity.Cv;
import com.itwill.ilhajob.user.entity.Message;
import com.itwill.ilhajob.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "app_id_SEQ_gen",
				   sequenceName = "app_id_SEQ",
				   allocationSize = 1)
@Table(name = "app")
public class App {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "app_id_SEQ_gen")
	private Long id;
	
	@Column(columnDefinition = "CHAR(1) DEFAUlT '0'")
	private char app_status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recruit_id")
	@ToString.Exclude
	private Recruit recruit;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cv_id")
	@ToString.Exclude
	private Cv cv;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "corp_id")
	@ToString.Exclude
	private Corp corp;
	
	@OneToMany(mappedBy = "app",
			   fetch = FetchType.LAZY)
	private List<Message> messageList = new ArrayList<Message>();
}