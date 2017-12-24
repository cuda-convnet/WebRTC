/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : conf_server

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-12-27 22:10:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account_admin`
-- ----------------------------
DROP TABLE IF EXISTS `account_admin`;
CREATE TABLE `account_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `pwd_salt` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of account_admin
-- ----------------------------
INSERT INTO `account_admin` VALUES ('1', 'admin@free4lab.com', 'f0920bd4e83833864e821c458a99a92e');

-- ----------------------------
-- Table structure for `alive`
-- ----------------------------
DROP TABLE IF EXISTS `alive`;
CREATE TABLE `alive` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `member` char(32) NOT NULL,
  `isAlive` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alive
-- ----------------------------

-- ----------------------------
-- Table structure for `conf_member`
-- ----------------------------
DROP TABLE IF EXISTS `conf_member`;
CREATE TABLE `conf_member` (
  `roomid` varchar(64) NOT NULL COMMENT '房间ID',
  `member` varchar(64) NOT NULL COMMENT '会议成员',
  `join_at` datetime DEFAULT NULL COMMENT '成员加入时间',
  `conn_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`roomid`,`member`),
  CONSTRAINT `FK_conf_member` FOREIGN KEY (`roomid`) REFERENCES `room` (`roomid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of conf_member
-- ----------------------------

-- ----------------------------
-- Table structure for `conn_id`
-- ----------------------------
DROP TABLE IF EXISTS `conn_id`;
CREATE TABLE `conn_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) DEFAULT NULL COMMENT '用户名',
  `connId` varchar(128) DEFAULT NULL COMMENT '连接ID',
  `call_time` datetime DEFAULT NULL COMMENT '呼叫时间',
  `status` int(5) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of conn_id
-- ----------------------------
INSERT INTO `conn_id` VALUES ('1', 'alice', 'conn:f716f090-93f76d0a-13c4-50022-349-bb723c-349', '2015-10-12 17:55:05', '1');
INSERT INTO `conn_id` VALUES ('2', 'bob', 'conn:f716f238-93f76d0a-13c4-50022-3ef-42fdac03-3ef', '2015-10-12 17:57:51', '1');
INSERT INTO `conn_id` VALUES ('11', '222', 'conn:f196fa38-8df76d0a-13c4-50022-384-6ae97fd4-384', '2015-10-12 23:23:00', '1');
INSERT INTO `conn_id` VALUES ('10', 'webrtc1-163.com~WebRTC', 'conn:f196f890-8df76d0a-13c4-50022-370-6adc9161-370', '2015-10-12 23:22:39', '1');

-- ----------------------------
-- Table structure for `event`
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `event` varchar(16) NOT NULL,
  `event_time` datetime NOT NULL,
  `accepted_time` datetime DEFAULT NULL,
  `roomid` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event
-- ----------------------------
INSERT INTO `event` VALUES ('108', 'webrtc8-163.com@WebRTC', 'UDP_JOIN', '2016-04-18 19:48:04', '2016-04-18 19:48:09', 'q8Ih');
INSERT INTO `event` VALUES ('109', 'webrtc1-163.com@WebRTC', 'UDP_JOIN', '2016-04-24 20:31:01', '2016-04-24 20:31:03', 'qljt');
INSERT INTO `event` VALUES ('110', 'webrtc10-163.com@WebRTC', 'UDP_CREATE', '2016-05-01 12:00:19', null, 'waPr');
INSERT INTO `event` VALUES ('111', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-01 12:01:59', null, 'UHq3');
INSERT INTO `event` VALUES ('112', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-01 12:03:39', null, 'xKDs');
INSERT INTO `event` VALUES ('113', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-01 12:05:19', null, '0aJB');
INSERT INTO `event` VALUES ('114', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-01 12:06:59', null, 'SR1t');
INSERT INTO `event` VALUES ('115', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-05 15:01:16', null, 'SR1t');
INSERT INTO `event` VALUES ('116', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-05 15:02:56', null, 'SR1t');
INSERT INTO `event` VALUES ('117', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-05 15:04:36', null, 'SR1t');
INSERT INTO `event` VALUES ('118', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-05 15:06:16', null, 'SR1t');
INSERT INTO `event` VALUES ('119', 'webrtc9-163.com@WebRTC', 'UDP_CREATE', '2016-05-07 17:04:33', null, 'SR1t');

-- ----------------------------
-- Table structure for `logaddr`
-- ----------------------------
DROP TABLE IF EXISTS `logaddr`;
CREATE TABLE `logaddr` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fromuser` varchar(128) NOT NULL,
  `fromtag` varchar(128) NOT NULL,
  `totag` varchar(128) NOT NULL,
  `callid` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1743 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logaddr
-- ----------------------------
INSERT INTO `logaddr` VALUES ('1712', 'webrtc9-163.com@WebRTC', '982854d2081821a6db8e3445900d81f7', '788552706', '982854d2081821a6db8e3445900d81f7982854d2081821a6db8e3445900d81f7');
INSERT INTO `logaddr` VALUES ('1718', 'webrtc10-163.com@WebRTC', 'f6a554c58e8198c049b40d5e86aba327', '1322100290', 'f6a554c58e8198c049b40d5e86aba327f6a554c58e8198c049b40d5e86aba327');
INSERT INTO `logaddr` VALUES ('1716', 'webrtc8-163.com@WebRTC', '0a957e0dba7fff3f1a60db796b3f8b73', '394961652', '0a957e0dba7fff3f1a60db796b3f8b730a957e0dba7fff3f1a60db796b3f8b73');
INSERT INTO `logaddr` VALUES ('1267', 'S1dm', '1600296932', '36467956b5e2147d2dc02e2371a09f71', '36467956b5e2147d2dc02e2371a09f7136467956b5e2147d2dc02e2371a09f71');
INSERT INTO `logaddr` VALUES ('1317', 'webrtc7-163.com@WebRTC', 'fdb59166a3a036c0338449c8721cc454', '13888021', 'fdb59166a3a036c0338449c8721cc454fdb59166a3a036c0338449c8721cc454');
INSERT INTO `logaddr` VALUES ('1740', 'webrtc4-163.com@WebRTC', '1c6d371eeab6ad5d2c88822242dc0655', '477237329', '1c6d371eeab6ad5d2c88822242dc06551c6d371eeab6ad5d2c88822242dc0655');
INSERT INTO `logaddr` VALUES ('1693', 'msml', 'f727c360-93f76d0a-13c4-50022-3c105-3a4a0aca-3c105', '218976600', '2baa6db320ed1204dec72876e3fe76452baa6db320ed1204dec72876e3fe7645');
INSERT INTO `logaddr` VALUES ('1720', 'webrtc1-163.com@WebRTC', 'e18d7e2af0192373ef78bf5056410a90', '2103587597', 'e18d7e2af0192373ef78bf5056410a90e18d7e2af0192373ef78bf5056410a90');
INSERT INTO `logaddr` VALUES ('1742', 'webrtc5-163.com@WebRTC', '70f5a91023f312edf9ba2f2044742ecf', '54273004', '70f5a91023f312edf9ba2f2044742ecf70f5a91023f312edf9ba2f2044742ecf');

-- ----------------------------
-- Table structure for `reservation_conf`
-- ----------------------------
DROP TABLE IF EXISTS `reservation_conf`;
CREATE TABLE `reservation_conf` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `theme` varchar(50) DEFAULT NULL,
  `roomid` varchar(50) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `creator` varchar(50) NOT NULL,
  `reservation_time` datetime NOT NULL,
  `cycle` tinyint(4) DEFAULT NULL,
  `duration` int(4) unsigned DEFAULT NULL,
  `member_num` tinyint(4) unsigned DEFAULT NULL,
  `members` varchar(128) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `confname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=905 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation_conf
-- ----------------------------
INSERT INTO `reservation_conf` VALUES ('808', 'theme', '1234', '1', 'webrtc1-163.com@WebRTC', '2017-03-01 11:32:18', '1', '20', '0', '', '1', null, 'WebRTC会议');
INSERT INTO `reservation_conf` VALUES ('814', 'theme', 'qCXO', '1', 'webrtc10-163.com@WebRTC', '2017-01-01 21:06:11', '0', '20', '0', '', '1', null, '春游会议');
INSERT INTO `reservation_conf` VALUES ('828', 'theme', 'Bp7L', '1', 'webrtc4-163.com@WebRTC', '2017-02-04 22:50:16', '0', '1', '0', '', '1', null, '茶话会');
INSERT INTO `reservation_conf` VALUES ('830', 'theme', 'MkLy', '1', 'webrtc10-163.com@WebRTC', '2018-06-01 12:00:00', '0', '20', '0', '', '1', null, '派对会议');
INSERT INTO `reservation_conf` VALUES ('831', 'theme', 'ogll', '1', 'webrtc10-163.com@WebRTC', '2018-11-24 12:00:00', '0', '20', '0', '', '1', null, '欢迎会');
INSERT INTO `reservation_conf` VALUES ('832', 'theme', 'LHut', '1', 'webrtc10-163.com@WebRTC', '2019-06-22 12:00:00', '0', '20', '0', '', '1', null, '委员会');
INSERT INTO `reservation_conf` VALUES ('833', 'theme', 'waPr', '1', 'webrtc10-163.com@WebRTC', '2016-05-01 12:00:00', '0', '20', '0', '', '0', null, '顾问会');
INSERT INTO `reservation_conf` VALUES ('843', 'theme', 'Fb5v', '1', 'webrtc10-163.com@WebRTC', '2016-04-15 21:17:58', '0', '20', '0', '', '0', null, 'WebRTC1');
INSERT INTO `reservation_conf` VALUES ('844', 'theme', 'b1Xa', '1', 'webrtc10-163.com@WebRTC', '2016-04-15 21:18:31', '0', '20', '0', '', '0', null, 'WebRTC2');
INSERT INTO `reservation_conf` VALUES ('842', 'theme', 'umBD', '1', 'webrtc10-163.com@WebRTC', '2016-04-15 20:22:21', '0', '20', '3', 'webrtc1-163.com@WebRTC#webrtc2-163.com@WebRTC#webrtc9-163.com@WebRTC', '0', '2016-04-15 20:40:47', 'WebRTC3');
INSERT INTO `reservation_conf` VALUES ('845', 'theme', '6O7H', '1', 'webrtc10-163.com@WebRTC', '2016-04-15 21:20:51', '0', '20', '0', 'webrtc1-163.com@WebRTC#webrtc2-163.com@WebRTC#webrtc9-163.com@WebRTC', '0', '2016-04-15 21:37:35', 'WebRTC4');
INSERT INTO `reservation_conf` VALUES ('846', 'theme', 'e2ky', '1', 'webrtc10-163.com@WebRTC', '2016-04-15 21:20:57', '0', '20', '0', '', '0', '2016-04-15 21:37:39', 'WebRTC5');
INSERT INTO `reservation_conf` VALUES ('874', 'theme', 'kD4J', '1', 'webrtc9-163.com@WebRTC', '2016-04-17 22:00:21', '0', '7', '0', '', '0', '2016-04-17 22:20:38', 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('900', 'theme', 'd3JR', '1', 'webrtc4-163.com@WebRTC', '2016-05-08 16:52:33', '0', '20', '0', '', '0', '2016-05-08 17:14:50', 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('878', 'theme', 'ESDH', '1', 'webrtc4-163.com@WebRTC', '2016-04-17 22:12:49', '0', '6', '0', '', '0', null, 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('894', 'theme', 'p0fW', '1', 'webrtc5-163.com@WebRTC', '2016-05-07 17:24:04', '0', '20', '0', '', '0', '2016-05-07 17:40:03', 'ä½ å¥½');
INSERT INTO `reservation_conf` VALUES ('895', 'theme', 'jOJY', '1', 'webrtc5-163.com@WebRTC', '2016-05-07 17:36:42', '0', '20', '0', '', '0', null, 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('896', 'theme', 'zIbs', '1', 'webrtc5-163.com@WebRTC', '2016-05-07 17:36:57', '0', '20', '0', '', '0', null, 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('897', 'theme', 'nBsK', '1', 'webrtc5-163.com@WebRTC', '2016-05-07 17:37:27', '0', '20', '0', '', '0', null, 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('898', 'theme', 'pWFV', '1', 'webrtc5-163.com@WebRTC', '2016-05-07 17:38:07', '0', '20', '0', '', '0', null, 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('899', 'theme', '8qgK', '1', 'webrtc5-163.com@WebRTC', '2016-05-07 17:39:00', '0', '20', '0', '', '0', null, 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('901', 'theme', 'Y0GN', '1', 'webrtc4-163.com@WebRTC', '2016-05-08 17:06:07', '0', '20', '0', '', '0', '2016-05-08 17:22:10', 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('902', 'theme', '7ZXb', '1', 'webrtc4-163.com@WebRTC', '2016-05-08 17:07:25', '0', '20', '0', '', '0', '2016-05-08 17:30:14', 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('903', 'theme', 'oeUy', '1', 'webrtc4-163.com@WebRTC', '2016-05-08 17:14:32', '0', '20', '0', '', '0', '2016-05-08 17:30:29', 'WebRTC');
INSERT INTO `reservation_conf` VALUES ('904', 'theme', '3Hl6', '1', 'webrtc5-163.com@WebRTC', '2016-05-08 17:14:57', '0', '20', '0', '', '0', '2016-05-08 17:31:05', 'WebRTC');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomid` varchar(64) NOT NULL COMMENT '房间ID',
  `confid` varchar(64) DEFAULT NULL COMMENT '会议ID',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `member_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '在线人数',
  `create_at` datetime DEFAULT NULL COMMENT '会议创建时间',
  `description` varchar(60) DEFAULT NULL COMMENT '会议描述',
  `type` tinyint(4) DEFAULT NULL,
  `duration` int(4) unsigned DEFAULT NULL,
  `theme` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`roomid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('175W', 'conf:xms.localdomain-27-20000', 'webrtc10-163.com@WebRTC', '0', '2016-04-14 21:24:46', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('1yrC', 'conf:xms.localdomain-23-20002', 'webrtc8-163.com@WebRTC', '0', '2016-04-17 17:39:24', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('2aqj', 'conf:xms.localdomain-33-20003', 'webrtc10-163.com@WebRTC', '0', '2016-04-14 22:05:35', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('3Hl6', 'conf:xms.localdomain-58-20002', 'webrtc5-163.com@WebRTC', '0', '2016-05-08 17:30:57', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('3xQZ', 'conf:xms.localdomain-33-20001', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 18:25:37', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('6dGb', 'conf:xms.localdomain-25-20000', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 17:53:35', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('6O7H', 'conf:xms.localdomain-15-20002', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 21:37:32', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('7FFV', 'conf:xms.localdomain-8-20003', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 12:30:56', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('7LSm', 'conf:xms.localdomain-24-20003', 'webrtc8-163.com@WebRTC', '0', '2016-04-17 17:45:58', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('7qnU', 'conf:xms.localdomain-32-20000', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 18:17:32', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('7ZXb', 'conf:xms.localdomain-56-20001', 'webrtc4-163.com@WebRTC', '0', '2016-05-08 17:23:21', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('8gmH', 'conf:xms.localdomain-51-20000', 'webrtc5-163.com@WebRTC', '0', '2016-05-07 17:34:21', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('8HwV', 'conf:xms.localdomain-9-20000', 'webrtc4-163.com@WebRTC', '0', '2016-04-15 18:12:25', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('9Q1s', 'conf:xms.localdomain-31-20002', 'webrtc10-163.com@WebRTC', '0', '2016-04-14 21:55:52', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('9qxs', 'conf:xms.localdomain-18-20001', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 21:38:23', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('aLTf', 'conf:xms.localdomain-39-20003', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 22:09:01', null, '1', '7', 'theme');
INSERT INTO `room` VALUES ('Bp7L', 'conf:xms.localdomain-7-20003', 'webrtc4-163.com@WebRTC', '0', '2016-04-14 23:07:03', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('BUAh', 'conf:xms.localdomain-45-20000', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 22:44:14', null, '1', '9', 'theme');
INSERT INTO `room` VALUES ('CrpX', 'conf:xms.localdomain-21-20000', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 21:38:37', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('d3JR', 'conf:xms.localdomain-54-20002', 'webrtc4-163.com@WebRTC', '0', '2016-05-08 17:08:29', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('DL50', 'conf:xms.localdomain-49-20003', 'webrtc5-163.com@WebRTC', '0', '2016-05-07 17:29:52', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('e2ky', 'conf:xms.localdomain-16-20003', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 21:37:38', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('Eii1', 'conf:xms.localdomain-37-20002', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 20:44:33', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('GcaL', 'conf:xms.localdomain-28-20001', 'webrtc10-163.com@WebRTC', '0', '2016-04-14 21:32:11', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('hX5y', 'conf:xms.localdomain-52-20001', 'webrtc5-163.com@WebRTC', '0', '2016-05-07 17:39:40', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('JEhe', 'conf:xms.localdomain-26-20001', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 17:54:53', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('jjZk', 'conf:xms.localdomain-48-20001', 'webrtc5-163.com@WebRTC', '0', '2016-05-07 17:28:23', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('jwAY', 'conf:xms.localdomain-19-20002', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 21:38:27', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('kD4J', 'conf:xms.localdomain-41-20002', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 22:16:57', null, '1', '7', 'theme');
INSERT INTO `room` VALUES ('llIM', 'conf:xms.localdomain-50-20002', 'webrtc5-163.com@WebRTC', '0', '2016-05-07 17:31:17', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('MUt5', 'conf:xms.localdomain-17-20000', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 21:37:44', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('N3kz', 'conf:xms.localdomain-27-20002', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 17:55:37', null, '1', '6', 'theme');
INSERT INTO `room` VALUES ('nmn8', 'conf:xms.localdomain-20-20003', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 21:38:31', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('oeUy', 'conf:xms.localdomain-57-20003', 'webrtc4-163.com@WebRTC', '0', '2016-05-08 17:30:28', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('p0fW', 'conf:xms.localdomain-53-20003', 'webrtc5-163.com@WebRTC', '0', '2016-05-07 17:40:01', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('p5I9', 'conf:xms.localdomain-6-20003', 'webrtc4-163.com@WebRTC', '0', '2016-04-14 22:57:16', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('pKKX', 'conf:xms.localdomain-31-20002', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 18:17:24', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('pOSa', 'conf:xms.localdomain-10-20001', 'webrtc4-163.com@WebRTC', '0', '2016-04-15 20:22:10', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('q6bU', 'conf:xms.localdomain-12-20003', 'webrtc4-163.com@WebRTC', '0', '2016-04-15 20:31:09', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('q8Ih', 'conf:xms.localdomain-46-20002', 'webrtc4-163.com@WebRTC', '0', '2016-04-18 19:47:12', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('qCXO', 'conf:xms.localdomain-26-20001', 'webrtc10-163.com@WebRTC', '0', '2016-04-14 20:58:49', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('qljt', 'conf:xms.localdomain-47-20000', 'webrtc10-163.com@WebRTC', '0', '2016-04-24 20:30:48', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('qSHr', 'conf:xms.localdomain-3-20002', 'webrtc4-163.com@WebRTC', '0', '2016-04-14 22:19:05', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('RTBE', 'conf:xms.localdomain-44-20002', 'webrtc4-163.com@WebRTC', '0', '2016-04-17 22:38:31', null, '1', '6', 'theme');
INSERT INTO `room` VALUES ('S6Mb', 'conf:xms.localdomain-35-20000', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 18:29:31', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('SNzz', 'conf:xms.localdomain-24-20001', 'webrtc1-163.com@WebRTC', '0', '2016-04-14 15:54:05', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('TEJz', 'conf:xms.localdomain-34-20002', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 18:29:03', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('UbWU', 'conf:xms.localdomain-42-20000', 'webrtc4-163.com@WebRTC', '0', '2016-04-17 22:28:38', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('uC3x', 'conf:xms.localdomain-5-20003', 'webrtc4-163.com@WebRTC', '0', '2016-04-14 22:24:10', null, '1', '1', 'theme');
INSERT INTO `room` VALUES ('umBD', 'conf:xms.localdomain-14-20001', 'webrtc10-163.com@WebRTC', '0', '2016-04-15 20:39:02', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('v7Cu', 'conf:xms.localdomain-11-20002', 'webrtc4-163.com@WebRTC', '0', '2016-04-15 20:28:31', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('VlJH', 'conf:xms.localdomain-13-20000', 'webrtc4-163.com@WebRTC', '0', '2016-04-15 20:34:07', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('Xkbh', 'conf:xms.localdomain-30-20001', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 18:00:52', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('Y0GN', 'conf:xms.localdomain-55-20000', 'webrtc4-163.com@WebRTC', '0', '2016-05-08 17:22:04', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('zIeb', 'conf:xms.localdomain-25-20000', 'webrtc1-163.com@WebRTC', '0', '2016-04-14 16:08:52', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('zquw', 'conf:xms.localdomain-23-20000', 'webrtc1-163.com@WebRTC', '0', '2016-04-14 15:51:26', null, '1', '20', 'theme');
INSERT INTO `room` VALUES ('zsEm', 'conf:xms.localdomain-29-20000', 'webrtc9-163.com@WebRTC', '0', '2016-04-17 18:00:37', null, '1', '20', 'theme');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT '-1',
  `email` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `profile_image_url` varchar(100) DEFAULT NULL,
  `screen_name` varchar(50) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email_work` varchar(50) DEFAULT NULL,
  `email_home` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `phone_work` varchar(20) DEFAULT NULL,
  `phone_home` varchar(20) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `msn` varchar(50) DEFAULT NULL,
  `microblog` varchar(100) DEFAULT NULL,
  `blog` varchar(100) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `email_extend` tinyint(4) DEFAULT '-1' COMMENT '鏄?惁鍦╡mail鎵╁睍琛ㄩ噷鏈変俊鎭',
  `phone_extend` tinyint(4) DEFAULT '-1' COMMENT '鏄?惁鍦╬hone鎵╁睍琛ㄩ噷鏈変俊鎭',
  `all_extend` tinyint(4) DEFAULT '-1',
  `extend` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('47', '36', 'admin@free4lab.com', 'admin', '57bb2c24-a98e-4411-b28d-b8e657f8f428', '', null, null, null, '', null, null, '', '', null, null, null, '40', '-1', '-1', '-1', null);

-- ----------------------------
-- Table structure for `webrtc_user`
-- ----------------------------
DROP TABLE IF EXISTS `webrtc_user`;
CREATE TABLE `webrtc_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webrtc_user
-- ----------------------------
INSERT INTO `webrtc_user` VALUES ('1', 'rzl', '2.2.2.2', 'zlren2012@163.com', '-1');
