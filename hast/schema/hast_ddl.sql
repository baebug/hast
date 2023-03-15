CREATE TABLE `world` (
	`world_id`	BIGINT	NOT NULL,
	`world_kor_name`	VARCHAR(255)	NOT NULL,
	`world_eng_name`	VARCHAR(255)	NOT NULL,
	`world_alpha2`	VARCHAR(2)	NOT NULL,
	`world_alpha3`	VARCHAR(3)	NOT NULL,
	`world_latitude`	FLOAT	NOT NULL,
	`world_longtitude`	FLOAT	NOT NULL
);

CREATE TABLE `event` (
	`event_id`	BIGINT	NOT NULL,
	`world_id`	BIGINT	NOT NULL,
	`event_code`	VARCHAR(255)	NULL,
	`event_class`	INTEGER	NULL,
	`event_gold`	FLOAT	NULL,
	`event_ton`	NUMERIC	NULL,
	`event_url`	VARCHAR(255)	NULL,
	`event_latitude`	FLOAT	NULL,
	`event_longtitude`	FLOAT	NULL
);

CREATE TABLE `gkg` (
	`gkg_id`	BIGINT	NOT NULL,
	`world_id`	BIGINT	NOT NULL,
	`gkg_code`	VARCHAR(255)	NULL,
	`gkg_theme`	INTEGER	NULL,
	`gkg_url`	VARCHAR(255)	NULL
);

CREATE TABLE `safety` (
	`world_id`	BIGINT	NOT NULL,
	`safety1`	BIGINT	NOT NULL,
	`safety2`	BIGINT	NOT NULL,
	`safety3`	BIGINT	NOT NULL,
	`safety4`	BIGINT	NOT NULL,
	`safety5`	BIGINT	NOT NULL,
	`safety6`	BIGINT	NOT NULL,
	`safety7`	BIGINT	NOT NULL,
	`safety8`	BIGINT	NOT NULL,
	`safety9`	BIGINT	NOT NULL,
	`safety10`	BIGINT	NOT NULL,
	`safety11`	BIGINT	NOT NULL,
	`safety12`	BIGINT	NOT NULL
);

CREATE TABLE `eng_info` (
	`world_id`	BIGINT	NOT NULL,
	`info_name`	VARCHAR(255)	NOT NULL,
	`info_capital`	VARCHAR(255)	NOT NULL,
	`info_money`	VARCHAR(255)	NOT NULL,
	`info_size`	VARCHAR(255)	NOT NULL,
	`info_popul`	INT	NOT NULL
);

CREATE TABLE `kor_info` (
	`world_id`	BIGINT	NOT NULL,
	`info_name`	VARCHAR(255)	NOT NULL,
	`info_capital`	VARCHAR(255)	NOT NULL,
	`info_money`	VARCHAR(255)	NOT NULL,
	`info_size`	VARCHAR(255)	NOT NULL,
	`info_popul`	INT	NOT NULL
);

ALTER TABLE `world` ADD CONSTRAINT `PK_WORLD` PRIMARY KEY (
	`world_id`
);

ALTER TABLE `event` ADD CONSTRAINT `PK_EVENT` PRIMARY KEY (
	`event_id`
);

ALTER TABLE `gkg` ADD CONSTRAINT `PK_GKG` PRIMARY KEY (
	`gkg_id`
);

ALTER TABLE `safety` ADD CONSTRAINT `PK_SAFETY` PRIMARY KEY (
	`world_id`
);

ALTER TABLE `eng_info` ADD CONSTRAINT `PK_ENG_INFO` PRIMARY KEY (
	`world_id`
);

ALTER TABLE `kor_info` ADD CONSTRAINT `PK_KOR_INFO` PRIMARY KEY (
	`world_id`
);

ALTER TABLE `event` ADD CONSTRAINT `FK_world_TO_event_1` FOREIGN KEY (
	`world_id`
)
REFERENCES `world` (
	`world_id`
);

ALTER TABLE `gkg` ADD CONSTRAINT `FK_world_TO_gkg_1` FOREIGN KEY (
	`world_id`
)
REFERENCES `world` (
	`world_id`
);

ALTER TABLE `safety` ADD CONSTRAINT `FK_world_TO_safety_1` FOREIGN KEY (
	`world_id`
)
REFERENCES `world` (
	`world_id`
);

ALTER TABLE `eng_info` ADD CONSTRAINT `FK_world_TO_eng_info_1` FOREIGN KEY (
	`world_id`
)
REFERENCES `world` (
	`world_id`
);

ALTER TABLE `kor_info` ADD CONSTRAINT `FK_world_TO_kor_info_1` FOREIGN KEY (
	`world_id`
)
REFERENCES `world` (
	`world_id`
);

