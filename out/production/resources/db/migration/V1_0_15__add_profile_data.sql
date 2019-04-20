insert into "assets_schema"."profile"("id", "value", "user_id")
    values(uuid_generate_v4(), 'Client', (select "id" from "assets_schema"."user" where
        "last_name" = 'Kama')) ;

insert into "assets_schema"."profile"("id", "value", "user_id")
    values(uuid_generate_v4(), 'Employer', (select "id" from "assets_schema"."user" where
        "last_name" = 'Mbana')) ;

insert into "assets_schema"."profile"("id", "value", "user_id")
    values(uuid_generate_v4(), 'Employee', (select "id" from "assets_schema"."user" where
        "last_name" = 'Stock')) ;

insert into "assets_schema"."profile"("id", "value", "user_id")
    values(uuid_generate_v4(), 'Customer', (select "id" from "assets_schema"."user" where
        "last_name" = 'Khwaza')) ;