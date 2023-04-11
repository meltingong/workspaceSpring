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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.itwill.ilhajob.common.entity.App;
import com.itwill.ilhajob.common.entity.Blog;
import com.itwill.ilhajob.common.entity.BlogComment;
import com.itwill.ilhajob.common.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@SequenceGenerator(	name="user_id_SEQ_gen",
					sequenceName = "user_id_SEQ",
					allocationSize = 1)
@Table(name = "userinfo")
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	@Column(nullable = false)
    private String userEmail;
	@NonNull
	@Column(nullable = false)
    private String userPassword;
	
    private String userName;
    
    private String userPhone;
    
    private String userSex;
    
    @Column(length = 600)
    private String userAddress;
    
    private String userCareer;
    
    private Integer userAge;
    
    private String userFinalEducation;
    
    private String userLanguage;
    
    @Column(length = 300)
    private String userSkills;
    
    private String userImage;
    
    private char userStatus;
    
    private String snsType;
    
    private String snsId;
    
    private String job;
    
    private int role;
    
    @OneToMany( mappedBy = "user",
    			cascade = CascadeType.ALL)
    private List<App> appList = new ArrayList<App>();
    // 바로 초기화 시 nullPointException 이나  LazyInitializationException와 같은 예외상황 발생하지않음
    
    @OneToMany( mappedBy = "user",
    			cascade = CascadeType.REMOVE)
    private List<Cv> cvList = new ArrayList<Cv>();
    
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL)
    private List<Exp> expList = new ArrayList<Exp>();
    
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL) // mappedBy로 설정된것 주인x edu에서 객체로 가진 user를 말함
    private List<Edu> eduList = new ArrayList<Edu>();
    
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL)
    private List<Awards> awardsList = new ArrayList<Awards>();
    
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<Review>();
    
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL)
    private List<CorpBookmark> corpBookmarkList = new ArrayList<CorpBookmark>();
   
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL)
    private List<Blog> blogList = new ArrayList<Blog>();
    
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL)
    private List<BlogComment> blogCommentList = new ArrayList<BlogComment>();
   
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.PERSIST)
    private List<Message> messageList = new ArrayList<Message>();
   
    @OneToMany( mappedBy = "user",
			cascade = CascadeType.PERSIST)
    private List<Payment> paymentList = new ArrayList<Payment>();
    
    @PrePersist
    private void preper() {
    	this.role = this.role == 0 ? 1 : this.role;
	}
}
