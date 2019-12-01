------------------------------------------------------------------
--  TABLE character_position
------------------------------------------------------------------
ALTER TABLE "character_position"
	ADD COLUMN angle integer;

UPDATE "character_position" SET angle = 0;

ALTER TABLE "character_position"
    ALTER COLUMN angle SET NOT NULL;

------------------------------------------------------------------
--  TABLE character
------------------------------------------------------------------
ALTER TABLE "character"
  RENAME COLUMN inteligence TO intelligence;

------------------------------------------------------------------
--  FUNCTION func_update_character_position
------------------------------------------------------------------
DROP FUNCTION func_update_character_position(integer, real, real, real);

CREATE OR REPLACE FUNCTION func_update_character_position(
	in_id integer,
	in_x real,
	in_y real,
	in_z real,
	in_angle integer
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	BEGIN
		UPDATE "character_position" SET
			locationx = in_x,
			locationy = in_y,
			locationz = in_z,
			angle = in_angle
		WHERE id = (SELECT position_id FROM character WHERE id = in_id);

		RETURN 0;
	END;
$BODY$;