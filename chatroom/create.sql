#消息表设计
CREATE TABLE `message` (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息id，自增长',
  userID int(11) not null comment '消息接收者',
  `msg_type` char(1) DEFAULT NULL COMMENT '类型 S=文字、F=文件、A=申请',
  `create_date` date DEFAULT NULL COMMENT '消息发送日期',
  `talkerID` int(11) DEFAULT NULL COMMENT '发信人ID/申请人ID',
  `talker_type` char(1) DEFAULT NULL COMMENT '消息来源：来自群聊时为G、来自朋友时为F',
  `groupID` int(11) DEFAULT NULL COMMENT '若消息来自群聊，则查看这一行',
  `content` text COMMENT '若为文本消息则存储消息本身、若为文件则存储在服务器文件系统中，并存储文件存储的路径',
  isAccept char(1) not null comment 'T=已查看、F=未查看    ',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#用户表设计
create table user(
userID int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id，自增长',
username varchar(50) NOT NULL COMMENT '用户名',
password varchar(50) NOT NULL COMMENT '密码',
mail varchar(50) NOT NULL COMMENT '电子邮箱',
online char(1) NOT NULL COMMENT '在线状态，T=在线、F=下线',
primary key(userID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#朋友表设计
create table friend(
fromID int(11) NOT NULL COMMENT '用户1 id',
toID int(11) NOT NULL COMMENT '用户2 id',
shield char(1) NOT NULL COMMENT '0=无屏蔽关系，1=前者屏蔽后者，2=后者屏蔽前者，3=双向屏蔽',
from_name char(50) NOT NULL,
to_name char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#群组表设计
create table group1(
groupID int(11) NOT NULL AUTO_INCREMENT COMMENT '组id，自增长',
group_name varchar(50) NOT NULL COMMENT '组名',
ownerID int(11) NOT NULL COMMENT '群主',
primary key (groupID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#群组表设计
create table group2(
groupID int(11) NOT NULL  COMMENT '组id',
group_name varchar(50) NOT NULL COMMENT '组名',
userID int(11) NOT NULL COMMENT '成员id',
user_type char(1) NOT NULL COMMENT '0=普通成员，1=管理员，9=群主',
say char(1) not null comment 'T=可发言、F=禁言'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
