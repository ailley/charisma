/*
Navicat MySQL Data Transfer

Source Server         : charisma
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : charisma

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-08-21 18:00:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '菜单名',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父类id',
  `url` varchar(255) NOT NULL COMMENT '菜单路径',
  `sort` bigint(1) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 - 正常 1 - 失效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `uid` varchar(32) NOT NULL COMMENT '用户uid',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `name` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '用户类别 0系统用户 1普通用户',
  `qq` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `gender` int(1) DEFAULT '0' COMMENT '0 - 女 1 - 男',
  `head` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  `note` varchar(255) DEFAULT '' COMMENT '说明',
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态 0正常 1失效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '10000', 'ailley', 'qinqin520', '江延磊', '0', '137080253', '137080253@qq.com', '1', null, '', null, null, '0');
INSERT INTO `user` VALUES ('4', 'AC7CD03AFFA801654268DDFF11F36058', 'cqq', '123456', '曹芹芹', '0', '838873398', '838873398@qq.com', '0', null, null, '1471772676154', null, '0');
