/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2024-12-27 18:26:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rc_admin
-- ----------------------------
DROP TABLE IF EXISTS `rc_admin`;
CREATE TABLE `rc_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(255) NOT NULL,
  `admin_password` varchar(255) NOT NULL,
  `admin_privilege` int(11) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_admin
-- ----------------------------
INSERT INTO `rc_admin` VALUES ('1', 'admin', '123', '255');

-- ----------------------------
-- Table structure for rc_class
-- ----------------------------
DROP TABLE IF EXISTS `rc_class`;
CREATE TABLE `rc_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_major_id` int(11) NOT NULL,
  `class_grade` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_class
-- ----------------------------
INSERT INTO `rc_class` VALUES ('1', '1', '2021', '软件工程1班');
INSERT INTO `rc_class` VALUES ('2', '1', '2021', '软件工程2班');
INSERT INTO `rc_class` VALUES ('3', '1', '2021', '软件工程3班');
INSERT INTO `rc_class` VALUES ('4', '2', '2021', '计算机科学与技术1班');
INSERT INTO `rc_class` VALUES ('5', '2', '2021', '计算机科学与技术2班');
INSERT INTO `rc_class` VALUES ('6', '2', '2021', '计算机科学与技术3班');
INSERT INTO `rc_class` VALUES ('7', '3', '2021', '网络工程1班');
INSERT INTO `rc_class` VALUES ('8', '3', '2021', '网络工程2班');
INSERT INTO `rc_class` VALUES ('9', '3', '2021', '网络工程3班');

-- ----------------------------
-- Table structure for rc_course
-- ----------------------------
DROP TABLE IF EXISTS `rc_course`;
CREATE TABLE `rc_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_teacher_id` int(11) NOT NULL,
  `course_name` varchar(255) NOT NULL,
  `course_grade` int(11) NOT NULL,
  `course_time` varchar(10) NOT NULL,
  `course_location` varchar(255) NOT NULL,
  `course_credit` int(11) NOT NULL,
  `course_selected_count` int(11) DEFAULT '0',
  `course_max_size` int(11) NOT NULL,
  `course_exam_date` datetime DEFAULT NULL,
  `course_exam_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_course
-- ----------------------------
INSERT INTO `rc_course` VALUES ('1', '5', '计算机网络', '2021', '2-1-2', '第一教学楼101', '2', '1', '50', null, '实验楼101');
INSERT INTO `rc_course` VALUES ('2', '1', '计算机组成原理', '2021', '1-3-2', '第一教学楼201', '2', '1', '50', '2024-12-17 16:00:00', '实验楼201');

-- ----------------------------
-- Table structure for rc_department
-- ----------------------------
DROP TABLE IF EXISTS `rc_department`;
CREATE TABLE `rc_department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_department
-- ----------------------------
INSERT INTO `rc_department` VALUES ('1', '计算机学院');
INSERT INTO `rc_department` VALUES ('2', '外国语学院');
INSERT INTO `rc_department` VALUES ('3', '商学院');

-- ----------------------------
-- Table structure for rc_major
-- ----------------------------
DROP TABLE IF EXISTS `rc_major`;
CREATE TABLE `rc_major` (
  `major_id` int(11) NOT NULL AUTO_INCREMENT,
  `major_department_id` int(11) NOT NULL,
  `major_name` varchar(255) NOT NULL,
  PRIMARY KEY (`major_id`),
  KEY `major_department_id` (`major_department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_major
-- ----------------------------
INSERT INTO `rc_major` VALUES ('1', '1', '软件工程');
INSERT INTO `rc_major` VALUES ('2', '1', '计算机科学与技术');
INSERT INTO `rc_major` VALUES ('3', '1', '网络工程');
INSERT INTO `rc_major` VALUES ('4', '1', '信息管理与信息系统');
INSERT INTO `rc_major` VALUES ('5', '2', '英语');
INSERT INTO `rc_major` VALUES ('6', '2', '日语');
INSERT INTO `rc_major` VALUES ('7', '2', '法语');
INSERT INTO `rc_major` VALUES ('8', '2', '朝鲜语');
INSERT INTO `rc_major` VALUES ('9', '2', '俄语');
INSERT INTO `rc_major` VALUES ('10', '3', '工商管理');
INSERT INTO `rc_major` VALUES ('11', '3', '市场营销');
INSERT INTO `rc_major` VALUES ('12', '3', '会计学');
INSERT INTO `rc_major` VALUES ('13', '3', '财务管理');
INSERT INTO `rc_major` VALUES ('14', '3', '人力资源管理');

-- ----------------------------
-- Table structure for rc_status
-- ----------------------------
DROP TABLE IF EXISTS `rc_status`;
CREATE TABLE `rc_status` (
  `student` varchar(6) NOT NULL,
  `teacher` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_status
-- ----------------------------
INSERT INTO `rc_status` VALUES ('1', '0');

-- ----------------------------
-- Table structure for rc_student
-- ----------------------------
DROP TABLE IF EXISTS `rc_student`;
CREATE TABLE `rc_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_class_id` int(11) NOT NULL,
  `student_number` char(12) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `student_password` varchar(255) NOT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `student_birthday` date DEFAULT NULL,
  `student_sex` tinyint(4) NOT NULL,
  `student_last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_student
-- ----------------------------
INSERT INTO `rc_student` VALUES ('1', '1', '202109010101', '张三', '123', null, null, '1', '2024-12-27 09:59:18');
INSERT INTO `rc_student` VALUES ('2', '1', '202109010102', '李四', '123', null, null, '1', '2024-12-26 16:30:11');
INSERT INTO `rc_student` VALUES ('3', '1', '202109010103', '王五', '123', null, null, '0', null);
INSERT INTO `rc_student` VALUES ('4', '1', '202109010104', '张四', '123', null, null, '1', null);
INSERT INTO `rc_student` VALUES ('5', '1', '202109010105', '王一', '123', null, null, '0', null);

-- ----------------------------
-- Table structure for rc_student_course
-- ----------------------------
DROP TABLE IF EXISTS `rc_student_course`;
CREATE TABLE `rc_student_course` (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT,
  `sc_student_id` int(11) NOT NULL,
  `sc_course_id` int(11) NOT NULL,
  `sc_daily_score` int(11) DEFAULT NULL,
  `sc_exam_score` int(11) DEFAULT NULL,
  `sc_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`sc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_student_course
-- ----------------------------
INSERT INTO `rc_student_course` VALUES ('1', '1', '1', '50', '50', '100');
INSERT INTO `rc_student_course` VALUES ('3', '2', '2', null, null, null);

-- ----------------------------
-- Table structure for rc_teacher
-- ----------------------------
DROP TABLE IF EXISTS `rc_teacher`;
CREATE TABLE `rc_teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_department_id` int(11) NOT NULL,
  `teacher_number` char(12) NOT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `teacher_password` varchar(255) NOT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rc_teacher
-- ----------------------------
INSERT INTO `rc_teacher` VALUES ('1', '1', '202100000001', '王老师', '123');
INSERT INTO `rc_teacher` VALUES ('2', '2', '202100000002', '张老师', '123');
INSERT INTO `rc_teacher` VALUES ('3', '3', '202100000003', '田老师', '123');
INSERT INTO `rc_teacher` VALUES ('4', '1', '202100000004', '陈老师', '123');
INSERT INTO `rc_teacher` VALUES ('5', '1', '202100000005', '李老师', '123');
