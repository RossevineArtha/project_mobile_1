-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema expenceManager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema expenceManager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `expenceManager` DEFAULT CHARACTER SET utf8 ;
USE `expenceManager` ;

-- -----------------------------------------------------
-- Table `expenceManager`.`Category_Pemasukkan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenceManager`.`Category_Pemasukkan` (
  `idcategory_pemasukkan` INT NOT NULL,
  `category_pemasukkan` VARCHAR(50) NULL,
  PRIMARY KEY (`idcategory_pemasukkan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expenceManager`.`category_pengeluwaran`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenceManager`.`category_pengeluwaran` (
  `idcategory_pengeluwaran` INT NOT NULL,
  `category_pengeluwaran` VARCHAR(50) NULL,
  PRIMARY KEY (`idcategory_pengeluwaran`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expenceManager`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenceManager`.`User` (
  `idUser` INT NOT NULL,
  `name` VARCHAR(50) NULL,
  `username` VARCHAR(30) NULL,
  `password` VARCHAR(30) NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expenceManager`.`Pengeluwaran`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenceManager`.`Pengeluwaran` (
  `idPengeluwaran` INT NOT NULL,
  `judulPengeluwaran` VARCHAR(50) NULL,
  `jumlahPengeluwaran` INT NULL,
  `informationPengeluwaran` VARCHAR(200) NULL,
  `waktuPengeluwaran` DATETIME NULL,
  `category_pengeluwaran_id` INT NOT NULL,
  `User_idUser` INT NOT NULL,
  PRIMARY KEY (`idPengeluwaran`, `category_pengeluwaran_id`, `User_idUser`),
  INDEX `fk_Pengeluwaran_category_pengeluwaran1_idx` (`category_pengeluwaran_id` ASC),
  INDEX `fk_Pengeluwaran_User1_idx` (`User_idUser` ASC),
  CONSTRAINT `fk_Pengeluwaran_category_pengeluwaran1`
    FOREIGN KEY (`category_pengeluwaran_id`)
    REFERENCES `expenceManager`.`category_pengeluwaran` (`idcategory_pengeluwaran`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pengeluwaran_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `expenceManager`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expenceManager`.`Pemasukan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenceManager`.`Pemasukan` (
  `idPemasukan` INT NOT NULL,
  `jumlahPemasukan` INT NULL,
  `informasiPemasukan` VARCHAR(200) NULL,
  `waktuPemasukan` DATETIME NULL,
  `judulPemasukan` VARCHAR(50) NULL,
  `User_idUser` INT NOT NULL,
  `Category_pemasukkan_Id` INT NOT NULL,
  PRIMARY KEY (`idPemasukan`, `User_idUser`, `Category_pemasukkan_Id`),
  INDEX `fk_masukkan_User_idx` (`User_idUser` ASC),
  INDEX `fk_masukkan_category_masukkan1_idx` (`Category_pemasukkan_Id` ASC),
  CONSTRAINT `fk_masukkan_User`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `expenceManager`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_masukkan_category_masukkan1`
    FOREIGN KEY (`Category_pemasukkan_Id`)
    REFERENCES `expenceManager`.`Category_Pemasukkan` (`idcategory_pemasukkan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `expenceManager`.`alokasi_dana`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenceManager`.`alokasi_dana` (
  `idalokasi_dana` INT NOT NULL,
  `namaAlokasi` VARCHAR(45) NULL,
  `jumlahAlokasi` INT NULL,
  `User_idUser` INT NOT NULL,
  `idcategory_pengeluwaran` INT NOT NULL,
  PRIMARY KEY (`idalokasi_dana`, `User_idUser`, `idcategory_pengeluwaran`),
  INDEX `fk_alokasi_dana_User1_idx` (`User_idUser` ASC),
  INDEX `fk_alokasi_dana_category_pengeluwaran1_idx` (`idcategory_pengeluwaran` ASC),
  CONSTRAINT `fk_alokasi_dana_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `expenceManager`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alokasi_dana_category_pengeluwaran1`
    FOREIGN KEY (`idcategory_pengeluwaran`)
    REFERENCES `expenceManager`.`category_pengeluwaran` (`idcategory_pengeluwaran`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `expenceManager` ;

-- -----------------------------------------------------
-- Placeholder table for view `expenceManager`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenceManager`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `expenceManager`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `expenceManager`.`view1`;
USE `expenceManager`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
