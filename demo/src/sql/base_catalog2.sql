/*
Navicat MySQL Data Transfer

Source Server         : atguigu
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : gmall

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-07-10 10:25:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_catalog2
-- ----------------------------
DROP TABLE IF EXISTS `base_catalog2`;
CREATE TABLE `base_catalog2` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(200) NOT NULL COMMENT '二级分类名称',
  `catalog1_id` int(11) DEFAULT NULL COMMENT '一级分类编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_catalog2
-- ----------------------------
INSERT INTO `base_catalog2` VALUES ('1', '电子书刊', '1');
INSERT INTO `base_catalog2` VALUES ('2', '音像', '1');
INSERT INTO `base_catalog2` VALUES ('3', '英文原版', '1');
INSERT INTO `base_catalog2` VALUES ('4', '文艺', '1');
INSERT INTO `base_catalog2` VALUES ('5', '少儿', '1');
INSERT INTO `base_catalog2` VALUES ('6', '人文社科', '1');
INSERT INTO `base_catalog2` VALUES ('7', '经管励志', '1');
INSERT INTO `base_catalog2` VALUES ('8', '生活', '1');
INSERT INTO `base_catalog2` VALUES ('9', '科技', '1');
INSERT INTO `base_catalog2` VALUES ('10', '教育', '1');
INSERT INTO `base_catalog2` VALUES ('11', '港台图书', '1');
INSERT INTO `base_catalog2` VALUES ('12', '其他', '1');
INSERT INTO `base_catalog2` VALUES ('13', '手机通讯', '2');
INSERT INTO `base_catalog2` VALUES ('14', '运营商', '2');
INSERT INTO `base_catalog2` VALUES ('15', '手机配件', '2');
INSERT INTO `base_catalog2` VALUES ('16', '大 家 电', '3');
INSERT INTO `base_catalog2` VALUES ('17', '厨卫大电', '3');
INSERT INTO `base_catalog2` VALUES ('18', '厨房小电', '3');
INSERT INTO `base_catalog2` VALUES ('19', '生活电器', '3');
INSERT INTO `base_catalog2` VALUES ('20', '个护健康', '3');
INSERT INTO `base_catalog2` VALUES ('21', '五金家装', '3');
INSERT INTO `base_catalog2` VALUES ('22', '摄影摄像', '4');
INSERT INTO `base_catalog2` VALUES ('23', '数码配件', '4');
INSERT INTO `base_catalog2` VALUES ('24', '智能设备', '4');
INSERT INTO `base_catalog2` VALUES ('25', '影音娱乐', '4');
INSERT INTO `base_catalog2` VALUES ('26', '电子教育', '4');
INSERT INTO `base_catalog2` VALUES ('27', '虚拟商品', '4');
INSERT INTO `base_catalog2` VALUES ('28', '家纺', '5');
INSERT INTO `base_catalog2` VALUES ('29', '灯具', '5');
INSERT INTO `base_catalog2` VALUES ('30', '生活日用', '5');
INSERT INTO `base_catalog2` VALUES ('31', '家装软饰', '5');
INSERT INTO `base_catalog2` VALUES ('32', '宠物生活', '5');
INSERT INTO `base_catalog2` VALUES ('33', '电脑整机', '6');
INSERT INTO `base_catalog2` VALUES ('34', '电脑配件', '6');
INSERT INTO `base_catalog2` VALUES ('35', '外设产品', '6');
INSERT INTO `base_catalog2` VALUES ('36', '游戏设备', '6');
INSERT INTO `base_catalog2` VALUES ('37', '网络产品', '6');
INSERT INTO `base_catalog2` VALUES ('38', '办公设备', '6');
INSERT INTO `base_catalog2` VALUES ('39', '文具/耗材', '6');
INSERT INTO `base_catalog2` VALUES ('40', '服务产品', '6');
INSERT INTO `base_catalog2` VALUES ('41', '烹饪锅具', '7');
INSERT INTO `base_catalog2` VALUES ('42', '刀剪菜板', '7');
INSERT INTO `base_catalog2` VALUES ('43', '厨房配件', '7');
INSERT INTO `base_catalog2` VALUES ('44', '水具酒具', '7');
INSERT INTO `base_catalog2` VALUES ('45', '餐具', '7');
INSERT INTO `base_catalog2` VALUES ('46', '酒店用品', '7');
INSERT INTO `base_catalog2` VALUES ('47', '茶具/咖啡具', '7');
INSERT INTO `base_catalog2` VALUES ('48', '清洁用品', '8');
INSERT INTO `base_catalog2` VALUES ('49', '面部护肤', '8');
INSERT INTO `base_catalog2` VALUES ('50', '身体护理', '8');
INSERT INTO `base_catalog2` VALUES ('51', '口腔护理', '8');
INSERT INTO `base_catalog2` VALUES ('52', '女性护理', '8');
INSERT INTO `base_catalog2` VALUES ('53', '洗发护发', '8');
INSERT INTO `base_catalog2` VALUES ('54', '香水彩妆', '8');
INSERT INTO `base_catalog2` VALUES ('55', '女装', '9');
INSERT INTO `base_catalog2` VALUES ('56', '男装', '9');
INSERT INTO `base_catalog2` VALUES ('57', '内衣', '9');
INSERT INTO `base_catalog2` VALUES ('58', '洗衣服务', '9');
INSERT INTO `base_catalog2` VALUES ('59', '服饰配件', '9');
INSERT INTO `base_catalog2` VALUES ('60', '钟表', '10');
INSERT INTO `base_catalog2` VALUES ('61', '流行男鞋', '11');
INSERT INTO `base_catalog2` VALUES ('62', '时尚女鞋', '11');
INSERT INTO `base_catalog2` VALUES ('63', '奶粉', '12');
INSERT INTO `base_catalog2` VALUES ('64', '营养辅食', '12');
INSERT INTO `base_catalog2` VALUES ('65', '尿裤湿巾', '12');
INSERT INTO `base_catalog2` VALUES ('66', '喂养用品', '12');
INSERT INTO `base_catalog2` VALUES ('67', '洗护用品', '12');
INSERT INTO `base_catalog2` VALUES ('68', '童车童床', '12');
INSERT INTO `base_catalog2` VALUES ('69', '寝居服饰', '12');
INSERT INTO `base_catalog2` VALUES ('70', '妈妈专区', '12');
INSERT INTO `base_catalog2` VALUES ('71', '童装童鞋', '12');
INSERT INTO `base_catalog2` VALUES ('72', '安全座椅', '12');
INSERT INTO `base_catalog2` VALUES ('73', '潮流女包', '13');
INSERT INTO `base_catalog2` VALUES ('74', '精品男包', '13');
INSERT INTO `base_catalog2` VALUES ('75', '功能箱包', '13');
INSERT INTO `base_catalog2` VALUES ('76', '礼品', '13');
INSERT INTO `base_catalog2` VALUES ('77', '奢侈品', '13');
INSERT INTO `base_catalog2` VALUES ('78', '婚庆', '13');
INSERT INTO `base_catalog2` VALUES ('79', '进口食品', '14');
INSERT INTO `base_catalog2` VALUES ('80', '地方特产', '14');
INSERT INTO `base_catalog2` VALUES ('81', '休闲食品', '14');
INSERT INTO `base_catalog2` VALUES ('82', '粮油调味', '14');
INSERT INTO `base_catalog2` VALUES ('83', '饮料冲调', '14');
INSERT INTO `base_catalog2` VALUES ('84', '食品礼券', '14');
INSERT INTO `base_catalog2` VALUES ('85', '茗茶', '14');
INSERT INTO `base_catalog2` VALUES ('86', '时尚饰品', '15');
INSERT INTO `base_catalog2` VALUES ('87', '黄金', '15');
INSERT INTO `base_catalog2` VALUES ('88', 'K金饰品', '15');
INSERT INTO `base_catalog2` VALUES ('89', '金银投资', '15');
INSERT INTO `base_catalog2` VALUES ('90', '银饰', '15');
INSERT INTO `base_catalog2` VALUES ('91', '钻石', '15');
INSERT INTO `base_catalog2` VALUES ('92', '翡翠玉石', '15');
INSERT INTO `base_catalog2` VALUES ('93', '水晶玛瑙', '15');
INSERT INTO `base_catalog2` VALUES ('94', '彩宝', '15');
INSERT INTO `base_catalog2` VALUES ('95', '铂金', '15');
INSERT INTO `base_catalog2` VALUES ('96', '木手串/把件', '15');
INSERT INTO `base_catalog2` VALUES ('97', '珍珠', '15');
INSERT INTO `base_catalog2` VALUES ('98', '维修保养', '16');
INSERT INTO `base_catalog2` VALUES ('99', '车载电器', '16');
INSERT INTO `base_catalog2` VALUES ('100', '美容清洗', '16');
INSERT INTO `base_catalog2` VALUES ('101', '汽车装饰', '16');
INSERT INTO `base_catalog2` VALUES ('102', '安全自驾', '16');
INSERT INTO `base_catalog2` VALUES ('103', '汽车服务', '16');
INSERT INTO `base_catalog2` VALUES ('104', '赛事改装', '16');
INSERT INTO `base_catalog2` VALUES ('105', '运动鞋包', '17');
INSERT INTO `base_catalog2` VALUES ('106', '运动服饰', '17');
INSERT INTO `base_catalog2` VALUES ('107', '骑行运动', '17');
INSERT INTO `base_catalog2` VALUES ('108', '垂钓用品', '17');
INSERT INTO `base_catalog2` VALUES ('109', '游泳用品', '17');
INSERT INTO `base_catalog2` VALUES ('110', '户外鞋服', '17');
INSERT INTO `base_catalog2` VALUES ('111', '户外装备', '17');
INSERT INTO `base_catalog2` VALUES ('112', '健身训练', '17');
INSERT INTO `base_catalog2` VALUES ('113', '体育用品', '17');
INSERT INTO `base_catalog2` VALUES ('114', '适用年龄', '18');
INSERT INTO `base_catalog2` VALUES ('115', '遥控/电动', '18');
INSERT INTO `base_catalog2` VALUES ('116', '毛绒布艺', '18');
INSERT INTO `base_catalog2` VALUES ('117', '娃娃玩具', '18');
INSERT INTO `base_catalog2` VALUES ('118', '模型玩具', '18');
INSERT INTO `base_catalog2` VALUES ('119', '健身玩具', '18');
INSERT INTO `base_catalog2` VALUES ('120', '动漫玩具', '18');
INSERT INTO `base_catalog2` VALUES ('121', '益智玩具', '18');
INSERT INTO `base_catalog2` VALUES ('122', '积木拼插', '18');
INSERT INTO `base_catalog2` VALUES ('123', 'DIY玩具', '18');
INSERT INTO `base_catalog2` VALUES ('124', '创意减压', '18');
INSERT INTO `base_catalog2` VALUES ('125', '乐器', '18');
INSERT INTO `base_catalog2` VALUES ('126', '彩票', '19');
INSERT INTO `base_catalog2` VALUES ('127', '机票', '19');
INSERT INTO `base_catalog2` VALUES ('128', '酒店', '19');
INSERT INTO `base_catalog2` VALUES ('129', '旅行', '19');
INSERT INTO `base_catalog2` VALUES ('130', '充值', '19');
INSERT INTO `base_catalog2` VALUES ('131', '游戏', '19');
INSERT INTO `base_catalog2` VALUES ('132', '票务', '19');
INSERT INTO `base_catalog2` VALUES ('133', '产地直供', '20');
INSERT INTO `base_catalog2` VALUES ('134', '水果', '20');
INSERT INTO `base_catalog2` VALUES ('135', '猪牛羊肉', '20');
INSERT INTO `base_catalog2` VALUES ('136', '海鲜水产', '20');
INSERT INTO `base_catalog2` VALUES ('137', '禽肉蛋品', '20');
INSERT INTO `base_catalog2` VALUES ('138', '冷冻食品', '20');
INSERT INTO `base_catalog2` VALUES ('139', '熟食腊味', '20');
INSERT INTO `base_catalog2` VALUES ('140', '饮品甜品', '20');
INSERT INTO `base_catalog2` VALUES ('141', '蔬菜', '20');
INSERT INTO `base_catalog2` VALUES ('142', '全新整车', '21');
INSERT INTO `base_catalog2` VALUES ('143', '二手车', '21');
