CREATE TABLE SERVICECONFIG (
	id number(19,0) not null,
	host varchar(255) not null,
	port number(8,0) default 80 not null,
	url varchar(255) not null
);
ALTER TABLE SERVICECONFIG ADD CONSTRAINT serviceconfigPk PRIMARY KEY (id);

CREATE TABLE CONFIGCHANGE (
	id number(19,0) not null,
	configaction varchar(255) not null,
	create_Ts TIMESTAMP not null,
	done_Ts TIMESTAMP,
	failed number(1,0) default 0 not null,
	outcome varchar(255)
);
ALTER TABLE CONFIGCHANGE ADD CONSTRAINT configchangePk PRIMARY KEY (id);


create sequence hibernate_sequence start with 1 increment by 1;

insert into SERVICECONFIG (id, host, port, url) values (nextval('hibernate_sequence'), 'xy1.com', 8080, '/');
insert into SERVICECONFIG (id, host, port, url) values (nextval('hibernate_sequence'), 'xy2.com', 80, '/service2');