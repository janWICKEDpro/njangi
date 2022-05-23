use njangi;

-- CREATE TABLE users(
-- 	user_id int primary key,
--     user_name varchar(20),
--     user_email_address varchar(20),
--     user_password varchar(20),
--     user_balance int
-- );

-- CREATE TABLE njangi(
-- 	njangi_code varchar(5) primary key,
--     njangi_name varchar(10),
--     njangi_admin varchar(20),
--     njangi_rules varchar(100),
--     njangi_balance int
-- );

-- CREATE TABLE njangi_users(
-- 	user_id int,
--     njangi_code varchar(5),
--     foreign key (user_id) references users(user_id),
-- 	foreign key (njangi_code) references njangi(njangi_code),
-- 	primary key(user_id, njangi_code)
-- );

-- CREATE TABLE request(
-- 	user_id int ,
--     njangi_code varchar(5) ,
--     state varchar(15) default "pending",
-- 	foreign key (user_id) references users(user_id),
-- 	foreign key (njangi_code) references njangi(njangi_code),
--     primary key(user_id, njangi_code)
-- );

describe njangi;
describe users;
describe request;