--drop table if exists "assets_schema"."license_type";
create table if not exists "assets_schema"."license_type"("id" UUID not null,
           "code" Character varying(4), primary key(id)) ;

create index if not exists code_uk on "assets_schema"."license_type" using btree("code");