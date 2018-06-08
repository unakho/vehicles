CREATE TABLE tlicense(id number(20) GENERATED BY DEFAULT ON NULL as IDENTITY,
  code varchar2(2) NOT NULL, expiry_date timestamp NOT NULL,
  constraint pk_license_id PRIMARY KEY(id));

CREATE UNIQUE INDEX code_uk ON tlicense(code);
