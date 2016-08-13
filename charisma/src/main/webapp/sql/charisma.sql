/*
Navicat MySQL Data Transfer

Source Server         : charisma
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : charisma

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-08-13 23:42:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户uid',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户类别',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户状态 0正常 1失效',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10000', 'ailley', 'qinqin520', '0', '0');
