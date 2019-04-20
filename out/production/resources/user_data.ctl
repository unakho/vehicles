load data

infile 'user_data.dsv'

into table tuser

fields terminated by "|"

(id, id_number, first_names, last_name, msisdn, network, points, card_number, gender)
