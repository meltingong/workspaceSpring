DROP SEQUENCE board_boardno_seq;

CREATE SEQUENCE board_boardno_seq;
DROP TABLE board;
create table board (
       boardno number(19,0) not null,
        content varchar2(2000 char) not null,
        depth number(19,0) default 0,
        groupno number(19,0) default 0 not null,
        readcount number(19,0) default 0,
        regdate timestamp default sysdate,
        step number(19,0) default 0 not null,
        title varchar2(100 char) not null,
        writer varchar2(20 char) not null,
        primary key (boardno)
    )









