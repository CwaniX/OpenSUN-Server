------------------------------------------------------------------
--  TABLE character_position
------------------------------------------------------------------
ALTER TABLE "character_position"
	ALTER COLUMN locationx TYPE real,
	ALTER COLUMN locationy TYPE real,
	ALTER COLUMN locationz TYPE real;
	
------------------------------------------------------------------
--  TABLE character_set
------------------------------------------------------------------
ALTER TABLE "character_set"
	ALTER COLUMN locationx TYPE real,
	ALTER COLUMN locationy TYPE real,
	ALTER COLUMN locationz TYPE real;

------------------------------------------------------------------
--  FUNCTION func_update_character_position
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_update_character_position(
	in_id integer,
	in_x real,
	in_y real,
	in_z real
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	BEGIN
		UPDATE "character_position" SET
			locationx = in_x,
			locationy = in_y,
			locationz = in_z
		WHERE id = (SELECT position_id FROM character WHERE id = in_id);
		
		RETURN 0;
	END;
$BODY$;