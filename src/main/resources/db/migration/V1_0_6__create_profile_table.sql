CREATE TABLE tprofile(id number(20) GENERATED BY DEFAULT ON NULL as IDENTITY, tuser_id number(20) DEFAULT NULL,
  ttypes_id number(20) DEFAULT NULL, value varchar(100) NOT NULL,
  PRIMARY KEY (id), FOREIGN KEY(tuser_id) REFERENCES tuser(id),
  FOREIGN KEY(ttypes_id) REFERENCES ttypes(id));
