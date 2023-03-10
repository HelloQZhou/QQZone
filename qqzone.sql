CREATE DATABASE `qqzonedb` CHAR SET utf8;

USE qqzonedb;

CREATE TABLE `t_friend` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `uid` INT(11) DEFAULT NULL,
  `fid` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_friend_basic_uid` (`uid`),
  KEY `FK_friend_basic_fid` (`fid`),
  CONSTRAINT `FK_friend_basic_fid` FOREIGN KEY (`fid`) REFERENCES `t_user_basic` (`id`),
  CONSTRAINT `FK_friend_basic_uid` FOREIGN KEY (`uid`) REFERENCES `t_user_basic` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_friend` */

INSERT  INTO `t_friend`(`id`,`uid`,`fid`) VALUES (1,1,2),(2,1,3),(3,1,4),(4,1,5),(5,2,3),(6,2,1),(7,2,4),(8,3,1),(9,3,2),(10,5,1);




/*Table structure for table `t_topic`  日志表*/

CREATE TABLE `t_topic` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(500) NOT NULL,
  `topicDate` DATETIME NOT NULL,
  `author` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_topic_basic` (`author`),
  CONSTRAINT `FK_topic_basic` FOREIGN KEY (`author`) REFERENCES `t_user_basic` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_topic` */

INSERT  INTO `t_topic`(`id`,`title`,`content`,`topicDate`,`author`) VALUES (3,'我的空间开通了，先做自我介绍！','大家好，我是铁锤妹妹！','2021-06-18 11:25:30',2),(8,'我的空间','我的空间','2021-07-14 16:16:40',1);

INSERT  INTO `t_topic`(`id`,`title`,`content`,`topicDate`,`author`) VALUES (7,'我的空间开通了，先做自我介绍！','大家好，我是铁锤妹妹！','2021-06-18 11:25:30',1)



/*Table structure for table `t_user_detail` */

CREATE TABLE `t_user_detail` (
  `id` INT(11) NOT NULL,
  `realName` VARCHAR(20) DEFAULT NULL,
  `tel` VARCHAR(11) DEFAULT NULL,
  `email` VARCHAR(30) DEFAULT NULL,
  `birth` DATETIME DEFAULT NULL,
  `star` VARCHAR(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_detail_basic` FOREIGN KEY (`id`) REFERENCES `t_user_basic` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_detail` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


/*Data for the table `t_host_reply` */

/*Table structure for table `t_reply` 回复表 */

CREATE TABLE `t_reply` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(500) NOT NULL,
  `replyDate` DATETIME NOT NULL,
  `author` INT(11) NOT NULL,
  `topic` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_reply_basic` (`author`),
  KEY `FK_reply_topic` (`topic`),
  CONSTRAINT `FK_reply_basic` FOREIGN KEY (`author`) REFERENCES `t_user_basic` (`id`),
  CONSTRAINT `FK_reply_topic` FOREIGN KEY (`topic`) REFERENCES `t_topic` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_reply` */

INSERT  INTO `t_reply`(`id`,`content`,`replyDate`,`author`,`topic`) VALUES (3,'回复','2021-07-14 16:16:54',2,8),(4,'回复2222','2021-07-14 16:17:11',3,8),(5,'这里是第三个回复','2021-07-14 16:30:49',1,8);


/*Table structure for table `t_user_basic` */

CREATE TABLE `t_user_basic` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `loginId` VARCHAR(20) NOT NULL,
  `nickName` VARCHAR(50) NOT NULL,
  `pwd` VARCHAR(20) NOT NULL,
  `headImg` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginId` (`loginId`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_basic` */

INSERT  INTO `t_user_basic`(`id`,`loginId`,`nickName`,`pwd`,`headImg`) VALUES (1,'u001','jim','ok','h1.jpeg'),(2,'u002','tom','ok','h2.jpeg'),(3,'u003','kate','ok','h3.jpeg'),(4,'u004','lucy','ok','h4.jpeg'),(5,'u005','张三丰','ok','h5.jpeg');

/*Table structure for table `t_host_reply` */

CREATE TABLE `t_host_reply` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(500) NOT NULL,
  `hostReplyDate` DATETIME NOT NULL,
  `author` INT(11) NOT NULL,
  `reply` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_host_basic` (`author`),
  KEY `FK_host_reply` (`reply`),
  CONSTRAINT `FK_host_basic` FOREIGN KEY (`author`) REFERENCES `t_user_basic` (`id`),
  CONSTRAINT `FK_host_reply` FOREIGN KEY (`reply`) REFERENCES `t_reply` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;



/* check sb friend list*/ .
SELECT * FROM t_user_basic t1 
LEFT JOIN t_friend t2 on t1.id=t2.uid 
LEFT JOIN t_user_basic t3 ON t2.fid=t3.id 


SELECT fid FROM t_friend WHERE id=1
SELECT fid as 'id' FROM t_friend WHERE id=1
select * from t_topic where author=2

UPDATE  t_topic SET title='你好，这是我第一条空间' ,content='我是乔巴' WHERE id=8
INSERT INTO t_host_reply VALUES(0,'这是主人的回复','2023-02-14 16:17:11',1,11)