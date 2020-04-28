------------------------------------------------------------------
--  SEQUENCE seq_channel_instance
------------------------------------------------------------------
CREATE SEQUENCE seq_channel_instance INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1;

------------------------------------------------------------------
--  TABLE channel_instance
------------------------------------------------------------------
CREATE TABLE "channel_instance" (
	id integer NOT NULL,
	server_instance_id integer NOT NULL,
	name character varying(255),
	CONSTRAINT channel_instance_pkey PRIMARY KEY (id),
		CONSTRAINT channel_instance_server_instance_fkey FOREIGN KEY (server_instance_id)
		REFERENCES server_instance (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);