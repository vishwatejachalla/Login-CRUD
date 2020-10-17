CREATE SCHEMA IF NOT EXISTS `log_in` ;

USE `log_in` ;

-- -----------------------------------------------------
-- Table `log_in`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log_in`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(50) NOT NULL,
  `us_email` VARCHAR(50) NOT NULL,
  `us_password` VARCHAR(20) NOT NULL,
  `us_description` VARCHAR(45) NOT NULL,
  `us_createdby` VARCHAR(45) NOT NULL,
  `us_createddate` VARCHAR(45) NOT NULL,
  `us_updatedby` VARCHAR(45) NOT NULL,
  `us_updateddate` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`us_id`))