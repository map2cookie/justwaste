CREATE TABLE TOPIC (
	id number(19,0) not null,
	name varchar(255) not null,
	done number(1,0) default 0 not null,
	deleted number(1,0) default 0 not null,
	create_Ts TIMESTAMP not null,
	done_Ts TIMESTAMP,
	delete_Ts TIMESTAMP
);
ALTER TABLE TOPIC
ADD CONSTRAINT topicPk PRIMARY KEY (id);


create sequence hibernate_sequence start with 1 increment by 1;

insert into TOPIC (id, name, create_Ts) values (nextval('hibernate_sequence'), 'top1', CURRENT_TIMESTAMP);
insert into TOPIC (id, name, create_Ts) values (nextval('hibernate_sequence'), 'top2', CURRENT_TIMESTAMP);