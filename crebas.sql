/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/2/6 16:39:51                            */
/*==============================================================*/


drop table if exists role;

drop table if exists userInfo;

drop table if exists users;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role                 varchar(20),
   username             varchar(100)
);

/*==============================================================*/
/* Table: userInfo                                              */
/*==============================================================*/
create table userInfo
(
   id                   integer not null,
   username             varchar(100),
   usersex              varchar(1),
   userage              int,
   primary key (id)
);

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   username             varchar(100) not null,
   password             varchar(12) binary,
   enabled              boolean,
   primary key (username)
);

alter table role add constraint FK_Reference_1 foreign key (username)
      references users (username) on delete restrict on update restrict;

alter table userInfo add constraint FK_Reference_2 foreign key (username)
      references users (username) on delete restrict on update restrict;

