package com.itwill.ilhajob.corp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.itwill.ilhajob.common.entity.App;
import com.itwill.ilhajob.common.entity.CorpTag;
import com.itwill.ilhajob.common.entity.Orders;
import com.itwill.ilhajob.common.entity.Payment;
import com.itwill.ilhajob.user.entity.CorpBookmark;
import com.itwill.ilhajob.user.entity.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "corp_id_SEQ_gen",
				   sequenceName = "corp_id_SEQ",
				   allocationSize = 1)
@Table(name = "corp")
public class Corp {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corp_id_SEQ_gen")
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	private String corpLoginId;
	
	@NonNull
	@Column(nullable = false)
	private String corpPassword;
	
	private String corpName;
	
	private String corpPhone;
	
	private String corpBusinessNo;
	
	private String corpWebsite;
	
	private Date corpEst;
	
	private String corpSize;
	
	private String corpSales;
	
	@Column(length = 1000)
	private String corpComment;
	
	@Column(length = 600)
	private String corpWelfare;
	
	@Column(length = 600)
	private String corpAddress;
	
	private char corpStatus;
	
	private String job;
	
	@Column(columnDefinition = "NUMBER(1) DEFAULT 2")
	private Integer role;
	
	@OneToMany(mappedBy = "corp",
			   cascade = CascadeType.REMOVE)
	@ToString.Exclude
	private List<App> appList = new ArrayList<App>();
	
	@OneToMany(mappedBy = "corp")
	@ToString.Exclude
	private List<Orders> orders = new ArrayList<Orders>();
	
	@OneToMany(mappedBy = "corp",
			   cascade = CascadeType.REMOVE)
	@ToString.Exclude
	private List<Recruit> recruitList = new ArrayList<Recruit>();
	
	@OneToMany(mappedBy = "corp",
			   cascade = CascadeType.REMOVE)
	@ToString.Exclude
	private List<Review> reviewList = new ArrayList<Review>();
	
	@OneToMany(mappedBy = "corp",
			   cascade = CascadeType.REMOVE)
	@ToString.Exclude
	private List<CorpImage> corpImageList = new ArrayList<CorpImage>();
	
	@OneToMany(mappedBy = "corp",
			   cascade = CascadeType.REMOVE)
	@ToString.Exclude
	private List<Manager> managerList = new ArrayList<Manager>();
	
	@OneToMany(mappedBy = "corp")
	@ToString.Exclude
	private List<CorpTag> corpTagList = new ArrayList<CorpTag>();
	
	@OneToMany(mappedBy = "corp",
			   cascade = CascadeType.REMOVE)
	@ToString.Exclude
	private List<CorpBookmark> corpBookmarkList = new ArrayList<CorpBookmark>();
	
	@OneToMany(mappedBy = "corp",
			   cascade = CascadeType.PERSIST)
	@ToString.Exclude
	private List<Payment> paymentList = new ArrayList<Payment>();
}

