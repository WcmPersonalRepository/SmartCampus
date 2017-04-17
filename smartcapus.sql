/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.28 : Database - smartcampus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smartcampus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `smartcampus`;

/*Table structure for table `sys_authorities` */

DROP TABLE IF EXISTS `sys_authorities`;

CREATE TABLE `sys_authorities` (
  `AUTHORITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AUTHORITY_DESC` varchar(200) DEFAULT NULL,
  `AUTHORITY_MARK` varchar(100) DEFAULT NULL,
  `AUTHORITY_NAME` varchar(100) NOT NULL,
  `ENABLE` int(11) DEFAULT NULL,
  `ISSYS` int(11) DEFAULT NULL,
  `MESSAGE` varchar(100) DEFAULT NULL,
  `MODULE_ID` varchar(100) DEFAULT NULL,
  `ROLE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`AUTHORITY_ID`),
  UNIQUE KEY `AUTHORITY_ID` (`AUTHORITY_ID`),
  KEY `FK4A3C64AFE2B1918C` (`ROLE_ID`),
  CONSTRAINT `FK4A3C64AFE2B1918C` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_roles` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_authorities` */

/*Table structure for table `sys_campus` */

DROP TABLE IF EXISTS `sys_campus`;

CREATE TABLE `sys_campus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `campus_description` longtext,
  `campus_location` varchar(100) DEFAULT NULL,
  `campus_name` varchar(50) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_campus` */

insert  into `sys_campus`(`id`,`campus_description`,`campus_location`,`campus_name`,`city`,`province`) values (1,NULL,NULL,'明秀校区',NULL,NULL),(2,NULL,NULL,'相思湖校区',NULL,NULL),(3,NULL,NULL,'防城港校区',NULL,NULL);

/*Table structure for table `sys_class` */

DROP TABLE IF EXISTS `sys_class`;

CREATE TABLE `sys_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(10) DEFAULT NULL,
  `reserved_field1` varchar(100) DEFAULT NULL,
  `reserved_field2` varchar(100) DEFAULT NULL,
  `reserved_field3` varchar(100) DEFAULT NULL,
  `reserved_field4` varchar(100) DEFAULT NULL,
  `professional_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK1F5ABD86F98F9505` (`teacher_id`),
  KEY `FK1F5ABD86F83484AF` (`professional_id`),
  CONSTRAINT `FK1F5ABD86F83484AF` FOREIGN KEY (`professional_id`) REFERENCES `sys_professional` (`id`),
  CONSTRAINT `FK1F5ABD86F98F9505` FOREIGN KEY (`teacher_id`) REFERENCES `sys_teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_class` */

insert  into `sys_class`(`id`,`class_name`,`reserved_field1`,`reserved_field2`,`reserved_field3`,`reserved_field4`,`professional_id`,`teacher_id`) values (2,'电商1621',NULL,NULL,NULL,NULL,84,2),(3,'信息1441',NULL,NULL,NULL,NULL,86,6),(4,'信息1541',NULL,NULL,NULL,NULL,86,3),(5,'计应1331',NULL,NULL,NULL,NULL,87,5);

/*Table structure for table `sys_college` */

DROP TABLE IF EXISTS `sys_college`;

CREATE TABLE `sys_college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college_description` varchar(200) DEFAULT NULL,
  `college_name` varchar(50) DEFAULT NULL,
  `campus_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKB957AA2567978D6F` (`campus_id`),
  CONSTRAINT `FKB957AA2567978D6F` FOREIGN KEY (`campus_id`) REFERENCES `sys_campus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `sys_college` */

insert  into `sys_college`(`id`,`college_description`,`college_name`,`campus_id`) values (1,'','信息与统计学院\r\n',1),(2,'','商务外国语学院\r\n',1),(3,'','会计与审计学院\r\n',1),(4,'','法学院\r\n',1),(5,'','国际教育学院\r\n',1),(6,'','体育教学部\r\n',1),(7,'','马克思主义学院\r\n',1),(8,'','经济与贸易学院\r\n',2),(9,'','财政与公共管理学院\r\n',2),(10,'','金融与保险学院\r\n',2),(11,'','工商管理学院\r\n',2),(12,'','管理科学与工程学院\r\n',2),(13,'','文化传播学院\r\n',2),(14,'','防城港学院\r\n',3),(16,'','教务处',2),(17,NULL,'继续教育学院',1),(18,NULL,'国际交流处',NULL);

/*Table structure for table `sys_leave_info` */

DROP TABLE IF EXISTS `sys_leave_info`;

CREATE TABLE `sys_leave_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approver_agree` varchar(10) DEFAULT NULL,
  `approver_description` varchar(200) DEFAULT NULL,
  `is_family_agree` int(11) DEFAULT NULL,
  `leave_end_date` datetime NOT NULL,
  `leave_end_lesson` int(11) DEFAULT NULL,
  `leave_start_date` datetime NOT NULL,
  `leave_start_lesson` int(11) DEFAULT NULL,
  `reserved_field1` varchar(200) DEFAULT NULL,
  `reserved_field2` varchar(100) DEFAULT NULL,
  `reserved_field3` varchar(200) DEFAULT NULL,
  `reserved_field4` varchar(100) DEFAULT NULL,
  `teach_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKE66DADE8DCB8AB92` (`teach_id`),
  KEY `FKE66DADE88806E962` (`user_id`),
  CONSTRAINT `FKE66DADE88806E962` FOREIGN KEY (`user_id`) REFERENCES `sys_users` (`USER_ID`),
  CONSTRAINT `FKE66DADE8DCB8AB92` FOREIGN KEY (`teach_id`) REFERENCES `sys_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_leave_info` */

/*Table structure for table `sys_organization` */

DROP TABLE IF EXISTS `sys_organization`;

CREATE TABLE `sys_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `sys_organization` */

insert  into `sys_organization`(`id`,`organization_name`,`remark`) values (1,'党政机构',NULL),(2,'教学院部',NULL),(3,'教辅部门',NULL),(4,'科研机构',NULL);

/*Table structure for table `sys_part` */

DROP TABLE IF EXISTS `sys_part`;

CREATE TABLE `sys_part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_description` varchar(100) DEFAULT NULL,
  `part_name` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `organization_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK74A5962596A3992F` (`organization_id`),
  CONSTRAINT `FK74A5962596A3992F` FOREIGN KEY (`organization_id`) REFERENCES `sys_organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

/*Data for the table `sys_part` */

insert  into `sys_part`(`id`,`part_description`,`part_name`,`remark`,`organization_id`) values (46,NULL,'党委办公室 院长办公室',NULL,1),(47,NULL,'组织部',NULL,1),(48,NULL,'宣传部',NULL,1),(49,NULL,'学生工作部',NULL,1),(50,NULL,'团委',NULL,1),(51,NULL,'纪检监察室',NULL,1),(52,NULL,'工会',NULL,1),(53,NULL,'审计处',NULL,1),(54,NULL,'科研处',NULL,1),(55,NULL,'人事处',NULL,1),(56,NULL,'教务处',NULL,1),(57,NULL,'发展规划与教育评估中心',NULL,1),(58,NULL,'财务处',NULL,1),(59,NULL,'保卫处',NULL,1),(60,NULL,'后勤管理处',NULL,1),(61,NULL,'招生就业处',NULL,1),(62,NULL,'采购工作委员会办公室',NULL,1),(63,NULL,'建设处',NULL,1),(64,NULL,'离退休工作处',NULL,1),(65,NULL,'住房建设办公室',NULL,1),(66,NULL,'研究生处',NULL,1),(67,NULL,'国际交流处（港澳台事务办公室）',NULL,1),(68,NULL,'经济与贸易学院',NULL,2),(69,NULL,'财政与公共管理学院',NULL,2),(70,NULL,'金融与保险学院',NULL,2),(71,NULL,'商务外国语学院',NULL,2),(72,NULL,'信息与统计学院',NULL,2),(73,NULL,'工商管理学院',NULL,2),(74,NULL,'管理科学与工程学院',NULL,2),(75,NULL,'会计与审计学院',NULL,2),(76,NULL,'文化传播学院',NULL,2),(77,NULL,'法学院',NULL,2),(78,NULL,'防城港学院',NULL,2),(79,NULL,'国际教育学院',NULL,2),(80,NULL,'马克思主义学院',NULL,2),(81,NULL,'体育教学部',NULL,2),(82,NULL,'现代教育技术部',NULL,3),(83,NULL,'图书馆',NULL,3),(84,NULL,'继续教育学院',NULL,3),(85,NULL,'学报编辑部',NULL,3),(86,NULL,'实验教学中心',NULL,3),(87,NULL,'创新创业学院',NULL,3),(88,NULL,'海上丝绸之路与广西区域发展研究院',NULL,4),(89,NULL,'海陆经济一体化与海上丝绸之路建设研究协同中心',NULL,4),(90,NULL,'广西（东盟）财经研究中心',NULL,4);

/*Table structure for table `sys_professional` */

DROP TABLE IF EXISTS `sys_professional`;

CREATE TABLE `sys_professional` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `belong_course` varchar(50) DEFAULT NULL,
  `education_duration` int(11) DEFAULT NULL,
  `education_level` varchar(10) DEFAULT NULL,
  `professional_code` varchar(10) DEFAULT NULL,
  `professional_description` varchar(200) DEFAULT NULL,
  `professional_name` varchar(100) DEFAULT NULL,
  `reserved_field1` varchar(100) DEFAULT NULL,
  `reserved_field2` varchar(100) DEFAULT NULL,
  `reserved_field3` varchar(100) DEFAULT NULL,
  `reserved_field4` varchar(100) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKFAA57E59677DBCE5` (`college_id`),
  CONSTRAINT `FKFAA57E59677DBCE5` FOREIGN KEY (`college_id`) REFERENCES `sys_college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8;

/*Data for the table `sys_professional` */

insert  into `sys_professional`(`id`,`belong_course`,`education_duration`,`education_level`,`professional_code`,`professional_description`,`professional_name`,`reserved_field1`,`reserved_field2`,`reserved_field3`,`reserved_field4`,`college_id`) values (1,'经济学',4,'本科','140',NULL,'天财访学',NULL,NULL,NULL,NULL,16),(2,'经济学',4,'本科','20144',NULL,'国际经济与贸易(双学位)',NULL,NULL,NULL,NULL,8),(3,'经济学',4,'本科','10142',NULL,'经济学(产业经济学方向)',NULL,NULL,NULL,NULL,8),(4,'经济学',4,'本科','10143',NULL,'经济学(区域经济学方向)',NULL,NULL,NULL,NULL,8),(5,'经济学',4,'本科','10140',NULL,'经济学',NULL,NULL,NULL,NULL,8),(6,'经济学',4,'本科','10240',NULL,'农村区域发展',NULL,NULL,NULL,NULL,8),(7,'经济学',4,'本科','10241',NULL,'农村区域发展(卓越)',NULL,NULL,NULL,NULL,8),(8,'管理学',4,'本科','10340',NULL,'农林经济管理',NULL,NULL,NULL,NULL,8),(9,'经济学',2,'专升本','20520',NULL,'国际商务(专升本)',NULL,NULL,NULL,NULL,8),(10,'管理学',4,'本科','10440',NULL,'土地资源管理',NULL,NULL,NULL,NULL,8),(11,'经济学',4,'本科','20146',NULL,'国际经济与贸易(国教转入)',NULL,NULL,NULL,NULL,8),(12,'管理学',2,'专升本','10320',NULL,'农林经济管理（专升本）',NULL,NULL,NULL,NULL,8),(13,'经济学',4,'本科','20147',NULL,'国际经济与贸易(中越转入)',NULL,NULL,NULL,NULL,8),(14,'经济学',4,'本科','10540',NULL,'商务经济学',NULL,NULL,NULL,NULL,8),(15,'经济学',2,'专升本','20120',NULL,'国际经济与贸易(专升本)',NULL,NULL,NULL,NULL,8),(16,'经济学',4,'本科','20040',NULL,'贸易类',NULL,NULL,NULL,NULL,8),(17,'经济学',3,'专科','20530',NULL,'国际商务(高职专科)',NULL,NULL,NULL,NULL,8),(18,'经济学',4,'本科','20140',NULL,'国际经济与贸易',NULL,NULL,NULL,NULL,8),(19,'经济学',4,'本科','20141',NULL,'国际经济与贸易(东南亚方向)',NULL,NULL,NULL,NULL,8),(20,'经济学',4,'本科','20540',NULL,'国际商务',NULL,NULL,NULL,NULL,8),(21,'经济学',4,'本科','20145',NULL,'国际经济与贸易(中泰转入)',NULL,NULL,NULL,NULL,8),(22,'经济学',4,'本科','20541',NULL,'国际商务(卓越)',NULL,NULL,NULL,NULL,8),(23,'经济学',4,'本科','30140',NULL,'财政学',NULL,NULL,NULL,NULL,9),(24,'经济学',4,'本科','30040',NULL,'财政类',NULL,NULL,NULL,NULL,9),(25,'管理学',3,'专科','30530',NULL,'公共事务管理(高职专科)',NULL,NULL,NULL,NULL,9),(26,'经济学',4,'本科','30141',NULL,'财政学(财政方向)',NULL,NULL,NULL,NULL,9),(27,'经济学',4,'本科','30142',NULL,'财政学(税收方向)',NULL,NULL,NULL,NULL,9),(28,'经济学',3,'专科','30130',NULL,'财政(高职专科)',NULL,NULL,NULL,NULL,9),(29,'管理学',4,'本科','30340',NULL,'劳动与社会保障',NULL,NULL,NULL,NULL,9),(30,'经济学',4,'本科','30240',NULL,'税务',NULL,NULL,NULL,NULL,9),(31,'经济学',4,'本科','30241',NULL,'税务(双学位)',NULL,NULL,NULL,NULL,9),(32,'经济学',4,'本科','30242',NULL,'税务(财税信息化-航信)',NULL,NULL,NULL,NULL,9),(33,'经济学',4,'本科','30243',NULL,'税务(卓越)',NULL,NULL,NULL,NULL,9),(34,'经济学',4,'本科','30244',NULL,'税收学(卓越)',NULL,NULL,NULL,NULL,9),(35,'经济学',4,'本科','30245',NULL,'税收学(航信)',NULL,NULL,NULL,NULL,9),(36,'管理学',4,'本科','30440',NULL,'公共事业管理',NULL,NULL,NULL,NULL,9),(37,'经济学',4,'本科','30246',NULL,'税收学',NULL,NULL,NULL,NULL,9),(38,'经济学',4,'本科','30143',NULL,'财政学(政府采购方向)',NULL,NULL,NULL,NULL,9),(39,'经济学',4,'本科','30144',NULL,'财政学(卓越财经)',NULL,NULL,NULL,NULL,9),(40,'经济学',4,'本科','30247',NULL,'税收学(航信创新)',NULL,NULL,NULL,NULL,9),(41,'管理学',4,'本科','90340',NULL,'公共关系学',NULL,NULL,NULL,NULL,9),(42,'经济学',3,'专科','40730',NULL,'金融管理与实务(高职专科)',NULL,NULL,NULL,NULL,10),(43,'经济学',4,'本科','40140',NULL,'金融学',NULL,NULL,NULL,NULL,10),(44,'经济学',3,'专科','40230',NULL,'金融保险(高职专科)',NULL,NULL,NULL,NULL,10),(45,'经济学',3,'专科','40530',NULL,'证券投资与管理(高职专科)',NULL,NULL,NULL,NULL,10),(46,'经济学',4,'本科','40141',NULL,'金融学(金融学方向)',NULL,NULL,NULL,NULL,10),(47,'经济学',4,'本科','40142',NULL,'金融学(投资方向)',NULL,NULL,NULL,NULL,10),(48,'经济学',4,'本科','40143',NULL,'金融学(保险方向)',NULL,NULL,NULL,NULL,10),(49,'经济学',3,'专科','40231',NULL,'金融保险(高职）',NULL,NULL,NULL,NULL,10),(50,'经济学',4,'本科','40340',NULL,'保险',NULL,NULL,NULL,NULL,10),(51,'经济学',4,'本科','40145',NULL,'金融学(金融工程方向)',NULL,NULL,NULL,NULL,10),(52,'经济学',4,'本科','40146',NULL,'金融学(东南亚金融方向)',NULL,NULL,NULL,NULL,10),(53,'经济学',4,'本科','40040',NULL,'金融类',NULL,NULL,NULL,NULL,10),(54,'经济学',4,'本科','40147',NULL,'金融学(双学位)',NULL,NULL,NULL,NULL,10),(55,'经济学',4,'本科','40148',NULL,'投资理财(实验班)',NULL,NULL,NULL,NULL,10),(56,'经济学',4,'本科','40240',NULL,'投资学',NULL,NULL,NULL,NULL,10),(57,'经济学',4,'本科','40149',NULL,'金融学(卓越)',NULL,NULL,NULL,NULL,10),(58,'经济学',4,'本科','40341',NULL,'保险(卓越)',NULL,NULL,NULL,NULL,10),(59,'经济学',4,'本科','40241',NULL,'投资学(卓越)',NULL,NULL,NULL,NULL,10),(60,'经济学',2,'专升本','40120',NULL,'金融学(专升本)',NULL,NULL,NULL,NULL,10),(61,'经济学',4,'本科','40342',NULL,'保险学(卓越)',NULL,NULL,NULL,NULL,10),(62,'经济学',4,'本科','40440',NULL,'金融工程',NULL,NULL,NULL,NULL,10),(63,'经济学',4,'本科','40441',NULL,'金融工程(卓越)',NULL,NULL,NULL,NULL,10),(64,'经济学',4,'本科','40144',NULL,'金融学(卓越财经)',NULL,NULL,NULL,NULL,10),(65,'经济学',3,'专科','42730',NULL,'金融管理(高职专科）',NULL,NULL,NULL,NULL,10),(66,'经济学',3,'专科','42830',NULL,'证券与期货(高职专科）',NULL,NULL,NULL,NULL,10),(67,'经济学',3,'专科','42930',NULL,'保险(高职专科）',NULL,NULL,NULL,NULL,10),(68,'文学',4,'本科','50140',NULL,'英语',NULL,NULL,NULL,NULL,2),(69,'文学',4,'本科','50143',NULL,'英语(文秘方向)',NULL,NULL,NULL,NULL,2),(70,'文学',4,'本科','50142',NULL,'英语(商务方向)',NULL,NULL,NULL,NULL,2),(71,'文学',4,'本科','50141',NULL,'英语(英语方向)',NULL,NULL,NULL,NULL,2),(72,'文学',3,'专科','50230',NULL,'商务英语(高职专科)',NULL,NULL,NULL,NULL,2),(73,'文学',3,'专科','50330',NULL,'旅游英语(高职专科)',NULL,NULL,NULL,NULL,2),(74,'文学',2,'专科','50250',NULL,'商务英语(3+2)',NULL,NULL,NULL,NULL,2),(75,'文学',4,'本科','50146',NULL,'英语(双学位)',NULL,NULL,NULL,NULL,2),(76,'文学',4,'本科','50147',NULL,'英语(翻译方向)',NULL,NULL,NULL,NULL,2),(77,'文学',4,'本科','50149',NULL,'英语(翻译方向)(卓越)',NULL,NULL,NULL,NULL,2),(78,'文学',4,'本科','50240',NULL,'商务英语',NULL,NULL,NULL,NULL,2),(79,'文学',4,'本科','50144',NULL,'英语(卓越)',NULL,NULL,NULL,NULL,2),(80,'文学',4,'本科','50241',NULL,'商务英语（会计方向）',NULL,NULL,NULL,NULL,2),(81,'文学',4,'本科','50242',NULL,'商务英语（国际贸易方向）',NULL,NULL,NULL,NULL,2),(82,'文学',4,'本科','50440',NULL,'法语',NULL,NULL,NULL,NULL,2),(83,'文学',4,'本科','50243',NULL,'商务英语(卓越财经)',NULL,NULL,NULL,NULL,2),(84,'管理学',2,'专升本','60120',NULL,'电子商务(专升本)',NULL,NULL,NULL,NULL,1),(85,'管理学',4,'本科','60140',NULL,'电子商务',NULL,NULL,NULL,NULL,1),(86,'管理学',4,'本科','60240',NULL,'信息管理与信息系统',NULL,NULL,NULL,NULL,1),(87,'工学',3,'专科','60430',NULL,'计算机应用技术(高职专科)',NULL,NULL,NULL,NULL,1),(88,'工学',3,'专科','60431',NULL,'计算机多媒体技术（高职专科）',NULL,NULL,NULL,NULL,1),(89,'工学',3,'专科','60630',NULL,'计算机网络技术(高职专科)',NULL,NULL,NULL,NULL,1),(90,'工学',2,'专科','60450',NULL,'计算机应用技术(3+2)',NULL,NULL,NULL,NULL,1),(91,'管理学',2,'专科','60150',NULL,'电子商务(3+2)',NULL,NULL,NULL,NULL,1),(92,'管理学',3,'专科','60130',NULL,'电子商务(高职专科)',NULL,NULL,NULL,NULL,1),(93,'经济学',3,'专科','60230',NULL,'经济信息管理(高职专科)',NULL,NULL,NULL,NULL,1),(94,'工学',4,'本科','60440',NULL,'计算机科学与技术',NULL,NULL,NULL,NULL,1),(95,'管理学',4,'本科','60040',NULL,'商务信息管理类',NULL,NULL,NULL,NULL,1),(96,'工学',4,'本科','60030',NULL,'计算机应用类',NULL,NULL,NULL,NULL,1),(97,'工学',4,'本科','60441',NULL,'计算机科学与技术(数字媒体技术方向)',NULL,NULL,NULL,NULL,1),(98,'工学',4,'本科','60442',NULL,'计算机科学与技术(网络工程方向)',NULL,NULL,NULL,NULL,1),(99,'工学',4,'本科','60443',NULL,'计算机科学与技术(航信)',NULL,NULL,NULL,NULL,1),(100,'工学',4,'本科','60444',NULL,'计算机科学与技术(信息-航信)',NULL,NULL,NULL,NULL,1),(101,'工学',4,'本科','60445',NULL,'计算机科学与技术(软件设计方向)',NULL,NULL,NULL,NULL,1),(102,'理学',4,'本科','100144',NULL,'统计学(拔尖人才)',NULL,NULL,NULL,NULL,1),(103,'经济学',4,'本科','100240',NULL,'经济统计学',NULL,NULL,NULL,NULL,1),(104,'工学',4,'本科','60540',NULL,'数字媒体技术',NULL,NULL,NULL,NULL,1),(105,'理学',4,'本科','100340',NULL,'应用统计学',NULL,NULL,NULL,NULL,1),(106,'管理学',4,'本科','60141',NULL,'电子商务（网络创业方向）（双学位）',NULL,NULL,NULL,NULL,1),(107,'工学',4,'本科','60541',NULL,'数字媒体技术（双学位）',NULL,NULL,NULL,NULL,1),(108,'经济学',4,'本科','100440',NULL,'金融数学',NULL,NULL,NULL,NULL,1),(109,'工学',4,'本科','60446',NULL,'计算机科学与技术(卓越财经)',NULL,NULL,NULL,NULL,1),(110,'理学',4,'本科','100140',NULL,'统计学',NULL,NULL,NULL,NULL,1),(111,'理学',4,'本科','100141',NULL,'统计学(市场调查与数据分析)',NULL,NULL,NULL,NULL,1),(112,'理学',4,'本科','100142',NULL,'统计学(风险管理与精算)',NULL,NULL,NULL,NULL,1),(113,'理学',4,'本科','100143',NULL,'统计学(卓越)',NULL,NULL,NULL,NULL,1),(114,'管理学',3,'专科','70931',NULL,'旅游管理(中泰转入)(高职专科)',NULL,NULL,NULL,NULL,11),(115,'管理学',4,'本科','70240',NULL,'旅游管理',NULL,NULL,NULL,NULL,11),(116,'管理学',4,'本科','70143',NULL,'工商管理(卓越)',NULL,NULL,NULL,NULL,11),(117,'管理学',3,'专科','70930',NULL,'旅游管理(高职专科)',NULL,NULL,NULL,NULL,11),(118,'管理学',4,'本科','70140',NULL,'工商管理',NULL,NULL,NULL,NULL,11),(119,'管理学',4,'本科','70141',NULL,'工商管理(特色)',NULL,NULL,NULL,NULL,11),(120,'管理学',2,'专升本','70120',NULL,'工商管理(专升本)',NULL,NULL,NULL,NULL,11),(121,'管理学',4,'本科','70040',NULL,'工商管理类',NULL,NULL,NULL,NULL,11),(122,'管理学',3,'专科','70630',NULL,'工商企业管理(高职专科)',NULL,NULL,NULL,NULL,11),(123,'管理学',4,'本科','70540',NULL,'人力资源管理',NULL,NULL,NULL,NULL,11),(124,'管理学',2,'专科','20250',NULL,'市场营销(3+2)',NULL,NULL,NULL,NULL,11),(125,'管理学',4,'本科','20440',NULL,'会展经济与管理',NULL,NULL,NULL,NULL,11),(126,'管理学',4,'本科','20244',NULL,'市场营销(营销策划方向)',NULL,NULL,NULL,NULL,11),(127,'管理学',3,'专科','20230',NULL,'市场营销(高职专科)',NULL,NULL,NULL,NULL,11),(128,'管理学',4,'本科','20240',NULL,'市场营销',NULL,NULL,NULL,NULL,11),(129,'管理学',2,'专升本','20220',NULL,'市场营销(专升本)',NULL,NULL,NULL,NULL,11),(130,'管理学',4,'本科','70840',NULL,'酒店管理',NULL,NULL,NULL,NULL,11),(131,'管理学',4,'本科','20245',NULL,'市场营销(卓越财经)',NULL,NULL,NULL,NULL,11),(132,'管理学',2,'专升本','80120',NULL,'会计学(专升本)',NULL,NULL,NULL,NULL,3),(133,'管理学',4,'本科','80040',NULL,'会计类',NULL,NULL,NULL,NULL,3),(134,'管理学',3,'专科','80130',NULL,'会计(高职专科)',NULL,NULL,NULL,NULL,3),(135,'管理学',2,'专科','80450',NULL,'会计电算化(3+2)',NULL,NULL,NULL,NULL,3),(136,'管理学',3,'专科','80430',NULL,'会计电算化(高职专科)',NULL,NULL,NULL,NULL,3),(137,'管理学',3,'专科','80530',NULL,'会计与审计(高职专科)',NULL,NULL,NULL,NULL,3),(138,'管理学',4,'本科','80140',NULL,'会计学',NULL,NULL,NULL,NULL,3),(139,'管理学',4,'本科','80141',NULL,'会计学(财务会计方向)',NULL,NULL,NULL,NULL,3),(140,'管理学',4,'本科','80142',NULL,'会计学(国际会计方向)',NULL,NULL,NULL,NULL,3),(141,'管理学',4,'本科','80143',NULL,'会计学(注册会计师方向)',NULL,NULL,NULL,NULL,3),(142,'管理学',4,'本科','80340',NULL,'财务管理',NULL,NULL,NULL,NULL,3),(143,'管理学',4,'本科','80240',NULL,'审计学',NULL,NULL,NULL,NULL,3),(144,'管理学',3,'专科','80431',NULL,'会计电算化(高职）',NULL,NULL,NULL,NULL,3),(145,'经济学',3,'专科','80630',NULL,'资产评估与管理（高职专科）',NULL,NULL,NULL,NULL,3),(146,'管理学',4,'本科','80640',NULL,'资产评估',NULL,NULL,NULL,NULL,3),(147,'管理学',4,'本科','80740',NULL,'会计学(东盟国际会计)',NULL,NULL,NULL,NULL,3),(148,'管理学',4,'本科','80144',NULL,'会计学(双学位)',NULL,NULL,NULL,NULL,3),(149,'管理学',4,'本科','80341',NULL,'财务管理(双学位)',NULL,NULL,NULL,NULL,3),(150,'管理学',3,'专科','80132',NULL,'会计(中马转入)(高职专科)',NULL,NULL,NULL,NULL,3),(151,'管理学',3,'专科','80133',NULL,'会计(中法转入)(高职专科)',NULL,NULL,NULL,NULL,3),(152,'管理学',4,'本科','80145',NULL,'会计学(中英转入)',NULL,NULL,NULL,NULL,3),(153,'管理学',4,'本科','80146',NULL,'会计学(卓越财经)',NULL,NULL,NULL,NULL,3),(154,'管理学',4,'本科','80641',NULL,'资产评估(卓越)',NULL,NULL,NULL,NULL,3),(155,'管理学',4,'本科','80147',NULL,'会计学(会计信息化-航信)',NULL,NULL,NULL,NULL,3),(156,'管理学',3,'专科','80432',NULL,'会计电算化(中马转入)(高职专科)',NULL,NULL,NULL,NULL,3),(157,'管理学',3,'专科','80433',NULL,'会计电算化(中法转入)(高职专科)',NULL,NULL,NULL,NULL,3),(158,'管理学',4,'本科','80148',NULL,'会计学(中马转入)',NULL,NULL,NULL,NULL,3),(159,'管理学',4,'本科','80149',NULL,'会计学(国教转入)',NULL,NULL,NULL,NULL,3),(160,'管理学',4,'本科','80840',NULL,'财务会计教育',NULL,NULL,NULL,NULL,3),(161,'管理学',4,'本科','80150',NULL,'会计学(中法转入)',NULL,NULL,NULL,NULL,3),(162,'管理学',4,'本科','80151',NULL,'会计学(中美转入)',NULL,NULL,NULL,NULL,3),(163,'管理学',4,'本科','80741',NULL,'会计学(东盟国际会计)(越南)',NULL,NULL,NULL,NULL,3),(164,'管理学',4,'本科','80742',NULL,'会计学(东盟国际会计)(泰国)',NULL,NULL,NULL,NULL,3),(165,'管理学',3,'专科','80230',NULL,'审计(高职专科）',NULL,NULL,NULL,NULL,3),(166,'经济学',3,'专科','40630',NULL,'资产评估与管理(高职专科)',NULL,NULL,NULL,NULL,3),(167,'管理学',3,'专科','80730',NULL,'财务管理(高职专科)',NULL,NULL,NULL,NULL,3),(168,'文学',4,'本科','20342',NULL,'广告学(广告策划方向)',NULL,NULL,NULL,NULL,13),(169,'文学',4,'本科','20343',NULL,'广告学(广告设计方向)',NULL,NULL,NULL,NULL,13),(170,'文学',4,'本科','90240',NULL,'艺术设计',NULL,NULL,NULL,NULL,13),(171,'文学',4,'本科','90440',NULL,'秘书学',NULL,NULL,NULL,NULL,13),(172,'艺术学',4,'本科','90540',NULL,'文化产业管理',NULL,NULL,NULL,NULL,13),(173,'艺术学',4,'本科','90640',NULL,'视觉传达设计',NULL,NULL,NULL,NULL,13),(174,'艺术学',4,'本科','90740',NULL,'环境设计',NULL,NULL,NULL,NULL,13),(175,'文学',4,'本科','20840',NULL,'新闻学',NULL,NULL,NULL,NULL,13),(176,'文学',4,'本科','20340',NULL,'广告学',NULL,NULL,NULL,NULL,13),(177,'教育学',4,'本科','90140',NULL,'文秘教育(经济文秘)',NULL,NULL,NULL,NULL,13),(178,'文学',3,'专科','90230',NULL,'文秘(高职专科)',NULL,NULL,NULL,NULL,13),(179,'法学',4,'本科','110140',NULL,'法学',NULL,NULL,NULL,NULL,4),(180,'法学',3,'专科','110230',NULL,'法律事务(高职专科)',NULL,NULL,NULL,NULL,4),(181,'法学',4,'本科','110141',NULL,'法学(双学位)',NULL,NULL,NULL,NULL,4),(182,'法学',4,'本科','110142',NULL,'法学(卓越)',NULL,NULL,NULL,NULL,4),(183,'法学',4,'本科','110143',NULL,'法学(经济法方向)',NULL,NULL,NULL,NULL,4),(184,'法学',4,'本科','110144',NULL,'法学(民商法方向)',NULL,NULL,NULL,NULL,4),(185,'管理学',4,'本科','80180',NULL,'会计学(国际会计)(中英)',NULL,NULL,NULL,NULL,5),(186,'工学',3,'专科','60491',NULL,'计算机应用技术(网络通讯与服务)(中法专科）',NULL,NULL,NULL,NULL,5),(187,'管理学',3,'专科','70691',NULL,'工商企业管理(企业管理)（中法）',NULL,NULL,NULL,NULL,5),(188,'管理学',3,'专科','80191',NULL,'会计(金融与会计)（中法）',NULL,NULL,NULL,NULL,5),(189,'管理学',3,'专科','80190',NULL,'会计(国际会计ACCA)(中马)',NULL,NULL,NULL,NULL,5),(190,'管理学',3,'专科','70990',NULL,'旅游管理(中泰专科)',NULL,NULL,NULL,NULL,5),(191,'文学',3,'专科','50290',NULL,'商务英语(中越专科)',NULL,NULL,NULL,NULL,5),(192,'经济学',4,'本科','20181',NULL,'国际经济与贸易(东南亚贸易)(中泰)',NULL,NULL,NULL,NULL,5),(193,'管理学',3,'专科','80290',NULL,'会计(国际会计ACCA)(中马B)',NULL,NULL,NULL,NULL,5),(194,'管理学',4,'本科','80280',NULL,'会计学(ACCA方向)',NULL,NULL,NULL,NULL,5),(195,'经济学',4,'本科','20182',NULL,'国际经济与贸易(东南亚贸易)(中越)',NULL,NULL,NULL,NULL,5),(196,'经济学',4,'本科','40183',NULL,'金融学(国际金融)(中英)',NULL,NULL,NULL,NULL,5),(197,'经济学',4,'本科','40184',NULL,'金融学(国际金融)(中美)',NULL,NULL,NULL,NULL,5),(198,'管理学',4,'本科','80181',NULL,'会计学(国际会计)(中法)',NULL,NULL,NULL,NULL,5),(199,'管理学',4,'本科','80182',NULL,'会计学(国际会计)(中马)',NULL,NULL,NULL,NULL,5),(200,'管理学',4,'本科','80183',NULL,'会计学(国际会计-创新实验)',NULL,NULL,NULL,NULL,5),(201,'管理学',4,'本科','80184',NULL,'会计学(国际会计)(中美)',NULL,NULL,NULL,NULL,5),(202,'管理学',4,'本科','80281',NULL,'会计学(中澳)',NULL,NULL,NULL,NULL,5),(203,'管理学',4,'本科','80185',NULL,'会计学(中法留学-本)',NULL,NULL,NULL,NULL,5),(204,'管理学',3,'专科','80192',NULL,'会计(中法留学-专科）',NULL,NULL,NULL,NULL,5),(205,'经济学',4,'本科','20183',NULL,'国际经济与贸易（东南亚贸易）（中马）',NULL,NULL,NULL,NULL,5),(206,'管理学',4,'本科','80186',NULL,'会计学（国际金融与会计）-中泰',NULL,NULL,NULL,NULL,5),(207,'经济学',4,'本科','20184',NULL,'国际经济与贸易（留学生）',NULL,NULL,NULL,NULL,5),(208,'管理学',4,'本科','470140',NULL,'会计(脱产本科)',NULL,NULL,NULL,NULL,17),(209,'管理学',2,'专科','470130',NULL,'会计(脱产专科)',NULL,NULL,NULL,NULL,17),(210,'管理学',4,'本科','70341',NULL,'工程管理(卓越)',NULL,NULL,NULL,NULL,12),(211,'理学',4,'本科','70740',NULL,'资源环境与城乡规划管理',NULL,NULL,NULL,NULL,12),(212,'管理学',3,'专科','70830',NULL,'房地产经营与估价(高职专科)',NULL,NULL,NULL,NULL,12),(213,'管理学',4,'本科','70340',NULL,'工程管理',NULL,NULL,NULL,NULL,12),(214,'管理学',4,'本科','70440',NULL,'物流管理',NULL,NULL,NULL,NULL,12),(215,'管理学',4,'本科','71040',NULL,'房地产经营管理',NULL,NULL,NULL,NULL,12),(216,'管理学',2,'专升本','70420',NULL,'物流管理(专升本)',NULL,NULL,NULL,NULL,12),(217,'管理学',3,'专科','70530',NULL,'物流管理(港口物流方向)(高职专科)',NULL,NULL,NULL,NULL,12),(218,'工学',3,'专科','100130',NULL,'机电设备维修与管理(高职专科)',NULL,NULL,NULL,NULL,12),(219,'管理学',2,'专升本','70220',NULL,'工程管理(专升本)',NULL,NULL,NULL,NULL,12),(220,'管理学',4,'本科','130140',NULL,'房地产开发与管理',NULL,NULL,NULL,NULL,12),(221,'管理学',4,'本科','130240',NULL,'人文地理与城乡规划',NULL,NULL,NULL,NULL,12),(222,'工学',4,'本科','130340',NULL,'工程造价',NULL,NULL,NULL,NULL,12),(223,'管理学',4,'本科','130440',NULL,'自然地理与资源环境',NULL,NULL,NULL,NULL,12),(224,'工学',2,'专升本','130320',NULL,'工程造价（专升本）',NULL,NULL,NULL,NULL,12),(225,'管理学',4,'本科','70441',NULL,'物流管理-联合办学',NULL,NULL,NULL,NULL,12),(226,'管理学',3,'专科','71030',NULL,'房地产经营与管理(高职专科）',NULL,NULL,NULL,NULL,12),(227,'工学',4,'本科','130341',NULL,'工程造价(卓越财经)',NULL,NULL,NULL,NULL,12),(228,'管理学',3,'专科','70430',NULL,'物流管理(高职专科)',NULL,NULL,NULL,NULL,12),(229,'经济学',3,'专科','130',NULL,'中法转入',NULL,NULL,NULL,NULL,14),(230,'',1,'本科','320141',NULL,'国际经济与贸易（预）',NULL,NULL,NULL,NULL,18),(231,'',0,'本科','320149',NULL,'短训班',NULL,NULL,NULL,NULL,18),(232,'',1,'本科','320191',NULL,'汉语语言（留学生）',NULL,NULL,NULL,NULL,18);

/*Table structure for table `sys_roles` */

DROP TABLE IF EXISTS `sys_roles`;

CREATE TABLE `sys_roles` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ENABLE` int(11) DEFAULT NULL,
  `ISSYS` int(11) DEFAULT NULL,
  `MODULE_ID` varchar(100) DEFAULT NULL,
  `ROLE_DESC` varchar(200) DEFAULT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `ROLE_ID` (`ROLE_ID`),
  KEY `FK202FA2CB8806E962` (`USER_ID`),
  CONSTRAINT `FK202FA2CB8806E962` FOREIGN KEY (`USER_ID`) REFERENCES `sys_users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_roles` */

/*Table structure for table `sys_student` */

DROP TABLE IF EXISTS `sys_student`;

CREATE TABLE `sys_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `into_school_year` datetime NOT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `real_name` varchar(10) DEFAULT NULL,
  `reserved_field1` varchar(200) DEFAULT NULL,
  `reserved_field2` varchar(200) DEFAULT NULL,
  `reserved_field3` varchar(200) DEFAULT NULL,
  `reserved_field4` longtext,
  `sex` varchar(2) DEFAULT NULL,
  `student_number` varchar(20) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK10BECAC9B910CC05` (`class_id`),
  CONSTRAINT `FK10BECAC9B910CC05` FOREIGN KEY (`class_id`) REFERENCES `sys_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;

/*Data for the table `sys_student` */

insert  into `sys_student`(`id`,`into_school_year`,`mobile`,`real_name`,`reserved_field1`,`reserved_field2`,`reserved_field3`,`reserved_field4`,`sex`,`student_number`,`class_id`) values (1,'2016-09-06 00:00:00','电子商务','庞良仪',NULL,NULL,NULL,NULL,'男','160601202101',2),(2,'2016-09-06 00:00:00','电子商务','陈德钰',NULL,NULL,NULL,NULL,'女','160601202102',2),(3,'2016-09-06 00:00:00','电子商务','李冰',NULL,NULL,NULL,NULL,'女','160601202103',2),(4,'2016-09-06 00:00:00','电子商务','覃小花',NULL,NULL,NULL,NULL,'女','160601202106',2),(5,'2016-09-06 00:00:00','电子商务','黄余春',NULL,NULL,NULL,NULL,'男','160601202107',2),(6,'2016-09-06 00:00:00','电子商务','梁秋凤',NULL,NULL,NULL,NULL,'女','160601202108',2),(7,'2016-09-06 00:00:00','电子商务','蓝丽婷',NULL,NULL,NULL,NULL,'女','160601202109',2),(8,'2016-09-06 00:00:00','电子商务','王进媚',NULL,NULL,NULL,NULL,'女','160601202111',2),(9,'2016-09-06 00:00:00','电子商务','王俏云',NULL,NULL,NULL,NULL,'女','160601202112',2),(10,'2016-09-06 00:00:00','电子商务','李锦兴',NULL,NULL,NULL,NULL,'男','160601202113',2),(11,'2016-09-06 00:00:00','电子商务','何丽君',NULL,NULL,NULL,NULL,'女','160601202114',2),(12,'2016-09-06 00:00:00','电子商务','覃富丽',NULL,NULL,NULL,NULL,'女','160601202115',2),(13,'2016-09-06 00:00:00','电子商务','许莲霞',NULL,NULL,NULL,NULL,'女','160601202117',2),(14,'2016-09-06 00:00:00','电子商务','王相楠',NULL,NULL,NULL,NULL,'女','160601202118',2),(15,'2016-09-06 00:00:00','电子商务','韦汉铭',NULL,NULL,NULL,NULL,'男','160601202119',2),(16,'2016-09-06 00:00:00','电子商务','何菲菲',NULL,NULL,NULL,NULL,'女','160601202121',2),(17,'2016-09-06 00:00:00','电子商务','黄莉岚',NULL,NULL,NULL,NULL,'女','160601202122',2),(18,'2016-09-06 00:00:00','电子商务','许艳乐',NULL,NULL,NULL,NULL,'女','160601202123',2),(19,'2016-09-06 00:00:00','电子商务','谢庆城',NULL,NULL,NULL,NULL,'男','160601202124',2),(20,'2016-09-06 00:00:00','电子商务','梁露',NULL,NULL,NULL,NULL,'女','160601202125',2),(21,'2016-09-06 00:00:00','电子商务','朱晓庆',NULL,NULL,NULL,NULL,'女','160601202126',2),(22,'2016-09-06 00:00:00','电子商务','顾全凤',NULL,NULL,NULL,NULL,'女','160601202127',2),(23,'2016-09-06 00:00:00','电子商务','张玮',NULL,NULL,NULL,NULL,'女','160601202128',2),(24,'2016-09-06 00:00:00','电子商务','农继贵',NULL,NULL,NULL,NULL,'男','160601202129',2),(25,'2016-09-06 00:00:00','电子商务','施燕萍',NULL,NULL,NULL,NULL,'女','160601202130',2),(26,'2016-09-06 00:00:00','电子商务','陈思羽',NULL,NULL,NULL,NULL,'女','160601202131',2),(27,'2016-09-06 00:00:00','电子商务','梁林霞',NULL,NULL,NULL,NULL,'女','160601202132',2),(28,'2016-09-06 00:00:00','电子商务','徐丽萍',NULL,NULL,NULL,NULL,'女','160601202133',2),(29,'2016-09-06 00:00:00','电子商务','谢宇',NULL,NULL,NULL,NULL,'男','160601202134',2),(30,'2016-09-06 00:00:00','电子商务','钟婕',NULL,NULL,NULL,NULL,'女','160601202135',2),(31,'2016-09-06 00:00:00','电子商务','冼静霞',NULL,NULL,NULL,NULL,'女','160601202136',2),(32,'2016-09-06 00:00:00','电子商务','钟洁',NULL,NULL,NULL,NULL,'女','160601202137',2),(33,'2016-09-06 00:00:00','电子商务','庞云方',NULL,NULL,NULL,NULL,'女','160601202138',2),(34,'2016-09-06 00:00:00','电子商务','莫师弘',NULL,NULL,NULL,NULL,'男','160601202139',2),(35,'2016-09-06 00:00:00','电子商务','黄琳',NULL,NULL,NULL,NULL,'女','160601202140',2),(36,'2016-09-06 00:00:00','电子商务','庞小莹',NULL,NULL,NULL,NULL,'女','160601202141',2),(37,'2016-09-06 00:00:00','电子商务','黄宁',NULL,NULL,NULL,NULL,'女','160601202142',2),(38,'2016-09-06 00:00:00','电子商务','蒙中中',NULL,NULL,NULL,NULL,'女','160601202143',2),(39,'2016-09-06 00:00:00','电子商务','古悦淋',NULL,NULL,NULL,NULL,'男','160601202144',2),(40,'2016-09-06 00:00:00','电子商务','李文婷',NULL,NULL,NULL,NULL,'女','160601202145',2),(41,'2016-09-06 00:00:00','电子商务','杨希琪',NULL,NULL,NULL,NULL,'女','160601202146',2),(42,'2016-09-06 00:00:00','电子商务','周静云',NULL,NULL,NULL,NULL,'女','160601202147',2),(43,'2016-09-06 00:00:00','电子商务','龙河珍',NULL,NULL,NULL,NULL,'女','160601202148',2),(44,'2016-09-06 00:00:00','电子商务','樊吉明',NULL,NULL,NULL,NULL,'女','160601202150',2),(45,'2016-09-06 00:00:00','电子商务','谢枝伶',NULL,NULL,NULL,NULL,'女','160601202151',2),(46,'2016-09-06 00:00:00','电子商务','李莹莹',NULL,NULL,NULL,NULL,'女','160601202152',2),(47,'2016-09-06 00:00:00','电子商务','吕舒萍',NULL,NULL,NULL,NULL,'女','160601202153',2),(48,'2016-09-06 00:00:00','电子商务','劳纯龙',NULL,NULL,NULL,NULL,'男','160601202154',2),(49,'2016-09-06 00:00:00','电子商务','范丽宏',NULL,NULL,NULL,NULL,'女','160601202155',2),(50,'2016-09-06 00:00:00','电子商务','滕春萍',NULL,NULL,NULL,NULL,'女','160601202156',2),(51,'2016-09-06 00:00:00','电子商务','梁肖杨',NULL,NULL,NULL,NULL,'女','160601202157',2),(52,'2016-09-06 00:00:00','电子商务','覃观荷',NULL,NULL,NULL,NULL,'女','160601202158',2),(53,'2016-09-06 00:00:00','电子商务','王永柠',NULL,NULL,NULL,NULL,'男','160601202159',2),(54,'2016-09-06 00:00:00','电子商务','唐云艳',NULL,NULL,NULL,NULL,'女','160601202161',2),(55,'2016-09-06 00:00:00','电子商务','江宋甜甜',NULL,NULL,NULL,NULL,'女','160601202162',2),(56,'2016-09-06 00:00:00','电子商务','陈慧',NULL,NULL,NULL,NULL,'女','160601202163',2),(57,'2014-09-09 00:00:00','信息管理与信息系统','陆春宇',NULL,NULL,NULL,NULL,'男','140602404101',3),(58,'2014-09-09 00:00:00','信息管理与信息系统','潘琪',NULL,NULL,NULL,NULL,'女','140602404102',3),(59,'2014-09-09 00:00:00','信息管理与信息系统','邓馨薏',NULL,NULL,NULL,NULL,'女','140602404103',3),(60,'2014-09-09 00:00:00','信息管理与信息系统','黄伟津',NULL,NULL,NULL,NULL,'男','140602404104',3),(61,'2014-09-09 00:00:00','信息管理与信息系统','郭梦丹',NULL,NULL,NULL,NULL,'女','140602404105',3),(62,'2014-09-09 00:00:00','信息管理与信息系统','莫蓉萍',NULL,NULL,NULL,NULL,'女','140602404106',3),(63,'2014-09-09 00:00:00','信息管理与信息系统','王思同',NULL,NULL,NULL,NULL,'男','140602404107',3),(64,'2014-09-09 00:00:00','信息管理与信息系统','谢林渺',NULL,NULL,NULL,NULL,'女','140602404108',3),(65,'2014-09-09 00:00:00','信息管理与信息系统','王文妍',NULL,NULL,NULL,NULL,'女','140602404109',3),(66,'2014-09-09 00:00:00','信息管理与信息系统','廖雨',NULL,NULL,NULL,NULL,'男','140602404110',3),(67,'2014-09-09 00:00:00','信息管理与信息系统','施晓玲',NULL,NULL,NULL,NULL,'女','140602404111',3),(68,'2014-09-09 00:00:00','信息管理与信息系统','陆璐',NULL,NULL,NULL,NULL,'女','140602404112',3),(69,'2014-09-09 00:00:00','信息管理与信息系统','张勇伟',NULL,NULL,NULL,NULL,'男','140602404113',3),(70,'2014-09-09 00:00:00','信息管理与信息系统','黄世金',NULL,NULL,NULL,NULL,'女','140602404114',3),(71,'2014-09-09 00:00:00','信息管理与信息系统','曾琼芳',NULL,NULL,NULL,NULL,'女','140602404115',3),(72,'2014-09-09 00:00:00','信息管理与信息系统','王松',NULL,NULL,NULL,NULL,'男','140602404116',3),(73,'2014-09-09 00:00:00','信息管理与信息系统','韦婷娟',NULL,NULL,NULL,NULL,'女','140602404117',3),(74,'2014-09-09 00:00:00','信息管理与信息系统','张凤',NULL,NULL,NULL,NULL,'女','140602404118',3),(75,'2014-09-09 00:00:00','信息管理与信息系统','李宝华',NULL,NULL,NULL,NULL,'男','140602404119',3),(76,'2014-09-09 00:00:00','信息管理与信息系统','韦爱花',NULL,NULL,NULL,NULL,'女','140602404120',3),(77,'2014-09-09 00:00:00','信息管理与信息系统','唐可',NULL,NULL,NULL,NULL,'女','140602404121',3),(78,'2014-09-09 00:00:00','信息管理与信息系统','黄绍赞',NULL,NULL,NULL,NULL,'男','140602404122',3),(79,'2014-09-09 00:00:00','信息管理与信息系统','黄佳宜',NULL,NULL,NULL,NULL,'女','140602404123',3),(80,'2014-09-09 00:00:00','信息管理与信息系统','黄丹',NULL,NULL,NULL,NULL,'女','140602404124',3),(81,'2014-09-09 00:00:00','信息管理与信息系统','胡泽辉',NULL,NULL,NULL,NULL,'男','140602404125',3),(82,'2014-09-09 00:00:00','信息管理与信息系统','吴文慧',NULL,NULL,NULL,NULL,'女','140602404126',3),(83,'2014-09-09 00:00:00','信息管理与信息系统','吴楚楚',NULL,NULL,NULL,NULL,'女','140602404127',3),(84,'2014-09-09 00:00:00','信息管理与信息系统','宋国应',NULL,NULL,NULL,NULL,'男','140602404128',3),(85,'2014-09-09 00:00:00','信息管理与信息系统','庞倩云',NULL,NULL,NULL,NULL,'女','140602404129',3),(86,'2014-09-09 00:00:00','信息管理与信息系统','颜若男',NULL,NULL,NULL,NULL,'女','140602404130',3),(87,'2014-09-09 00:00:00','信息管理与信息系统','赵武猛',NULL,NULL,NULL,NULL,'男','140602404131',3),(88,'2014-09-09 00:00:00','信息管理与信息系统','马巧慧',NULL,NULL,NULL,NULL,'女','140602404132',3),(89,'2014-09-09 00:00:00','信息管理与信息系统','赵凌帆',NULL,NULL,NULL,NULL,'男','140602404133',3),(90,'2014-09-09 00:00:00','信息管理与信息系统','罗昌辉',NULL,NULL,NULL,NULL,'男','140602404135',3),(91,'2014-09-09 00:00:00','信息管理与信息系统','宋美',NULL,NULL,NULL,NULL,'女','140602404136',3),(92,'2014-09-09 00:00:00','信息管理与信息系统','梁光磊',NULL,NULL,NULL,NULL,'男','140602404137',3),(93,'2014-09-09 00:00:00','信息管理与信息系统','罗海琼',NULL,NULL,NULL,NULL,'女','140602404138',3),(94,'2014-09-09 00:00:00','信息管理与信息系统','史福前',NULL,NULL,NULL,NULL,'男','140602404139',3),(95,'2014-09-09 00:00:00','信息管理与信息系统','黄龙项',NULL,NULL,NULL,NULL,'女','140602404140',3),(96,'2014-09-09 00:00:00','信息管理与信息系统','杨家燊',NULL,NULL,NULL,NULL,'男','140602404141',3),(97,'2014-09-09 00:00:00','信息管理与信息系统','梁凌玉',NULL,NULL,NULL,NULL,'女','140602404142',3),(98,'2014-09-09 00:00:00','信息管理与信息系统','梁志杰',NULL,NULL,NULL,NULL,'男','140602404143',3),(99,'2014-09-09 00:00:00','信息管理与信息系统','封佩玲',NULL,NULL,NULL,NULL,'女','140602404144',3),(100,'2014-09-09 00:00:00','信息管理与信息系统','刘海朝',NULL,NULL,NULL,NULL,'男','140602404145',3),(101,'2014-09-09 00:00:00','信息管理与信息系统','潘远远',NULL,NULL,NULL,NULL,'女','140602404146',3),(102,'2014-09-09 00:00:00','信息管理与信息系统','邓钰峰',NULL,NULL,NULL,NULL,'男','140602404147',3),(103,'2014-09-09 00:00:00','信息管理与信息系统','韦文燕',NULL,NULL,NULL,NULL,'女','140602404148',3),(104,'2014-09-09 00:00:00','信息管理与信息系统','许业亮',NULL,NULL,NULL,NULL,'男','140602404149',3),(105,'2014-09-09 00:00:00','信息管理与信息系统','廖凯婷',NULL,NULL,NULL,NULL,'女','140602404150',3),(106,'2015-09-04 00:00:00','信息管理与信息系统','黎智骞',NULL,NULL,NULL,NULL,'男','150602404101',4),(107,'2015-09-04 00:00:00','信息管理与信息系统','吴嫦宇',NULL,NULL,NULL,NULL,'女','150602404102',4),(108,'2015-09-04 00:00:00','信息管理与信息系统','龚佩雯',NULL,NULL,NULL,NULL,'女','150602404103',4),(109,'2015-09-04 00:00:00','信息管理与信息系统','黄兆明',NULL,NULL,NULL,NULL,'男','150602404104',4),(110,'2015-09-04 00:00:00','信息管理与信息系统','余闻柳',NULL,NULL,NULL,NULL,'女','150602404105',4),(111,'2015-09-04 00:00:00','信息管理与信息系统','吴秀莹',NULL,NULL,NULL,NULL,'女','150602404106',4),(112,'2015-09-04 00:00:00','信息管理与信息系统','柏锦源',NULL,NULL,NULL,NULL,'男','150602404107',4),(113,'2015-09-04 00:00:00','信息管理与信息系统','罗燕妮',NULL,NULL,NULL,NULL,'女','150602404108',4),(114,'2015-09-04 00:00:00','信息管理与信息系统','易婷婷',NULL,NULL,NULL,NULL,'女','150602404109',4),(115,'2015-09-04 00:00:00','信息管理与信息系统','莫杰桦',NULL,NULL,NULL,NULL,'男','150602404110',4),(116,'2015-09-04 00:00:00','信息管理与信息系统','张琳',NULL,NULL,NULL,NULL,'女','150602404111',4),(117,'2015-09-04 00:00:00','信息管理与信息系统','陆嘉慧',NULL,NULL,NULL,NULL,'女','150602404112',4),(118,'2015-09-04 00:00:00','信息管理与信息系统','黄振豪',NULL,NULL,NULL,NULL,'男','150602404113',4),(119,'2015-09-04 00:00:00','信息管理与信息系统','林慧',NULL,NULL,NULL,NULL,'女','150602404114',4),(120,'2015-09-04 00:00:00','信息管理与信息系统','李森玲',NULL,NULL,NULL,NULL,'女','150602404115',4),(121,'2015-09-04 00:00:00','信息管理与信息系统','林钲',NULL,NULL,NULL,NULL,'男','150602404116',4),(122,'2015-09-04 00:00:00','信息管理与信息系统','莫明玲',NULL,NULL,NULL,NULL,'女','150602404117',4),(123,'2015-09-04 00:00:00','信息管理与信息系统','覃敏婷',NULL,NULL,NULL,NULL,'女','150602404118',4),(124,'2015-09-04 00:00:00','信息管理与信息系统','黄春',NULL,NULL,NULL,NULL,'男','150602404119',4),(125,'2015-09-04 00:00:00','信息管理与信息系统','沈淇芳',NULL,NULL,NULL,NULL,'女','150602404120',4),(126,'2015-09-04 00:00:00','信息管理与信息系统','黄丹桦',NULL,NULL,NULL,NULL,'女','150602404121',4),(127,'2015-09-04 00:00:00','信息管理与信息系统','阙宗德',NULL,NULL,NULL,NULL,'男','150602404122',4),(128,'2015-09-04 00:00:00','信息管理与信息系统','陈鸿梅',NULL,NULL,NULL,NULL,'女','150602404123',4),(129,'2015-09-04 00:00:00','信息管理与信息系统','李鸿宇',NULL,NULL,NULL,NULL,'女','150602404124',4),(130,'2015-09-04 00:00:00','信息管理与信息系统','庞凯元',NULL,NULL,NULL,NULL,'男','150602404125',4),(131,'2015-09-04 00:00:00','信息管理与信息系统','林榜玲',NULL,NULL,NULL,NULL,'女','150602404126',4),(132,'2015-09-04 00:00:00','信息管理与信息系统','邱海燕',NULL,NULL,NULL,NULL,'女','150602404127',4),(133,'2015-09-04 00:00:00','信息管理与信息系统','范明宪',NULL,NULL,NULL,NULL,'男','150602404128',4),(134,'2015-09-04 00:00:00','信息管理与信息系统','黄好好',NULL,NULL,NULL,NULL,'女','150602404129',4),(135,'2015-09-04 00:00:00','信息管理与信息系统','杨丽慧',NULL,NULL,NULL,NULL,'女','150602404130',4),(136,'2015-09-04 00:00:00','信息管理与信息系统','黎松龄',NULL,NULL,NULL,NULL,'男','150602404131',4),(137,'2015-09-04 00:00:00','信息管理与信息系统','庞雅琪',NULL,NULL,NULL,NULL,'女','150602404132',4),(138,'2015-09-04 00:00:00','信息管理与信息系统','谭语',NULL,NULL,NULL,NULL,'女','150602404133',4),(139,'2015-09-04 00:00:00','信息管理与信息系统','何俊杰',NULL,NULL,NULL,NULL,'男','150602404134',4),(140,'2015-09-04 00:00:00','信息管理与信息系统','蒙莉虹',NULL,NULL,NULL,NULL,'女','150602404135',4),(141,'2015-09-04 00:00:00','信息管理与信息系统','钟姗',NULL,NULL,NULL,NULL,'女','150602404136',4),(142,'2015-09-04 00:00:00','信息管理与信息系统','文俊杰',NULL,NULL,NULL,NULL,'男','150602404137',4),(143,'2015-09-04 00:00:00','信息管理与信息系统','林棣园',NULL,NULL,NULL,NULL,'女','150602404138',4),(144,'2015-09-04 00:00:00','信息管理与信息系统','黄瑞丰',NULL,NULL,NULL,NULL,'男','150602404139',4),(145,'2015-09-04 00:00:00','信息管理与信息系统','刘翠青',NULL,NULL,NULL,NULL,'女','150602404140',4),(146,'2015-09-04 00:00:00','信息管理与信息系统','韦佑都',NULL,NULL,NULL,NULL,'男','150602404141',4),(147,'2015-09-04 00:00:00','信息管理与信息系统','梁斐铭',NULL,NULL,NULL,NULL,'男','150602404143',4),(148,'2015-09-04 00:00:00','信息管理与信息系统','林钰镕',NULL,NULL,NULL,NULL,'女','150602404144',4),(149,'2015-09-04 00:00:00','信息管理与信息系统','黄富华',NULL,NULL,NULL,NULL,'男','150602404145',4),(150,'2015-09-04 00:00:00','信息管理与信息系统','韦园梅',NULL,NULL,NULL,NULL,'女','150602404146',4),(151,'2015-09-04 00:00:00','信息管理与信息系统','蔡鑫荣',NULL,NULL,NULL,NULL,'男','150602404147',4),(152,'2015-09-04 00:00:00','信息管理与信息系统','梁家嘉',NULL,NULL,NULL,NULL,'女','150602404148',4),(153,'2015-09-04 00:00:00','信息管理与信息系统','赵中万',NULL,NULL,NULL,NULL,'男','150602404149',4),(154,'2015-09-04 00:00:00','信息管理与信息系统','廖雨娟',NULL,NULL,NULL,NULL,'女','150602404150',4),(155,'2013-09-06 00:00:00','计算机应用技术','梁建明',NULL,NULL,NULL,NULL,'男','110604303115',5),(156,'2013-09-06 00:00:00','计算机应用技术','朱永国',NULL,NULL,NULL,NULL,'男','110604303126',5),(157,'2013-09-06 00:00:00','计算机应用技术','吴朝明',NULL,NULL,NULL,NULL,'男','120604303128',5),(158,'2013-09-06 00:00:00','计算机应用技术','谢贤律',NULL,NULL,NULL,NULL,'男','130604303101',5),(159,'2013-09-06 00:00:00','计算机应用技术','黎叶桂',NULL,NULL,NULL,NULL,'女','130604303102',5),(160,'2013-09-06 00:00:00','计算机应用技术','赵亮',NULL,NULL,NULL,NULL,'男','130604303104',5),(161,'2013-09-06 00:00:00','计算机应用技术','陆俊秀',NULL,NULL,NULL,NULL,'女','130604303105',5),(162,'2013-09-06 00:00:00','计算机应用技术','梁泽武',NULL,NULL,NULL,NULL,'男','130604303110',5),(163,'2013-09-06 00:00:00','计算机应用技术','韦记心',NULL,NULL,NULL,NULL,'女','130604303111',5),(164,'2013-09-06 00:00:00','计算机应用技术','甘宇鸿',NULL,NULL,NULL,NULL,'男','130604303116',5),(165,'2013-09-06 00:00:00','计算机应用技术','韦英瑜',NULL,NULL,NULL,NULL,'女','130604303117',5),(166,'2013-09-06 00:00:00','计算机应用技术','李玉情',NULL,NULL,NULL,NULL,'女','130604303120',5),(167,'2013-09-06 00:00:00','计算机应用技术','黄莹玉',NULL,NULL,NULL,NULL,'女','130604303121',5),(168,'2013-09-06 00:00:00','计算机应用技术','罗幸',NULL,NULL,NULL,NULL,'女','130604303123',5),(169,'2013-09-06 00:00:00','计算机应用技术','莫燕玲',NULL,NULL,NULL,NULL,'女','130604303124',5),(170,'2013-09-06 00:00:00','计算机应用技术','麻露元',NULL,NULL,NULL,NULL,'女','130604303126',5),(171,'2013-09-06 00:00:00','计算机应用技术','黄艳娜',NULL,NULL,NULL,NULL,'女','130604303127',5),(172,'2013-09-06 00:00:00','计算机应用技术','黄必宝',NULL,NULL,NULL,NULL,'男','130604303128',5),(173,'2013-09-06 00:00:00','计算机应用技术','廖祖慧',NULL,NULL,NULL,NULL,'女','130604303129',5),(174,'2013-09-06 00:00:00','计算机应用技术','张程',NULL,NULL,NULL,NULL,'男','130604303131',5),(175,'2013-09-06 00:00:00','计算机应用技术','陈靖熺',NULL,NULL,NULL,NULL,'女','130604303132',5),(176,'2013-09-06 00:00:00','计算机应用技术','蒙卓臻',NULL,NULL,NULL,NULL,'女','130604303133',5),(177,'2013-09-06 00:00:00','计算机应用技术','徐秋梅',NULL,NULL,NULL,NULL,'女','130604303136',5),(178,'2013-09-06 00:00:00','计算机应用技术','杨程麟',NULL,NULL,NULL,NULL,'男','130604303137',5),(179,'2013-09-06 00:00:00','计算机应用技术','覃丽秋',NULL,NULL,NULL,NULL,'女','130604303139',5),(180,'2013-09-06 00:00:00','计算机应用技术','陈秋兰',NULL,NULL,NULL,NULL,'女','130604303142',5),(181,'2013-09-06 00:00:00','计算机应用技术','罗超凡',NULL,NULL,NULL,NULL,'男','130604303146',5),(182,'2013-09-06 00:00:00','计算机应用技术','潘炎媚',NULL,NULL,NULL,NULL,'女','130604303147',5),(183,'2013-09-06 00:00:00','计算机应用技术','谢依依',NULL,NULL,NULL,NULL,'女','130604303151',5),(184,'2013-09-06 00:00:00','计算机应用技术','倪海森',NULL,NULL,NULL,NULL,'男','130604303152',5),(185,'2013-09-06 00:00:00','计算机应用技术','梁再柳',NULL,NULL,NULL,NULL,'女','130604303156',5),(186,'2013-09-06 00:00:00','计算机应用技术','赖思宇',NULL,NULL,NULL,NULL,'女','130604303157',5),(187,'2013-09-06 00:00:00','计算机应用技术','廖裕',NULL,NULL,NULL,NULL,'男','130604303158',5),(188,'2013-09-06 00:00:00','计算机应用技术','冯添',NULL,NULL,NULL,NULL,'女','130604303159',5),(189,'2013-09-06 00:00:00','计算机应用技术','劳春龙',NULL,NULL,NULL,NULL,'男','130604303161',5),(190,'2013-09-06 00:00:00','计算机应用技术','韦美君',NULL,NULL,NULL,NULL,'女','130604303162',5),(191,'2013-09-06 00:00:00','计算机应用技术','唐涌滩',NULL,NULL,NULL,NULL,'男','130604303165',5),(192,'2013-09-06 00:00:00','计算机应用技术','农兰青',NULL,NULL,NULL,NULL,'女','130604303166',5),(193,'2013-09-06 00:00:00','计算机应用技术','罗植毓',NULL,NULL,NULL,NULL,'男','130604303167',5),(194,'2013-09-06 00:00:00','计算机应用技术','谭静静',NULL,NULL,NULL,NULL,'女','130604303168',5),(195,'2013-09-06 00:00:00','计算机应用技术','覃一峰',NULL,NULL,NULL,NULL,'男','130604303171',5),(196,'2015-09-04 00:00:00','信息管理与信息系统','梁露',NULL,NULL,NULL,NULL,'女','150602404142',4),(197,'2013-09-06 00:00:00','计算机应用技术','庞良仪',NULL,NULL,NULL,NULL,'男','130604303107',5),(198,'2013-09-06 00:00:00','计算机应用技术','黄宁',NULL,NULL,NULL,NULL,'男','130604303119',5),(199,'2013-09-06 00:00:00','计算机应用技术','黄琳',NULL,NULL,NULL,NULL,'女','130604303138',5),(200,'2013-09-06 00:00:00','计算机应用技术','樊吉明',NULL,NULL,NULL,NULL,'女','130604303144',5),(201,'2013-09-06 00:00:00','计算机应用技术','李锦兴',NULL,NULL,NULL,NULL,'男','130604303155',5);

/*Table structure for table `sys_teach_building` */

DROP TABLE IF EXISTS `sys_teach_building`;

CREATE TABLE `sys_teach_building` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` varchar(100) DEFAULT NULL,
  `teach_building_floor` int(11) DEFAULT NULL,
  `teach_building_name` varchar(50) DEFAULT NULL,
  `teach_building_number` varchar(255) DEFAULT NULL,
  `teach_building_type` int(11) DEFAULT NULL,
  `campus_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKF9AC8AF067978D6F` (`campus_id`),
  CONSTRAINT `FKF9AC8AF067978D6F` FOREIGN KEY (`campus_id`) REFERENCES `sys_campus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_teach_building` */

/*Table structure for table `sys_teach_building_apply_record` */

DROP TABLE IF EXISTS `sys_teach_building_apply_record`;

CREATE TABLE `sys_teach_building_apply_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_time` datetime NOT NULL,
  `apply_use_date` datetime NOT NULL,
  `endt_lesson` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `is_agree` int(11) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `start_lesson` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `teach_building_type` int(11) DEFAULT NULL,
  `use_need_description` varchar(200) DEFAULT NULL,
  `use_reason` varchar(200) DEFAULT NULL,
  `teach_building_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKED92F3318806E962` (`user_id`),
  KEY `FKED92F3316E767E50` (`teach_building_id`),
  CONSTRAINT `FKED92F3316E767E50` FOREIGN KEY (`teach_building_id`) REFERENCES `sys_teach_building` (`id`),
  CONSTRAINT `FKED92F3318806E962` FOREIGN KEY (`user_id`) REFERENCES `sys_users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_teach_building_apply_record` */

/*Table structure for table `sys_teacher` */

DROP TABLE IF EXISTS `sys_teacher`;

CREATE TABLE `sys_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(11) DEFAULT NULL,
  `position_name` varchar(20) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `reserved_field1` varchar(200) DEFAULT NULL,
  `reserved_field2` varchar(100) DEFAULT NULL,
  `reserved_field3` varchar(100) DEFAULT NULL,
  `reserved_field4` varchar(100) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `work_number` varchar(20) DEFAULT NULL,
  `part_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK2AF214708B13462F` (`part_id`),
  CONSTRAINT `FK2AF214708B13462F` FOREIGN KEY (`part_id`) REFERENCES `sys_part` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `sys_teacher` */

insert  into `sys_teacher`(`id`,`mobile`,`position_name`,`real_name`,`reserved_field1`,`reserved_field2`,`reserved_field3`,`reserved_field4`,`sex`,`work_number`,`part_id`) values (2,'13557995319','辅导员','赵亮',NULL,NULL,NULL,NULL,NULL,NULL,72),(3,'18776772008','辅导员','禤桂珍',NULL,NULL,NULL,NULL,NULL,NULL,72),(4,'18878771199','辅导员','凌俊',NULL,NULL,NULL,NULL,NULL,NULL,75),(5,'15077108970','辅导员','韦火旺',NULL,NULL,NULL,NULL,NULL,NULL,72),(6,'18697968516','辅导员','刘筱丹',NULL,NULL,NULL,NULL,NULL,NULL,72),(7,'15977771867','分团委书记','廖一祯',NULL,NULL,NULL,NULL,NULL,NULL,72),(8,'15994460501','教师','刘丽君',NULL,NULL,NULL,NULL,NULL,NULL,72),(9,'3853013','党委书记','林耀飞',NULL,NULL,NULL,NULL,NULL,NULL,72),(10,'3833635','院长','农卓恩',NULL,NULL,NULL,NULL,NULL,NULL,72),(11,'3843363','行政人员','刘素兰',NULL,NULL,NULL,NULL,NULL,NULL,56),(12,'3843363','行政人员','谭顺平',NULL,NULL,NULL,NULL,NULL,NULL,56),(13,'3843363','行政人员','钟凤艳',NULL,NULL,NULL,NULL,NULL,NULL,56),(14,'3843363','行政人员','范海燕',NULL,NULL,NULL,NULL,NULL,NULL,56),(15,'3843363','行政人员','蒋怡琳',NULL,NULL,NULL,NULL,NULL,NULL,56),(16,'2531260','行政人员','施  艺',NULL,NULL,NULL,NULL,NULL,NULL,82),(17,'2531260','行政人员','陈  旭',NULL,NULL,NULL,NULL,NULL,NULL,82),(18,'2531260','行政人员','刘志娟',NULL,NULL,NULL,NULL,NULL,NULL,82),(19,'13132916968','行政人员','吕凤岐',NULL,NULL,NULL,NULL,NULL,NULL,86),(20,'13557577089','行政人员','陈雨花',NULL,NULL,NULL,NULL,NULL,NULL,86),(21,'18278188858','行政人员','李海茗',NULL,NULL,NULL,NULL,NULL,NULL,86),(22,'15994381958','行政人员','潘瑞冬',NULL,NULL,NULL,NULL,NULL,NULL,86),(23,'13877152046','行政人员','刘泽安',NULL,NULL,NULL,NULL,NULL,NULL,86),(24,'13737024415','行政人员','朱华晔',NULL,NULL,NULL,NULL,NULL,NULL,86),(25,'18977784482','行政人员','杨言斌',NULL,NULL,NULL,NULL,NULL,NULL,86),(26,'15977745808','行政人员','蔡明丹',NULL,NULL,NULL,NULL,NULL,NULL,86),(27,'13036868176','行政人员','林  彤',NULL,NULL,NULL,NULL,NULL,NULL,86),(28,'18607701600','行政人员','杜  敏',NULL,NULL,NULL,NULL,NULL,NULL,86),(29,'13878768521','行政人员','陈  妍',NULL,NULL,NULL,NULL,NULL,NULL,86),(30,'13086711011','行政人员','李小广',NULL,NULL,NULL,NULL,NULL,NULL,86),(31,'13471151384','行政人员','吴春明',NULL,NULL,NULL,NULL,NULL,NULL,86),(32,'13878187869','行政人员','杨  科',NULL,NULL,NULL,NULL,NULL,NULL,86),(33,'13878812990','行政人员','马梦远',NULL,NULL,NULL,NULL,NULL,NULL,86),(34,'13687711548','行政人员','韦富城',NULL,NULL,NULL,NULL,NULL,NULL,86),(35,'13768822929','行政人员','王思思',NULL,NULL,NULL,NULL,NULL,NULL,86),(36,'13687716596','行政人员','倪晓晓',NULL,NULL,NULL,NULL,NULL,NULL,86),(37,'13557809272','行政人员','刘偶偶',NULL,NULL,NULL,NULL,NULL,NULL,86),(38,'13878854932','行政人员','梁  婧',NULL,NULL,NULL,NULL,NULL,NULL,86),(39,'13607876176','行政人员','潘恒标',NULL,NULL,NULL,NULL,NULL,NULL,86),(40,'13087719433','行政人员','蓝  航',NULL,NULL,NULL,NULL,NULL,NULL,86);

/*Table structure for table `sys_users` */

DROP TABLE IF EXISTS `sys_users`;

CREATE TABLE `sys_users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `V_QZJGID` varchar(100) DEFAULT NULL,
  `V_QZJGMC` varchar(100) DEFAULT NULL,
  `ACCOUNT_NON_EXPIRED` int(11) DEFAULT NULL,
  `ACCOUNT_NON_LOCKED` int(11) DEFAULT NULL,
  `CREDENTIALS_NON_EXPIRED` int(11) DEFAULT NULL,
  `DEADLINE` datetime DEFAULT NULL,
  `DEP_ID` varchar(100) DEFAULT NULL,
  `DEP_NAME` varchar(100) DEFAULT NULL,
  `DT_CREATE` datetime DEFAULT NULL,
  `ENABLED` int(11) DEFAULT NULL,
  `is_campus_authentication` int(11) DEFAULT NULL,
  `LAST_LOGIN` datetime DEFAULT NULL,
  `LOGIN_IP` varchar(100) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `USERNAME` varchar(100) NOT NULL,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_ID` (`USER_ID`),
  KEY `FK205BA216F98F9505` (`teacher_id`),
  KEY `FK205BA216E8F44A65` (`STUDENT_ID`),
  CONSTRAINT `FK205BA216E8F44A65` FOREIGN KEY (`STUDENT_ID`) REFERENCES `sys_student` (`id`),
  CONSTRAINT `FK205BA216F98F9505` FOREIGN KEY (`teacher_id`) REFERENCES `sys_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
