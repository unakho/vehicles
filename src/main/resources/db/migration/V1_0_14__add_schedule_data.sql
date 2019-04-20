insert into "assets_schema"."schedule"("id", "scheduled_date", "vehicle_id")
   values(uuid_generate_v4(), '2019-02-27', (select "id" from "assets_schema"."vehicle"
        where "name" = 'Mercedes')) ;

insert into "assets_schema"."schedule"("id", "scheduled_date", "vehicle_id")
   values(uuid_generate_v4(), '2019-02-25', (select "id" from "assets_schema"."vehicle"
        where "name" = 'Isuzu Double Cab')) ;

insert into "assets_schema"."schedule"("id", "scheduled_date", "vehicle_id")
   values(uuid_generate_v4(), '2019-03-30', (select "id" from "assets_schema"."vehicle"
        where "name" = 'Mercedes'));