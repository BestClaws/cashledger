drop table if exists ledger_record;
drop table if exists tag;
drop sequence if exists  ledger_record_seq;

create sequence  if not exists ledger_record_seq increment by 50;


create table if not exists ledger_record (
    id int primary key not null,
    amount float not null,
    remarks character varying,
    created timestamp,
    updated timestamp
);


create table if not exists tag (
    tag_name character varying primary key not null,
    frequency float not null
);