------------------------------------------------------------------
--  FUNCTION func_create_user_and_account
------------------------------------------------------------------
CREATE OR REPLACE FUNCTION func_create_user_and_account(
	in_name character varying,
	in_password character varying
) RETURNS integer LANGUAGE 'plpgsql'

AS $BODY$
	DECLARE
		acc_id integer;
		
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
			upper(in_name),
			in_password,
			acc_id
		);
		
		RETURN 0;
	END;
$BODY$;