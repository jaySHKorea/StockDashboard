create database stockDashboard character set=utf8;

grant all privileges on stockDashboard.* to 'seunghye'@'%';
use stockDashboard;
alter user 'seunghye'@'%' IDENTIFIED WITH mysql_native_password BY 'password';

create table stockDashboard.MEMBER (
    ID int auto_increment primary key,
    EMAIL varchar(255),
    PASSWORD varchar(100),
    NAME varchar(100),
    REGDATE datetime,
    unique key (EMAIL) 
) engine=InnoDB character set = utf8;