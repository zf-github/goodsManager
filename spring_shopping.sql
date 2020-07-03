/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : spring_shopping

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-07-03 17:10:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `size` varchar(100) DEFAULT NULL,
  `produce_date` datetime DEFAULT NULL,
  `barcode` bigint(20) DEFAULT NULL,
  `batch` varchar(255) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `note` text,
  `thumbnail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('10', '百威啤酒', '中号', '2020-04-25 16:00:00', '6954767425896', '第一批', '500', '未成年人请勿饮酒，孕妇和身体不适者不宜饮酒。喝酒请勿驾车，请适度享用美酒，产品及包装以实物为准。', 'http://127.0.0.1:8080/images/9392.jpg');
INSERT INTO `goods` VALUES ('19', '百威啤酒', '750ml', '2019-06-12 16:00:00', '95213697452', '第二批', '36', '未成年人请勿饮酒，孕妇和身体不适者不宜饮酒。喝酒请勿驾车，请适度享用美酒，产品及包装以实物为准。', 'http://127.0.0.1:8080/images/e3692dae-2f96-4364-84bf-27d2bf7050ce.jpg');
INSERT INTO `goods` VALUES ('20', '安心大油条', '大号', '2019-06-10 16:00:00', '5211659462115783', '第二批', '60', '主要原料:油条', 'http://127.0.0.1:8080/images/c98f369f-f3c9-4f2d-a379-bdea0e86b2fc.jpg');
INSERT INTO `goods` VALUES ('21', '葡式蛋挞(经典)', '小号', '2020-06-02 16:00:00', '134823116951354', '第三批', '30', '主要原料:挞皮，蛋液，淡奶油，牛奶', 'http://127.0.0.1:8080/images/ce258f11-1728-4919-9e8f-9edfc9315c5c.jpg');
INSERT INTO `goods` VALUES ('24', '九珍果汁饮料11', '600ml', '2020-04-30 16:00:00', '6954767178264', '第一批', '50', '主要原料:果汁浓缩液、水', 'http://127.0.0.1:8080/images/9392.jpg');
