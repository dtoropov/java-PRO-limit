create schema if not exists java_pro;

drop table if exists java_pro.user_limit;
create table java_pro.user_limit(id bigserial, name text, value_limit numeric);


insert into java_pro.user_limit(id, name, value_limit)
values(1, 'Иван', 10000.00);

insert into java_pro.user_limit(id, name, value_limit)
values(2, 'Денис', 10000.00);

insert into java_pro.user_limit(id, name, value_limit)
values(3, 'Илья', 10000.00);


