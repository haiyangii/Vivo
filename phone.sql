create database phone default character set utf8 collate utf8_bin;
drop table admininfo;
drop table addrinfo;
drop table phonetype;

create table admininfo(
   aid int(11) primary key auto_increment,
   aname varchar(100) not null,
   pwd varchar(100) not null,
   tel varchar(15) default null unique,
   status int(11) --用1，2，3表示不同管理员
)ENGINE = InnoDB auto_increment=1 default charset=utf8 collate=utf8_bin;

create table if not exists userinfo(
    uid int(11) primary key auto_increment,
    uname varchar(100) not null,
    pwd  varchar(100) not null,
    tel varchar(15) default null unique
)ENGINE = InnoDB auto_increment = 1 default charset=utf8 collate=utf8_bin;

create table if not exists addrinfo(
    ano varchar(100) primary key,
    uid  int(11),
    aname varchar(100) not null,
    tel varchar(15),
    province varchar(15) not null,
    city varchar(15) not null,
    area varchar(15) not null,
    addr varchar(100) not null,
    constraint FK_addrinfo_uid foreign key(uid) references userinfo(uid)
)ENGINE = InnoDB  default charset=utf8 collate=utf8_bin;

create table if not exists phonetype(
    tno int(11) primary key auto_increment,
    pname varchar(100) not null unique,
    ptype varchar(100) default null,
    color varchar(100) default null,
    pic varchar(100),
    status int not null
)ENGINE = InnoDB auto_increment=1 default charset=utf8 collate=utf8_bin;

create table if not exists phoneinfo(
    pno int(11) primary key auto_increment,
    pname varchar(100) not null unique,
    tno int(11),
    price decimal(8,2) not null,
    pics varchar(1000) default null,
    pintro varchar(500) not null,
    inventory int(11) not null,
    capacity varchar(100),
    constraint FK_phoneinfo_tno foreign key(tno) references phonetype(tno)
)ENGINE =InnoDB auto_increment = 1 default charset=utf8 collate=utf8_bin;


create table if not exists cartinfo(
   cno varchar(100) primary key,
   uid int(11) not null,
   pno int(11),
   num int(11),
   constraint FK_cartinfo_uid foreign key(uid) references userinfo(uid),
   constraint FK_cartinfo_pno foreign key(pno) references phoneinfo(pno)
)ENGINE =InnoDB default charset=utf8 collate=utf8_bin;

create table if not exists orderinfo(
    ono varchar(100) primary key,
    odate datetime DEFAULT NULL,
    ano  varchar(100) COLLATE utf8_bin DEFAULT NULL,
    sdate datetime default null,
    rdate datetime default null,
    status int(11) default null,
    price decimal(10,2)  DEFAULT NULL,
    invoce int(11)  DEFAULT NULL,
    constraint FK_orderinfo_uid foreign key(ano) references addrinfo(ano)
) ENGINE = InnoDB default charset=utf8 collate=utf8_bin;



create table if not exists orderiteminfo(
    ino int(11) primary key not null AUTO_INCREMENT,
    ono varchar(100),
    pno int(11),
    nums int(11) not null,
    price int(11) not null,
    status int(11),
    constraint FK_orderiteminfo_ono foreign key(ono) references orderinfo(ono),
    constraint FK_orderiteminfo_pno foreign key(pno) references phoneinfo(pno)
) ENGINE = InnoDB  AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;


CREATE TABLE `orderiteminfo` (
  `ino` int(11) NOT NULL AUTO_INCREMENT,
  `ono` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `gno` int(11) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ino`),
  KEY `FK_orderItemInfo_gno` (`gno`),
  KEY `FK_orderItemInfo_ono` (`ono`),
  CONSTRAINT `FK_orderItemInfo_gno` FOREIGN KEY (`gno`) REFERENCES `goodsinfo` (`gno`),
  CONSTRAINT `FK_orderItemInfo_ono` FOREIGN KEY (`ono`) REFERENCES `orderinfo` (`ono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
