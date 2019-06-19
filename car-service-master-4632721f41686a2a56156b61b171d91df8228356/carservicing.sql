-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project` DEFAULT CHARACTER SET latin1 ;
USE `project` ;

-- -----------------------------------------------------
-- Table `project`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`admin` (
  `fname` VARCHAR(30) NULL DEFAULT NULL,
  `lname` VARCHAR(30) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `gender` VARCHAR(30) NULL DEFAULT NULL,
  `contactNo` VARCHAR(30) NULL DEFAULT NULL,
  `adminId` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`adminId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `project`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`bill` (
  `requestId` INT(11) NULL DEFAULT NULL,
  `centerName` VARCHAR(20) NULL DEFAULT NULL,
  `total` FLOAT NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `userId` VARCHAR(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `project`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`delivery` (
  `dname` VARCHAR(20) NULL DEFAULT NULL,
  `status` VARCHAR(20) NULL DEFAULT NULL,
  `experience` INT(11) NULL DEFAULT NULL,
  `id` INT(11) NULL DEFAULT NULL,
  `contact` VARCHAR(10) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `project`.`delivery_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`delivery_info` (
  `requestId` INT(11) NOT NULL,
  `dname` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`requestId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `project`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`service` (
  `serviceId` INT(11) NOT NULL,
  `centerName` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(50) NULL DEFAULT NULL,
  `availability` DATE NULL DEFAULT NULL,
  `rating` FLOAT NULL DEFAULT NULL,
  `cost` FLOAT NULL DEFAULT NULL,
  `cost1` FLOAT NULL DEFAULT NULL,
  `cost2` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`serviceId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `project`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`status` (
  `requestId` INT(11) NOT NULL,
  `serviceid` INT(11) NULL DEFAULT NULL,
  `status` VARCHAR(30) NULL DEFAULT NULL,
  `userId` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`requestId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `project`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`user` (
  `fname` VARCHAR(30) NULL DEFAULT NULL,
  `lname` VARCHAR(30) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `gender` VARCHAR(30) NULL DEFAULT NULL,
  `contactNo` VARCHAR(30) NULL DEFAULT NULL,
  `userId` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
