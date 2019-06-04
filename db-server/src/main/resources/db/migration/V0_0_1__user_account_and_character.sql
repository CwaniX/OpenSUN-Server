------------------------------------------------------------------
--  SEQUENCE seq_account
------------------------------------------------------------------
CREATE SEQUENCE seq_account INCREMENT BY 50
	MINVALUE 1
	NO MAXVALUE
	START 1
	CACHE 1;

------------------------------------------------------------------
--  TABLE account
------------------------------------------------------------------
CREATE TABLE account (
	id bigint NOT NULL,
	CONSTRAINT account_pkey PRIMARY KEY (id)
);

------------------------------------------------------------------
--  SEQUENCE seq_user
------------------------------------------------------------------
CREATE SEQUENCE seq_user INCREMENT BY 50
	MINVALUE 1
	NO MAXVALUE
	START 1
	CACHE 1;

------------------------------------------------------------------
--  TABLE user
------------------------------------------------------------------
CREATE TABLE "user" (
	id bigint NOT NULL,
	creation_date timestamp without time zone,
	last_login_date timestamp without time zone,
	modification_date timestamp without time zone,
	name character varying(255),
	password character varying(255),
	account_id bigint,
	CONSTRAINT user_pkey PRIMARY KEY (id),
	CONSTRAINT user_account_fkey FOREIGN KEY (account_id)
		REFERENCES account (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);

------------------------------------------------------------------
--  SEQUENCE seq_character_position
------------------------------------------------------------------
CREATE SEQUENCE seq_character_position INCREMENT BY 50
	MINVALUE 1
	NO MAXVALUE
	START 1
	CACHE 1;

------------------------------------------------------------------
--  TABLE character_position
------------------------------------------------------------------
CREATE TABLE character_position (
	id bigint NOT NULL,
	locationx integer NOT NULL,
	locationy integer NOT NULL,
	locationz integer NOT NULL,
	region integer NOT NULL,
	CONSTRAINT character_position_pkey PRIMARY KEY (id)
);

------------------------------------------------------------------
--  SEQUENCE seq_inventory
------------------------------------------------------------------
CREATE SEQUENCE seq_inventory INCREMENT BY 50
	MINVALUE 1
	NO MAXVALUE
	START 1
	CACHE 1;

------------------------------------------------------------------
--  TABLE inventory
------------------------------------------------------------------
CREATE TABLE inventory (
	id bigint NOT NULL,
	inventory_lock integer NOT NULL,
	money integer NOT NULL,
	CONSTRAINT inventory_pkey PRIMARY KEY (id)
);

------------------------------------------------------------------
--  SEQUENCE seq_character
------------------------------------------------------------------
CREATE SEQUENCE seq_character INCREMENT BY 50
	MINVALUE 1
	NO MAXVALUE
	START 1
	CACHE 1;

------------------------------------------------------------------
--  TABLE character
------------------------------------------------------------------
CREATE TABLE "character" (
	id bigint NOT NULL,
	char_state integer NOT NULL,
	class_code integer NOT NULL,
	creation_date timestamp without time zone,
	deleted boolean NOT NULL,
	dexterity integer NOT NULL,
	experience bigint NOT NULL,
	face_code integer NOT NULL,
	hair_code integer NOT NULL,
	height_code integer NOT NULL,
	hp integer NOT NULL,
	inteligence integer NOT NULL,
	invisible_opt integer NOT NULL,
	last_login_date timestamp without time zone,
	level integer NOT NULL,
	max_hp integer NOT NULL,
	max_mp integer NOT NULL,
	modification_date timestamp without time zone,
	mp integer NOT NULL,
	name character varying(255),
	pk_state integer NOT NULL,
	play_limited_time integer NOT NULL,
	remain_skill integer NOT NULL,
	remain_stat integer NOT NULL,
	selected_style integer NOT NULL,
	skill_stat1 integer NOT NULL,
	skill_stat2 integer NOT NULL,
	spirit integer NOT NULL,
	state_time integer NOT NULL,
	strength integer NOT NULL,
	title_id integer NOT NULL,
	user_point integer NOT NULL,
	vitality integer NOT NULL,
	account_id bigint,
	inventory_id bigint,
	position_id bigint,
	CONSTRAINT character_pkey PRIMARY KEY (id),
	CONSTRAINT character_position_fkey FOREIGN KEY (position_id)
		REFERENCES character_position (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT character_account_fkey FOREIGN KEY (account_id)
		REFERENCES account (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT character_inventory_fkey FOREIGN KEY (inventory_id)
		REFERENCES inventory (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);