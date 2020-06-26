/*
 Navicat Premium Data Transfer

 Source Server         : mysql_gzc
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 29/05/2020 22:41:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `admin_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admin_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `admin_name`(`admin_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info`(admin_name,password) VALUES ('admin', 'admin');
INSERT INTO `admin_info`(admin_name,password) VALUES ('root', 'root');

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`  (
  `book_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '书籍ID',
  `book_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '书名',
  `isbn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'ISBN',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '作者',
  `press` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '出版社',
  `publication_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '出版日期',
  `price` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '价格',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '在馆状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
  PRIMARY KEY (`book_id`) USING BTREE,
  UNIQUE INDEX `book_id`(`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1019 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('巴黎圣母院', '9787560575667', '[法]雨果 著 李玉民 译', '西安交通大学出版社', '2015-08-01 00:00:00', 37.80, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('失乐园', '9787555257035', '渡边淳一[著]  林少华[译]', '青岛出版社', '2017-11-01 00:00:00', 45.00, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '假面之夜+假面饭店+假面前夜', '25286485', '东野圭吾', '南海出版公司', '2018-06-01 00:00:00', 115.90, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '布隆夫曼脱单历险记', '9787559431394', '[美]丹尼尔·华莱士 著 宁蒙 译 时代华语', '江苏凤凰文艺出版社', '2019-04-01 00:00:00', 35.80, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '光与影', '9787555269397', '渡边淳一', '青岛出版社', '2018-05-25 00:00:00', 32.00, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '三体：全三册', '23579654', '刘慈欣', '重庆出版社', '2010-11-01 00:00:00', 55.80, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '鲛在水中央', '9787540490645', '孙频', '湖南文艺出版社', '2017-08-01 00:00:00', 42.70, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('彼得·林奇点评版股票作手回忆录', '9787515303628', '[美]杰西·利弗莫尔', '中国青年出版社', '2019-05-01 00:00:00', 32.20, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '财务自由之路（全三册）', '26511903', '[德]博多·舍费尔', '现代出版社', '2019-02-20 00:00:00', 121.10, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '稻盛和夫阿米巴经营经典套装（理论+实践）', '9787520202824', '[日]稻盛和夫', '中国大百科全书出版社', '2018-05-01 00:00:00', 74.70, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('斯坦福极简经济学', '24010635', '[美]泰勒', '湖南人民出版社', '2016-08-16 00:00:00', 45.50, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '工匠精神：向价值型员工进化——精装典藏新版', '9787515814940', '付守永', '中华工商联合出版社', '2015-12-01 00:00:00', 37.00, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '高效能学习：思维力+学习力（套装共2册）', '26514401', '王世民', '电子工业出版社', '2019-02-19 00:00:00', 101.40, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('谈判：如何在博弈中获得更多', '9787513918930', '[英] 盖温·肯尼迪 (Gavin Kennedy)', '民主与建设出版社', '2018-04-06 00:00:00', 40.50, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('曾国藩的正面与侧面', '27856398', '张宏杰', '岳麓出版社', '2018-04-06 00:00:00', 134.60, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('第二性（ⅠⅡ 全两册）', '23429879', '[法]西蒙娜德波伏瓦', '上海译文出版社', '2011-09-01 00:00:00', 68.60, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '易经杂说', '9787520707862', '南怀瑾', '东方出版社', '2019-04-01 00:00:00', 45.50, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('中国文史哲大辞典（全六册）', '25282178', '郑天挺、谭其骧、钱仲联、章培恒、傅璇琮、张岱年等', '上海辞书出版社', '2018-08-15 00:00:00', 945.60, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('范志红健康日历', '9787122327475', '范志红', '化学工业出版社', '2019-12-01 00:00:00', 70.50, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '闪电增肌', '9787121359552', '仰望尾迹云', '电子工业出版社', '2019-03-01 00:00:00', 46.80, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '你不懂茶', '9787559430076', '[日]三宅贵男', '江苏凤凰文艺出版社', '2019-09-01 00:00:00', 39.50, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '男人这东西', '9787555269410', '渡边淳一', '青岛出版社', '2018-05-31 00:00:00', 39.00, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '孩子受益一生的思维力', '9787554613122', '杨瑜君 万玲', '古吴轩出版社', '2019-01-20 00:00:00', 44.30, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '刚刚好的养育：如何培养高情商的孩子', '9787555277750', '鱼爸 ', '青岛出版社', '2019-03-01 00:00:00', 40.10, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '四大名著', '25111286', '[清]曹雪芹、[明]吴承恩、[明]罗贯中、[明]施耐庵', '民主与建设出版社', '2017-08-01 00:00:00', 97.74, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '中华上下五千年', '9787570404506', '刘敬余主编', '北京教育出版社', '2019-02-20 00:00:00', 89.70, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '古史·文言·今论', '9787303227259', '杨洋', '北京师范大学出版社', '2018-05-01 00:00:00', 65.30, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '星火英语六级真题试卷', '9787313086716', '汪开虎', '上海交通大学出版社', '2016-08-16 00:00:00', 36.80, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('现代汉语词典(第7版)', '9787100124508', '中国社会科学院语言研究所词典编辑室 ', '商务印书馆', '2015-12-01 00:00:00', 93.00, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '居里夫人传', '9787512655942', '[法]玛丽.居里', '团结出版社', '2019-02-19 00:00:00', 21.60, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('艺术的故事', '9787807463726', '[英] 贡布里希', '广西美术出版社', '2018-04-06 00:00:00', 182.00, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('梵高：化世间痛苦为激情洋溢的美', '9787568041638', '[法]扬·布朗', '华中科技大学出版社', '2018-04-06 00:00:00', 353.80, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('林徽因传：人生从来都靠自己成全', '9787202134948', '程碧', '河北人民出版社', '2011-09-01 00:00:00', 51.60, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '三毛典藏全集', '9787530216545', '三毛 ', '北京十月文艺出版社', '2019-04-01 00:00:00', 336.00, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ('雨夜短文', '9787545536829', '余秋雨', '天地出版社', '2018-08-15 00:00:00', 55.70, b'0');
INSERT INTO `book_info`(book_name,isbn,author,press,publication_date,price,`status`) VALUES ( '鲁迅全集', '9787547711101', '鲁迅', '北京日报出版社', '2019-03-01 00:00:00', 457.50, b'0');

-- ----------------------------
-- Table structure for borrow_info
-- ----------------------------
DROP TABLE IF EXISTS `borrow_info`;
CREATE TABLE `borrow_info`  (
  `borrow_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `reader_id` bigint unsigned NOT NULL COMMENT '读者ID',
  `book_id` int unsigned NOT NULL COMMENT '书籍ID',
  `borrow_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '借阅时间',
  `expire_time` datetime(0) NOT NULL COMMENT '到期时间',
  PRIMARY KEY (`borrow_id`) USING BTREE,
  UNIQUE INDEX `borrow_id`(`reader_id`, `book_id`) USING BTREE,
  INDEX `reader_id_2`(`reader_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `borrow_info_ibfk_1` FOREIGN KEY (`reader_id`) REFERENCES `reader_info` (`reader_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `borrow_info_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reader_info
-- ----------------------------
DROP TABLE IF EXISTS `reader_info`;
CREATE TABLE `reader_info`  (
  `reader_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '读者ID',
  `reader_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者姓名',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '读者状态',
  `fine` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '欠款金额',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`reader_id`) USING BTREE,
  UNIQUE INDEX `reader_id`(`reader_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2020052 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader_info
-- ----------------------------
INSERT INTO `reader_info`(reader_name,phone,`status`,fine) VALUES ('张三', '13154697895', b'0', 0.80);
INSERT INTO `reader_info`(reader_name,phone,`status`,fine) VALUES ('李四', '12345678911', b'0', 0.00);
INSERT INTO `reader_info`(reader_name,phone,`status`,fine) VALUES ( 'jack', '12547896547', b'1', 0.00);
INSERT INTO `reader_info`(reader_name,phone,`status`,fine) VALUES ( '王五', '15369987456', b'0', 12.50);
INSERT INTO `reader_info`(reader_name,phone,`status`,fine) VALUES ('李华', '13154698745', b'0', 0.00);

-- ----------------------------
-- Table structure for return_info
-- ----------------------------
DROP TABLE IF EXISTS `return_info`;
CREATE TABLE `return_info`  (
  `r_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `reader_id` bigint unsigned NOT NULL COMMENT '读者ID',
  `book_id` int unsigned NOT NULL COMMENT '书籍ID',
  `borrow_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '借阅时间',
  `return_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '归还时间',
  PRIMARY KEY (`r_id`) USING BTREE,
  INDEX `reader_id_2`(`reader_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `return_info_ibfk_1` FOREIGN KEY (`reader_id`) REFERENCES `reader_info` (`reader_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `return_info_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Redundant;

SET FOREIGN_KEY_CHECKS = 1;
