CREATE TABLE tours
(
   id bigserial, 
   name character varying(200) not null,
   destination character varying(100),
   description text,
   duration_hrs smallint,
   transport_type character varying(100),
   toll_taxes smallint,
   price_adult  decimal,
   price_child decimal,
   currency character varying(8),
   expected_time_back_at_origin timestamp,
   documents_needed character varying(300),
   contacts character varying(300),
   CONSTRAINT tour_pk PRIMARY KEY (id)
);