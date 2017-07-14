CREATE TABLE `t_eod_file_record` (
`ID`  int(8) NOT NULL AUTO_INCREMENT ,
`busi_date`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`busi_status`  int(2) NULL DEFAULT NULL ,
`begin_time`  datetime NULL DEFAULT NULL ,
`end_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`ID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;

