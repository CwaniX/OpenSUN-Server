------------------------------------------------------------------
--  TABLE character
------------------------------------------------------------------
ALTER TABLE "character" ADD COLUMN slot smallint;

------------------------------------------------------------------
--  FUNCTION func_create_user_and_account
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_create_user_and_account(
	in_name character varying,
	in_password character varying
) RETURNS bigint LANGUAGE 'plpgsql'

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
	in_char_name character varying,
	in_class smallint,
	in_height smallint,
	in_face smallint,
	in_hair smallint,
	in_slot smallint
) RETURNS bigint LANGUAGE 'plpgsql'

AS $BODY$
	BEGIN

		
		RETURN 0;
	END;
$BODY$;

------------------------------------------------------------------
--  FUNCTION func_create_character
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_create_character(
	in_account_id bigint,
	in_slot integer
) RETURNS bigint LANGUAGE 'plpgsql'

AS $BODY$
	BEGIN
		UPDATE "character"
		SET deleted = true
		WHERE account_id = in_account_id AND slot = in_slot;
		
		RETURN 0;
	END;
$BODY$;
