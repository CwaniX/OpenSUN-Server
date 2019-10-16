------------------------------------------------------------------
--  FUNCTION func_update_character_statistics
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_update_character_statistics(
	in_id integer,
	in_attribute_code integer
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	BEGIN
		IF (SELECT remain_stat FROM "character" WHERE id = in_id) <= 0 THEN
			RETURN 1;
		END IF;
		
		CASE in_attribute_code
			WHEN 1 THEN 
				UPDATE "character" SET
					strength = strength + 1,
					remain_stat = remain_stat - 1
				WHERE id = in_id;
			WHEN 2 THEN 
				UPDATE "character" SET
					agility = agility + 1,
					remain_stat = remain_stat - 1
				WHERE id = in_id;
			WHEN 3 THEN 
				UPDATE "character" SET
					vitality = vitality + 1,
					remain_stat = remain_stat - 1
				WHERE id = in_id;
			WHEN 4 THEN 
				UPDATE "character" SET
					inteligence = inteligence + 1,
					remain_stat = remain_stat - 1
				WHERE id = in_id;
			WHEN 5 THEN 
				UPDATE "character" SET
					spirit = spirit + 1,
					remain_stat = remain_stat - 1
				WHERE id = in_id;
			WHEN 6 THEN 
				UPDATE "character" SET
					skill_stat1 = skill_stat1 + 1,
					remain_stat = remain_stat - 1
				WHERE id = in_id;
			WHEN 7 THEN 
				UPDATE "character" SET
					skill_stat2 = skill_stat2 + 1,
					remain_stat = remain_stat - 1
				WHERE id = in_id;
			ELSE RETURN 2;
		END CASE;

		RETURN 0;
	END;
$BODY$;