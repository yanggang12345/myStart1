/*
Navicat MySQL Data Transfer

Source Server         : scott
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-07-26 17:00:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `decidedzone_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '张三', '百度', '1', '北京', 'dq003');
INSERT INTO `t_customer` VALUES ('2', '李四', '哇哈哈', '2', '上海', 'dq003');
INSERT INTO `t_customer` VALUES ('3', '王五', '搜狗', '3', '天津', null);
INSERT INTO `t_customer` VALUES ('4', '赵六', '联想', '4', '石家庄', null);
INSERT INTO `t_customer` VALUES ('5', '小白', '测试空间', '5', '内蒙古', null);
INSERT INTO `t_customer` VALUES ('6', '小黑', '联想', '6', '天津', 'dq003');
INSERT INTO `t_customer` VALUES ('7', '小花', '百度', '7', '北京', null);
INSERT INTO `t_customer` VALUES ('8', '小李', '长城', '8', '北京', null);
