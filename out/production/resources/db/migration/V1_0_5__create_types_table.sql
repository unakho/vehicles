--drop table if exists "assets_schema"."types";
create table if not exists "assets_schema"."types"("id" UUID not null,
  "type" Character varying(100) not null, "cell_number" Character varying(20) not null,
  "description" Character varying(255) not null, "deleted" integer not null,
  constraint pk_types_id primary key("id"));
