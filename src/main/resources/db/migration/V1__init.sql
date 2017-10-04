CREATE TABLE TOPIC (
	id BIGINT,
	name varchar(255) not null,
	content varchar(255) not null,
	ts TIMESTAMP not null
);

create sequence hibernate_sequence start with 1 increment by 1;

insert into TOPIC (id, name, content, ts) values (nextval('hibernate_sequence'), 'top1', 'content1', CURRENT_TIMESTAMP);
insert into TOPIC (id, name, content, ts) values (nextval('hibernate_sequence'), 'top2', 'content2', CURRENT_TIMESTAMP);