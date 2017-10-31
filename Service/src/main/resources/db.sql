#创建错误码对应表
DROP TABLE IF EXISTS `t_error`;
CREATE TABLE `t_error` (
  `errorCode` varchar(10) NOT NULL COMMENT '错误编码',
  `errorMessage` varchar(255) NOT NULL COMMENT '错误内容',
  `errorMessageClient` varchar(255) DEFAULT NULL COMMENT '客户端提示信息',
  PRIMARY KEY (`errorCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `t_error` VALUES ('EG-S-999', '系统异常', null);
INSERT INTO `t_error` VALUES ('EG-U-001', '用户名或者密码不对', null);

#创建Token表
DROP TABLE IF EXISTS `t_token`;
CREATE TABLE `t_token` (
  `id` varchar(40) NOT NULL COMMENT 'tokenId',
  `userId` int(11) NOT NULL COMMENT '用户Id\n',
  `careatTime` timestamp(3) NOT NULL DEFAULT '0000-00-00 00:00:00.000' COMMENT '创建时间',
  `updateTime` timestamp(3) NOT NULL DEFAULT '0000-00-00 00:00:00.000' COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#创建用户表 从1000开始
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(7) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `userPwd` varchar(30) NOT NULL COMMENT '密码',
  `userHeadPic` varchar(255) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4;

#图片信息表
DROP TABLE IF EXISTS `t_images_info`;
CREATE TABLE `t_images_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msgId` int(11) NOT NULL COMMENT '消息ID',
  `imageUrl` varchar(100) NOT NULL,
  `imageWidth` int(11) DEFAULT NULL,
  `iamgeHeight` int(11) DEFAULT NULL,
  `imageSize` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图片信息表';
