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
CREATE SCHEMA IF NOT EXISTS `periodicals` DEFAULT CHARACTER SET utf8 ;
USE `periodicals` ;

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
-- Table `periodicals`.`wallets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`wallets` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`wallets` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `balance` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `periodicals`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`users` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`users` (
  `id` INT(11) NOT NULL,
  `login` VARCHAR(40) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `firstName` VARCHAR(50) NULL DEFAULT NULL,
  `lastName` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `walletID` INT(11) NULL DEFAULT NULL,
  `role` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `FK_mmgnrg9xuk9v75158vut4jl8e` (`role` ASC),
  INDEX `FK_wallets_idx` (`walletID` ASC),
  CONSTRAINT `FK_mmgnrg9xuk9v75158vut4jl8e`
    FOREIGN KEY (`role`)
    REFERENCES `periodicals`.`roles` (`id`),
  CONSTRAINT `FK_wallets`
    FOREIGN KEY (`walletID`)
    REFERENCES `periodicals`.`wallets` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


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
  `id` INT(11) NOT NULL,
  `name` VARCHAR(150) NULL DEFAULT NULL,
  `description` VARCHAR(2000) NULL DEFAULT NULL,
  `themeID` INT(11) NULL DEFAULT NULL,
  `typeID` INT(11) NULL DEFAULT NULL,
  `periodicity` INT(11) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_types_idx` (`typeID` ASC),
  INDEX `FK_themes_idx` (`themeID` ASC),
  CONSTRAINT `FK_themes`
    FOREIGN KEY (`themeID`)
    REFERENCES `periodicals`.`themes` (`id`),
  CONSTRAINT `FK_types`
    FOREIGN KEY (`typeID`)
    REFERENCES `periodicals`.`types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `periodicals`.`subscriptions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`subscriptions` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`subscriptions` (
  `id` INT(11) NOT NULL,
  `userID` INT(11) NULL DEFAULT NULL,
  `publication` INT(11) NULL DEFAULT NULL,
  `startDate` DATE NULL DEFAULT NULL,
  `endDate` DATE NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
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


-- -----------------------------------------------------
-- Table `periodicals`.`payments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `periodicals`.`payments` ;

CREATE TABLE IF NOT EXISTS `periodicals`.`payments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `walletID` INT(11) NULL DEFAULT NULL,
  `subscriptionID` INT(11) NULL DEFAULT NULL,
  `dateOfPay` DATETIME NULL DEFAULT NULL,
  `sum` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_subscriptions_idx` (`subscriptionID` ASC),
  INDEX `FK_walletsqwer` (`walletID` ASC),
  CONSTRAINT `FK_subscriptionsqwer`
    FOREIGN KEY (`subscriptionID`)
    REFERENCES `periodicals`.`subscriptions` (`id`),
  CONSTRAINT `FK_walletsqwer`
    FOREIGN KEY (`walletID`)
    REFERENCES `periodicals`.`wallets` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
