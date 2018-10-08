/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : todolist

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-09-22 11:34:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for matters
-- ----------------------------
DROP TABLE IF EXISTS `matters`;
CREATE TABLE `matters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of matters
-- ----------------------------
INSERT INTO `matters` VALUES ('1', '2', '1完Spring MVC 第二天', '2018-09-17 18:16:59', '2018-09-18 18:16:59', '0');
INSERT INTO `matters` VALUES ('2', '1', '2看完Spring MVC 第二天', '2018-09-17 18:18:25', '2018-09-18 18:18:25', '1');
INSERT INTO `matters` VALUES ('3', '1', '3看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '0');
INSERT INTO `matters` VALUES ('4', '1', '4看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '3');
INSERT INTO `matters` VALUES ('5', '1', '5看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '1');
INSERT INTO `matters` VALUES ('6', '1', '6看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '2');
INSERT INTO `matters` VALUES ('7', '1', '7看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '0');
INSERT INTO `matters` VALUES ('8', '1', '8看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '1');
INSERT INTO `matters` VALUES ('9', '1', '9看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '3');
INSERT INTO `matters` VALUES ('10', '1', '10看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '0');
INSERT INTO `matters` VALUES ('11', '1', '11看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '3');
INSERT INTO `matters` VALUES ('12', '1', '12完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '1');
INSERT INTO `matters` VALUES ('13', '1', '12看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '1');
INSERT INTO `matters` VALUES ('14', '1', '14看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '3');
INSERT INTO `matters` VALUES ('15', '1', '15看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '2');
INSERT INTO `matters` VALUES ('16', '1', '16看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '1');
INSERT INTO `matters` VALUES ('17', '1', '17看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '0');
INSERT INTO `matters` VALUES ('18', '1', '18看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '3');
INSERT INTO `matters` VALUES ('19', '1', '19看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '2');
INSERT INTO `matters` VALUES ('20', '1', '20看完Spring MVC 第二天', '2018-09-18 18:18:25', '2018-09-18 18:18:25', '2');
INSERT INTO `matters` VALUES ('25', '1', '修改bug ，写 spring mvc', '2018-09-20 21:28:30', '2018-09-18 21:28:30', '1');
INSERT INTO `matters` VALUES ('27', '1', '写Spring Boot', '2018-09-20 21:31:32', '2018-09-18 21:31:32', '0');
INSERT INTO `matters` VALUES ('75', '1', '编写测试文档', null, '2018-09-21 15:11:49', '2');
INSERT INTO `matters` VALUES ('77', '1', '添加 编写测试文档', '2018-09-21 15:13:55', '2018-09-21 15:13:55', '0');
INSERT INTO `matters` VALUES ('78', '1', 'test id fanhui', '2018-09-21 15:31:29', '2018-09-21 16:40:12', '0');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(51) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
