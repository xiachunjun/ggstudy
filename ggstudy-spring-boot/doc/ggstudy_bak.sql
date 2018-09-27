/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : ggstudy_bak

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 27/09/2018 11:27:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ggstudy_sys_configs
-- ----------------------------
DROP TABLE IF EXISTS `ggstudy_sys_configs`;
CREATE TABLE `ggstudy_sys_configs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cfg_code` varchar(64) DEFAULT NULL COMMENT '代码',
  `cfg_name` varchar(128) DEFAULT NULL COMMENT '名称',
  `cfg_key` varchar(128) DEFAULT NULL COMMENT '键',
  `cfg_value` varchar(512) DEFAULT NULL COMMENT '值',
  `cfg_des` varchar(512) DEFAULT NULL COMMENT '描述',
  `cfg_type` varchar(128) DEFAULT NULL COMMENT '类型',
  `parent_code` varchar(64) DEFAULT NULL COMMENT '父code（多层级时使用）',
  `data_status` int(11) DEFAULT NULL,
  `data_version` int(11) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `create_user` varchar(128) DEFAULT NULL,
  `update_user` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sc_users
-- ----------------------------
DROP TABLE IF EXISTS `sc_users`;
CREATE TABLE `sc_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户代码',
  `user_login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '登录名',
  `user_login_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `user_id_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `user_nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `data_state` int(11) DEFAULT NULL,
  `data_version` int(11) DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sc_users_copy
-- ----------------------------
DROP TABLE IF EXISTS `sc_users_copy`;
CREATE TABLE `sc_users_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户代码',
  `user_login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '登录名',
  `user_login_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `user_id_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `user_nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `data_state` int(11) DEFAULT NULL,
  `data_version` int(11) DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tt
-- ----------------------------
DROP TABLE IF EXISTS `tt`;
CREATE TABLE `tt` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
