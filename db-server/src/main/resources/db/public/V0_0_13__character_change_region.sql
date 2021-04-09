------------------------------------------------------------------
--  FUNCTION func_update_character_region
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_update_character_region(
	in_id integer,
	in_x real,
	in_y real,
	in_z real,
	in_angle integer,
	in_region integer
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	BEGIN
		UPDATE "character_position" SET
			locationx = in_x,
			locationy = in_y,
			locationz = in_z,
			angle = in_angle,
		    region = in_region
		WHERE id = (SELECT position_id FROM character WHERE id = in_id);

		RETURN 0;
	END;
$BODY$;