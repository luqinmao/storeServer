/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-10-04 12:28:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for store_cart
-- ----------------------------
DROP TABLE IF EXISTS `store_cart`;
CREATE TABLE `store_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `checked` int(11) DEFAULT NULL COMMENT '是否选择,1=已勾选,0=未勾选',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id_index` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_cart
-- ----------------------------
INSERT INTO `store_cart` VALUES ('130', '2', '29', '1', '1', '2019-09-28 10:43:57', '2019-09-28 14:59:05');

-- ----------------------------
-- Table structure for store_category
-- ----------------------------
DROP TABLE IF EXISTS `store_category`;
CREATE TABLE `store_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别Id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类别id当id=0时说明是根节点,一级类别',
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `status` tinyint(1) DEFAULT '1' COMMENT '类别状态1-正常,2-已废弃',
  `sort_order` int(4) DEFAULT NULL COMMENT '排序编号,同类展示顺序,数值相等则自然排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100031 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_category
-- ----------------------------
INSERT INTO `store_category` VALUES ('100001', '0', '甜点美食', '1', null, '2017-03-25 16:46:00', '2019-09-28 11:25:06');
INSERT INTO `store_category` VALUES ('100002', '0', '生鲜果蔬', '1', null, '2017-03-25 16:46:21', '2019-09-28 11:25:19');
INSERT INTO `store_category` VALUES ('100003', '0', '酒水饮料', '1', null, '2017-03-25 16:49:53', '2019-09-28 11:25:36');
INSERT INTO `store_category` VALUES ('100004', '0', '午餐优选', '1', null, '2017-03-25 16:50:19', '2019-09-28 11:25:44');
INSERT INTO `store_category` VALUES ('100005', '0', '家常菜', '1', null, '2017-03-25 16:50:29', '2019-09-28 11:25:50');

-- ----------------------------
-- Table structure for store_order
-- ----------------------------
DROP TABLE IF EXISTS `store_order`;
CREATE TABLE `store_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` bigint(20) DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) DEFAULT NULL,
  `payment` decimal(20,2) DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数',
  `payment_type` int(4) DEFAULT NULL COMMENT '支付类型,1-在线支付',
  `postage` int(10) DEFAULT NULL COMMENT '运费,单位是元',
  `status` int(10) DEFAULT NULL COMMENT '订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no_index` (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_order
-- ----------------------------
INSERT INTO `store_order` VALUES ('122', '1570158652572', '1', '38', '23.00', '1', '0', '0', null, null, null, null, '2019-10-04 11:10:52', '2019-10-04 12:20:35');
INSERT INTO `store_order` VALUES ('123', '1570159451559', '1', '38', '74.60', '1', '0', '20', '2019-10-04 12:20:46', null, null, null, '2019-10-04 11:24:11', '2019-10-04 11:24:11');
INSERT INTO `store_order` VALUES ('124', '1570160143370', '1', '38', '33.00', '1', '0', '20', null, null, null, null, '2019-10-04 11:35:43', '2019-10-04 11:37:39');
INSERT INTO `store_order` VALUES ('125', '1570160199128', '1', '38', '68.00', '1', '0', '10', null, null, null, null, '2019-10-04 11:36:39', '2019-10-04 11:36:39');
INSERT INTO `store_order` VALUES ('126', '1570160663790', '1', '38', '35.00', '1', '0', '10', null, null, null, null, '2019-10-04 11:44:23', '2019-10-04 11:44:23');
INSERT INTO `store_order` VALUES ('127', '1570162151760', '1', '38', '23.00', '1', '0', '10', null, null, null, null, '2019-10-04 12:09:11', '2019-10-04 12:09:11');
INSERT INTO `store_order` VALUES ('128', '1570162275156', '1', '38', '23.00', '1', '0', '50', '2019-10-04 12:11:20', null, null, null, '2019-10-04 12:11:15', '2019-10-04 12:12:25');
INSERT INTO `store_order` VALUES ('129', '1570162358492', '1', '38', '12.00', '1', '0', '40', '2019-10-04 12:12:43', null, null, null, '2019-10-04 12:12:38', '2019-10-04 12:13:10');

-- ----------------------------
-- Table structure for store_order_item
-- ----------------------------
DROP TABLE IF EXISTS `store_order_item`;
CREATE TABLE `store_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
  `user_id` int(11) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `product_image` varchar(500) DEFAULT NULL COMMENT '商品图片地址',
  `current_unit_price` decimal(20,2) DEFAULT NULL COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
  `quantity` int(10) DEFAULT NULL COMMENT '商品数量',
  `total_price` decimal(20,2) DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `order_no_index` (`order_no`) USING BTREE,
  KEY `order_no_user_id_index` (`user_id`,`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_order_item
-- ----------------------------
INSERT INTO `store_order_item` VALUES ('113', '1', '1491753014256', '26', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', '6999.00', '2', '13998.00', '2017-04-09 23:50:14', '2017-04-09 23:50:14');
INSERT INTO `store_order_item` VALUES ('141', '1', '1570158652572', '5', '狠霸王牛堡套餐', 'https://fuss10.elemecdn.com/6/c6/9d8a54c12b820f09b41adcf2a6049png.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', '23.00', '1', '23.00', '2019-10-04 11:10:52', '2019-10-04 11:10:52');
INSERT INTO `store_order_item` VALUES ('142', '1', '1570159451559', '5', '狠霸王牛堡套餐', 'https://fuss10.elemecdn.com/6/c6/9d8a54c12b820f09b41adcf2a6049png.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', '23.00', '1', '23.00', '2019-10-04 11:24:11', '2019-10-04 11:24:11');
INSERT INTO `store_order_item` VALUES ('143', '1', '1570159451559', '9', '芒芒青能量', 'https://fuss10.elemecdn.com/1/2d/5327b41db429a1deb0b5775a78e8ejpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '4.60', '1', '4.60', '2019-10-04 11:24:11', '2019-10-04 11:24:11');
INSERT INTO `store_order_item` VALUES ('144', '1', '1570159451559', '2', '招牌牛腩+酱汁排骨双人餐', 'https://fuss10.elemecdn.com/f/6d/35529482015fc9578a3926560b90bjpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '35.00', '1', '35.00', '2019-10-04 11:24:11', '2019-10-04 11:24:11');
INSERT INTO `store_order_item` VALUES ('145', '1', '1570159451559', '7', '(大杯)冰淇淋红茶', 'https://fuss10.elemecdn.com/7/a8/4b97b20887e0f60fa1a78f030848fpng.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', '12.00', '1', '12.00', '2019-10-04 11:24:11', '2019-10-04 11:24:11');
INSERT INTO `store_order_item` VALUES ('146', '1', '1570160143370', '13', '【爱意碰撞】椰奶芝士两个装+泡芙一盒', 'https://fuss10.elemecdn.com/8/67/67ca234f5caad35cdb7445bd4ee75jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '33.00', '1', '33.00', '2019-10-04 11:35:43', '2019-10-04 11:35:43');
INSERT INTO `store_order_item` VALUES ('147', '1', '1570160199128', '13', '【爱意碰撞】椰奶芝士两个装+泡芙一盒', 'https://fuss10.elemecdn.com/8/67/67ca234f5caad35cdb7445bd4ee75jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '33.00', '1', '33.00', '2019-10-04 11:36:39', '2019-10-04 11:36:39');
INSERT INTO `store_order_item` VALUES ('148', '1', '1570160199128', '2', '招牌牛腩+酱汁排骨双人餐', 'https://fuss10.elemecdn.com/f/6d/35529482015fc9578a3926560b90bjpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '35.00', '1', '35.00', '2019-10-04 11:36:39', '2019-10-04 11:36:39');
INSERT INTO `store_order_item` VALUES ('149', '1', '1570160663790', '2', '招牌牛腩+酱汁排骨双人餐', 'https://fuss10.elemecdn.com/f/6d/35529482015fc9578a3926560b90bjpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '35.00', '1', '35.00', '2019-10-04 11:44:23', '2019-10-04 11:44:23');
INSERT INTO `store_order_item` VALUES ('150', '1', '1570162151760', '4', '霸辣鸡翅', 'https://fuss10.elemecdn.com/4/a6/54416c3bb2b9f171143eeacd2fbfbpng.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', '23.00', '1', '23.00', '2019-10-04 12:09:11', '2019-10-04 12:09:11');
INSERT INTO `store_order_item` VALUES ('151', '1', '1570162275156', '6', '(中杯)波霸奶茶', 'https://fuss10.elemecdn.com/3/d8/1f8614dfd6ff01e275fc0e1691e27png.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', '23.00', '1', '23.00', '2019-10-04 12:11:15', '2019-10-04 12:11:15');
INSERT INTO `store_order_item` VALUES ('152', '1', '1570162358492', '8', '白火龙果', 'https://fuss10.elemecdn.com/e/88/94a77a7bf75d23805d62820cd8d6djpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '12.00', '1', '12.00', '2019-10-04 12:12:38', '2019-10-04 12:12:38');

-- ----------------------------
-- Table structure for store_pay_info
-- ----------------------------
DROP TABLE IF EXISTS `store_pay_info`;
CREATE TABLE `store_pay_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `order_no` bigint(20) DEFAULT NULL COMMENT '订单号',
  `pay_platform` int(10) DEFAULT NULL COMMENT '支付平台:1-支付宝,2-微信',
  `platform_number` varchar(200) DEFAULT NULL COMMENT '支付宝支付流水号',
  `platform_status` varchar(20) DEFAULT NULL COMMENT '支付宝支付状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_pay_info
-- ----------------------------
INSERT INTO `store_pay_info` VALUES ('53', '1', '1492090946105', '1', '2017041321001004300200116250', 'WAIT_BUYER_PAY', '2017-04-13 21:42:33', '2017-04-13 21:42:33');
INSERT INTO `store_pay_info` VALUES ('61', '1', '1570162275156', '1', '2019100422001429401000022161', 'TRADE_SUCCESS', '2019-10-04 12:11:26', '2019-10-04 12:11:26');
INSERT INTO `store_pay_info` VALUES ('62', '1', '1570162358492', '1', '2019100422001429401000025046', 'TRADE_SUCCESS', '2019-10-04 12:12:49', '2019-10-04 12:12:49');
INSERT INTO `store_pay_info` VALUES ('63', '1', '1570159451559', '1', '2019100422001429401000025047', 'TRADE_SUCCESS', '2019-10-04 12:20:52', '2019-10-04 12:20:52');

-- ----------------------------
-- Table structure for store_product
-- ----------------------------
DROP TABLE IF EXISTS `store_product`;
CREATE TABLE `store_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int(11) NOT NULL COMMENT '分类id,对应store_category表的主键',
  `name` varchar(100) NOT NULL COMMENT '商品名称',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '商品副标题',
  `main_image` varchar(500) DEFAULT NULL COMMENT '产品主图,url相对地址',
  `sub_images` text COMMENT '图片地址,json格式,扩展用',
  `detail` text COMMENT '商品详情',
  `price` decimal(20,2) NOT NULL COMMENT '价格,单位-元保留两位小数',
  `stock` int(11) NOT NULL COMMENT '库存数量',
  `status` int(6) DEFAULT '1' COMMENT '商品状态.1-在售 2-下架 3-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_product
-- ----------------------------
INSERT INTO `store_product` VALUES ('1', '100005', '招牌牛腩+瓦锅饭', '招牌牛腩+瓦锅饭', 'https://fuss10.elemecdn.com/3/c7/d2a8690b6a8f43de55b02ddcef2cajpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '选用上等爽楠，其特点有块薄软胶质，爽软不硬，口感一流，配合秘制牛腩汁回味无穷。 主要原料：其他', '选用上等爽楠，其特点有块薄软胶质，爽软不硬，口感一流，配合秘制牛腩汁回味无穷。 主要原料：其他', '99.00', '9993', '1', '2017-04-13 19:07:47', '2019-09-28 14:46:23');
INSERT INTO `store_product` VALUES ('2', '100005', '招牌牛腩+酱汁排骨双人餐', null, 'https://fuss10.elemecdn.com/f/6d/35529482015fc9578a3926560b90bjpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', null, '招牌牛腩+酱汁排骨+瓦锅饭*2+蒸蛋*2+小菜*2+饮料*2 主要原料：其他', '35.00', '31', '1', '2019-09-28 14:34:24', '2019-09-28 14:46:25');
INSERT INTO `store_product` VALUES ('3', '100004', '缤纷秋日双人套餐', null, 'https://fuss10.elemecdn.com/8/9e/07e85a17287445a8727a1f641b15cpng.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/8/9e/07e85a17287445a8727a1f641b15cpng.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', '每天限量10份以特惠价48元售卖，售完不再提供该等优惠价格。狠霸王牛堡+霸辣鸡腿堡+薯霸王（大）+霸王鸡条（鲜辣）+可口可乐（大）+可口可乐（大）。主要原料：面包、牛肉饼、球生菜、洋葱、酸黄瓜、车打芝士、鸡肉、马铃薯。 主要原料：牛肉', '65.00', '5', '1', '2019-09-28 14:36:08', '2019-09-28 14:36:08');
INSERT INTO `store_product` VALUES ('4', '100004', '霸辣鸡翅', '霸辣鸡翅', 'https://fuss10.elemecdn.com/4/a6/54416c3bb2b9f171143eeacd2fbfbpng.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', null, '金黄酥脆的外皮，一口咬下，热辣四溢在口中弥漫。更有鲜嫩多汁的鸡肉。（主要原料：鸡肉。） 主要原料：鸡肉', '23.00', '3', '1', '2019-09-28 14:37:01', '2019-09-28 14:37:01');
INSERT INTO `store_product` VALUES ('5', '100004', '狠霸王牛堡套餐', '狠霸王牛堡套餐', 'https://fuss10.elemecdn.com/6/c6/9d8a54c12b820f09b41adcf2a6049png.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', null, '足足包含双层100%火烤牛肉饼，三层酥软面包，还有快要溢出来的蔬菜酱料！（主要原料：面包、牛肉饼、球生菜、洋葱、酸黄瓜片） 主要原料：牛肉', '23.00', '42', '1', '2019-09-28 14:37:53', '2019-09-28 14:37:53');
INSERT INTO `store_product` VALUES ('6', '100003', '(中杯)波霸奶茶', '(中杯)波霸奶茶', 'https://fuss10.elemecdn.com/3/d8/1f8614dfd6ff01e275fc0e1691e27png.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/3/d8/1f8614dfd6ff01e275fc0e1691e27png.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', '奶茶搭配波霸，口感软Q。辅料：波霸、植脂末。 主要原料：红茶', '23.00', '1', '1', '2019-09-28 14:39:01', '2019-09-28 14:39:01');
INSERT INTO `store_product` VALUES ('7', '100003', '(大杯)冰淇淋红茶', '(大杯)冰淇淋红茶', 'https://fuss10.elemecdn.com/7/a8/4b97b20887e0f60fa1a78f030848fpng.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/7/a8/4b97b20887e0f60fa1a78f030848fpng.png?imageMogr2/thumbnail/360x360/format/webp/quality/85', '阿萨姆红茶搭配香草冰淇淋，口感滑润，清爽恬淡。辅料：冰淇淋。 主要原料：红茶', '12.00', '33', '1', '2019-09-28 14:39:44', '2019-09-28 14:39:44');
INSERT INTO `store_product` VALUES ('8', '100002', '白火龙果', '白火龙果', 'https://fuss10.elemecdn.com/e/88/94a77a7bf75d23805d62820cd8d6djpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/e/88/94a77a7bf75d23805d62820cd8d6djpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '白火龙果\r\n100g 甜 微酸', '12.00', '31', '1', '2019-09-28 14:42:06', '2019-09-28 14:42:06');
INSERT INTO `store_product` VALUES ('9', '100002', '芒芒青能量', '芒芒青能量', 'https://fuss10.elemecdn.com/1/2d/5327b41db429a1deb0b5775a78e8ejpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/1/2d/5327b41db429a1deb0b5775a78e8ejpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '温馨提示：因季节原因，果盒中的白芭乐更换为哈密瓜、杨桃更换为腌李子哦 青芒+白芭乐+西瓜+苹果+杨桃+白芯火龙果+雪梨+木瓜 “青”新滋味，能量加倍 消除困意，充能一整天 甜而多汁爽口的芒芒青能量 唇齿留香，愉悦你的味蕾 份量规格： 600G（1-2人享用） 1000G（3-4人享用） 1300G（4-5人享用） 温馨提示：此套餐以青芒为主打，青芒会偏多哦 享受情景：困意缠绕的下午', '4.60', '2', '1', '2019-09-28 14:42:53', '2019-09-28 14:43:06');
INSERT INTO `store_product` VALUES ('10', '100002', '酸爽青芒', '酸爽青芒', 'https://fuss10.elemecdn.com/c/bc/dc3a660366be6343483ce8b270578jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/c/bc/dc3a660366be6343483ce8b270578jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '酸爽青芒\r\n精选热带季风气候的越南青芒 生态果园种植，新鲜采摘，产地直供 利用半熟状态的青芒加入秘制配料腌制 清脆爽口，甘甜酸涩，回味无穷 青芒1号： 果肉呈青绿色，甜度低，酸涩爽口，提神解馋，止渴生津！ 甜度★★☆ 青芒2号： 果肉偏黄芒色，果肉硬度适中，酸酸甜甜，开胃解腻！ 甜度★★★☆', '5.90', '22', '1', '2019-09-28 14:44:07', '2019-09-28 14:44:07');
INSERT INTO `store_product` VALUES ('11', '100001', '椰奶芝士', '椰奶芝士', 'https://fuss10.elemecdn.com/e/44/71a62cbc9b561b056ae31d4a18f8fjpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/e/44/71a62cbc9b561b056ae31d4a18f8fjpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '雀巢椰香淡奶与大利年芝士的结合，成就了一款香味浓郁、爽口嫩滑的椰奶芝士 主要原料：牛奶,芝士', '9.00', '2', '1', '2019-09-28 14:45:04', '2019-09-28 14:45:04');
INSERT INTO `store_product` VALUES ('12', '100001', '现烤蛋黄老婆饼（4个装）', '现烤蛋黄老婆饼（4个装）', 'https://fuss10.elemecdn.com/6/06/94a8d2c164eaf704055ef2d52ecbdjpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/6/06/94a8d2c164eaf704055ef2d52ecbdjpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '采用原味老婆饼的皮与馅，包上精选蛋黄，外皮酥脆，皮薄馅厚、馅心滋润软滑、味道甜而不腻。 口味：原味老婆饼+精选蛋黄。 主要材料:小麦粉、糯米粉、白砂糖、咸蛋黄、猪油、椰丝等。 保质期：1天，常温储存。 重量：100克/个*4个 主要原料：小麦粉,白砂糖,咸蛋黄', '23.00', '22', '1', '2019-09-28 14:45:41', '2019-09-28 14:45:41');
INSERT INTO `store_product` VALUES ('13', '100001', '【爱意碰撞】椰奶芝士两个装+泡芙一盒', '【爱意碰撞】椰奶芝士两个装+泡芙一盒', 'https://fuss10.elemecdn.com/8/67/67ca234f5caad35cdb7445bd4ee75jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', 'https://fuss10.elemecdn.com/8/67/67ca234f5caad35cdb7445bd4ee75jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85', '传说奶油和蛋糕结婚了，面包从此失恋了，它把对奶油的爱深深藏进了心底，于是有了泡芙。当泡芙遇见椰奶芝士，会擦出什么样的火花，由你来见证。 主要原料：小麦粉,芝士', '33.00', '20', '1', '2019-09-28 14:46:16', '2019-09-28 14:46:16');

-- ----------------------------
-- Table structure for store_shipping
-- ----------------------------
DROP TABLE IF EXISTS `store_shipping`;
CREATE TABLE `store_shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(20) DEFAULT NULL COMMENT '收货固定电话',
  `receiver_mobile` varchar(20) DEFAULT NULL COMMENT '收货移动电话',
  `receiver_province` varchar(20) DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) DEFAULT NULL COMMENT '区/县',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `is_default` tinyint(2) DEFAULT '0',
  `receiver_zip` varchar(6) DEFAULT NULL COMMENT '邮编',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_shipping
-- ----------------------------
INSERT INTO `store_shipping` VALUES ('4', '13', 'geely', '010', '18688888888', '北京', '北京市', '海淀区', '中关村', '0', '100000', '2017-01-22 14:26:25', '2017-01-22 14:26:25');
INSERT INTO `store_shipping` VALUES ('38', '1', 'xiaoer', '13900000001', null, null, null, null, 'china guangdong ', '1', null, '2019-09-28 11:10:50', '2019-09-28 11:10:50');
INSERT INTO `store_shipping` VALUES ('39', '1', 'xiaosan', '13900000002', null, null, null, null, 'chiana shenzhen', '0', null, '2019-09-28 11:11:33', '2019-09-28 11:11:33');
INSERT INTO `store_shipping` VALUES ('40', '28', 'test2', '123123123', null, null, null, null, 'japan ', '1', null, '2019-09-28 15:02:00', '2019-09-28 15:02:00');

-- ----------------------------
-- Table structure for store_user
-- ----------------------------
DROP TABLE IF EXISTS `store_user`;
CREATE TABLE `store_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密码答案',
  `role` int(4) NOT NULL COMMENT '角色0-管理员,1-普通用户',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_user
-- ----------------------------
INSERT INTO `store_user` VALUES ('1', 'admin', '427338237BD929443EC5D48E24FD2B1A', 'admin@happymmall.com', '13800138000', '问题', '答案', '1', '2016-11-06 16:56:45', '2019-08-23 11:55:56', 'IMG_20190522_153946.jpg');
INSERT INTO `store_user` VALUES ('13', 'geely', '08E9A6EA287E70E7E3F7C982BF7923AC', 'geely@happymmall.com', '13800138000', '问题', '答案', '0', '2016-11-19 22:19:25', '2019-08-23 11:56:22', 'IMG_20190522_153946.jpg');
INSERT INTO `store_user` VALUES ('17', 'rosen', '095AC193FE2212EEC7A93E8FEFF11902', 'rosen1@happymmall.com', '13800138000', '问题', '答案', '0', '2017-03-17 10:51:33', '2019-08-23 11:56:25', 'IMG_20190522_153946.jpg');
INSERT INTO `store_user` VALUES ('21', 'soonerbetter', 'DE6D76FE7C40D5A1A8F04213F2BEFBEE', 'test06@happymmall.com', '13800138000', '105204', '105204', '0', '2017-04-13 21:26:22', '2019-08-23 11:56:26', 'IMG_20190522_153946.jpg');
INSERT INTO `store_user` VALUES ('27', 'test1', 'D8F80B67499E434EA61ADAF6E6219BF2', '1002489464', null, null, null, '0', '2019-08-23 11:57:00', '2019-08-23 11:57:00', 'IMG_20190823_115645.jpg');
INSERT INTO `store_user` VALUES ('28', 'test2', '3273C3AF1F259E5E19464976B3FBEE58', '123123', null, null, null, '0', '2019-09-28 15:01:29', '2019-09-28 15:01:29', 'IMG_20190928_070107.jpg');
