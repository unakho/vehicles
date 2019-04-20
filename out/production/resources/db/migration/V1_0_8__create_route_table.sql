--drop table if exists "assets_schema"."route";
create table if not exists "assets_schema"."route"("id" uuid not null, "user_id" uuid
   default null, "start_address" Character varying(100) not null, "end_address" Character varying(100) not null,
   "mileage" real, primary key("id"),
   foreign key("user_id") references "assets_schema"."user"("id"));