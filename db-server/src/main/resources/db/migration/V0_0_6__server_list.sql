------------------------------------------------------------------
--  SEQUENCE seq_server
------------------------------------------------------------------
CREATE SEQUENCE seq_server INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1;

------------------------------------------------------------------
--  TABLE server
------------------------------------------------------------------
CREATE TABLE "server" (
	id integer NOT NULL,
	port integer NOT NULL,
	ip character varying(255),
	name character varying(255),
	CONSTRAINT server_pkey PRIMARY KEY (id)
);