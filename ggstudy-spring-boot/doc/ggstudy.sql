/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : ggstudy

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 27/09/2018 11:27:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill_export_log
-- ----------------------------
DROP TABLE IF EXISTS `bill_export_log`;
CREATE TABLE `bill_export_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `restaurant_id` bigint(20) DEFAULT '0' COMMENT '实体id',
  `operate_id` bigint(20) DEFAULT '0' COMMENT '操作者id',
  `shop_name` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '商户名称',
  `begin_date` date NOT NULL DEFAULT '1970-01-01' COMMENT '开始日期',
  `end_date` date NOT NULL DEFAULT '1970-01-01' COMMENT '结束日期',
  `status` smallint(6) DEFAULT '0' COMMENT '账单导出状态,1:初始化 2:成功 -1:失败',
  `file_hash` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '文件存储地址',
  `biz_type` tinyint(4) DEFAULT '0' COMMENT '业务类型,0:商户账单 1:小程序账单 2:运营平台账单',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `ix_restaurant_id` (`restaurant_id`),
  KEY `ix_operate_id` (`operate_id`),
  KEY `ix_updated_at` (`updated_at`),
  KEY `ix_created_at` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='账单导出记录表';

-- ----------------------------
-- Table structure for ggstudy_sys_configs
-- ----------------------------
DROP TABLE IF EXISTS `ggstudy_sys_configs`;
CREATE TABLE `ggstudy_sys_configs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cfg_code` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '代码',
  `cfg_name` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `cfg_key` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '键',
  `cfg_value` varchar(512) CHARACTER SET utf8 DEFAULT NULL COMMENT '值',
  `cfg_des` varchar(512) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `cfg_type` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型',
  `parent_code` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '父code（多层级时使用）',
  `data_status` int(11) DEFAULT NULL,
  `data_version` int(11) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `create_user` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `update_user` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
