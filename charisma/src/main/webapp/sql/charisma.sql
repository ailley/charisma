/*
Navicat MySQL Data Transfer

Source Server         : charisma
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : charisma

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-09-01 22:47:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `menu`
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
-- Table structure for `permission`
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'visit:user', '查看用户管理', '0', '1472651594671', '1472728647307', '4', '0');
INSERT INTO `permission` VALUES ('2', 'add:user', '添加用户', '1', '1472728431007', '1472728448800', '4', '0');
INSERT INTO `permission` VALUES ('3', 'update:user', '修改用户', '1', '1472728445330', null, '4', '0');
INSERT INTO `permission` VALUES ('4', 'delete:user', '删除用户', '0', '1472728474692', null, '4', '0');
INSERT INTO `permission` VALUES ('5', 'select:user', '查询用户', '0', '1472728521513', null, '4', '0');
INSERT INTO `permission` VALUES ('6', 'visit:menu', '查看菜单管理', '0', '1472728636688', null, '3', '0');
INSERT INTO `permission` VALUES ('7', 'add:rootMenu', '添加根目录', '1', '1472728710472', null, '3', '0');
INSERT INTO `permission` VALUES ('8', 'add:menu', '添加菜单', '1', '1472728732156', null, '3', '0');
INSERT INTO `permission` VALUES ('9', 'delete:rootMenu', '删除根目录', '1', '1472728756664', null, '3', '0');
INSERT INTO `permission` VALUES ('10', 'select:menu', '查询菜单', '1', '1472728814600', null, '3', '0');
INSERT INTO `permission` VALUES ('11', 'update:menu', '修改菜单', '1', '1472728832794', null, '3', '0');
INSERT INTO `permission` VALUES ('12', 'delete:menu', '删除菜单', '1', '1472728852386', null, '3', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名',
  `role_code` varchar(32) NOT NULL DEFAULT '' COMMENT '角色编码',
  `role_des` varchar(32) NOT NULL DEFAULT '' COMMENT '角色描述',
  `status` int(1) NOT NULL COMMENT '0 有效 1 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'SUPERADMIN', '超级管理员', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '10000', 'ailley', 'qinqin520', '江延磊', '0', '137080253', '137080253@qq.com', '1', null, '', null, '1472285948987', '1');
INSERT INTO `user` VALUES ('4', 'AC7CD03AFFA801654268DDFF11F36058', 'cqq', '123456', '曹芹芹', '0', '838873398', '838873398@qq.com', '0', null, null, '1471772676154', null, '1');
INSERT INTO `user` VALUES ('5', 'BCDAB597FFA80165732E02E4A3E6405C', 'github', '123456', 'linux', '1', '10086', 'linux@github.cn', '1', null, null, '1472047265175', null, '0');
INSERT INTO `user` VALUES ('6', 'BCDC3B8AFFA8016577C3271EED8CC412', 'haha', '123456', '哈哈', '1', '11111', '1111@qq.cm', '1', null, null, '1472047365002', null, '1');
INSERT INTO `user` VALUES ('7', 'BCE01629FFA8016568BCF800FA4B7CC2', 'aaa', '123456', 'aaa', '1', '1211', '1111@qq.com', '1', null, null, '1472047617577', null, '1');
INSERT INTO `user` VALUES ('8', 'BCE37630FFA80165733E58ABDFA8E956', 'aaaaaaaaaaaaaaa', '123456', 'aaaaa', '1', '11111111', '1111111111111111111@qq.cp', '1', null, null, '1472047838768', null, '1');
INSERT INTO `user` VALUES ('9', 'BCF5EF33FFA8016576E5987F29E6A115', 'aaaaaaaaaaaaaaa', '123456', 'aaaaa', '1', '11111111', '1111111111111111111@qq.cp', '1', null, null, '1472049049395', null, '1');
INSERT INTO `user` VALUES ('10', 'BCF5F659FFA801656E7BC7821B5E3ED0', 'aaaaaaaaaaaaaaa', '123456', 'aaaaa', '1', '11111111', '1111111111111111111@qq.cp', '1', null, null, '1472049051225', null, '1');
INSERT INTO `user` VALUES ('11', 'BCF5FD33FFA8016557D70B2B891DBEF3', 'aaaaaaaaaaaaaaa', '123456', 'aaaaa', '1', '11111111', '1111111111111111111@qq.cp', '1', null, null, '1472049052979', null, '1');
INSERT INTO `user` VALUES ('12', 'BCF603B1FFA8016561DA40C0996EC7B4', 'aaaaaaaaaaaaaaa', '123456', 'aaaaa', '1', '11111111', '1111111111111111111@qq.cp', '1', null, null, '1472049054641', null, '1');
INSERT INTO `user` VALUES ('13', 'BCF613BAFFA80165686B9CC2E2E9BEDB', 'aaaaaaaaaaaaaaa', '123456', 'aaaaa', '1', '11111111', '1111111111111111111@qq.cp', '1', null, null, '1472049058746', null, '0');
INSERT INTO `user` VALUES ('14', 'BCF6212AFFA801656C7373C4203F9530', 'aaaaaaaaaaaaaaa', '123456', 'aaaaa', '1', '11111111', '1111111111111111111@qq.cp', '1', null, null, '1472049062186', null, '0');
INSERT INTO `user` VALUES ('15', 'C206C2FBFFA801654490516BBAC940F1', '', '123456', '', '0', '', '', null, null, null, '1472134038267', null, '0');
