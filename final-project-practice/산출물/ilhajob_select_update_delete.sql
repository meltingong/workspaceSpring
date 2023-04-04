-- 회원 추가정보 업데이트
update userinfo set
user_name='이름1',
user_phone='010-1234-5678',
user_sex='성별',
user_address='주소',
user_age=99,
user_final_education='x대학교',
user_language='토익xxx',
user_skills='기술',
user_image='default.jpg',
user_status='F',
sns_type='카카오?',
sns_id='2720506301811636',
job_id=2,
role_id=4  
where user_email='테스트1@test.com';

--기업회원 추가정보 업데이트
update corp set
corp_phone='02-1234-5678',
corp_business_no='11024266788',
corp_website='corp1@crop.com',
corp_est=sysdate,
corp_size='50',
corp_sales='100억',
corp_comment='ㅎ...ㅎ.ㅎ.ㅎ.ㅎ.ㅎ.ㅎ.ㅎ.ㅎ',
corp_welfare='^&^&^&^&^&^&^&^',
corp_address='@!$@!%@#^^$^%&$',
corp_status='F',
job_id=2,
role_id=1
where corp_id='기업1@corp.com';


/********************회원 학력**********************/
select * 
from userinfo u
join education e
on u.user_email=e.user_email
where u.user_email='테스트1@test.com';
/********************회원 수상**********************/
select * 
from userinfo u
join awards a
on u.user_seq=a.user_seq
where u.user_seq=2;
/********************회원 경력**********************/
select * 
from userinfo u
join experience exp
on u.user_email=exp.user_email
where u.user_email='테스트1@test.com';

/********************회원1의 이력서 목록**********************/
select * from cv where cv.user_email='테스트1@test.com';

/********************회원1의 이력서 제출목록**********************/
select * from (
            select * from cv 
            where cv.user_email='테스트1@test.com'
            ) ucv
join app
on app.cv_seq=ucv.cv_seq;

/********************회원1의 이력서 제출목록의 공고정보**********************/
select * from (
            select * from cv 
            where cv.user_email='테스트1@test.com'
            ) ucv
join app
on app.cv_seq=ucv.cv_seq
join recruit r
on r.rc_seq=app.rc_seq
order by r.rc_deadline desc;

/********회원 1의 리뷰 작성 목록->order by 생략 가능********/
select * from review r
join userinfo u
on r.user_seq=u.user_seq
where r.user_seq=1
order by r.review_seq desc;

/********************recruit**********************/
select * from recruit rc 
join corp c
on rc.corp_id = c.corp_id
order by rc_seq desc; 

update recruit
set rc_title = '업데이트테스트', rc_position = '업데이트', rc_content = '업데이트',
    rc_qualification = '업데이트', rc_salary = 5000,rc_deadline = '2023/04/05'
where rc_seq = 1 and corp_id = 'corp_01';

delete from recruit where rc_seq = 1 and corp_id = 'corp_01';


/********************기업1의 공고 목록**********************/
select * from recruit r where r.corp_id='corp_01'
order by rc_seq desc;

select * from corp c
join recruit r
on c.corp_id=r.corp_id
where r.corp_id='corp_01'
order by rc_seq desc;

/********************기업1의 공고에 지원된 이력서 목록**********************/
select * from (
            select * from recruit r
            where r.corp_id='corp_01'
            ) c
join app
on app.rc_seq=c.rc_seq
join cv
on cv.cv_seq=app.cv_seq
order by c.rc_deadline desc, c.rc_title asc;

/********************기업1의 모든 지원자목록**********************/
select * from (
            select * from recruit r
            where r.corp_id='corp_01'
            ) c
join app
on app.rc_seq=c.rc_seq
join cv
on cv.cv_seq=app.cv_seq
join userinfo u
on u.user_seq=cv.user_seq
order by c.rc_deadline desc, c.rc_title asc;
/***이너 셀렉트 생략가능 ***/
select * from recruit r
join app
on app.rc_seq=r.rc_seq
join cv
on cv.cv_seq=app.cv_seq
join userinfo u
on u.user_seq=cv.user_seq
where r.corp_id='corp_01'
order by r.rc_deadline desc, r.rc_title asc;

/***************기업 1의 리뷰 모두 보기(order by revoew.seq desc: 최신순-> 생략가능)*************/
select * from corp c
join review r
on c.corp_id=r.corp_id
where c.corp_id='corp_01'
order by r.review_seq desc;

/********************회원의 결제상품 상세보기**********************/
select * from orders
where user_seq=1;

/********************개인회원의 결제상품 상세보기**********************/
select * from orders o
join product p
on o.p_no=p.p_no
where user_seq=1;

/********************기업의 결제상품 상세보기**********************/
select * from orders o
join product p
on o.p_no=p.p_no
where corp_id='corp_01';


/********************기업의 이미지리스트 보기**********************/
select * from corp c
join corp_image ci
on c.corp_id=ci.corp_id
where c.corp_id='corp_01';

/********************기업의 이미지리스트, 매니저리스트 보기**********************/
select * from corp c
join corp_image ci
on c.corp_id=ci.corp_id
join manager m
on m.corp_id=c.corp_id
where c.corp_id='corp_01';

/********************기업의 오더객체,이미지리스트, 매니저리스트 보기**********************/
select * from corp c
join corp_image ci
on c.corp_id=ci.corp_id
join manager m
on c.corp_id=m.corp_id
join orders o
on c.corp_id=o.corp_id
where c.corp_id='corp_01';

/********************기업의 orders with Product**********************/
select * from corp c
join orders o
on c.corp_id=o.corp_id
where c.corp_id='corp_01';

select * from corp c
		join orders o
		on c.corp_id=o.corp_id
        join product p
        on o.p_no=p.p_no
where c.corp_id='corp_01';


/*****기업 아이디 중복체크******/
select count(*) cnt from corp where corp_id='corp_01';

/*****매니저 1이 속한 기업의 정보 불러오기 [매니저1 email(pk):이메일@기업1-1.com]******/
select c.* from corp c
join manager m
on c.corp_id=m.corp_id
where m.manager_email='이메일@기업1-1.com';

/*********************************************메세지***************/
select * from message;

select * from message where message_seq=1;

select * from message where user_seq=2;

update message set message_title='제목변경', message_contents='제목 내용', message_date='2022/01/01', user_seq=3 where message_seq=1;

delete from message where message_seq=3;

delete from message where user_seq=2;








--rollback;














