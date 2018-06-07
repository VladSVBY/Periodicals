-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema periodicals
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `periodicals` ;

-- -----------------------------------------------------
-- Schema periodicals
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `periodicals` DEFAULT CHARACTER SET latin1 ;
USE `periodicals` ;

-- -----------------------------------------------------
-- Table `periodicals`.`themes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`themes` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`themes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `periodicals`.`types`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`types` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`types` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `periodicals`.`publications`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`publications` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`publications` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `description` VARCHAR(2000) NOT NULL,
  `theme_id` INT(11) NOT NULL,
  `type_id` INT(11) NOT NULL,
  `periodicity` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `rating` DECIMAL(3,2) NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  INDEX `FK_types_idx` (`type_id` ASC),
  INDEX `FK_themes_idx` (`theme_id` ASC),
  CONSTRAINT `FK_themes`
    FOREIGN KEY (`theme_id`)
    REFERENCES `periodicals`.`themes` (`id`),
  CONSTRAINT `FK_types`
    FOREIGN KEY (`type_id`)
    REFERENCES `periodicals`.`types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `periodicals`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`roles` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`roles` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `roleName_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `periodicals`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`users` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(40) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `balance` DOUBLE NOT NULL,
  `role_id` INT(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `FK_krvotbtiqhudlkamvlpaqus0t` (`role_id` ASC),
  CONSTRAINT `FK_krvotbtiqhudlkamvlpaqus0t`
    FOREIGN KEY (`role_id`)
    REFERENCES `periodicals`.`roles` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `periodicals`.`reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`reviews` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`reviews` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `publication_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `date_time` DATETIME NOT NULL,
  `header` VARCHAR(200) NOT NULL,
  `text` VARCHAR(3000) NOT NULL,
  `mark` TINYINT(4) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `fk_reviews_user_idx` (`user_id` ASC),
  INDEX `fk_review_publication_idx` (`publication_id` ASC),
  CONSTRAINT `fk_review_publication`
    FOREIGN KEY (`publication_id`)
    REFERENCES `periodicals`.`publications` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reviews_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `periodicals`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `periodicals`.`subscriptions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`subscriptions` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`subscriptions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userID` INT(11) NOT NULL,
  `publication` INT(11) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `price` DOUBLE NOT NULL,
  `status` ENUM('ACTIVE', 'EXPIRED') NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`),
  INDEX `FK_okh5x9oxgw2wyy6x3ak57uafc` (`userID` ASC),
  INDEX `FK_tf6uj79yfrw6kjp5hob78tiec` (`publication` ASC),
  CONSTRAINT `FK_okh5x9oxgw2wyy6x3ak57uafc`
    FOREIGN KEY (`userID`)
    REFERENCES `periodicals`.`users` (`id`),
  CONSTRAINT `FK_tf6uj79yfrw6kjp5hob78tiec`
    FOREIGN KEY (`publication`)
    REFERENCES `periodicals`.`publications` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `periodicals`;

DELIMITER $$

USE `periodicals`$$
DROP TRIGGER IF EXISTS `periodicals`.`reviews_AFTER_INSERT` $$
USE `periodicals`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `periodicals`.`reviews_AFTER_INSERT`
AFTER INSERT ON `periodicals`.`reviews`
FOR EACH ROW
BEGIN
Update publications 
SET publications.rating = (SELECT SUM(mark) / COUNT(id) FROM reviews WHERE publication_id = NEW.publication_id)
WHERE publications.id = NEW.publication_id;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
