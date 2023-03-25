/*
job 카테고리 insert
*/
insert into job(job_id,job_name) values(6,'게임개발');

/*
회사 insert
*/
insert into corp(corp_id,corp_password,corp_name,corp_phone,corp_business_no,corp_website,corp_est,corp_size,
                 corp_sales,corp_comment,corp_welfare,corp_address,corp_status,job_id) 
                 values ('aa12',1111,'무한상사',028221234,8211111,'www.moohan.com','1995-02-12',10,100000000,'무한도전','웃겨드려요','서울특별시 강남구 테헤란로 124 4층 (역삼동, 삼원타워)','1',6);
insert into corp(corp_id,corp_password,corp_name,corp_phone,corp_business_no,corp_website,corp_est,corp_size,
                 corp_sales,corp_comment,corp_welfare,corp_address,corp_status,job_id) 
                 values ('bb12',1111,'무야호',028222312,8212222,'www.mooyaho.com','2010-03-05',30,200000000,'무야호','무~야~호','서울특별시 동작구 장승배기로 161','2',6);
insert into corp(corp_id,corp_password,corp_name,corp_phone,corp_business_no,corp_website,corp_est,corp_size,
                 corp_sales,corp_comment,corp_welfare,corp_address,corp_status,job_id) 
                 values ('cc12',1111,'넥슨',028225678,8213333,'www.nexon.com','1997-12-25',3000,4000000000,'게임회사','업계 최고 복지','경기도 성남시 분당구 판교로256번길 7','1',6);
insert into corp(corp_id,corp_password,corp_name,corp_phone,corp_business_no,corp_website,corp_est,corp_size,
                 corp_sales,corp_comment,corp_welfare,corp_address,corp_status,job_id) 
                 values ('dd12',1111,'넥센',028227893,8214444,'www.nexen.com','1999-03-05',4000,200000000,'게임회사느낌','중식 제공 및 성과급 빵빵','경남 김해시 김해대로 2595','2',6);
insert into corp(corp_id,corp_password,corp_name,corp_phone,corp_business_no,corp_website,corp_est,corp_size,
                 corp_sales,corp_comment,corp_welfare,corp_address,corp_status,job_id) 
                 values ('ee12',1111,'한게임',028229999,8215555,'www.hangame.com','2000-07-06',50,300000000,'맞고하고 가세요','명절선물,4대보험','경기도 성남시 분당구 대왕판교로645번길 16','1',6);
insert into corp(corp_id,corp_password,corp_name,corp_phone,corp_business_no,corp_website,corp_est,corp_size,
                 corp_sales,corp_comment,corp_welfare,corp_address,corp_status,job_id) 
                 values ('ff12',1111,'넷마블',028227876,8216666,'www.netmable.com','2002-01-05',30,500000000,'서든어택원조','고양이 있음, 휴게공간 업계최고','서울특별시 구로구 디지털로26길 38','2',6);
/*
공고 insert product_p_no_SEQ.nextval
*/
insert into recruit(recruit_seq,recruit_title,recruit_position,recruit_content,recruit_career_level,recruit_qualification,
                    recruit_salary,recruit_deadline,recruit_experience,recruit_read_count,corp_id) 
                    values (recruit_recruit_seq_SEQ.nextval,'백엔드 개발자 모집합니다','신입','열정있으신 분','','정보처리기사 자격증 보유','35000000','2023-04-28','경력무관',0,'aa12');
insert into recruit(recruit_seq,recruit_title,recruit_position,recruit_content,recruit_career_level,recruit_qualification,
                    recruit_salary,recruit_deadline,recruit_experience,recruit_read_count,corp_id) 
                    values (recruit_recruit_seq_SEQ.nextval,'프론트 개발자 모집합니다','신입/경력','미적 감각이 뛰어나신 분','ㅇ','포토샵 가능자','28000000','2023-05-30','2년이상',0,'bb12');
insert into recruit(recruit_seq,recruit_title,recruit_position,recruit_content,recruit_career_level,recruit_qualification,
                    recruit_salary,recruit_deadline,recruit_experience,recruit_read_count,corp_id) 
                    values (recruit_recruit_seq_SEQ.nextval,'게임 개발자 모집합니다','신입/경력','물리엔진에 대한 이해가 뛰어나신 분','','게임개발 경험 보유자','45000000','2023-06-15','5년이상',0,'cc12');
insert into recruit(recruit_seq,recruit_title,recruit_position,recruit_content,recruit_career_level,recruit_qualification,
                    recruit_salary,recruit_deadline,recruit_experience,recruit_read_count,corp_id) 
                    values (recruit_recruit_seq_SEQ.nextval,'넥센 인재를 모집합니다','경력','의사소통이 원할하게 가능한 분','','깃허브를 이용한 프로젝트 경험 보유자','35000000','2023-07-28','3년이상',0,'dd12');
insert into recruit(recruit_seq,recruit_title,recruit_position,recruit_content,recruit_career_level,recruit_qualification,
                    recruit_salary,recruit_deadline,recruit_experience,recruit_read_count,corp_id) 
                    values (recruit_recruit_seq_SEQ.nextval,'함께 할 개발자를 구합니다','신입','열정을 가진 누구나','','정보처리기사 자격증 보유','33000000','2023-05-15','경력무관',0,'ee12');
insert into recruit(recruit_seq,recruit_title,recruit_position,recruit_content,recruit_career_level,recruit_qualification,
                    recruit_salary,recruit_deadline,recruit_experience,recruit_read_count,corp_id) 
                    values (recruit_recruit_seq_SEQ.nextval,'넷마블을 사랑하는 누구나','신입/경력','넷마블 게임 해보신분','','정보처리기사 자격증 보유','35000000','2023-07-27','3년이상',0,'ff12');