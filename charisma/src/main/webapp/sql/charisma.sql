/*
Navicat MySQL Data Transfer

Source Server         : 本地备份
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : charisma

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2017-01-11 11:16:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `text` varchar(255) NOT NULL COMMENT '菜单名',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父类id',
  `href` varchar(255) NOT NULL COMMENT '菜单路径',
  `icon` varchar(255) DEFAULT '' COMMENT 'bootstrap 图标',
  `sort` bigint(1) DEFAULT '0' COMMENT '排序字段',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 - 正常 1 - 失效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', '0', '#', 'glyphicon glyphicon-list', '10', '0');
INSERT INTO `menu` VALUES ('3', '菜单管理', '1', 'menu.htm', '', '12', '0');
INSERT INTO `menu` VALUES ('4', '用户管理', '1', 'user.htm', '', '11', '0');
INSERT INTO `menu` VALUES ('5', '角色管理', '1', 'role.htm', '', '13', '0');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permission_mark` varchar(32) NOT NULL DEFAULT '' COMMENT '权限标识字段',
  `permission_des` varchar(32) DEFAULT '' COMMENT '权限描述',
  `permission_type` int(1) DEFAULT NULL COMMENT '权限类别',
  `create_date` bigint(32) DEFAULT NULL COMMENT '创建时间',
  `updete_date` bigint(32) DEFAULT NULL COMMENT '修改时间',
  `menu_id` bigint(32) NOT NULL COMMENT '关联menu表',
  `status` int(1) NOT NULL COMMENT '0 有效 1 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10014 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('10001', 'visit:user', '查看用户管理', '0', '1472651594671', '1472728647307', '4', '0');
INSERT INTO `permission` VALUES ('10002', 'add:user', '添加用户', '1', '1472728431007', '1472728448800', '4', '0');
INSERT INTO `permission` VALUES ('10003', 'update:user', '修改用户', '1', '1472728445330', null, '4', '0');
INSERT INTO `permission` VALUES ('10004', 'delete:user', '删除用户', '0', '1472728474692', null, '4', '0');
INSERT INTO `permission` VALUES ('10005', 'select:user', '查询用户', '0', '1472728521513', null, '4', '0');
INSERT INTO `permission` VALUES ('10006', 'visit:menu', '查看菜单管理', '0', '1472728636688', null, '3', '0');
INSERT INTO `permission` VALUES ('10007', 'add:rootMenu', '添加根目录', '1', '1472728710472', null, '3', '0');
INSERT INTO `permission` VALUES ('10008', 'add:menu', '添加菜单', '1', '1472728732156', null, '3', '0');
INSERT INTO `permission` VALUES ('10009', 'delete:rootMenu', '删除根目录', '1', '1472728756664', null, '3', '0');
INSERT INTO `permission` VALUES ('10010', 'select:menu', '查询菜单', '1', '1472728814600', null, '3', '0');
INSERT INTO `permission` VALUES ('10011', 'update:menu', '修改菜单', '1', '1472728832794', null, '3', '0');
INSERT INTO `permission` VALUES ('10012', 'delete:menu', '删除菜单', '1', '1472728852386', null, '3', '0');
INSERT INTO `permission` VALUES ('10013', 'visit:role', '查询角色', '0', '1484104266588', null, '5', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名',
  `role_code` varchar(32) NOT NULL DEFAULT '' COMMENT '角色编码',
  `role_des` varchar(32) NOT NULL DEFAULT '' COMMENT '角色描述',
  `status` int(1) NOT NULL COMMENT '0 有效 1 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'SUPERADMIN', '超级管理员', '0');
INSERT INTO `role` VALUES ('2', '管理员', 'ADMIN', '管理员', '0');
INSERT INTO `role` VALUES ('3', '普通用户', 'GENER', '普通用户', '0');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(32) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(32) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('24', '1', '1');
INSERT INTO `role_menu` VALUES ('25', '1', '3');
INSERT INTO `role_menu` VALUES ('26', '1', '4');
INSERT INTO `role_menu` VALUES ('27', '1', '5');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(32) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(32) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('68', '1', '10006');
INSERT INTO `role_permission` VALUES ('69', '1', '10007');
INSERT INTO `role_permission` VALUES ('70', '1', '10008');
INSERT INTO `role_permission` VALUES ('71', '1', '10009');
INSERT INTO `role_permission` VALUES ('72', '1', '10010');
INSERT INTO `role_permission` VALUES ('73', '1', '10011');
INSERT INTO `role_permission` VALUES ('74', '1', '10012');
INSERT INTO `role_permission` VALUES ('75', '1', '10001');
INSERT INTO `role_permission` VALUES ('76', '1', '10002');
INSERT INTO `role_permission` VALUES ('77', '1', '10003');
INSERT INTO `role_permission` VALUES ('78', '1', '10004');
INSERT INTO `role_permission` VALUES ('79', '1', '10005');
INSERT INTO `role_permission` VALUES ('80', '1', '10013');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `uid` varchar(32) NOT NULL COMMENT '用户uid',
  `role_code` varchar(32) DEFAULT NULL,
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `name` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '用户类别 0系统用户 1普通用户',
  `head` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  `qq` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `gender` int(1) DEFAULT '0' COMMENT '0 - 女 1 - 男',
  `note` varchar(255) DEFAULT '' COMMENT '说明',
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态 0正常 1失效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '10000', 'SUPERADMIN', 'ailley', 'qinqin520', '江延磊', '0', null, '137080253', '137080253@qq.com', '1', '', null, '1472285948987', '1');
SET FOREIGN_KEY_CHECKS=1;
