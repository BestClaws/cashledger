
insert into ledger_record (id, amount, remarks, created, updated)
values(1000, 0, 'one hundred', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into TAG(tag_name, frequency)
values ( 'one', 1.0 ),
       ('hundred', 1.0);