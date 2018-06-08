CREATE TABLE tuser(id number(20) GENERATED BY DEFAULT ON NULL as IDENTITY, id_number varchar2(20), first_names varchar2(25),
    last_name varchar2(25), msisdn varchar2(20), network varchar2(10),  points number(8),
    card_number varchar2(20), gender varchar2(1), constraint pk_user_id PRIMARY KEY(id));

CREATE UNIQUE INDEX id_number_uk ON tuser(id_number);
CREATE SEQUENCE user_seq START WITH 1;