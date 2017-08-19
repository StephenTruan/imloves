/*
Navicat MySQL Data Transfer

Source Server         : MINE
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : imloves

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-17 21:55:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wx_customer
-- ----------------------------
DROP TABLE IF EXISTS `wx_customer`;
CREATE TABLE `wx_customer` (
  `uuid` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户数据编号',
  `open_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '微信openId',
  `nick_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `sex` int(3) DEFAULT '0' COMMENT '性别（0：未填写，1：男，2：女）',
  `state` int(3) DEFAULT NULL COMMENT '状态（0：冻结，1：可用）',
  `city` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '用户所在城市',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
