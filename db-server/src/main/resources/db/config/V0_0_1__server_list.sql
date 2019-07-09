------------------------------------------------------------------
--  SEQUENCE seq_server_instance
------------------------------------------------------------------
CREATE SEQUENCE seq_server_instance INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1;

------------------------------------------------------------------
--  TABLE server_instance
------------------------------------------------------------------
CREATE TABLE "server_instance" (
	id integer NOT NULL,
	port integer NOT NULL,
	ip character varying(255),
	name character varying(255),
	CONSTRAINT server_pkey PRIMARY KEY (id)
);