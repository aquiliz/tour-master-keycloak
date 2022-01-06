CREATE TABLE orders
(
   id bigserial,
   tour_id bigint REFERENCES tours (id) not null,
   order_time timestamp,
   updated_at timestamp,
   count_adults smallint not null,
   count_children smallint not null,
   pickup_time timestamp,
   pickup_address text,
   pickup_coordinates character varying(100),
   hotel_name character varying(100),
   contact_person_name character varying(100),
   contact_person_phone character varying(100),
   payment_method character varying(50),
   voucher_id character varying(50),
   CONSTRAINT order_id PRIMARY KEY (id)
);