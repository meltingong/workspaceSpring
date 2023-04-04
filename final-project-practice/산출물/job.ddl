DROP TABLE blog_heart CASCADE CONSTRAINTS;
DROP TABLE admin CASCADE CONSTRAINTS;
DROP TABLE message CASCADE CONSTRAINTS;
DROP TABLE blog_comment CASCADE CONSTRAINTS;
DROP TABLE blog CASCADE CONSTRAINTS;
DROP TABLE blog_cate CASCADE CONSTRAINTS;
DROP TABLE corp_image CASCADE CONSTRAINTS;
DROP TABLE recruit_tag CASCADE CONSTRAINTS;
DROP TABLE corp_tag CASCADE CONSTRAINTS;
DROP TABLE payment CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE corp_bookmark CASCADE CONSTRAINTS;
DROP TABLE recruit_scrap CASCADE CONSTRAINTS;
DROP TABLE app CASCADE CONSTRAINTS;
DROP TABLE tag CASCADE CONSTRAINTS;
DROP TABLE recruit CASCADE CONSTRAINTS;
DROP TABLE manager CASCADE CONSTRAINTS;
DROP TABLE corp CASCADE CONSTRAINTS;
DROP TABLE awards CASCADE CONSTRAINTS;
DROP TABLE experience CASCADE CONSTRAINTS;
DROP TABLE education CASCADE CONSTRAINTS;
DROP TABLE CV CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;
DROP TABLE user_roles CASCADE CONSTRAINTS;
DROP TABLE job CASCADE CONSTRAINTS;


CREATE TABLE userinfo(
		user_seq                      		NUMBER(20)		 NULL ,
		user_email                    		VARCHAR2(50)		 NOT NULL,
		user_password                 		VARCHAR2(45)		 NOT NULL,
		user_name                     		VARCHAR2(30)		 NULL ,
		user_phone                    		VARCHAR2(20)		 NULL ,
		user_sex                      		VARCHAR2(10)		 NULL ,
		user_address                  		VARCHAR2(150)		 NULL ,
		user_career                   		VARCHAR2(20)		 NULL ,
		user_age                      		NUMBER(5)		 NULL ,
		user_final_education          		VARCHAR2(30)		 NULL ,
		user_language                 		VARCHAR2(60)		 NULL ,
		user_skills                   		VARCHAR2(120)		 NULL ,
		user_image                    		VARCHAR2(45)		 NULL ,
		user_status                   		CHAR(1)		 NULL ,
		sns_type                      		VARCHAR2(45)		 NULL ,
		sns_id                        		VARCHAR2(45)		 NULL ,
		job                         		VARCHAR2(60)		 NULL ,
		role                        		NUMBER(5)			 NULL 
);

DROP SEQUENCE userinfo_user_seq_SEQ;

CREATE SEQUENCE userinfo_user_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE CV(
		cv_seq                        		NUMBER(20)		 NOT NULL,
		cv_name                       		VARCHAR2(30)		 DEFAULT 'my CV'		 NULL ,
		cv_description                		VARCHAR2(1000)		 NULL ,
		cv_portfolio                  		VARCHAR2(70)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE CV_cv_seq_SEQ;

CREATE SEQUENCE CV_cv_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE education(
		edu_seq                       		NUMBER(20)		 NOT NULL,
		edu_major                     		VARCHAR2(20)		 NOT NULL,
		edu_name                      		VARCHAR2(50)		 NOT NULL,
		edu_start_date                		DATE		 NOT NULL,
		edu_end_date                  		DATE		 NULL ,
		edu_score                     		NUMBER(10)		 NULL ,
		edu_content                   		VARCHAR2(50)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE education_edu_seq_SEQ;

CREATE SEQUENCE education_edu_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE experience(
		exp_seq                       		NUMBER(20)		 NOT NULL,
		exp_position                  		VARCHAR2(30)		 NOT NULL,
		exp_corp_name                 		VARCHAR2(30)		 NOT NULL,
		exp_start_date                		DATE		 NOT NULL,
		exp_end_date                  		DATE		 NOT NULL,
		exp_content                   		VARCHAR2(100)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE experience_exp_seq_SEQ;

CREATE SEQUENCE experience_exp_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE awards(
		awards_seq                    		NUMBER(20)		 NOT NULL,
		awards_name                   		VARCHAR2(30)		 NOT NULL,
		awards_date                   		DATE		 NOT NULL,
		awards_content                		VARCHAR2(100)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE awards_awards_seq_SEQ;

CREATE SEQUENCE awards_awards_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE corp(
		corp_id                       		VARCHAR2(30)		 NOT NULL,
		corp_password                 		VARCHAR2(45)		 NOT NULL,
		corp_name                     		VARCHAR2(50)		 NOT NULL,
		corp_phone                    		VARCHAR2(20)		 NULL ,
		corp_business_no              		VARCHAR2(20)		 NULL ,
		corp_website                  		VARCHAR2(50)		 NULL ,
		corp_est                      		DATE		 NULL ,
		corp_size                     		VARCHAR2(20)		 NULL ,
		corp_sales                    		VARCHAR2(20)		 NULL ,
		corp_comment                  		VARCHAR2(1000)		 NULL ,
		corp_welfare                  		VARCHAR2(50)		 NULL ,
		corp_address                  		VARCHAR2(100)		 NULL ,
		corp_status                   		CHAR(1)		 NULL ,
		job                         		VARCHAR2(60)		 NULL ,
		role                        		NUMBER(5)			 NULL 
);


CREATE TABLE manager(
		manager_email                 		VARCHAR2(40)		 NOT NULL,
		manager_name                  		VARCHAR2(20)		 NULL ,
		manager_position              		VARCHAR2(30)		 NOT NULL,
		manager_phone                 		VARCHAR2(20)		 NOT NULL,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);


CREATE TABLE recruit(
		rc_seq                        		NUMBER(20)		 NOT NULL,
		rc_title                      		VARCHAR2(40)		 NULL ,
		rc_position                   		VARCHAR2(30)		 NULL ,
		rc_content                    		VARCHAR2(200)		 NULL ,
		rc_qualification              		VARCHAR2(50)		 NULL ,
		rc_salary                     		NUMBER(20)		 NULL ,
		rc_deadline                   		DATE		 NULL ,
		rc_read_count                 		NUMBER(10)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);

DROP SEQUENCE recruit_rc_seq_SEQ;

CREATE SEQUENCE recruit_rc_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE tag(
		tag_id                        		NUMBER(10)		 NULL ,
		tag_name                      		VARCHAR2(10)		 NOT NULL
);

DROP SEQUENCE tag_tag_id_SEQ;

CREATE SEQUENCE tag_tag_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE app(
		app_seq                       		NUMBER(20)		 NOT NULL,
		app_status                    		CHAR(1)		 NULL ,
		rc_seq                        		NUMBER(20)		 NOT NULL,
		cv_seq                        		NUMBER(20)		 NOT NULL
);

DROP SEQUENCE app_app_seq_SEQ;

CREATE SEQUENCE app_app_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE recruit_scrap(
		rc_seq                        		NUMBER(20)		 NOT NULL,
		recruit_seq                   		NUMBER(20)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE recruit_scrap_rc_seq_SEQ;

CREATE SEQUENCE recruit_scrap_rc_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE corp_bookmark(
		user_email                    		VARCHAR2(50)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);


CREATE TABLE review(
		review_seq                    		NUMBER(20)		 NULL ,
		review_grade                  		CHAR(1)		 NULL ,
		review_title                  		VARCHAR2(100)		 NULL ,
		review_content                		VARCHAR2(200)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE review_review_seq_SEQ;

CREATE SEQUENCE review_review_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE product(
		p_no                          		NUMBER(20)		 NULL ,
		p_name                        		VARCHAR2(50)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_date                        		DATE		 NULL ,
		p_image                       		VARCHAR2(45)		 NULL ,
		p_div                         		CHAR(1)		 NULL 
);


CREATE TABLE orders(
		order_no                      		NUMBER(20)		 NOT NULL,
		p_no                          		NUMBER(20)		 NOT NULL,
		corp_id                       		VARCHAR2(30)		 NOT NULL,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE orders_order_no_SEQ;

CREATE SEQUENCE orders_order_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE payment(
		pay_seq                       		NUMBER(10)		 NULL ,
		order_no                      		NUMBER(20)		 NULL ,
		pay_price                     		NUMBER(20)		 NULL ,
		pay_method                    		VARCHAR2(50)		 NULL ,
		pay_date                      		DATE		 NULL 
);


CREATE TABLE corp_tag(
		tag_id                        		NUMBER(10)		 NOT NULL,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);


CREATE TABLE recruit_tag(
		tag_id                        		NUMBER(10)		 NOT NULL,
		rc_seq                        		NUMBER(20)		 NOT NULL
);


CREATE TABLE corp_image(
		corp_image_seq                		NUMBER(20)		 NULL ,
		corp_image                    		VARCHAR2(50)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);

DROP SEQUENCE corp_image_corp_image_seq_SEQ;

CREATE SEQUENCE corp_image_corp_image_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE blog_cate(
		blog_cate_seq                 		NUMBER(20)		 NULL ,
		blog_cate_name                		VARCHAR2(20)		 NULL 
);

DROP SEQUENCE blog_cate_blog_cate_seq_SEQ;

CREATE SEQUENCE blog_cate_blog_cate_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE blog(
		blog_seq                      		NUMBER(20)		 NULL ,
		blog_title                    		VARCHAR2(30)		 NULL ,
		blog_content                  		VARCHAR2(200)		 NULL ,
		blog_image                    		VARCHAR2(45)		 NULL ,
		blog_date                     		DATE		 DEFAULT sysdate		 NULL ,
		blog_read_count               		NUMBER(10)		 NULL ,
		blog_like                     		NUMBER(10)		 NULL ,
		blog_cate_seq                 		NUMBER(20)		 NOT NULL,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE blog_blog_seq_SEQ;

CREATE SEQUENCE blog_blog_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE blog_comment(
		comment_seq                   		NUMBER(20)		 NULL ,
		comment_content               		VARCHAR2(50)		 NULL ,
		comment_date                  		DATE		 DEFAULT sysdate		 NULL ,
		blog_seq                      		NUMBER(20)		 NOT NULL,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE blog_comment_comment_seq_SEQ;

CREATE SEQUENCE blog_comment_comment_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE message(
		massage_seq                   		NUMBER(20)		 NULL ,
		massage_title                 		VARCHAR2(50)		 NULL ,
		massage_contents              		VARCHAR2(100)		 NULL ,
		massage_date                  		DATE		 NULL ,
		app_seq                       		NUMBER(20)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE message_massage_seq_SEQ;

CREATE SEQUENCE message_massage_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE admin(
		admin_id                      		VARCHAR2(20)		 NULL ,
		blog_seq                      		NUMBER(20)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NULL ,
		pay_seq                       		NUMBER(10)		 NULL ,
		rc_seq                        		NUMBER(20)		 NULL ,
		p_no                          		NUMBER(20)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);


CREATE TABLE blog_heart(
		blog_heart_no                 		NUMBER(10)		 NULL ,
		blog_heart_state              		NUMBER(1)		 NULL ,
		blog_seq                      		NUMBER(20)		 NULL ,
		user_seq                      		NUMBER(20)		 NULL 
);

DROP SEQUENCE blog_heart_blog_heart_no_SEQ;

CREATE SEQUENCE blog_heart_blog_heart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

ALTER TABLE job ADD CONSTRAINT IDX_job_PK PRIMARY KEY (job_id);

ALTER TABLE user_roles ADD CONSTRAINT IDX_user_roles_PK PRIMARY KEY (role_id);

ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (user_seq);

ALTER TABLE CV ADD CONSTRAINT IDX_CV_PK PRIMARY KEY (cv_seq);
ALTER TABLE CV ADD CONSTRAINT IDX_CV_FK0 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE education ADD CONSTRAINT IDX_education_PK PRIMARY KEY (edu_seq);
ALTER TABLE education ADD CONSTRAINT IDX_education_FK0 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE experience ADD CONSTRAINT IDX_experience_PK PRIMARY KEY (exp_seq);
ALTER TABLE experience ADD CONSTRAINT IDX_experience_FK0 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE awards ADD CONSTRAINT IDX_awards_PK PRIMARY KEY (awards_seq);
ALTER TABLE awards ADD CONSTRAINT IDX_awards_FK0 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE corp ADD CONSTRAINT IDX_corp_PK PRIMARY KEY (corp_id);

ALTER TABLE manager ADD CONSTRAINT IDX_manager_PK PRIMARY KEY (manager_email);
ALTER TABLE manager ADD CONSTRAINT IDX_manager_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id) on delete cascade;

ALTER TABLE recruit ADD CONSTRAINT IDX_recruit_PK PRIMARY KEY (rc_seq);
ALTER TABLE recruit ADD CONSTRAINT IDX_recruit_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id) on delete cascade;

ALTER TABLE tag ADD CONSTRAINT IDX_tag_PK PRIMARY KEY (tag_id);

ALTER TABLE app ADD CONSTRAINT IDX_app_PK PRIMARY KEY (app_seq);
ALTER TABLE app ADD CONSTRAINT IDX_app_FK0 FOREIGN KEY (rc_seq) REFERENCES recruit (rc_seq) on delete cascade;
ALTER TABLE app ADD CONSTRAINT IDX_app_FK1 FOREIGN KEY (cv_seq) REFERENCES CV (cv_seq) on delete cascade;

ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_PK PRIMARY KEY (rc_seq);
ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_FK0 FOREIGN KEY (rc_seq) REFERENCES recruit (rc_seq) on delete cascade;
ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_FK1 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE corp_bookmark ADD CONSTRAINT IDX_corp_bookmark_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id) on delete cascade;
ALTER TABLE corp_bookmark ADD CONSTRAINT IDX_corp_bookmark_FK1 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (review_seq);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id) on delete cascade;
ALTER TABLE review ADD CONSTRAINT IDX_review_FK1 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (order_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (p_no) REFERENCES product (p_no) on delete cascade;
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK1 FOREIGN KEY (corp_id) REFERENCES corp (corp_id) on delete cascade;
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK2 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE payment ADD CONSTRAINT IDX_payment_PK PRIMARY KEY (pay_seq);
ALTER TABLE payment ADD CONSTRAINT IDX_payment_FK0 FOREIGN KEY (order_no) REFERENCES orders (order_no) on delete cascade;

ALTER TABLE corp_tag ADD CONSTRAINT IDX_corp_tag_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id) on delete cascade;
ALTER TABLE corp_tag ADD CONSTRAINT IDX_corp_tag_FK1 FOREIGN KEY (tag_id) REFERENCES tag (tag_id) on delete cascade;

ALTER TABLE recruit_tag ADD CONSTRAINT IDX_recruit_tag_FK0 FOREIGN KEY (tag_id) REFERENCES tag (tag_id) on delete cascade;
ALTER TABLE recruit_tag ADD CONSTRAINT IDX_recruit_tag_FK1 FOREIGN KEY (rc_seq) REFERENCES recruit (rc_seq) on delete cascade;

ALTER TABLE corp_image ADD CONSTRAINT IDX_corp_image_PK PRIMARY KEY (corp_image_seq);
ALTER TABLE corp_image ADD CONSTRAINT IDX_corp_image_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id) on delete cascade;

ALTER TABLE blog_cate ADD CONSTRAINT IDX_blog_cate_PK PRIMARY KEY (blog_cate_seq);

ALTER TABLE blog ADD CONSTRAINT IDX_blog_PK PRIMARY KEY (blog_seq);
ALTER TABLE blog ADD CONSTRAINT IDX_blog_FK0 FOREIGN KEY (blog_cate_seq) REFERENCES blog_cate (blog_cate_seq) on delete cascade;
ALTER TABLE blog ADD CONSTRAINT IDX_blog_FK1 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE blog_comment ADD CONSTRAINT IDX_blog_comment_PK PRIMARY KEY (comment_seq);
ALTER TABLE blog_comment ADD CONSTRAINT IDX_blog_comment_FK0 FOREIGN KEY (blog_seq) REFERENCES blog (blog_seq) on delete cascade;
ALTER TABLE blog_comment ADD CONSTRAINT IDX_blog_comment_FK1 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE message ADD CONSTRAINT IDX_message_PK PRIMARY KEY (massage_seq);
ALTER TABLE message ADD CONSTRAINT IDX_message_FK0 FOREIGN KEY (app_seq) REFERENCES app (app_seq) on delete cascade;
ALTER TABLE message ADD CONSTRAINT IDX_message_FK1 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE admin ADD CONSTRAINT IDX_admin_PK PRIMARY KEY (admin_id);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK0 FOREIGN KEY (blog_seq) REFERENCES blog (blog_seq) on delete cascade;
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK1 FOREIGN KEY (corp_id) REFERENCES corp (corp_id) on delete cascade;
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK2 FOREIGN KEY (pay_seq) REFERENCES payment (pay_seq) on delete cascade;
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK3 FOREIGN KEY (rc_seq) REFERENCES recruit (rc_seq) on delete cascade;
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK4 FOREIGN KEY (p_no) REFERENCES product (p_no) on delete cascade;
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK5 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;

ALTER TABLE blog_heart ADD CONSTRAINT IDX_blog_heart_PK PRIMARY KEY (blog_heart_no);
ALTER TABLE blog_heart ADD CONSTRAINT IDX_blog_heart_FK0 FOREIGN KEY (blog_seq) REFERENCES blog (blog_seq) on delete cascade;
ALTER TABLE blog_heart ADD CONSTRAINT IDX_blog_heart_FK1 FOREIGN KEY (user_seq) REFERENCES userinfo (user_seq) on delete cascade;
