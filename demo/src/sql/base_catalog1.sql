/*
Navicat MySQL Data Transfer

Source Server         : atguigu
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : gmall

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-07-10 10:25:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_catalog1
-- ----------------------------
DROP TABLE IF EXISTS `base_catalog1`;
CREATE TABLE `base_catalog1` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(200) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='一级分类表';

-- ----------------------------
-- Records of base_catalog1
-- ----------------------------
INSERT INTO `base_catalog1` VALUES ('1', '图书、音像、电子书刊');
INSERT INTO `base_catalog1` VALUES ('2', '手机');
INSERT INTO `base_catalog1` VALUES ('3', '家用电器');
INSERT INTO `base_catalog1` VALUES ('4', '数码');
INSERT INTO `base_catalog1` VALUES ('5', '家居家装');
INSERT INTO `base_catalog1` VALUES ('6', '电脑办公');
INSERT INTO `base_catalog1` VALUES ('7', '厨具');
INSERT INTO `base_catalog1` VALUES ('8', '个护化妆');
INSERT INTO `base_catalog1` VALUES ('9', '服饰内衣');
INSERT INTO `base_catalog1` VALUES ('10', '钟表');
INSERT INTO `base_catalog1` VALUES ('11', '鞋靴');
INSERT INTO `base_catalog1` VALUES ('12', '母婴');
INSERT INTO `base_catalog1` VALUES ('13', '礼品箱包');
INSERT INTO `base_catalog1` VALUES ('14', '食品饮料、保健食品');
INSERT INTO `base_catalog1` VALUES ('15', '珠宝');
INSERT INTO `base_catalog1` VALUES ('16', '汽车用品');
INSERT INTO `base_catalog1` VALUES ('17', '运动健康');
INSERT INTO `base_catalog1` VALUES ('18', '玩具乐器');
INSERT INTO `base_catalog1` VALUES ('19', '彩票、旅行、充值、票务');
INSERT INTO `base_catalog1` VALUES ('20', '生鲜');
INSERT INTO `base_catalog1` VALUES ('21', '整车');
