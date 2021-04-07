------------------------------------------------------------------
--  TABLE character_set
------------------------------------------------------------------
ALTER TABLE character_set
    ADD COLUMN IF NOT EXISTS angle integer NOT NULL default 0;

ALTER TABLE character_set
    RENAME COLUMN inteligence TO intelligence;

------------------------------------------------------------------
--  FUNCTION func_create_character
------------------------------------------------------------------
DROP FUNCTION func_create_character(integer, character varying, integer, integer, integer, integer, integer);

CREATE OR REPLACE FUNCTION func_create_character(
	in_account_id integer,
	in_name character varying,
	in_class integer,
	in_height integer,
	in_face integer,
	in_hair integer,
	in_slot integer
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	DECLARE
		position_id integer;
		inventory_id integer;	
		
	BEGIN
		IF EXISTS (SELECT name FROM "character" WHERE name = in_name) THEN
			RETURN 1;
		END IF;
		
		IF EXISTS (SELECT slot FROM "character" WHERE account_id = in_account_id AND slot = in_slot AND deleted = false) THEN
			RETURN 2;
		END IF;
		
		INSERT INTO "character_position" (
			id,
			locationx,
			locationy,
			locationz,
			region,
		    angle
		) (SELECT
				nextval('seq_character_position'),
				locationx,
				locationy,
				locationz,
				region,
		        angle
			FROM "character_set"
			WHERE class_code = in_class
		) RETURNING id INTO position_id;
		
		INSERT INTO "inventory" (
			id,
			inventory_lock,
			inventory_item,
			tmp_inventory_item,
			equip_item,
			money
		) (SELECT
				nextval('seq_inventory'),
				0,
				inventory_item,
				tmp_inventory_item,
				equip_item,
				money
			FROM "character_set"
			WHERE class_code = in_class
		) RETURNING id INTO inventory_id;
		
		INSERT INTO "character"
			(id,
			experience,
			char_state,
			class_code,
			dexterity,
			face_code,
			hair_code,
			height_code,
			hp,
			intelligence,
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
			deleted
		) (SELECT
				nextval('seq_character'),
				0,
				0,
				class_code,
				dexterity,
				in_face,
				in_hair,
				in_height,
				100,
				intelligence,
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
				in_account_id,
				inventory_id,
				position_id,
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
			FROM "character_set"
			WHERE class_code = in_class
		);
		
		RETURN 0;
	END;
$BODY$;