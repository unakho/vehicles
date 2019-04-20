insert into "assets_schema"."user"("id", "id_number", "name", "last_name", "msisdn",
      "network",  "points", "card_number", "gender", "license_id")
   values(uuid_generate_v4(), '8505116131087', 'Unakho', 'Kama', '0836701982',
      'MTN', 23, '614641645', 1, (select "id" from "assets_schema"."license" where
        "expiry_date" = '2018-01-01')) ;

insert into "assets_schema"."user"("id", "id_number", "name", "last_name", "msisdn",
      "network",  "points", "card_number", "gender", "license_id")
   values(uuid_generate_v4(), '8505116131087', 'Alutha', 'Khwaza', '0836701982',
      'MTN', 23, '614600645', 1, (select "id" from "assets_schema"."license" where
        "expiry_date" = '2019-01-01')) ;

insert into "assets_schema"."user"("id", "id_number", "name", "last_name", "msisdn",
      "network",  "points", "card_number", "gender", "license_id")
   values(uuid_generate_v4(), '8905116131087', 'Litha', 'Stock', '0836701982',
      'Vodacom', 23, '444600656', 1, (select "id" from "assets_schema"."license" where
        "expiry_date" = '2018-02-28')) ;

insert into "assets_schema"."user"("id", "id_number", "name", "last_name", "msisdn",
      "network",  "points", "card_number", "gender", "license_id")
   values(uuid_generate_v4(), '9005116131087', 'Ozzy', 'Mbana', '0656701982',
      'Telkom', 23, '325600612', 1, (select "id" from "assets_schema"."license" where
        "expiry_date" = '2021-07-04')) ;

insert into "assets_schema"."user"("id", "id_number", "name", "last_name", "msisdn",
      "network",  "points", "card_number", "gender", "license_id")
   values(uuid_generate_v4(), '8705116131087', 'Buhle', 'Bura', '0656701982',
      'Telkom', 23, '479600655', 1, (select "id" from "assets_schema"."license" where
        "expiry_date" = '2018-02-01')) ;
