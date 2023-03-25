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

