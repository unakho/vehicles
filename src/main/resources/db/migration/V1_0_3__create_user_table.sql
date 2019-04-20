--drop table if exists "assets_schema"."user";
create table if not exists "assets_schema"."user"("id" UUID not null, "id_number" Character varying(16),
    "name" Character varying(25), "last_name" Character varying(25),
    "msisdn" Character varying(20), "network" Character varying(10),  "points" integer,
    "card_number" Character varying(20), "gender" integer, "license_id" UUID not null,
    constraint pk_user_id PRIMARY KEY("id"), foreign key("license_id")
            references "assets_schema"."license"("id"));

create index if not exists "id_number_uk" on "assets_schema"."user" using btree("id_number");