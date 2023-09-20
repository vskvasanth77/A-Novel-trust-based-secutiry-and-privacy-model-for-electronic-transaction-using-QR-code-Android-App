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
  `expirydate` varchar(200) default NULL,
  `cash` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bankdetails` */

insert into `bankdetails` (`name`,`accountno`,`cvv`,`expirydate`,`cash`) values ('prabu','1234567890','677','12//20','450');
insert into `bankdetails` (`name`,`accountno`,`cvv`,`expirydate`,`cash`) values ('as','979867654367','434','21/1/18','1050');

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

insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('C1','as','C1','tambaram','tnagar','04:30:00','30','2018-03-27');
insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('B1','as','B1','tambaram','tnagar','03:20:00','90','2018-03-27');
insert into `booklist` (`conductorid`,`username`,`busnumber`,`fromst`,`tost`,`time`,`amount`,`currentdate`) values ('B1','as','B1','tambaram','tnagar','03:20:00','20','2018-03-27');

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
insert into `user` (`username`,`password`,`emailid`,`phone`) values ('aa','aa','aa@gmail.com','aa');

SET SQL_MODE=@OLD_SQL_MODE;