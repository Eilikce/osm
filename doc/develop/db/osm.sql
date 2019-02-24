/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `eilikce` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eilikce`;

DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE IF NOT EXISTS `tb_account` (
  `account_id` varchar(50) NOT NULL COMMENT '账单账目id',
  `order_id` varchar(50) NOT NULL COMMENT '订单号id',
  `order_commodity_id` varchar(50) NOT NULL COMMENT '订单商品id',
  `commodity_id` varchar(100) NOT NULL COMMENT '商品id',
  `commodity_name` varchar(      100) NOT NULL COMMENT '商品名称',
  `barcode` int(11) DEFAULT NULL COMMENT '商品条形码',
  `unit` varchar(10) NOT NULL COMMENT '商品单位',
  `original` float NOT NULL COMMENT '商品进价',
  `price` float NOT NULL COMMENT '商品售价',
  `profit` float NOT NULL COMMENT '商品利润',
  `sales_volume` int(11) NOT NULL DEFAULT '0' COMMENT '销售数量。',
  `account_original` float NOT NULL COMMENT ' 入账金额，总进价',
  `account_price` float NOT NULL COMMENT ' 入账金额，总售价',
  `account_profit` float NOT NULL COMMENT ' 入账金额，总利润。',
  `account_detail` varchar(500) DEFAULT '' COMMENT '账目备注',
  `account_date` datetime NOT NULL COMMENT '入账时间',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_account`;
/*!40000 ALTER TABLE `tb_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_account` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE IF NOT EXISTS `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `permissions` varchar(10) NOT NULL COMMENT '权限 root/admin',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_admin`;
/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` (`id`, `user_name`, `password`, `permissions`) VALUES
	(1, 'root', '123', 'root');
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_commodity`;
CREATE TABLE IF NOT EXISTS `tb_commodity` (
  `commodity_id` varchar(100) NOT NULL COMMENT '商品id',
  `group_id` int(11) NOT NULL COMMENT '大类id',
  `item_id` int(11) NOT NULL COMMENT '品类id',
  `barcode` int(11) DEFAULT NULL COMMENT '条形码，可为空，必须唯一',
  `commodity_name` varchar(100) NOT NULL COMMENT '商品名称',
  `commodity_detail` varchar(500) DEFAULT '' COMMENT '商品详情',
  `img_rule` varchar(50) NOT NULL COMMENT '图片规则',
  `number` int(11) NOT NULL COMMENT '存货数',
  `original` float NOT NULL COMMENT '进价',
  `price` float NOT NULL COMMENT '售价',
  `unit` varchar(10) NOT NULL COMMENT '单位：个/斤',
  `source` varchar(100) DEFAULT '' COMMENT '进货渠道',
  `detail` varchar(500) DEFAULT '' COMMENT '备注信息',
  `sales_volume` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  `shelves` int(11) NOT NULL DEFAULT '1' COMMENT '是否上架，0/1',
  `create_date` datetime NOT NULL COMMENT '商品创建日期，精确到日',
  PRIMARY KEY (`commodity_id`),
  UNIQUE KEY `barcode` (`barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_commodity`;
/*!40000 ALTER TABLE `tb_commodity` DISABLE KEYS */;
INSERT INTO `tb_commodity` (`commodity_id`, `group_id`, `item_id`, `barcode`, `commodity_name`, `commodity_detail`, `img_rule`, `number`, `original`, `price`, `unit`, `source`, `detail`, `sales_volume`, `shelves`, `create_date`) VALUES
	('11111', 1, 1, NULL, '鲁花花生油', '鲁花花生油 详细', 'main', 100, 1.5, 2.5, '个', '批发市场', '测试进货', 0, 1, '2019-02-24 22:37:36'),
	('22222', 1, 1, NULL, '金龙鱼调和油 原味', '金龙鱼调和油 原味 详细', 'main', 100, 3, 6.3, '个', '批发市场', '测试进货', 5, 1, '2019-02-24 22:37:36'),
	('33333', 1, 2, NULL, '东北大米', '东北大米 详细资料', 'main', 100, 5.5, 8, '个', '网购', '测试进货', 0, 1, '2019-02-24 22:37:36'),
	('444', 1, 3, NULL, '超级面粉 精装版', '超级面粉 精装版 详细', 'main', 100, 4.5, 7, '个', '网购', '测试进货', 0, 1, '2019-02-24 22:37:37'),
	('555', 1, 4, NULL, '稻花高粱米', '稻花高粱米 详细资料', 'main', 100, 5.5, 8, '个', '网购', '测试进货', 0, 1, '2019-02-24 22:37:37'),
	('666', 2, 1, NULL, '海飞丝 洗发露', '海飞丝 洗发露 榛子味', 'main', 100, 5.5, 8, '个', '网购', '测试进货', 0, 1, '2019-02-24 22:37:37'),
	('77', 2, 2, NULL, '佳洁士香皂', '佳洁士香皂', 'main', 100, 1.1, 9.9, '个', '网购', '测试进货', 0, 1, '2019-02-24 22:37:37'),
	('88', 3, 1, NULL, '曼秀雷敦', '曼秀雷敦', 'main', 100, 1.1, 9.9, '个', '网购', '测试进货', 0, 1, '2019-02-24 22:37:37');
/*!40000 ALTER TABLE `tb_commodity` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_commodity_group`;
CREATE TABLE IF NOT EXISTS `tb_commodity_group` (
  `group_id` int(11) NOT NULL COMMENT '大类id',
  `group_name` varchar(20) NOT NULL COMMENT '大类名称',
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `group_name` (`group_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_commodity_group`;
/*!40000 ALTER TABLE `tb_commodity_group` DISABLE KEYS */;
INSERT INTO `tb_commodity_group` (`group_id`, `group_name`) VALUES
	(3, '休闲食品'),
	(5, '味精调料'),
	(4, '啤酒饮料'),
	(6, '工具厨具'),
	(7, '日用品'),
	(2, '洗护用品'),
	(1, '米面粮油'),
	(8, '计生用品');
/*!40000 ALTER TABLE `tb_commodity_group` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_commodity_item`;
CREATE TABLE IF NOT EXISTS `tb_commodity_item` (
  `group_id` int(11) NOT NULL COMMENT '大类id',
  `item_id` int(11) NOT NULL COMMENT '品类id',
  `item_name` varchar(20) NOT NULL COMMENT '品类名称',
  `img_name` varchar(20) NOT NULL COMMENT '品类图片名称',
  `img_src` varchar(100) NOT NULL COMMENT '品类图片路径',
  PRIMARY KEY (`group_id`,`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_commodity_item`;
/*!40000 ALTER TABLE `tb_commodity_item` DISABLE KEYS */;
INSERT INTO `tb_commodity_item` (`group_id`, `item_id`, `item_name`, `img_name`, `img_src`) VALUES
	(1, 1, '食用油', '1_1_item.png', 'commodity_item'),
	(1, 2, '大米', '1_2_item.png', 'commodity_item'),
	(1, 3, '白面', '1_3_item.png', 'commodity_item'),
	(1, 4, '高粱米', '1_4_item.png', 'commodity_item'),
	(2, 1, '洗发露', '2_1_item.png', 'commodity_item'),
	(2, 2, '香皂', '2_2_item.png', 'commodity_item'),
	(3, 1, '薯片', '3_1_item.png', 'commodity_item'),
	(3, 2, '糖果', '3_2_item.png', 'commodity_item'),
	(3, 3, '干果', '3_3_item.png', 'commodity_item'),
	(3, 4, '方便面', '3_4_item.png', 'commodity_item'),
	(4, 1, '啤酒', '4_1_item.png', 'commodity_item'),
	(4, 2, '汽水', '4_2_item.png', 'commodity_item'),
	(5, 1, '调料', '5_1_item.png', 'commodity_item'),
	(6, 1, '餐具', '6_1_item.png', 'commodity_item'),
	(7, 1, '卫生纸', '7_1_item.png', 'commodity_item'),
	(7, 2, '清洁用品', '7_2_item.png', 'commodity_item'),
	(8, 1, '避孕套', '8_1_item.png', 'commodity_item');
/*!40000 ALTER TABLE `tb_commodity_item` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_consumer`;
CREATE TABLE IF NOT EXISTS `tb_consumer` (
  `consumer_id` varchar(100) NOT NULL COMMENT '用户id',
  `addr` varchar(100) NOT NULL COMMENT '地址',
  `name` varchar(30) NOT NULL COMMENT '用户姓名或昵称',
  `phone` varchar(30) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`consumer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_consumer`;
/*!40000 ALTER TABLE `tb_consumer` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_consumer` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_record_order`;
CREATE TABLE IF NOT EXISTS `tb_record_order` (
  `order_id` varchar(50) NOT NULL COMMENT '订单号id',
  `total_cost` float NOT NULL COMMENT '订单成本',
  `total_price` float NOT NULL COMMENT '订单总价',
  `total_profit` float NOT NULL COMMENT '订单利润',
  `consumer_addr` varchar(100) NOT NULL COMMENT '用户地址',
  `consumer_name` varchar(30) NOT NULL COMMENT '用户姓名',
  `consumer_phone` varchar(30) NOT NULL COMMENT '用户电话',
  `consumer_id` varchar(100) NOT NULL COMMENT '用户id',
  `payment_status` int(11) NOT NULL DEFAULT '0' COMMENT '订单支付状态。0未支付/1已支付',
  `order_invalid` int(11) NOT NULL DEFAULT '1' COMMENT '有效标识，是否消单。0消单/1订单有效',
  `order_cancel_detail` varchar(100) DEFAULT '' COMMENT '消单备注',
  `order_date` datetime NOT NULL COMMENT '订单时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_record_order`;
/*!40000 ALTER TABLE `tb_record_order` DISABLE KEYS */;
INSERT INTO `tb_record_order` (`order_id`, `total_cost`, `total_price`, `total_profit`, `consumer_addr`, `consumer_name`, `consumer_phone`, `consumer_id`, `payment_status`, `order_invalid`, `order_cancel_detail`, `order_date`) VALUES
	('AAAA', 200, 300, 100, '用户历史地址', '用户历史姓名', '用户电话', '用户ID1', 1, 1, '', '2019-02-24 22:37:33'),
	('BBBB', 3, 5, 3, '用户历史地址', '用户历史姓名', '用户电话', '用户ID2', 0, 0, '消单原因', '2019-02-24 22:37:34'),
	('CCCC', 3, 5, 3, '用户历史地址', '用户历史姓名', '用户电话', '用户ID2', 0, 0, '消单原因', '2019-02-24 22:37:34'),
	('DDDD', 3, 5, 3, '用户历史地址', '用户历史姓名', '用户电话', '用户ID2', 0, 0, '消单原因', '2019-02-24 22:37:34'),
	('EEEE', 3, 5, 3, '用户历史地址', '用户历史姓名', '用户电话', '用户ID2', 0, 0, '消单原因', '2019-02-24 22:37:34'),
	('FFFF', 3, 5, 3, '用户历史地址', '用户历史姓名', '用户电话', '用户ID2', 0, 0, '消单原因', '2019-02-24 22:37:34');
/*!40000 ALTER TABLE `tb_record_order` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_record_order_commodity`;
CREATE TABLE IF NOT EXISTS `tb_record_order_commodity` (
  `order_commodity_id` varchar(50) NOT NULL COMMENT '订单商品id',
  `order_id` varchar(50) NOT NULL COMMENT '订单号id',
  `commodity_name` varchar(100) NOT NULL COMMENT '商品名称',
  `commodity_detail` varchar(500) DEFAULT '' COMMENT '商品详情',
  `barcode` int(11) DEFAULT NULL COMMENT '商品条形码',
  `unit` varchar(10) NOT NULL COMMENT '商品单位',
  `original` float NOT NULL COMMENT '商品进价',
  `price` float NOT NULL COMMENT '商品售价',
  `profit` float NOT NULL COMMENT '商品利润',
  `sales_volume` int(11) NOT NULL DEFAULT '1' COMMENT '销售数量',
  `sales_date` datetime NOT NULL COMMENT '销售时间',
  PRIMARY KEY (`order_commodity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_record_order_commodity`;
/*!40000 ALTER TABLE `tb_record_order_commodity` DISABLE KEYS */;
INSERT INTO `tb_record_order_commodity` (`order_commodity_id`, `order_id`, `commodity_name`, `commodity_detail`, `barcode`, `unit`, `original`, `price`, `profit`, `sales_volume`, `sales_date`) VALUES
	('AAAA11111', 'AAAA', '商品历史名称', '商品历史详情', 123456, '袋', 50, 110, 60, 3, '2019-02-24 22:37:34'),
	('BBBB22222', 'BBBB', '商品历史名称', '商品历史详情', 654321, '袋', 66, 77, 11, 10, '2019-02-24 22:37:34'),
	('BBBB33333', 'BBBB', '商品历史名称', '商品历史详情', 777777, '袋', 66, 77, 11, 10, '2019-02-24 22:37:34');
/*!40000 ALTER TABLE `tb_record_order_commodity` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_roles_permissions`;
CREATE TABLE IF NOT EXISTS `tb_roles_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `permission` varchar(100) NOT NULL COMMENT '权限',
  `role_name` varchar(30) NOT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_roles_permissions`;
/*!40000 ALTER TABLE `tb_roles_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_roles_permissions` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE IF NOT EXISTS `tb_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `password_salt` varchar(100) NOT NULL COMMENT '密码盐',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_users`;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_users` ENABLE KEYS */;

DROP TABLE IF EXISTS `tb_user_roles`;
CREATE TABLE IF NOT EXISTS `tb_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(100) NOT NULL COMMENT '角色',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tb_user_roles`;
/*!40000 ALTER TABLE `tb_user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
