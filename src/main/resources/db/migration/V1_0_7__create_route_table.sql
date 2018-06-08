CREATE TABLE troute(id number(20) GENERATED BY DEFAULT ON NULL as IDENTITY, user_id number(20) DEFAULT NULL, schedule_id number(20) DEFAULT NULL,
  start_address varchar2(100) NOT NULL, end_address varchar2(100) NOT NULL,  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES tuser(id), FOREIGN KEY(schedule_id) REFERENCES tschedule(id));