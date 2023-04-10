package com.itwill.ilhajob.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.itwill.ilhajob.common.entity.App;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "cv_id_SEQ_gen",
				   sequenceName = "cv_id_SEQ",
				   allocationSize = 1)
@Table(name = "cv")
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cv_id_SEQ_gen")
	private Long id;
	
	@Column(columnDefinition = "VARCHAR2(90) DEFAULT 'my resume'")
	private String cvName;
	
	@NonNull
	@Column(nullable = false, length = 1000)
	private String cvDescription;
	
	private String cvPortfolio;
		
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;
	
	@OneToMany(mappedBy = "cv",
			   cascade = CascadeType.PERSIST)
	private List<App> applist = new ArrayList<App>();
	
}
