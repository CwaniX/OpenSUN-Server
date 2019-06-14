------------------------------------------------------------------
--  SEQUENCE seq_account
------------------------------------------------------------------
ALTER SEQUENCE "seq_account" MAXVALUE 2147483647;

------------------------------------------------------------------
--  TABLE account
------------------------------------------------------------------
ALTER TABLE "account" ALTER COLUMN id TYPE integer;

------------------------------------------------------------------
--  SEQUENCE seq_user
------------------------------------------------------------------
ALTER SEQUENCE "seq_user" MAXVALUE 2147483647;

------------------------------------------------------------------
--  TABLE user
------------------------------------------------------------------
ALTER TABLE "user"
	ALTER COLUMN id TYPE integer,
	ALTER COLUMN account_id TYPE integer;

------------------------------------------------------------------
--  SEQUENCE seq_character_position
------------------------------------------------------------------
ALTER SEQUENCE "seq_character_position" MAXVALUE 2147483647;

------------------------------------------------------------------
--  TABLE character_position
------------------------------------------------------------------
ALTER TABLE "character_position" ALTER COLUMN id TYPE integer;

------------------------------------------------------------------
--  SEQUENCE seq_inventory
------------------------------------------------------------------
ALTER SEQUENCE "seq_inventory" MAXVALUE 2147483647;

------------------------------------------------------------------
--  TABLE inventory
------------------------------------------------------------------
ALTER TABLE "inventory" ALTER COLUMN id TYPE integer;

------------------------------------------------------------------
--  SEQUENCE seq_character
------------------------------------------------------------------
ALTER SEQUENCE "seq_character" MAXVALUE 2147483647;

------------------------------------------------------------------
--  TABLE character
------------------------------------------------------------------
ALTER TABLE "character"
	ALTER COLUMN id TYPE integer,
	ALTER COLUMN account_id TYPE integer,
	ALTER COLUMN inventory_id TYPE integer,
	ALTER COLUMN position_id TYPE integer;

------------------------------------------------------------------
--  SEQUENCE seq_character
------------------------------------------------------------------
ALTER SEQUENCE "seq_character_set" MAXVALUE 2147483647;

------------------------------------------------------------------
--  TABLE character
------------------------------------------------------------------
ALTER TABLE "character_set" ALTER COLUMN id TYPE integer;