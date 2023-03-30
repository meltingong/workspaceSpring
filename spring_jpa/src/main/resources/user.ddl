 drop sequence users_id_seq;
 create sequence users_id_seq start with 1 increment by  1;
 
 drop table users;
 
 create table users (
        id number(19,0) not null,
        created_at timestamp not null,
        email varchar2(255 char),
        name varchar2(255 char) not null,
        updated_at timestamp not null,
        primary key (id)
  );



