insert into roles (id, name) values (1, 'USER');
insert into roles (id, name) values (2, 'ADMIN');

insert into account (id, create_date, email, name, nick_name, passwd)
 values(1, now(), 'urstory@gmail.com', 'kim', 'toto', '1234');

insert into account (id, create_date, email, name, nick_name, passwd)
 values(2, now(), 'carami@gmail.com', 'kang', 'carami', '1234');

insert into account_roles(account_id, role_id) values( 1, 1);
insert into account_roles(account_id, role_id) values( 2, 1);
insert into account_roles(account_id, role_id) values( 1, 2);

