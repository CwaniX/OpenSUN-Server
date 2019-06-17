------------------------------------------------------------------
--  TABLE character_set
------------------------------------------------------------------
UPDATE "character_set" SET
	equip_item = decode('00', 'hex'),
	inventory_item = decode('00', 'hex'),
	mission = decode('00', 'hex'),
	quest = decode('00', 'hex'),
	quick = decode('00', 'hex'),
	style = decode('00', 'hex'),
	tmp_inventory_item = decode('00', 'hex');
	
UPDATE "character_set" SET
	skill = decode('0200FD0301E507', 'hex')
WHERE class_code = 1;

UPDATE "character_set" SET
	skill = decode('0200A10F018913', 'hex')
WHERE class_code = 2;

UPDATE "character_set" SET
	skill = decode('0100E12E', 'hex')
WHERE class_code = 3;

UPDATE "character_set" SET
	skill = decode('0100591B', 'hex')
WHERE class_code = 4;

UPDATE "character_set" SET
	skill = decode('03001127012527029D2C', 'hex')
WHERE class_code = 5;