--drop table if exists "assets_schema"."license";
create table if not exists "assets_schema"."license"("id" UUID not null,
           "acquired_date" date, "expiry_date" date,
           "tickets_charged" integer, "has_pdp" integer, "license_type_id"
           UUID default null, primary key("id"), foreign key("license_type_id")
            references "assets_schema"."license_type"("id")) ;

create index if not exists acquired_date_uk on "assets_schema"."license" using btree("acquired_date");