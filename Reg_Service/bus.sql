/*
SQLyog - Free MySQL GUI v5.13
Host - 5.0.22-community-nt : Database - register
*********************************************************************
Server version : 5.0.22-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `register`;

USE `register`;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` varchar(200) default NULL,
  `password` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert into `admin` (`username`,`password`) values ('admin','admin');

/*Table structure for table `bankdetails` */

DROP TABLE IF EXISTS `bankdetails`;

CREATE TABLE `bankdetails` (
  `name` varchar(200) default NULL,
  `accountno` varchar(200) default NULL,
  `cvv` varchar(200) default NULL,
  `expirydate` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bankdetails` */

insert into `bankdetails` (`name`,`accountno`,`cvv`,`expirydate`) values ('prabu','1234567890','677','12//20');
insert into `bankdetails` (`name`,`accountno`,`cvv`,`expirydate`) values ('as','979867654367','434','21/1/18');

/*Table structure for table `booklist` */

DROP TABLE IF EXISTS `booklist`;

CREATE TABLE `booklist` (
  `conductorid` varchar(500) default NULL,
  `username` varchar(100) default NULL,
  `busnumber` varchar(100) default NULL,
  `fromst` varchar(100) default NULL,
  `tost` varchar(100) default NULL,
  `time` varchar(100) default NULL,
  `amount` varchar(100) default NULL,
  `currentdate` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `booklist` */

insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('1@PC8lEywpdW5Vhj0dUzsASPTbQmN6IoXYd+ndJKrsS7oVsP9qdSCninjm,dmS/rXbgZQ4+GDjVU51L/BxzA1oHfG2KQ5gDGjZXRHM=,kd9A3BiTN0NirPunbY9Pow==','user','C1','tambaram','tnagar','12:30:00','60','2018-03-01');
insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('1@krESsoaVUaOjuQY7xmV2mYbvQhxbwVuNpErNa9LU79KkKrnJc+h+CCeL,dmS/rXbgZQ4+GDjVU51L/BxzA1oHfG2KQ5gDGjZXRHM=,kd9A3BiTN0NirPunbY9Pow==','as','D1','tambaram','tnagar','13:30:00','45','2018-03-01');
insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('1@sXYR3b9K6PSRyYHsIfFms/QT8a5q/AnLpuAgW3IKbYZ+DZz4LTk26MWu,dmS/rXbgZQ4+GDjVU51L/BxzA1oHfG2KQ5gDGjZXRHM=,kd9A3BiTN0NirPunbY9Pow==','prabu','B1','tambaram','tnagar','14:20:00','50','2018-03-01');
insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('1@anitmmTTkSz+sNUBWs+Rs9bmsA7aOPT7qjZoLSmXCkmPvtu3Zv+lC3HY,PnoFS93CrLCzQuckAuv+8gOI7tby2ZIAeLBKW12Ij1A=,kd9A3BiTN0NirPunbY9Pow==','user','D1','tambaram','tnagar','15:30:00','75','2018-03-01');
insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('1@u0PpEGRwHYbKcbrd27iFzk0mzzmvEqm5uJYKnCBJMJE7+nTU+JN8kJtp,PnoFS93CrLCzQuckAuv+8gOI7tby2ZIAeLBKW12Ij1A=,kd9A3BiTN0NirPunbY9Pow==','prabu','B1','tambaram','tnagar','16:20:00','20','2018-03-01');
insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('1@Mt4wMCGUwj0/oZ0uy0yDtAtqPqpI6zBosXpaluctwKs7xCSqqa+yE9D3,PnoFS93CrLCzQuckAuv+8gOI7tby2ZIAeLBKW12Ij1A=,kd9A3BiTN0NirPunbY9Pow==','as','C1','tambaram','tnagar','17:30:00','80','2018-03-01');
insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('http://www.qrstuff.com','As','C1','Tambaram ','Tnagar ','04:30:00','60','2018-03-01');

/*Table structure for table `ticket` */

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `fromst` varchar(200) default NULL,
  `tost` varchar(200) default NULL,
  `amount` varchar(200) default NULL,
  `busnumber` varchar(100) default NULL,
  `time1` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ticket` */

insert into `ticket` (`fromst`,`tost`,`amount`,`busnumber`,`time1`) values ('tambaram','tnagar','10','B1','03:20:00');
insert into `ticket` (`fromst`,`tost`,`amount`,`busnumber`,`time1`) values ('tambaram','tnagar','10','C1','04:30:00');
insert into `ticket` (`fromst`,`tost`,`amount`,`busnumber`,`time1`) values ('tambaram','tnagar','15','D1','05:30:00');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `emailid` varchar(100) default NULL,
  `phone` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert into `user` (`username`,`password`,`emailid`,`phone`) values ('as','as','as','as');
insert into `user` (`username`,`password`,`emailid`,`phone`) values ('user','user','user@gmail.com','user');
insert into `user` (`username`,`password`,`emailid`,`phone`) values ('prabu','prabu','prabu@gmail.com','prabu');

SET SQL_MODE=@OLD_SQL_MODE;