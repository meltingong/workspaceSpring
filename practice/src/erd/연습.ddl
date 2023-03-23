/**********************************/
/* Table Name: member_detail */
/**********************************/
CREATE TABLE member_detail(
		m_seq                         		NUMBER(10)		 NULL ,
		m_age                         		NUMBER(10)		 NULL ,
		m_gender                      		VARCHAR2(10)		 NULL ,
		m_address                     		INTEGER(10)		 NULL 
);

CREATE SEQUENCE member_detail_m_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER member_detail_m_seq_TRG
BEFORE INSERT ON member_detail
FOR EACH ROW
BEGIN
IF :NEW.m_seq IS NOT NULL THEN
  SELECT member_detail_m_seq_SEQ.NEXTVAL INTO :NEW.m_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE member_detail is 'member_detail';
COMMENT ON COLUMN member_detail.m_seq is 'm_seq';
COMMENT ON COLUMN member_detail.m_age is 'm_age';
COMMENT ON COLUMN member_detail.m_gender is 'm_gender';
COMMENT ON COLUMN member_detail.m_address is 'm_address';


/**********************************/
/* Table Name: user_category */
/**********************************/
CREATE TABLE user_category(
		uc_no                         		NUMBER(10)		 NULL ,
		uc_name                       		VARCHAR2(50)		 NOT NULL
);

COMMENT ON TABLE user_category is 'user_category';
COMMENT ON COLUMN user_category.uc_no is 'uc_no';
COMMENT ON COLUMN user_category.uc_name is 'uc_name';


/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		p_seq                         		INTEGER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NOT NULL,
		p_desc                        		VARCHAR2(500)		 NOT NULL,
		p_price                       		NUMBER(100)		 NOT NULL,
		p_image                       		VARCHAR2(1000)		 NOT NULL,
		p_period                      		NUMBER(10)		 NOT NULL,
		uc_no                         		NUMBER(10)		 NULL 
);

CREATE SEQUENCE product_p_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER product_p_seq_TRG
BEFORE INSERT ON product
FOR EACH ROW
BEGIN
IF :NEW.p_seq IS NOT NULL THEN
  SELECT product_p_seq_SEQ.NEXTVAL INTO :NEW.p_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE product is 'product';
COMMENT ON COLUMN product.p_seq is 'p_seq';
COMMENT ON COLUMN product.p_name is 'p_name';
COMMENT ON COLUMN product.p_desc is 'p_desc';
COMMENT ON COLUMN product.p_price is 'p_price';
COMMENT ON COLUMN product.p_image is 'p_image';
COMMENT ON COLUMN product.p_period is 'p_period';
COMMENT ON COLUMN product.uc_no is 'uc_no';


/**********************************/
/* Table Name: license */
/**********************************/
CREATE TABLE license(
		li_seq                        		NUMBER(10)		 NULL ,
		li_name                       		VARCHAR2(50)		 NOT NULL,
		li_no                         		NUMBER(100)		 NOT NULL,
		li_insituation                		VARCHAR2(50)		 NOT NULL,
		li_aqqDate                    		DATE		 NOT NULL
);

CREATE SEQUENCE license_li_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER license_li_seq_TRG
BEFORE INSERT ON license
FOR EACH ROW
BEGIN
IF :NEW.li_seq IS NOT NULL THEN
  SELECT license_li_seq_SEQ.NEXTVAL INTO :NEW.li_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE license is 'license';
COMMENT ON COLUMN license.li_seq is 'li_seq';
COMMENT ON COLUMN license.li_name is 'li_name';
COMMENT ON COLUMN license.li_no is 'li_no';
COMMENT ON COLUMN license.li_insituation is 'li_insituation';
COMMENT ON COLUMN license.li_aqqDate is 'li_aqqDate';


/**********************************/
/* Table Name: career */
/**********************************/
CREATE TABLE career(
		career_seq                    		NUMBER(10)		 NULL ,
		career_name                   		VARCHAR2(50)		 NOT NULL,
		carrer_startDate              		DATE		 NOT NULL,
		carrer_endDate                		DATE		 NOT NULL,
		career_content                		VARCHAR2(2000)		 NOT NULL
);

CREATE SEQUENCE career_career_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER career_career_seq_TRG
BEFORE INSERT ON career
FOR EACH ROW
BEGIN
IF :NEW.career_seq IS NOT NULL THEN
  SELECT career_career_seq_SEQ.NEXTVAL INTO :NEW.career_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE career is 'career';
COMMENT ON COLUMN career.career_seq is 'career_seq';
COMMENT ON COLUMN career.career_name is 'career_name';
COMMENT ON COLUMN career.carrer_startDate is 'carrer_startDate';
COMMENT ON COLUMN career.carrer_endDate is 'carrer_endDate';
COMMENT ON COLUMN career.career_content is 'career_content';


/**********************************/
/* Table Name: workExperience */
/**********************************/
CREATE TABLE workExperience(
		w_seq                         		NUMBER(10)		 NULL ,
		w_companyName                 		VARCHAR2(100)		 NOT NULL,
		w_startDate                   		DATE		 NOT NULL,
		w_endDate                     		DATE		 NOT NULL,
		w_position                    		VARCHAR2(50)		 NOT NULL,
		w_endSales                    		NUMBER(50)		 NULL ,
		career_seq                    		NUMBER(10)		 NULL 
);

CREATE SEQUENCE workExperience_w_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER workExperience_w_seq_TRG
BEFORE INSERT ON workExperience
FOR EACH ROW
BEGIN
IF :NEW.w_seq IS NOT NULL THEN
  SELECT workExperience_w_seq_SEQ.NEXTVAL INTO :NEW.w_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE workExperience is 'workExperience';
COMMENT ON COLUMN workExperience.w_seq is 'w_seq';
COMMENT ON COLUMN workExperience.w_companyName is 'w_companyName';
COMMENT ON COLUMN workExperience.w_startDate is 'w_startDate';
COMMENT ON COLUMN workExperience.w_endDate is 'w_endDate';
COMMENT ON COLUMN workExperience.w_position is 'w_position';
COMMENT ON COLUMN workExperience.w_endSales is 'w_endSales';
COMMENT ON COLUMN workExperience.career_seq is 'career_seq';


/**********************************/
/* Table Name: education_category */
/**********************************/
CREATE TABLE education_category(
		ed_caNo                       		NUMBER(10)		 NULL ,
		ed_caName                     		VARCHAR2(50)		 NOT NULL
);

COMMENT ON TABLE education_category is 'education_category';
COMMENT ON COLUMN education_category.ed_caNo is 'ed_caNo';
COMMENT ON COLUMN education_category.ed_caName is 'ed_caName';


/**********************************/
/* Table Name: education */
/**********************************/
CREATE TABLE education(
		ed_seq                        		NUMBER(10)		 NULL ,
		ed_name                       		VARCHAR2(50)		 NOT NULL,
		ed_department1                		VARCHAR2(50)		 NOT NULL,
		ed_department2                		VARCHAR2(50)		 NULL ,
		ed_start                      		DATE		 NOT NULL,
		ed_end                        		DATE		 NOT NULL,
		ed_file                       		VARCHAR2(200)		 NOT NULL,
		ed_caNo                       		NUMBER(10)		 NULL 
);

CREATE SEQUENCE education_ed_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER education_ed_seq_TRG
BEFORE INSERT ON education
FOR EACH ROW
BEGIN
IF :NEW.ed_seq IS NOT NULL THEN
  SELECT education_ed_seq_SEQ.NEXTVAL INTO :NEW.ed_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE education is 'education';
COMMENT ON COLUMN education.ed_seq is 'ed_seq';
COMMENT ON COLUMN education.ed_name is 'ed_name';
COMMENT ON COLUMN education.ed_department1 is 'ed_department1';
COMMENT ON COLUMN education.ed_department2 is 'ed_department2';
COMMENT ON COLUMN education.ed_start is 'ed_start';
COMMENT ON COLUMN education.ed_end is 'ed_end';
COMMENT ON COLUMN education.ed_file is 'ed_file';
COMMENT ON COLUMN education.ed_caNo is 'ed_caNo';


/**********************************/
/* Table Name: resume_content */
/**********************************/
CREATE TABLE resume_content(
		rc_seq                        		NUMBER(10)		 NULL ,
		rc_title                      		VARCHAR2(50)		 NULL ,
		rc_content                    		VARCHAR2(2000)		 NULL 
);

CREATE SEQUENCE resume_content_rc_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER resume_content_rc_seq_TRG
BEFORE INSERT ON resume_content
FOR EACH ROW
BEGIN
IF :NEW.rc_seq IS NOT NULL THEN
  SELECT resume_content_rc_seq_SEQ.NEXTVAL INTO :NEW.rc_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE resume_content is 'resume_content';
COMMENT ON COLUMN resume_content.rc_seq is 'rc_seq';
COMMENT ON COLUMN resume_content.rc_title is 'rc_title';
COMMENT ON COLUMN resume_content.rc_content is 'rc_content';


/**********************************/
/* Table Name: resume */
/**********************************/
CREATE TABLE resume(
		re_seq                        		NUMBER(10)		 NULL ,
		re_title                      		VARCHAR2(20)		 NOT NULL,
		re_image                      		VARCHAR2(100)		 NOT NULL,
		li_seq                        		NUMBER(10)		 NULL ,
		w_seq                         		NUMBER(10)		 NULL ,
		ed_seq                        		NUMBER(10)		 NULL ,
		rc_seq                        		NUMBER(10)		 NULL 
);

CREATE SEQUENCE resume_re_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER resume_re_seq_TRG
BEFORE INSERT ON resume
FOR EACH ROW
BEGIN
IF :NEW.re_seq IS NOT NULL THEN
  SELECT resume_re_seq_SEQ.NEXTVAL INTO :NEW.re_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE resume is 'resume';
COMMENT ON COLUMN resume.re_seq is 're_seq';
COMMENT ON COLUMN resume.re_title is 're_title';
COMMENT ON COLUMN resume.re_image is 're_image';
COMMENT ON COLUMN resume.li_seq is 'li_seq';
COMMENT ON COLUMN resume.w_seq is 'w_seq';
COMMENT ON COLUMN resume.ed_seq is 'ed_seq';
COMMENT ON COLUMN resume.rc_seq is 'rc_seq';


/**********************************/
/* Table Name: order */
/**********************************/
CREATE TABLE order(
		o_no                          		NUMBER(10)		 NULL ,
		o_desc                        		VARCHAR2(50)		 NOT NULL,
		o_date                        		DATE		 DEFAULT sysdate		 NULL ,
		o_price                       		NUMBER(100)		 NOT NULL
);

CREATE SEQUENCE order_o_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER order_o_no_TRG
BEFORE INSERT ON order
FOR EACH ROW
BEGIN
IF :NEW.o_no IS NOT NULL THEN
  SELECT order_o_no_SEQ.NEXTVAL INTO :NEW.o_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE order is 'order';
COMMENT ON COLUMN order.o_no is 'o_no';
COMMENT ON COLUMN order.o_desc is 'o_desc';
COMMENT ON COLUMN order.o_date is 'o_date';
COMMENT ON COLUMN order.o_price is 'o_price';


/**********************************/
/* Table Name: member */
/**********************************/
CREATE TABLE member(
		m_email                       		VARCHAR2(50)		 NULL ,
		m_id                          		VARCHAR2(20)		 NOT NULL,
		m_pw                          		VARCHAR2(50)		 NOT NULL,
		m_name                        		VARCHAR2(10)		 NULL ,
		m_phone                       		VARCHAR2(100)		 NOT NULL,
		m_seq                         		NUMBER(10)		 NULL ,
		p_seq                         		INTEGER(10)		 NULL ,
		re_seq                        		NUMBER(10)		 NULL ,
		o_no                          		NUMBER(10)		 NULL 
);

COMMENT ON TABLE member is 'member';
COMMENT ON COLUMN member.m_email is 'm_email';
COMMENT ON COLUMN member.m_id is 'm_id';
COMMENT ON COLUMN member.m_pw is 'm_pw';
COMMENT ON COLUMN member.m_name is 'm_name';
COMMENT ON COLUMN member.m_phone is 'm_phone';
COMMENT ON COLUMN member.m_seq is 'm_seq';
COMMENT ON COLUMN member.p_seq is 'p_seq';
COMMENT ON COLUMN member.re_seq is 're_seq';
COMMENT ON COLUMN member.o_no is 'o_no';


/**********************************/
/* Table Name: job_detailCategory */
/**********************************/
CREATE TABLE job_detailCategory(
		jd_no                         		NUMBER(50)		 NULL ,
		jd_name                       		VARCHAR2(100)		 NOT NULL
);

COMMENT ON TABLE job_detailCategory is 'job_detailCategory';
COMMENT ON COLUMN job_detailCategory.jd_no is 'jd_no';
COMMENT ON COLUMN job_detailCategory.jd_name is 'jd_name';


/**********************************/
/* Table Name: job_category */
/**********************************/
CREATE TABLE job_category(
		job_no                        		NUMBER(10)		 NULL ,
		job_name                      		VARCHAR2(50)		 NOT NULL,
		jd_no                         		NUMBER(50)		 NULL 
);

CREATE SEQUENCE job_category_job_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER job_category_job_no_TRG
BEFORE INSERT ON job_category
FOR EACH ROW
BEGIN
IF :NEW.job_no IS NOT NULL THEN
  SELECT job_category_job_no_SEQ.NEXTVAL INTO :NEW.job_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE job_category is 'job_category';
COMMENT ON COLUMN job_category.job_no is 'job_no';
COMMENT ON COLUMN job_category.job_name is 'job_name';
COMMENT ON COLUMN job_category.jd_no is 'jd_no';


/**********************************/
/* Table Name: cor_detail */
/**********************************/
CREATE TABLE cor_detail(
		cor_seq                       		NUMBER(100)		 NULL ,
		cor_name                      		VARCHAR2(10)		 NOT NULL,
		cor_since                     		VARCHAR2(20)		 NOT NULL,
		cor_size                      		VARCHAR2(50)		 NOT NULL,
		cor_sales                     		NUMBER(10)		 NOT NULL,
		cor_regNo                     		VARCHAR2(50)		 NOT NULL,
		cor_address                   		VARCHAR2(100)		 NOT NULL,
		cor_content                   		VARCHAR2(200)		 NOT NULL,
		cor_logoImage                 		VARCHAR2(200)		 NULL ,
		cor_image1                    		VARCHAR2(1000)		 NULL ,
		cor_image2                    		VARCHAR2(1000)		 NULL ,
		cor_image3                    		VARCHAR2(1000)		 NULL ,
		job_no                        		NUMBER(10)		 NULL 
);

CREATE SEQUENCE cor_detail_cor_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER cor_detail_cor_seq_TRG
BEFORE INSERT ON cor_detail
FOR EACH ROW
BEGIN
IF :NEW.cor_seq IS NOT NULL THEN
  SELECT cor_detail_cor_seq_SEQ.NEXTVAL INTO :NEW.cor_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE cor_detail is 'cor_detail';
COMMENT ON COLUMN cor_detail.cor_seq is 'cor_seq';
COMMENT ON COLUMN cor_detail.cor_name is 'cor_name';
COMMENT ON COLUMN cor_detail.cor_since is 'cor_since';
COMMENT ON COLUMN cor_detail.cor_size is 'cor_size';
COMMENT ON COLUMN cor_detail.cor_sales is 'cor_sales';
COMMENT ON COLUMN cor_detail.cor_regNo is 'cor_regNo';
COMMENT ON COLUMN cor_detail.cor_address is 'cor_address';
COMMENT ON COLUMN cor_detail.cor_content is 'cor_content';
COMMENT ON COLUMN cor_detail.cor_logoImage is 'cor_logoImage';
COMMENT ON COLUMN cor_detail.cor_image1 is 'cor_image1';
COMMENT ON COLUMN cor_detail.cor_image2 is 'cor_image2';
COMMENT ON COLUMN cor_detail.cor_image3 is 'cor_image3';
COMMENT ON COLUMN cor_detail.job_no is 'job_no';


/**********************************/
/* Table Name: cor */
/**********************************/
CREATE TABLE cor(
		cor_id                        		VARCHAR2(50)		 NULL ,
		cor_pw                        		VARCHAR2(50)		 NOT NULL,
		cor_position                  		VARCHAR2(50)		 NOT NULL,
		cor_email                     		VARCHAR2(50)		 NOT NULL,
		cor_phone                     		VARCHAR2(50)		 NOT NULL,
		cor_seq                       		NUMBER(100)		 NULL ,
		p_seq                         		INTEGER(10)		 NULL ,
		o_no                          		NUMBER(10)		 NULL 
);

COMMENT ON TABLE cor is 'cor';
COMMENT ON COLUMN cor.cor_id is 'cor_id';
COMMENT ON COLUMN cor.cor_pw is 'cor_pw';
COMMENT ON COLUMN cor.cor_position is 'cor_position';
COMMENT ON COLUMN cor.cor_email is 'cor_email';
COMMENT ON COLUMN cor.cor_phone is 'cor_phone';
COMMENT ON COLUMN cor.cor_seq is 'cor_seq';
COMMENT ON COLUMN cor.p_seq is 'p_seq';
COMMENT ON COLUMN cor.o_no is 'o_no';


/**********************************/
/* Table Name: admin */
/**********************************/
CREATE TABLE admin(
		ad_email                      		VARCHAR2(50)		 NULL ,
		ad_pw                         		VARCHAR2(50)		 NOT NULL,
		ad_name                       		VARCHAR2(10)		 NOT NULL,
		m_email                       		VARCHAR2(50)		 NULL ,
		cor_id                        		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE admin is 'admin';
COMMENT ON COLUMN admin.ad_email is 'ad_email';
COMMENT ON COLUMN admin.ad_pw is 'ad_pw';
COMMENT ON COLUMN admin.ad_name is 'ad_name';
COMMENT ON COLUMN admin.m_email is 'm_email';
COMMENT ON COLUMN admin.cor_id is 'cor_id';


/**********************************/
/* Table Name: location */
/**********************************/
CREATE TABLE location(
		lo_no                         		NUMBER(10)		 NULL ,
		lo_name                       		VARCHAR2(50)		 NOT NULL
);

COMMENT ON TABLE location is 'location';
COMMENT ON COLUMN location.lo_no is 'lo_no';
COMMENT ON COLUMN location.lo_name is 'lo_name';


/**********************************/
/* Table Name: message */
/**********************************/
CREATE TABLE message(
		msg_no                        		NUMBER(10)		 NULL ,
		msg_title                     		VARCHAR2(100)		 NOT NULL,
		msg_content                   		VARCHAR2(500)		 NOT NULL,
		m_email                       		VARCHAR2(50)		 NULL ,
		cor_id                        		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE message is 'message';
COMMENT ON COLUMN message.msg_no is 'msg_no';
COMMENT ON COLUMN message.msg_title is 'msg_title';
COMMENT ON COLUMN message.msg_content is 'msg_content';
COMMENT ON COLUMN message.m_email is 'm_email';
COMMENT ON COLUMN message.cor_id is 'cor_id';


/**********************************/
/* Table Name: order_item */
/**********************************/
CREATE TABLE order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		oi_qty                        		NUMBER(10)		 NOT NULL,
		o_no                          		NUMBER(10)		 NULL ,
		p_seq                         		INTEGER(10)		 NULL 
);

CREATE SEQUENCE order_item_oi_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER order_item_oi_no_TRG
BEFORE INSERT ON order_item
FOR EACH ROW
BEGIN
IF :NEW.oi_no IS NOT NULL THEN
  SELECT order_item_oi_no_SEQ.NEXTVAL INTO :NEW.oi_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE order_item is 'order_item';
COMMENT ON COLUMN order_item.oi_no is 'oi_no';
COMMENT ON COLUMN order_item.oi_qty is 'oi_qty';
COMMENT ON COLUMN order_item.o_no is 'o_no';
COMMENT ON COLUMN order_item.p_seq is 'p_seq';


/**********************************/
/* Table Name: salary */
/**********************************/
CREATE TABLE salary(
		salary_no                     		NUMBER(50)		 NULL ,
		salary_category               		NUMBER(100)		 NOT NULL
);

COMMENT ON TABLE salary is 'salary';
COMMENT ON COLUMN salary.salary_no is 'salary_no';
COMMENT ON COLUMN salary.salary_category is 'salary_category';


/**********************************/
/* Table Name: welfare_category */
/**********************************/
CREATE TABLE welfare_category(
		welfare_no                    		NUMBER(100)		 NULL ,
		welfare_name                  		VARCHAR2(100)		 NOT NULL
);

COMMENT ON TABLE welfare_category is 'welfare_category';
COMMENT ON COLUMN welfare_category.welfare_no is 'welfare_no';
COMMENT ON COLUMN welfare_category.welfare_name is 'welfare_name';


/**********************************/
/* Table Name: hireProcess */
/**********************************/
CREATE TABLE hireProcess(
		pr_no                         		NUMBER(20)		 NULL ,
		pr_name                       		INTEGER(10)		 NOT NULL
);

COMMENT ON TABLE hireProcess is 'hireProcess';
COMMENT ON COLUMN hireProcess.pr_no is 'pr_no';
COMMENT ON COLUMN hireProcess.pr_name is 'pr_name';


/**********************************/
/* Table Name: jobOpening */
/**********************************/
CREATE TABLE jobOpening(
		jo_no                         		NUMBER(10)		 NULL ,
		jo_title                      		VARCHAR2(50)		 NOT NULL,
		jo_writeDate                  		DATE		 DEFAULT sysdate		 NULL ,
		jo_startDate                  		DATE		 NULL ,
		jo_recruited                  		NUMBER(10)		 NOT NULL,
		jo_qualification              		VARCHAR2(100)		 NOT NULL,
		salary_no                     		NUMBER(50)		 NULL ,
		job_no                        		NUMBER(10)		 NULL ,
		welfare_no                    		NUMBER(100)		 NULL ,
		lo_no                         		NUMBER(10)		 NULL ,
		pr_no                         		NUMBER(20)		 NULL 
);

CREATE SEQUENCE jobOpening_jo_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER jobOpening_jo_no_TRG
BEFORE INSERT ON jobOpening
FOR EACH ROW
BEGIN
IF :NEW.jo_no IS NOT NULL THEN
  SELECT jobOpening_jo_no_SEQ.NEXTVAL INTO :NEW.jo_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE jobOpening is 'jobOpening';
COMMENT ON COLUMN jobOpening.jo_no is 'jo_no';
COMMENT ON COLUMN jobOpening.jo_title is 'jo_title';
COMMENT ON COLUMN jobOpening.jo_writeDate is 'jo_writeDate';
COMMENT ON COLUMN jobOpening.jo_startDate is 'jo_startDate';
COMMENT ON COLUMN jobOpening.jo_recruited is 'jo_recruited';
COMMENT ON COLUMN jobOpening.jo_qualification is 'jo_qualification';
COMMENT ON COLUMN jobOpening.salary_no is 'salary_no';
COMMENT ON COLUMN jobOpening.job_no is 'job_no';
COMMENT ON COLUMN jobOpening.welfare_no is 'welfare_no';
COMMENT ON COLUMN jobOpening.lo_no is 'lo_no';
COMMENT ON COLUMN jobOpening.pr_no is 'pr_no';



ALTER TABLE member_detail ADD CONSTRAINT IDX_member_detail_PK PRIMARY KEY (m_seq);

ALTER TABLE user_category ADD CONSTRAINT IDX_user_category_PK PRIMARY KEY (uc_no);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_seq);
ALTER TABLE product ADD CONSTRAINT IDX_product_FK0 FOREIGN KEY (uc_no) REFERENCES user_category (uc_no);

ALTER TABLE license ADD CONSTRAINT IDX_license_PK PRIMARY KEY (li_seq);

ALTER TABLE career ADD CONSTRAINT IDX_career_PK PRIMARY KEY (career_seq);

ALTER TABLE workExperience ADD CONSTRAINT IDX_workExperience_PK PRIMARY KEY (w_seq);
ALTER TABLE workExperience ADD CONSTRAINT IDX_workExperience_FK0 FOREIGN KEY (career_seq) REFERENCES career (career_seq);

ALTER TABLE education_category ADD CONSTRAINT IDX_education_category_PK PRIMARY KEY (ed_caNo);

ALTER TABLE education ADD CONSTRAINT IDX_education_PK PRIMARY KEY (ed_seq);
ALTER TABLE education ADD CONSTRAINT IDX_education_FK0 FOREIGN KEY (ed_caNo) REFERENCES education_category (ed_caNo);

ALTER TABLE resume_content ADD CONSTRAINT IDX_resume_content_PK PRIMARY KEY (rc_seq);

ALTER TABLE resume ADD CONSTRAINT IDX_resume_PK PRIMARY KEY (re_seq);
ALTER TABLE resume ADD CONSTRAINT IDX_resume_FK0 FOREIGN KEY (li_seq) REFERENCES license (li_seq);
ALTER TABLE resume ADD CONSTRAINT IDX_resume_FK1 FOREIGN KEY (w_seq) REFERENCES workExperience (w_seq);
ALTER TABLE resume ADD CONSTRAINT IDX_resume_FK2 FOREIGN KEY (ed_seq) REFERENCES education (ed_seq);
ALTER TABLE resume ADD CONSTRAINT IDX_resume_FK3 FOREIGN KEY (rc_seq) REFERENCES resume_content (rc_seq);

ALTER TABLE order ADD CONSTRAINT IDX_order_PK PRIMARY KEY (o_no);

ALTER TABLE member ADD CONSTRAINT IDX_member_PK PRIMARY KEY (m_email);
ALTER TABLE member ADD CONSTRAINT IDX_member_FK0 FOREIGN KEY (m_seq) REFERENCES member_detail (m_seq);
ALTER TABLE member ADD CONSTRAINT IDX_member_FK1 FOREIGN KEY (p_seq) REFERENCES product (p_seq);
ALTER TABLE member ADD CONSTRAINT IDX_member_FK2 FOREIGN KEY (re_seq) REFERENCES resume (re_seq);
ALTER TABLE member ADD CONSTRAINT IDX_member_FK3 FOREIGN KEY (o_no) REFERENCES order (o_no);

ALTER TABLE job_detailCategory ADD CONSTRAINT IDX_job_detailCategory_PK PRIMARY KEY (jd_no);

ALTER TABLE job_category ADD CONSTRAINT IDX_job_category_PK PRIMARY KEY (job_no);
ALTER TABLE job_category ADD CONSTRAINT IDX_job_category_FK0 FOREIGN KEY (jd_no) REFERENCES job_detailCategory (jd_no);

ALTER TABLE cor_detail ADD CONSTRAINT IDX_cor_detail_PK PRIMARY KEY (cor_seq);
ALTER TABLE cor_detail ADD CONSTRAINT IDX_cor_detail_FK0 FOREIGN KEY (job_no) REFERENCES job_category (job_no);

ALTER TABLE cor ADD CONSTRAINT IDX_cor_PK PRIMARY KEY (cor_id);
ALTER TABLE cor ADD CONSTRAINT IDX_cor_FK0 FOREIGN KEY (cor_seq) REFERENCES cor_detail (cor_seq);
ALTER TABLE cor ADD CONSTRAINT IDX_cor_FK1 FOREIGN KEY (p_seq) REFERENCES product (p_seq);
ALTER TABLE cor ADD CONSTRAINT IDX_cor_FK2 FOREIGN KEY (o_no) REFERENCES order (o_no);

ALTER TABLE admin ADD CONSTRAINT IDX_admin_PK PRIMARY KEY (ad_email);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK0 FOREIGN KEY (m_email) REFERENCES member (m_email);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK1 FOREIGN KEY (cor_id) REFERENCES cor (cor_id);

ALTER TABLE location ADD CONSTRAINT IDX_location_PK PRIMARY KEY (lo_no);

ALTER TABLE message ADD CONSTRAINT IDX_message_PK PRIMARY KEY (msg_no);
ALTER TABLE message ADD CONSTRAINT IDX_message_FK0 FOREIGN KEY (m_email) REFERENCES member (m_email);
ALTER TABLE message ADD CONSTRAINT IDX_message_FK1 FOREIGN KEY (cor_id) REFERENCES cor (cor_id);

ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (o_no) REFERENCES order (o_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (p_seq) REFERENCES product (p_seq);

ALTER TABLE salary ADD CONSTRAINT IDX_salary_PK PRIMARY KEY (salary_no);

ALTER TABLE welfare_category ADD CONSTRAINT IDX_welfare_category_PK PRIMARY KEY (welfare_no);

ALTER TABLE hireProcess ADD CONSTRAINT IDX_hireProcess_PK PRIMARY KEY (pr_no);

ALTER TABLE jobOpening ADD CONSTRAINT IDX_jobOpening_PK PRIMARY KEY (jo_no);
ALTER TABLE jobOpening ADD CONSTRAINT IDX_jobOpening_FK0 FOREIGN KEY (salary_no) REFERENCES salary (salary_no);
ALTER TABLE jobOpening ADD CONSTRAINT IDX_jobOpening_FK1 FOREIGN KEY (job_no) REFERENCES job_category (job_no);
ALTER TABLE jobOpening ADD CONSTRAINT IDX_jobOpening_FK2 FOREIGN KEY (welfare_no) REFERENCES welfare_category (welfare_no);
ALTER TABLE jobOpening ADD CONSTRAINT IDX_jobOpening_FK3 FOREIGN KEY (lo_no) REFERENCES location (lo_no);
ALTER TABLE jobOpening ADD CONSTRAINT IDX_jobOpening_FK4 FOREIGN KEY (pr_no) REFERENCES hireProcess (pr_no);

