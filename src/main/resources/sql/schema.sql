use voting;

DROP TABLE IF EXISTS t_user_info;
CREATE TABLE t_user_info (
    `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '账号主键',
    `email` VARCHAR(100) UNIQUE COMMENT '登录邮箱',
    `password` VARCHAR(50) NOT NULL COMMENT '密码',
    `phone` VARCHAR(11) COMMENT '手机号',
    `create_time` DATETIME,
    `update_time` DATETIME
)  ENGINE=InnoDB;

DROP TABLE IF EXISTS t_vote_theme;
CREATE TABLE t_vote_theme (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL COMMENT '创建者id',
    `title` VARCHAR(50) COMMENT '投票主题名',
    `description` VARCHAR(255) COMMENT '投票描述',
    `status` INT DEFAULT 0 COMMENT '投票状态，0-未开始，1-进行中，2-已结束',
    `start_time` DATETIME COMMENT '预设投票开始时间',
    `close_time` DATETIME COMMENT '预设结束时间，可为null,通过手动停止投票',
    `create_time` DATETIME COMMENT '创建时间',
    `update_time` DATETIME COMMENT '更新时间',
    INDEX (`user_id`)
)  ENGINE=InnoDB;

DROP TABLE IF EXISTS t_vote_title;
CREATE TABLE t_vote_title (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `theme_id` INT NOT NULL COMMENT '投票主题id',
    `title` VARCHAR(30) NOT NULL COMMENT '投票子标题',
    `type` INT NOT NULL DEFAULT 0 COMMENT '投票类型：单选-0，多选-1',
    `img_name` INT COMMENT '图片名称',
	`vote_max` INT DEFAULT 1 COMMENT '最多投票项',
    `vote_min` INT DEFAULT 1 COMMENT '最少投票项',
    `must_vote` INT DEFAULT 1 COMMENT '是否必许选择：必须选择-1， 非必须-0',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间',
	INDEX (`theme_id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS t_vote_item;
CREATE TABLE t_vote_item (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `title_id` INT NOT NULL COMMENT '投票主题id',
    `vote_no` INT NOT NULL COMMENT '投票项序号',
    `vote_desc` INT NOT NULL COMMENT '投票项描述',
    `vote_num` INT NOT NULL COMMENT '投票数',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间',
    INDEX (`title_id`)
)  ENGINE=InnoDB;

DROP TABLE IF EXISTS t_vote_log;
CREATE TABLE t_vote_log (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT COMMENT '投票者id',
    `vote_id` INT NOT NULL COMMENT '投票主题id',
    `device_id` VARCHAR(255) COMMENT '设备编号',
    `vote_item_id` INT COMMENT '投票项id',
    `anoymouse` INT DEFAULT 0 COMMENT '是否匿名:1-匿名，0-实名',
    `create_time` DATETIME NOT NULL,
    `vote_time` DATETIME NOT NULL COMMENT '投票时间',
	INDEX(`vote_id`),
    INDEX(`device_id`)
)  ENGINE=InnoDB;