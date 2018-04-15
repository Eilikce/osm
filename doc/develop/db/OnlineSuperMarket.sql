-- Eilikce Online Super Market Project for MySql 

-- create database eilikce default character set utf8;

-- use eilikce;

drop table ADMIN;
drop table RECORD_ORDER;
drop table RECORD_ORDER_COMMODITY;
drop table ACCOUNT;
drop table CONSUMER;
drop table COMMODITY_GROUP;
drop table COMMODITY_ITEM;
drop table COMMODITY;

-- 用户表
create table CONSUMER(
	consumer_id		varchar(100)			PRIMARY KEY,							-- 用户id
	extra_id				varchar(100)								 UNIQUE,							-- 额外id预留，可为空，不可重复（如微信号）
	addr					varchar(100) 		NOT NULL, 											-- 地址
	name        			varchar(30) 			NOT NULL,											-- 用户姓名
	phone        			varchar(30) 			NOT NULL											    -- 联系电话(初步设计只有一个)
);

-- 商品分类概览表
create table COMMODITY_GROUP(
	group_id			int 							PRIMARY KEY,							-- 大类id
	group_name		varchar(20)			NOT NULL	 UNIQUE							-- 大类名称
);

-- 商品分类详细表
create table COMMODITY_ITEM(
	group_id		int							NOT NULL,											-- 大类id（外键，可重复）
	item_id			int							NOT NULL,											-- 品类id
	item_name	varchar(20)			NOT NULL,											-- 品类名称
	img_name		varchar(20)			NOT NULL,											-- 品类图片名称（000001.jpg）
	img_src			varchar(100)			NOT NULL,												-- 品类图片路径
	PRIMARY KEY (group_id,item_id)
);

-- 商品表
create table COMMODITY(
	commodity_id				varchar(100)				PRIMARY KEY,							-- 商品id
	group_id						int								NOT NULL ,											-- 大类id（外键，可重复）
	item_id							int								NOT NULL ,											-- 品类id（外键，可重复）
	barcode							int														UNIQUE,						-- 条形码，可为空，必须唯一
	commodity_name		varchar(100) 			NOT NULL,											-- 商品名称
	commodity_detail		varchar(500)										DEFAULT '',					-- 商品详情
	img_rule							varchar(50)				NOT NULL,											-- 图片规则
	number							int 								NOT NULL,											-- 存货数
	original							float							NOT NULL,											-- 进价
	price								float							NOT NULL,											-- 售价
	unit									varchar(10)				NOT NULL,											-- 单位：个/斤
	source							varchar(100)										DEFAULT '',					-- 进货渠道
	detail								varchar(500)										DEFAULT '',					-- 备注信息
	sales_volume				int								NOT NULL		DEFAULT 0,					-- 销量
	shelves							int								NOT NULL		DEFAULT 1,					-- 是否上架，0/1
	create_date					datetime					NOT NULL												-- 商品创建日期，精确到日
);


-- 订单表
create table RECORD_ORDER(
	order_id								varchar(50)			PRIMARY KEY,						-- 订单号id
	total_cost							float						NOT NULL,											-- 订单成本
	total_price							float						NOT NULL,											-- 订单总价
	total_profit						float						NOT NULL,											-- 订单利润（总利润）
	consumer_addr				varchar(100) 		NOT NULL,											-- 用户地址（历史记录）
	consumer_name				varchar(30) 			NOT NULL,											-- 用户姓名（历史记录）
	consumer_phone				varchar(30) 			NOT NULL,											-- 用户电话（历史记录）
	consumer_id						varchar(100)			NOT NULL,											-- 用户id（可用于获取最新信息）
	payment_status				int							NOT NULL		DEFAULT 0,					-- 订单支付状态。0未支付/1已支付
	order_invalid						int							NOT NULL		DEFAULT 1,					-- 有效标识，是否消单。0消单/1订单有效
	order_cancel_detail			varchar(100)									DEFAULT '',					-- 消单备注
	order_date						datetime				NOT NULL												-- 订单时间
);

-- 订单商品表
create table RECORD_ORDER_COMMODITY(
	order_commodity_id		varchar(50)			PRIMARY KEY,						-- 订单商品id
	order_id								varchar(50)			NOT NULL,											-- 订单号id（可重复外键）
	commodity_name			varchar(100) 		NOT NULL,											-- 商品名称（历史记录）
	commodity_detail			varchar(500)									DEFAULT '',					-- 商品详情（历史记录）
	barcode								int,																							-- 商品条形码（历史记录）
	unit										varchar(10)			NOT NULL,											-- 商品单位（历史记录）
	original								float						NOT NULL,											-- 商品进价（历史记录）
	price									float						NOT NULL,											-- 商品售价（历史记录）
	profit									float						NOT NULL,											-- 商品利润（历史记录）（单个利润）
	sales_volume					int							NOT NULL		DEFAULT 1,					-- 销售数量
	sales_date							datetime				NOT NULL												-- 销售时间
);

-- 账单表
create table ACCOUNT(
	account_id							varchar(50)			PRIMARY KEY,						-- 账单账目id
	order_id								varchar(50)			NOT NULL,											-- 订单号id（可重复）
	order_commodity_id		varchar(50)			NOT NULL,											-- 订单商品id（可重复）
	commodity_id					varchar(100)			NOT NULL,											-- 商品id（可重复）
	commodity_name			varchar(100) 		NOT NULL,											-- 商品名称
	barcode								int,																							-- 商品条形码
	unit										varchar(10)			NOT NULL,											-- 商品单位
	original								float						NOT NULL,											-- 商品进价
	price									float						NOT NULL,											-- 商品售价
	profit									float						NOT NULL,											-- 商品利润（单商品利润）
	sales_volume					int							NOT NULL		DEFAULT 0,					-- 销售数量。
	account_original				float						NOT NULL,											--	入账金额，总进价
	account_price					float						NOT NULL,											--	入账金额，总售价
	account_profit					float						NOT NULL,											--	入账金额，总利润。
	account_detail					varchar(500)									DEFAULT '',					-- 账目备注（可为空）
	account_date					datetime				NOT NULL												-- 入账时间
);

-- 进货账单表

-- 其他开销账单表。水电，工资，税务，其他

-- 管理员表
create table ADMIN(
	id						int							PRIMARY KEY AUTO_INCREMENT,
	user_name		varchar(20)			NOT NULL UNIQUE,								-- 用户名
	password		varchar(20)			NOT NULL,												-- 密码
	permissions	varchar(10)			NOT NULL													-- 权限 root/admin
);


insert into ADMIN values (null,"root","123","root");

insert into RECORD_ORDER values("AAAA",200,300,100,"用户历史地址","用户历史姓名","用户电话","用户ID1",1,1,"",now());
insert into RECORD_ORDER values("BBBB",3,5,3,"用户历史地址","用户历史姓名","用户电话","用户ID2",0,0,"消单原因",now());
insert into RECORD_ORDER values("CCCC",3,5,3,"用户历史地址","用户历史姓名","用户电话","用户ID2",0,0,"消单原因",now());
insert into RECORD_ORDER values("DDDD",3,5,3,"用户历史地址","用户历史姓名","用户电话","用户ID2",0,0,"消单原因",now());
insert into RECORD_ORDER values("EEEE",3,5,3,"用户历史地址","用户历史姓名","用户电话","用户ID2",0,0,"消单原因",now());
insert into RECORD_ORDER values("FFFF",3,5,3,"用户历史地址","用户历史姓名","用户电话","用户ID2",0,0,"消单原因",now());

insert into RECORD_ORDER_COMMODITY values("AAAA11111","AAAA","商品历史名称","商品历史详情",123456,"袋",50,110,60,3,now());
insert into RECORD_ORDER_COMMODITY values("BBBB22222","BBBB","商品历史名称","商品历史详情",654321,"袋",66,77,11,10,now());
insert into RECORD_ORDER_COMMODITY values("BBBB33333","BBBB","商品历史名称","商品历史详情",777777,"袋",66,77,11,10,now());


insert into COMMODITY_GROUP values (1,"米面粮油");
insert into COMMODITY_GROUP values (2,"洗护用品");
insert into COMMODITY_GROUP values (3,"休闲食品");
insert into COMMODITY_GROUP values (4,"啤酒饮料");
insert into COMMODITY_GROUP values (5,"味精调料");
insert into COMMODITY_GROUP values (6,"工具厨具");
insert into COMMODITY_GROUP values (7,"日用品");
insert into COMMODITY_GROUP values (8,"计生用品");

insert into COMMODITY_ITEM values (1,1,"食用油","1_1_item.png","commodity_item");
insert into COMMODITY_ITEM values (1,2,"大米","1_2_item.png","commodity_item");
insert into COMMODITY_ITEM values (1,3,"白面","1_3_item.png","commodity_item");
insert into COMMODITY_ITEM values (1,4,"高粱米","1_4_item.png","commodity_item");
insert into COMMODITY_ITEM values (2,1,"洗发露","2_1_item.png","commodity_item");
insert into COMMODITY_ITEM values (2,2,"香皂","2_2_item.png","commodity_item");
insert into COMMODITY_ITEM values (3,1,"薯片","3_1_item.png","commodity_item");
insert into COMMODITY_ITEM values (3,2,"糖果","3_2_item.png","commodity_item");
insert into COMMODITY_ITEM values (3,3,"干果","3_3_item.png","commodity_item");
insert into COMMODITY_ITEM values (3,4,"方便面","3_4_item.png","commodity_item");
insert into COMMODITY_ITEM values (4,1,"啤酒","4_1_item.png","commodity_item");
insert into COMMODITY_ITEM values (4,2,"汽水","4_2_item.png","commodity_item");
insert into COMMODITY_ITEM values (5,1,"调料","5_1_item.png","commodity_item");
insert into COMMODITY_ITEM values (6,1,"餐具","6_1_item.png","commodity_item");
insert into COMMODITY_ITEM values (7,1,"卫生纸","7_1_item.png","commodity_item");
insert into COMMODITY_ITEM values (7,2,"清洁用品","7_2_item.png","commodity_item");
insert into COMMODITY_ITEM values (8,1,"避孕套","8_1_item.png","commodity_item");

insert into COMMODITY values ("11111",1,1,null,"鲁花花生油","鲁花花生油 详细","main",100,1.5,2.5,"个","批发市场","测试进货",0,1,now());
insert into COMMODITY values ("22222",1,1,null,"金龙鱼调和油 原味","金龙鱼调和油 原味 详细","main",100,3,6.3,"个","批发市场","测试进货",5,1,now());
insert into COMMODITY values ("33333",1,2,null,"东北大米","东北大米 详细资料","main",100,5.5,8,"个","网购","测试进货",0,1,now());
insert into COMMODITY values ("444",1,3,null,"超级面粉 精装版","超级面粉 精装版 详细","main",100,4.5,7,"个","网购","测试进货",0,1,now());
insert into COMMODITY values ("555",1,4,null,"稻花高粱米","稻花高粱米 详细资料","main",100,5.5,8,"个","网购","测试进货",0,1,now());
insert into COMMODITY values ("666",2,1,null,"海飞丝 洗发露","海飞丝 洗发露 榛子味","main",100,5.5,8,"个","网购","测试进货",0,1,now());
insert into COMMODITY values ("77",2,2,null,"佳洁士香皂","佳洁士香皂","main",100,1.1,9.9,"个","网购","测试进货",0,1,now());
insert into COMMODITY values ("88",3,1,null,"曼秀雷敦","曼秀雷敦","main",100,1.1,9.9,"个","网购","测试进货",0,1,now());



