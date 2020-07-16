DROP SCHEMA IF EXISTS `students`;

CREATE SCHEMA `students`;

use `students`;

SET FOREIGN_KEY_CHECKS = 0;
# ------------------------------- -------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long,
  `is_admin` int(11) default 0,
  `user_name` varchar(50) NOT NULL ,
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `date_modify` datetime ,
  `modified_by` int(11) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
# ------------------------------- -------------------

DROP TABLE IF EXISTS `sys_privelages`;

CREATE TABLE `sys_privelages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `pre_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
# ------------------------------- -------------------

DROP TABLE IF EXISTS `user_privelage`;

CREATE TABLE `user_privelage` (
  `user_id` int(11) NOT NULL,
  `privelage_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`privelage_id`),
  
  KEY `FK_user_idx` (`user_id`),
  KEY `FK_pre_idx` (`privelage_id`),
  
  CONSTRAINT `FK_User_05` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_Privelage` FOREIGN KEY (`privelage_id`) 
  REFERENCES `sys_privelages` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
# ------------------------------- -------------------

DROP TABLE IF EXISTS `user_section`;

CREATE TABLE `user_section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `section_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 ALTER TABLE `students`.users ADD COLUMN user_section_id INT(11);

 alter table students.users add constraint `FK_sction` FOREIGN KEY (`user_section_id`) 
	REFERENCES `user_section` (`id`);

# ------------------------------- -------------------
DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `address` varchar(350) NOT NULL,
  `phone` int(11),
  `pre_degree` int(11),
  `country` varchar(20) NOT NULL,
  `city` varchar(30) NOT NULL,
  `image` varchar(400) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

ALTER TABLE `students`.users ADD COLUMN user_info_id INT(11);
ALTER TABLE `students`.user_info ADD COLUMN user_id INT(11);

alter table students.users add constraint `FK_info` FOREIGN KEY (`user_info_id`) 
  REFERENCES `user_info` (`id`);
  
  alter table students.users drop column `user_info_id`;
  
  alter table users drop foreign key `FK_info`;
  
  alter table students.user_info add constraint `FK_user_info2` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`);

SET FOREIGN_KEY_CHECKS = 1;


# -------------------------------------------------

# table user section inserts
INSERT INTO `students`.`user_section` (`id`, `code`, `section_name`) VALUES ('1', '001001', 'Manager');
INSERT INTO `students`.`user_section` (`id`, `code`, `section_name`) VALUES ('2', '001002', 'Agent');
INSERT INTO `students`.`user_section` (`id`, `code`, `section_name`) VALUES ('3', '001003', 'Teacher');
INSERT INTO `students`.`user_section` (`id`, `code`, `section_name`) VALUES ('4', '001004', 'secretary');
INSERT INTO `students`.`user_section` (`id`, `code`, `section_name`) VALUES ('5', '001005', 'Administrator');
INSERT INTO `students`.`user_section` (`id`, `code`, `section_name`) VALUES ('6', '001006', 'Worker');
#
#
#
# ------------------------------------------------------------
DROP TABLE IF EXISTS `user_parentis`;

CREATE TABLE `user_parentis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `parentis_name` varchar(45) not NULL,
  `phone` int(11) not null,
  `parentis_address` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

ALTER TABLE `students`.users ADD COLUMN user_parentis_id INT(11);

alter table students.users add constraint `FK_parentis` FOREIGN KEY (`user_parentis_id`) 
  REFERENCES `user_parentis` (`id`);
  
-- alter table students.users drop foreign key `FKpmy8l1djibvmm2ww0ewi9tl3m`;
  
-- alter table students.users add constraint `FKpmy8l1djibvmm2ww0ewi9tl3m` FOREIGN KEY (`user_id`) 
--   REFERENCES `user_parentis` (`id`);
  
-- alter table students.users drop column user_id;
# ----------------------------------------------------------------
DROP TABLE IF EXISTS `sys_parentis`;

CREATE TABLE `sys_parentis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `parentis_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

ALTER TABLE `students`.user_parentis ADD COLUMN sys_parentis_id INT(11);

alter table students.user_parentis add constraint `FK_sys_parentis` FOREIGN KEY (`sys_parentis_id`) 
  REFERENCES `sys_parentis` (`id`);
  
#
# ------------------------------------------------------
#

ALTER TABLE `students`.user_info ADD COLUMN card_id INT(14);
ALTER TABLE `students`.user_info ADD COLUMN qualification varchar(200);
ALTER TABLE `students`.user_info ADD COLUMN experience_year_no INT(5);

ALTER TABLE `students`.user_info ADD COLUMN class_name varchar(50);

#
# -------------------------------------------------------

DROP TABLE IF EXISTS `previous_job`;

CREATE TABLE `previous_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `pre_school_name` varchar(100) not NULL,
  `leave_reason` varchar(500) not NULL,
  `year_no` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- ALTER TABLE `students`.pre_job ADD COLUMN user_id INT(11);
-- alter table students.pre_job add constraint `FK_pre_job` FOREIGN KEY (`user_id`) 
-- REFERENCES `users` (`id`);

ALTER TABLE `students`.users ADD COLUMN previous_job_id INT(11);

alter table students.users add constraint `FK_previous_job` FOREIGN KEY (`previous_job_id`) 
  REFERENCES `previous_job` (`id`);
  

  
  
  
  