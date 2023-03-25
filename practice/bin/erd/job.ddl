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
DROP TABLE job CASCADE CONSTRAINTS;

CREATE TABLE job(
		job_id                        		NUMBER(10)		 NULL ,
		job_name                      		VARCHAR2(20)		 NULL 
);


CREATE TABLE userinfo(
		user_email                    		VARCHAR2(50)		 NOT NULL,
		user_password                 		VARCHAR2(45)		 NULL ,
		user_name                     		VARCHAR2(10)		 NULL ,
		user_phone                    		NUMBER(20)		 NOT NULL,
		user_sex                      		VARCHAR2(10)		 NULL ,
		user_address                  		VARCHAR2(50)		 NOT NULL,
		user_career                   		NUMBER(10)		 NOT NULL,
		user_age                      		NUMBER(10)		 NOT NULL,
		user_final_education          		VARCHAR2(10)		 NOT NULL,
		user_language                 		VARCHAR2(10)		 NULL ,
		user_skills                   		VARCHAR2(100)		 NULL ,
		user_image                    		VARCHAR2(45)		 NULL ,
		user_status                   		CHAR(1)		 NULL ,
		job_id                        		NUMBER(10)		 NULL ,
		sns_type                      		VARCHAR2(45)		 NULL ,
		sns_id                        		VARCHAR2(45)		 NULL 
);


CREATE TABLE CV(
		cv_seq                        		NUMBER(20)		 NOT NULL,
		cv_name                       		VARCHAR2(20)		 DEFAULT 'my CV'		 NULL ,
		cv_description                		VARCHAR2(50)		 NULL ,
		cv_portfolio                  		VARCHAR2(20)		 NULL ,
		user_email                    		VARCHAR2(50)		 NOT NULL
);

DROP SEQUENCE CV_cv_seq_SEQ;

CREATE SEQUENCE CV_cv_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER CV_cv_seq_TRG
BEFORE INSERT ON CV
FOR EACH ROW
BEGIN
IF :NEW.cv_seq IS NOT NULL THEN
  SELECT CV_cv_seq_SEQ.NEXTVAL INTO :NEW.cv_seq FROM DUAL;
END IF;
END;


CREATE TABLE education(
		education_seq                 		NUMBER(20)		 NOT NULL,
		education_major               		VARCHAR2(20)		 NOT NULL,
		education_name                		VARCHAR2(50)		 NOT NULL,
		education_start_date          		DATE		 NOT NULL,
		education_end_date            		DATE		 NULL ,
		education_score               		NUMBER(10)		 NULL ,
		education_content             		VARCHAR2(50)		 NULL ,
		user_email                    		VARCHAR2(50)		 NOT NULL
);

DROP SEQUENCE education_education_seq_SEQ;

CREATE SEQUENCE education_education_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER education_education_seq_TRG
BEFORE INSERT ON education
FOR EACH ROW
BEGIN
IF :NEW.education_seq IS NOT NULL THEN
  SELECT education_education_seq_SEQ.NEXTVAL INTO :NEW.education_seq FROM DUAL;
END IF;
END;


CREATE TABLE experience(
		experience_seq                		NUMBER(20)		 NOT NULL,
		experience_position           		VARCHAR2(30)		 NOT NULL,
		experience_corp_name          		VARCHAR2(30)		 NOT NULL,
		experience_start_date         		DATE		 NOT NULL,
		experience_end_date           		DATE		 NOT NULL,
		experience_content            		VARCHAR2(100)		 NULL ,
		user_email                    		VARCHAR2(50)		 NOT NULL
);

DROP SEQUENCE experience_experience_seq_SEQ;

CREATE SEQUENCE experience_experience_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER experience_experience_seq_TRG
BEFORE INSERT ON experience
FOR EACH ROW
BEGIN
IF :NEW.experience_seq IS NOT NULL THEN
  SELECT experience_experience_seq_SEQ.NEXTVAL INTO :NEW.experience_seq FROM DUAL;
END IF;
END;


CREATE TABLE awards(
		awards_seq                    		NUMBER(20)		 NOT NULL,
		awards_name                   		VARCHAR2(30)		 NOT NULL,
		awards_date                   		DATE		 NOT NULL,
		awards_content                		VARCHAR2(100)		 NULL ,
		user_email                    		VARCHAR2(50)		 NOT NULL
);


CREATE TABLE corp(
		corp_id                       		VARCHAR2(30)		 NOT NULL,
		corp_password                 		VARCHAR2(45)		 NOT NULL,
		corp_name                     		VARCHAR2(30)		 NOT NULL,
		corp_phone                    		NUMBER(10)		 NULL ,
		corp_business_no              		NUMBER(10)		 NULL ,
		corp_website                  		VARCHAR2(50)		 NULL ,
		corp_est                      		DATE		 NULL ,
		corp_size                     		NUMBER(10)		 NULL ,
		corp_sales                    		NUMBER(10)		 NULL ,
		corp_comment                  		VARCHAR2(200)		 NULL ,
		corp_welfare                  		VARCHAR2(50)		 NULL ,
		corp_address                  		VARCHAR2(100)		 NULL ,
		corp_status                   		CHAR(1)		 NULL ,
		job_id                        		NUMBER(10)		 NULL 
);


CREATE TABLE manager(
		manager_email                 		VARCHAR2(40)		 NOT NULL,
		manager_name                  		VARCHAR2(20)		 NULL ,
		manager_position              		VARCHAR2(10)		 NOT NULL,
		manager_phone                 		NUMBER(20)		 NOT NULL,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);


CREATE TABLE recruit(
		recruit_seq                   		NUMBER(20)		 NOT NULL,
		recruit_title                 		VARCHAR2(40)		 NULL ,
		recruit_position              		VARCHAR2(30)		 NULL ,
		recruit_content               		VARCHAR2(200)		 NULL ,
		recruit_career_level          		VARCHAR2(20)		 NULL ,
		recruit_qualification         		VARCHAR2(50)		 NULL ,
		recruit_salary                		NUMBER(20)		 NULL ,
		recruit_deadline              		DATE		 NULL ,
		recruit_experience            		VARCHAR2(20)		 NULL ,
		recruit_read_count            		NUMBER(10)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);

DROP SEQUENCE recruit_recruit_seq_SEQ;

CREATE SEQUENCE recruit_recruit_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER recruit_recruit_seq_TRG
BEFORE INSERT ON recruit
FOR EACH ROW
BEGIN
IF :NEW.recruit_seq IS NOT NULL THEN
  SELECT recruit_recruit_seq_SEQ.NEXTVAL INTO :NEW.recruit_seq FROM DUAL;
END IF;
END;


CREATE TABLE tag(
		tag_id                        		NUMBER(10)		 NULL ,
		tag_name                      		VARCHAR2(10)		 NOT NULL
);

DROP SEQUENCE tag_tag_id_SEQ;

CREATE SEQUENCE tag_tag_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER tag_tag_id_TRG
BEFORE INSERT ON tag
FOR EACH ROW
BEGIN
IF :NEW.tag_id IS NOT NULL THEN
  SELECT tag_tag_id_SEQ.NEXTVAL INTO :NEW.tag_id FROM DUAL;
END IF;
END;


CREATE TABLE app(
		app_seq                       		NUMBER(20)		 NOT NULL,
		app_status                    		CHAR(1)		 NULL ,
		recruit_seq                   		NUMBER(20)		 NOT NULL,
		cv_seq                        		NUMBER(20)		 NOT NULL
);

DROP SEQUENCE app_app_seq_SEQ;

CREATE SEQUENCE app_app_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER app_app_seq_TRG
BEFORE INSERT ON app
FOR EACH ROW
BEGIN
IF :NEW.app_seq IS NOT NULL THEN
  SELECT app_app_seq_SEQ.NEXTVAL INTO :NEW.app_seq FROM DUAL;
END IF;
END;


CREATE TABLE recruit_scrap(
		rs_seq                        		NUMBER(20)		 NOT NULL,
		recruit_seq                   		NUMBER(20)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE recruit_scrap_rs_seq_SEQ;

CREATE SEQUENCE recruit_scrap_rs_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER recruit_scrap_rs_seq_TRG
BEFORE INSERT ON recruit_scrap
FOR EACH ROW
BEGIN
IF :NEW.rs_seq IS NOT NULL THEN
  SELECT recruit_scrap_rs_seq_SEQ.NEXTVAL INTO :NEW.rs_seq FROM DUAL;
END IF;
END;


CREATE TABLE corp_bookmark(
		user_email                    		VARCHAR2(50)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NULL 
);


CREATE TABLE review(
		review_seq                    		NUMBER(20)		 NULL ,
		review_grade                  		CHAR(1)		 NULL ,
		review_title                  		VARCHAR2(10)		 NULL ,
		review_content                		VARCHAR2(50)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NULL 
);


CREATE TABLE product(
		product_no                    		NUMBER(20)		 NULL ,
		product_name                  		VARCHAR2(50)		 NULL ,
		product_price                 		NUMBER(10)		 NULL ,
		product_date                  		DATE		 NULL ,
		product_image                 		VARCHAR2(45)		 NULL ,
		product_div                   		CHAR(1)		 NULL 
);


CREATE TABLE orders(
		order_no                      		NUMBER(20)		 NOT NULL,
		product_no                    		NUMBER(20)		 NOT NULL,
		corp_id                       		VARCHAR2(30)		 NOT NULL,
		user_email                    		VARCHAR2(50)		 NOT NULL
);

DROP SEQUENCE orders_order_no_SEQ;

CREATE SEQUENCE orders_order_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER orders_order_no_TRG
BEFORE INSERT ON orders
FOR EACH ROW
BEGIN
IF :NEW.order_no IS NOT NULL THEN
  SELECT orders_order_no_SEQ.NEXTVAL INTO :NEW.order_no FROM DUAL;
END IF;
END;


CREATE TABLE payment(
		payment_seq                   		NUMBER(10)		 NULL ,
		order_no                      		NUMBER(20)		 NULL ,
		payment_price                 		NUMBER(20)		 NULL ,
		payment_method                		VARCHAR2(50)		 NULL ,
		payment_date                  		DATE		 NULL 
);


CREATE TABLE corp_tag(
		tag_id                        		NUMBER(10)		 NOT NULL,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);


CREATE TABLE recruit_tag(
		tag_id                        		NUMBER(10)		 NOT NULL,
		recruit_seq                   		NUMBER(20)		 NOT NULL
);


CREATE TABLE corp_image(
		corp_image_seq                		NUMBER(20)		 NULL ,
		corp_image                    		VARCHAR2(50)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);

DROP SEQUENCE corp_image_corp_image_seq_SEQ;

CREATE SEQUENCE corp_image_corp_image_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER corp_image_corp_image_seq_TRG
BEFORE INSERT ON corp_image
FOR EACH ROW
BEGIN
IF :NEW.corp_image_seq IS NOT NULL THEN
  SELECT corp_image_corp_image_seq_SEQ.NEXTVAL INTO :NEW.corp_image_seq FROM DUAL;
END IF;
END;


CREATE TABLE blog_cate(
		blog_cate_seq                 		NUMBER(20)		 NULL ,
		blog_cate_name                		VARCHAR2(20)		 NULL 
);

DROP SEQUENCE blog_cate_blog_cate_seq_SEQ;

CREATE SEQUENCE blog_cate_blog_cate_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER blog_cate_blog_cate_seq_TRG
BEFORE INSERT ON blog_cate
FOR EACH ROW
BEGIN
IF :NEW.blog_cate_seq IS NOT NULL THEN
  SELECT blog_cate_blog_cate_seq_SEQ.NEXTVAL INTO :NEW.blog_cate_seq FROM DUAL;
END IF;
END;


CREATE TABLE blog(
		blog_seq                      		NUMBER(20)		 NULL ,
		blog_title                    		VARCHAR2(30)		 NULL ,
		blog_content                  		VARCHAR2(200)		 NULL ,
		blog_image                    		VARCHAR2(45)		 NULL ,
		blog_date                     		DATE		 NULL ,
		blog_read_count               		NUMBER(10)		 NULL ,
		blog_like                     		NUMBER(10)		 NULL ,
		user_email                    		VARCHAR2(50)		 NOT NULL,
		blog_cate_seq                 		NUMBER(20)		 NOT NULL
);

DROP SEQUENCE blog_blog_seq_SEQ;

CREATE SEQUENCE blog_blog_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER blog_blog_seq_TRG
BEFORE INSERT ON blog
FOR EACH ROW
BEGIN
IF :NEW.blog_seq IS NOT NULL THEN
  SELECT blog_blog_seq_SEQ.NEXTVAL INTO :NEW.blog_seq FROM DUAL;
END IF;
END;


CREATE TABLE blog_comment(
		comment_seq                   		NUMBER(20)		 NULL ,
		comment_content               		VARCHAR2(50)		 NULL ,
		comment_date                  		DATE		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL ,
		blog_seq                      		NUMBER(20)		 NOT NULL
);


CREATE TABLE message(
		massage_seq                   		NUMBER(20)		 NULL ,
		massage_title                 		VARCHAR2(20)		 NULL ,
		massage_contents              		VARCHAR2(50)		 NULL ,
		massage_date                  		DATE		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL ,
		app_seq                       		NUMBER(20)		 NULL 
);

DROP SEQUENCE message_massage_seq_SEQ;

CREATE SEQUENCE message_massage_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER message_massage_seq_TRG
BEFORE INSERT ON message
FOR EACH ROW
BEGIN
IF :NEW.massage_seq IS NOT NULL THEN
  SELECT message_massage_seq_SEQ.NEXTVAL INTO :NEW.massage_seq FROM DUAL;
END IF;
END;


CREATE TABLE admin(
		admin_id                      		VARCHAR2(20)		 NULL ,
		blog_seq                      		NUMBER(100)		 NULL ,
		corp_id                       		VARCHAR2(30)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL ,
		payment_seq                   		NUMBER(10)		 NULL ,
		recruit_seq                   		NUMBER(20)		 NULL ,
		product_no                    		NUMBER(20)		 NULL 
);



ALTER TABLE job ADD CONSTRAINT IDX_job_PK PRIMARY KEY (job_id);

ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (user_email);
ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_FK0 FOREIGN KEY (job_id) REFERENCES job (job_id);

ALTER TABLE CV ADD CONSTRAINT IDX_CV_PK PRIMARY KEY (cv_seq);
ALTER TABLE CV ADD CONSTRAINT IDX_CV_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE education ADD CONSTRAINT IDX_education_PK PRIMARY KEY (education_seq);
ALTER TABLE education ADD CONSTRAINT IDX_education_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE experience ADD CONSTRAINT IDX_experience_PK PRIMARY KEY (experience_seq);
ALTER TABLE experience ADD CONSTRAINT IDX_experience_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE awards ADD CONSTRAINT IDX_awards_PK PRIMARY KEY (awards_seq);
ALTER TABLE awards ADD CONSTRAINT IDX_awards_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE corp ADD CONSTRAINT IDX_corp_PK PRIMARY KEY (corp_id);
ALTER TABLE corp ADD CONSTRAINT IDX_corp_FK0 FOREIGN KEY (job_id) REFERENCES job (job_id);

ALTER TABLE manager ADD CONSTRAINT IDX_manager_PK PRIMARY KEY (manager_email);
ALTER TABLE manager ADD CONSTRAINT IDX_manager_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id);

ALTER TABLE recruit ADD CONSTRAINT IDX_recruit_PK PRIMARY KEY (recruit_seq);
ALTER TABLE recruit ADD CONSTRAINT IDX_recruit_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id);

ALTER TABLE tag ADD CONSTRAINT IDX_tag_PK PRIMARY KEY (tag_id);

ALTER TABLE app ADD CONSTRAINT IDX_app_PK PRIMARY KEY (app_seq);
ALTER TABLE app ADD CONSTRAINT IDX_app_FK0 FOREIGN KEY (recruit_seq) REFERENCES recruit (recruit_seq);
ALTER TABLE app ADD CONSTRAINT IDX_app_FK1 FOREIGN KEY (cv_seq) REFERENCES CV (cv_seq);

ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_PK PRIMARY KEY (rs_seq);
ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_FK0 FOREIGN KEY (recruit_seq) REFERENCES recruit (recruit_seq);
ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_FK1 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE corp_bookmark ADD CONSTRAINT IDX_corp_bookmark_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);
ALTER TABLE corp_bookmark ADD CONSTRAINT IDX_corp_bookmark_FK1 FOREIGN KEY (corp_id) REFERENCES corp (corp_id);

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (review_seq);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK1 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (product_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (order_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (product_no) REFERENCES product (product_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK1 FOREIGN KEY (corp_id) REFERENCES corp (corp_id);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK2 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE payment ADD CONSTRAINT IDX_payment_PK PRIMARY KEY (payment_seq);
ALTER TABLE payment ADD CONSTRAINT IDX_payment_FK0 FOREIGN KEY (order_no) REFERENCES orders (order_no);

ALTER TABLE corp_tag ADD CONSTRAINT IDX_corp_tag_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id);
ALTER TABLE corp_tag ADD CONSTRAINT IDX_corp_tag_FK1 FOREIGN KEY (tag_id) REFERENCES tag (tag_id);

ALTER TABLE recruit_tag ADD CONSTRAINT IDX_recruit_tag_FK0 FOREIGN KEY (tag_id) REFERENCES tag (tag_id);
ALTER TABLE recruit_tag ADD CONSTRAINT IDX_recruit_tag_FK1 FOREIGN KEY (recruit_seq) REFERENCES recruit (recruit_seq);

ALTER TABLE corp_image ADD CONSTRAINT IDX_corp_image_PK PRIMARY KEY (corp_image_seq);
ALTER TABLE corp_image ADD CONSTRAINT IDX_corp_image_FK0 FOREIGN KEY (corp_id) REFERENCES corp (corp_id);

ALTER TABLE blog_cate ADD CONSTRAINT IDX_blog_cate_PK PRIMARY KEY (blog_cate_seq);

ALTER TABLE blog ADD CONSTRAINT IDX_blog_PK PRIMARY KEY (blog_seq);
ALTER TABLE blog ADD CONSTRAINT IDX_blog_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);
ALTER TABLE blog ADD CONSTRAINT IDX_blog_FK1 FOREIGN KEY (blog_cate_seq) REFERENCES blog_cate (blog_cate_seq);

ALTER TABLE blog_comment ADD CONSTRAINT IDX_blog_comment_PK PRIMARY KEY (comment_seq);
ALTER TABLE blog_comment ADD CONSTRAINT IDX_blog_comment_FK0 FOREIGN KEY (blog_seq) REFERENCES blog (blog_seq);
ALTER TABLE blog_comment ADD CONSTRAINT IDX_blog_comment_FK1 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE message ADD CONSTRAINT IDX_message_PK PRIMARY KEY (massage_seq);
ALTER TABLE message ADD CONSTRAINT IDX_message_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);
ALTER TABLE message ADD CONSTRAINT IDX_message_FK1 FOREIGN KEY (app_seq) REFERENCES app (app_seq);

ALTER TABLE admin ADD CONSTRAINT IDX_admin_PK PRIMARY KEY (admin_id);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK0 FOREIGN KEY (blog_seq) REFERENCES blog (blog_seq);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK1 FOREIGN KEY (corp_id) REFERENCES corp (corp_id);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK2 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK3 FOREIGN KEY (payment_seq) REFERENCES payment (payment_seq);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK4 FOREIGN KEY (recruit_seq) REFERENCES recruit (recruit_seq);
ALTER TABLE admin ADD CONSTRAINT IDX_admin_FK5 FOREIGN KEY (product_no) REFERENCES product (product_no);

