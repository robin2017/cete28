drop database if exists mybatis;
create database mybatis default character set utf8;
use mybatis;
-- ----------------------------
-- Table structure for pets
-- ----------------------------
DROP TABLE IF EXISTS `pets`;
CREATE TABLE `pets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `hostId` int(11) DEFAULT NULL COMMENT '主人Id',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `gender` int(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

