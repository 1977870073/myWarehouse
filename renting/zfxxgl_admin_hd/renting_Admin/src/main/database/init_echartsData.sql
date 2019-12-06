--用途：改变后台发布房源、用户发布房源和收藏的数据，使echarts数据好看点。

--初始化后台发布房源数据
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 6 day) where id in (select id from (select * from rent_houseinfo where user_type=0 and flag=1 limit 0,60) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 5 day) where id in (select id from (select * from rent_houseinfo where user_type=0 and flag=1 limit 60,66) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 4 day) where id in (select id from (select * from rent_houseinfo where user_type=0 and flag=1 limit 126,57) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 3 day) where id in (select id from (select * from rent_houseinfo where user_type=0 and flag=1 limit 183,36) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 2 day) where id in (select id from (select * from rent_houseinfo where user_type=0 and flag=1 limit 219,28) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 1 day) where id in (select id from (select * from rent_houseinfo where user_type=0 and flag=1 limit 247,41) a);
update rent_houseinfo set doTime = date_format(now(),'%Y-%m-%d') where id in (select id from (select * from rent_houseinfo where user_type=0 and flag=1 limit 288,30) a);
--初始化用户发布房源数据
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 6 day) where id in (select id from (select * from rent_houseinfo where user_type=1 and flag=1 limit 0,1) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 5 day) where id in (select id from (select * from rent_houseinfo where user_type=1 and flag=1 limit 1,14) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 4 day) where id in (select id from (select * from rent_houseinfo where user_type=1 and flag=1 limit 15,40) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 3 day) where id in (select id from (select * from rent_houseinfo where user_type=1 and flag=1 limit 55,56) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 2 day) where id in (select id from (select * from rent_houseinfo where user_type=1 and flag=1 limit 111,39) a);
update rent_houseinfo set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 1 day) where id in (select id from (select * from rent_houseinfo where user_type=1 and flag=1 limit 150,14) a);
update rent_houseinfo set doTime = date_format(now(),'%Y-%m-%d') where id in (select id from (select * from rent_houseinfo where user_type=1 and flag=1 limit 164,2) a);

--初始化收藏数据
update user_collection set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 6 day) where id in (select id from (select * from user_collection limit 0,1) a);
update user_collection set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 5 day) where id in (select id from (select * from user_collection limit 1,2) a);
update user_collection set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 4 day) where id in (select id from (select * from user_collection limit 3,3) a);
update user_collection set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 3 day) where id in (select id from (select * from user_collection limit 6,5) a);
update user_collection set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 2 day) where id in (select id from (select * from user_collection limit 11,20) a);
update user_collection set doTime = date_sub(date_format(now(),'%Y-%m-%d'),interval 1 day) where id in (select id from (select * from user_collection limit 31,53) a);
update user_collection set doTime = date_format(now(),'%Y-%m-%d') where id in (select id from (select * from user_collection limit 84,42) a);
--插入收藏数据
delimiter $$
create procedure pre()
begin
declare i int;
set i=141;
while i< 180 do
	INSERT INTO `renting`.`user_collection` (`user`, `house`, `flag`, `doTime`) VALUES ('123456789', i, '0', date_format(now(),'%Y-%m-%d'));
set i=i+1;
end while;
end $$

call pre();
drop procedure pre;