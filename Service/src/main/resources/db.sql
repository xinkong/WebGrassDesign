#设置mysql支持emoji
#C:\ProgramData\MySQL\MySQL Server 5.7\my.ini
#[client]
#default-character-set=utf8mb4
#[mysql] 去掉多余的
#default-character-set=utf8mb4
#[mysqld]
#character-set-server=utf8mb4
#init_connect='SET NAMES utf8mb4'
#查看数据库字符集 SHOW VARIABLES WHERE Variable_name LIKE 'character%' OR Variable_name LIKE 'collation%';


#创建错误码对应表
DROP TABLE IF EXISTS `t_error`;
CREATE TABLE `t_error` (
  `errorCode` varchar(10) NOT NULL COMMENT '错误编码',
  `errorMessage` varchar(255) NOT NULL COMMENT '错误内容',
  `errorMessageClient` varchar(255) DEFAULT NULL COMMENT '客户端提示信息',
  PRIMARY KEY (`errorCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `t_error` VALUES ('EG-M-001', '发消息用户不存在', null);
INSERT INTO `t_error` VALUES ('EG-M-002', '不能发送空消息', null);
INSERT INTO `t_error` VALUES ('EG-M-003', '只能发送图片', null);
INSERT INTO `t_error` VALUES ('EG-S-999', '系统异常', null);
INSERT INTO `t_error` VALUES ('EG-U-001', '用户名或者密码不对', null);

#创建Token表
DROP TABLE IF EXISTS `t_token`;
CREATE TABLE `t_token` (
  `id` varchar(40) NOT NULL COMMENT 'tokenId',
  `userId` int(11) NOT NULL COMMENT '用户Id',
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

#图片信息表,废弃
DROP TABLE IF EXISTS `t_images_info`;
#CREATE TABLE `t_images_info` (
#  `id` int(11) NOT NULL AUTO_INCREMENT,
# `msgId` int(11) NOT NULL COMMENT '消息ID',
# `imageUrl` varchar(100) NOT NULL,
# `imageWidth` int(11) DEFAULT NULL,
# `iamgeHeight` int(11) DEFAULT NULL,
# `imageSize` int(11) DEFAULT NULL,
# PRIMARY KEY (`id`)
)# ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图片信息表';

#消息列表
DROP TABLE IF EXISTS `t_msg_info`;
CREATE TABLE `t_msg_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息ID',
  `userId` int(11) NOT NULL COMMENT '用户Id',
  `msgContent` text,
  `msgImages` varchar(900) DEFAULT NULL,
  `createTime` timestamp NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

#评论列表
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msgId` int(11) NOT NULL COMMENT '消息ID',
  `commentUserID` int(11) NOT NULL COMMENT '评论用户Id',
  `replyUserId` int(11) DEFAULT NULL COMMENT '回复id',
  `content` varchar(255) NOT NULL COMMENT '评论内容',
  `createTime` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

