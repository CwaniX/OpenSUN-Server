------------------------------------------------------------------
--  TABLE character
------------------------------------------------------------------
ALTER TABLE "character"
	ADD COLUMN slot integer NOT NULL,
	ADD COLUMN skill bytea NOT NULL,
	ADD COLUMN quick bytea NOT NULL,
	ADD COLUMN style bytea NOT NULL,
	ADD COLUMN quest bytea NOT NULL,
	ADD COLUMN mission bytea NOT NULL;
	
------------------------------------------------------------------
--  TABLE inventory
------------------------------------------------------------------
ALTER TABLE "inventory"
	ADD COLUMN inventory_item bytea NOT NULL,
	ADD COLUMN tmp_inventory_item bytea NOT NULL,
	ADD COLUMN equip_item bytea NOT NULL;
	
------------------------------------------------------------------
--  SEQUENCE seq_character_set
------------------------------------------------------------------
CREATE SEQUENCE seq_character_set INCREMENT BY 50
	MINVALUE 1
	NO MAXVALUE
	START 1
	CACHE 1;
	
------------------------------------------------------------------
--  TABLE character_set
------------------------------------------------------------------
CREATE TABLE "character_set" (
	id bigint NOT NULL,
	experience bigint NOT NULL,
	
	class_name character varying(255),
	
	class_code integer NOT NULL,
	dexterity integer NOT NULL,
	inteligence integer NOT NULL,
	level integer NOT NULL,
	locationx integer NOT NULL,
	locationy integer NOT NULL,
	locationz integer NOT NULL,
	max_hp integer NOT NULL,
	max_mp integer NOT NULL,
	money integer NOT NULL,
	region integer NOT NULL,
	remain_skill integer NOT NULL,
	remain_stat integer NOT NULL,
	selected_style integer NOT NULL,
	skill_stat1 integer NOT NULL,
	skill_stat2 integer NOT NULL,
	spirit integer NOT NULL,
	strength integer NOT NULL,
	vitality integer NOT NULL,
	
	equip_item bytea NOT NULL,
	inventory_item bytea NOT NULL,
	mission bytea NOT NULL,
	quest bytea NOT NULL,
	quick bytea NOT NULL,
	skill bytea NOT NULL,
	style bytea NOT NULL,
	tmp_inventory_item bytea NOT NULL,
	CONSTRAINT character_set_pkey PRIMARY KEY (id)
);

INSERT INTO "character_set" (
	id,
	experience,
	class_name,
	class_code,
	dexterity,
	inteligence,
	level,
	locationx,
	locationy,
	locationz,
	max_hp,
	max_mp,
	money,
	region,
	remain_skill,
	remain_stat,
	selected_style,
	skill_stat1,
	skill_stat2,
	spirit,
	strength,
	vitality,
	equip_item,
	inventory_item,
	mission,
	quest,
	quick,
	skill,
	style,
	tmp_inventory_item
) VALUES (
	nextval('seq_character_set'),
	0,
	'Berserker',
	1,
	13,
	4,
	1,
	0,
	0,
	0,
	200,
	20,
	0,
	10001,
	1,
	0,
	60100,
	0,
	0,
	10,
	26,
	24,
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x0200FD0301E507',
	'\\x00',
	'\\x00'
), (
	nextval('seq_character_set'),
	0,
	'Dragon',
	2,
	20,
	6,
	1,
	0,
	0,
	0,
	159,
	25,
	0,
	10001,
	1,
	0,
	60200,
	0,
	0,
	12,
	22,
	20,
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x0200A10F018913',
	'\\x00',
	'\\x00'
), (
	nextval('seq_character_set'),
	0,
	'Shadow',
	3,
	18,
	15,
	1,
	0,
	0,
	0,
	160,
	38,
	0,
	10001,
	1,
	0,
	60400,
	0,
	0,
	13,
	20,
	15,
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x0100E12E',
	'\\x00',
	'\\x00'
), (
	nextval('seq_character_set'),
	0,
	'Valkyrie',
	4,
	23,
	7,
	1,
	0,
	0,
	0,
	160,
	42,
	0,
	10001,
	1,
	0,
	60601,
	0,
	0,
	19,
	16,
	15,
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x0100591B',
	'\\x00',
	'\\x00'
), (
	nextval('seq_character_set'),
	0,
	'Magician',
	5,
	12,
	25,
	1,
	0,
	0,
	0,
	150,
	232,
	0,
	10001,
	1,
	0,
	60801,
	0,
	0,
	22,
	8,
	13,
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x00',
	'\\x03001127012527029D2C',
	'\\x00',
	'\\x00'
);
	
------------------------------------------------------------------
--  FUNCTION func_create_user_and_account
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_create_user_and_account(
	in_name character varying,
	in_password character varying
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	DECLARE
		acc_id bigint;
		
	BEGIN
		INSERT INTO "account" (
			id
		) VALUES (
			nextval('seq_account')
		) RETURNING id INTO acc_id;
		
		INSERT INTO "user" (
			id,
			name,
			password,
			account_id
		) VALUES (
			nextval('seq_user'),
			in_name,
			in_password,
			acc_id
		);
		
		RETURN 0;
	END;
$BODY$;

------------------------------------------------------------------
--  FUNCTION func_delete_character
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_delete_character(
	in_account_id bigint,
	in_slot integer
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	BEGIN
		UPDATE "character"
		SET deleted = true
		WHERE account_id = in_account_id AND slot = in_slot;
		
		RETURN 0;
	END;
$BODY$;

------------------------------------------------------------------
--  FUNCTION func_create_character
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_create_character(
	in_account_id bigint,
	in_name character varying,
	in_class integer,
	in_height integer,
	in_face integer,
	in_hair integer,
	in_slot integer
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	BEGIN
		IF EXISTS (SELECT name FROM character WHERE name = in_name) THEN
			RETURN 1;
		END IF;
		
		IF EXISTS (SELECT slot FROM character WHERE account_id = in_account_id AND slot = in_slot AND deleted = false) THEN
			RETURN 2;
		END IF;
		
		INSERT INTO character
			(id,
			experience,
			char_state,
			class_code,
			dexterity,
			face_code,
			hair_code,
			height_code,
			hp,
			inteligence,
			invisible_opt,
			level,
			max_hp,
			max_mp,
			mp,
			name,
			pk_state,
			play_limited_time,
			remain_skill,
			remain_stat,
			selected_style,
			skill_stat1,
			skill_stat2,
			spirit,
			state_time,
			strength,
			title_id,
			user_point,
			vitality,
			account_id,
			inventory_id,
			position_id,
			slot,
			mission,
			quest,
			quick,
			skill,
			style,
			creation_date,
			last_login_date,
			modification_date,
			deleted)
			
		(SELECT
			nextval('seq_character'),
			0,
			0,
			class_code,
			dexterity,
			in_face,
			in_hair,
			in_height,
			100
			inteligence,
			0,
			level,
			max_hp,
			max_mp,
			10,
			in_name,
			0,
			0,
			remain_skill,
			remain_stat,
			selected_style,
			skill_stat1,
			skill_stat2,
			spirit,
			0,
			strength,
			0,
			0,
			vitality,
			0,
			0,
			0,
			in_slot,
			mission,
			quest,
			quick,
			skill,
			style,
			now(),
			now(),
			now(),
			false
		FROM character_set
		WHERE class_code = in_class);
		
		RETURN 0;
	END;
$BODY$;
