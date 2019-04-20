--drop table if exists "assets_schema"."profile"
create table if not exists "assets_schema"."profile"("id" uuid not null,
  "user_id" uuid not null, "types_id" uuid default null,
  "value" Character varying(100) not null,  primary key("id"),
  foreign key("user_id") references "assets_schema"."user"("id"), foreign key("types_id")
  references "assets_schema"."types"("id"));

