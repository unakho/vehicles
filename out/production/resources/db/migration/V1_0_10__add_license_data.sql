insert into "assets_schema"."license"("id", "acquired_date", "expiry_date",
   "tickets_charged", "has_pdp", "license_type_id")
   values(uuid_generate_v4(), '2014-01-01', '2018-01-01', 0, 1,
   (select "id" from "assets_schema"."license_type" where
        "code" = 'C008')) ;

insert into "assets_schema"."license"("id", "acquired_date", "expiry_date",
   "tickets_charged", "has_pdp", "license_type_id")
   values(uuid_generate_v4(), '2015-01-01', '2019-01-01', 0, 1,
   (select "id" from "assets_schema"."license_type" where
        "code" = 'C010')) ;

insert into "assets_schema"."license"("id", "acquired_date", "expiry_date",
   "tickets_charged", "has_pdp", "license_type_id")
   values(uuid_generate_v4(), '2014-02-28', '2018-02-28', 0, 1,
   (select "id" from "assets_schema"."license_type" where
        "code" = 'C014')) ;

insert into "assets_schema"."license"("id", "acquired_date", "expiry_date",
   "tickets_charged", "has_pdp", "license_type_id")
   values(uuid_generate_v4(), '2016-07-04', '2021-07-04', 0, 1,
   (select "id" from "assets_schema"."license_type" where
        "code" = 'C010')) ;

insert into "assets_schema"."license"("id", "acquired_date", "expiry_date",
   "tickets_charged", "has_pdp", "license_type_id")
   values(uuid_generate_v4(), '2014-02-01', '2018-02-01', 0, 1,
   (select "id" from "assets_schema"."license_type" where
        "code" = 'C008')) ;