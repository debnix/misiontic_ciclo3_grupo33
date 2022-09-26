-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema grupo33
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `grupo33` ;

-- -----------------------------------------------------
-- Schema grupo33
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `grupo33` DEFAULT CHARACTER SET utf8 ;
USE `grupo33` ;

-- -----------------------------------------------------
-- Table `grupo33`.`facultad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`facultad` (
  `numero` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(120) NOT NULL,
  `ubicacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`numero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`decano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`decano` (
  `cedula` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(80) NOT NULL,
  `facultad_numero` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`cedula`),
  INDEX `fk_decano_facultad1_idx` (`facultad_numero` ASC) VISIBLE,
  CONSTRAINT `fk_decano_facultad1`
    FOREIGN KEY (`facultad_numero`)
    REFERENCES `grupo33`.`facultad` (`numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`telefono` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo_pais` VARCHAR(3) NOT NULL,
  `numero` VARCHAR(15) NOT NULL,
  `decano_cedula` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_telefono_decano_idx` (`decano_cedula` ASC) VISIBLE,
  CONSTRAINT `fk_telefono_decano`
    FOREIGN KEY (`decano_cedula`)
    REFERENCES `grupo33`.`decano` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`docente` (
  `cedula` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(60) NOT NULL,
  `facultad_numero` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`cedula`),
  INDEX `fk_docente_facultad1_idx` (`facultad_numero` ASC) VISIBLE,
  CONSTRAINT `fk_docente_facultad1`
    FOREIGN KEY (`facultad_numero`)
    REFERENCES `grupo33`.`facultad` (`numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`titulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`titulo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`docente_titulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`docente_titulo` (
  `docente_cedula` VARCHAR(15) NOT NULL,
  `titulo_id` INT NOT NULL,
  INDEX `fk_docente_titulo_docente1_idx` (`docente_cedula` ASC) VISIBLE,
  INDEX `fk_docente_titulo_titulo1_idx` (`titulo_id` ASC) VISIBLE,
  PRIMARY KEY (`docente_cedula`, `titulo_id`),
  CONSTRAINT `fk_docente_titulo_docente1`
    FOREIGN KEY (`docente_cedula`)
    REFERENCES `grupo33`.`docente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_docente_titulo_titulo1`
    FOREIGN KEY (`titulo_id`)
    REFERENCES `grupo33`.`titulo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`asignatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`asignatura` (
  `codigo` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(80) NOT NULL,
  `creditos` INT NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`asiganuta_docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`asiganuta_docente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `docente_cedula` VARCHAR(15) NOT NULL,
  `asignatura_codigo` VARCHAR(10) NOT NULL,
  INDEX `fk_asiganuta_docente_docente1_idx` (`docente_cedula` ASC) VISIBLE,
  INDEX `fk_asiganuta_docente_asignatura1_idx` (`asignatura_codigo` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_asiganuta_docente_docente1`
    FOREIGN KEY (`docente_cedula`)
    REFERENCES `grupo33`.`docente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asiganuta_docente_asignatura1`
    FOREIGN KEY (`asignatura_codigo`)
    REFERENCES `grupo33`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`estudiante` (
  `tarjeta_identidad` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(80) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`tarjeta_identidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo33`.`estudiante_asignatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo33`.`estudiante_asignatura` (
  `estudiante_tarjeta_identidad` VARCHAR(15) NOT NULL,
  `asignatura_codigo` VARCHAR(10) NOT NULL,
  INDEX `fk_estudiante_asignatura_estudiante1_idx` (`estudiante_tarjeta_identidad` ASC) VISIBLE,
  INDEX `fk_estudiante_asignatura_asignatura1_idx` (`asignatura_codigo` ASC) VISIBLE,
  PRIMARY KEY (`estudiante_tarjeta_identidad`, `asignatura_codigo`),
  CONSTRAINT `fk_estudiante_asignatura_estudiante1`
    FOREIGN KEY (`estudiante_tarjeta_identidad`)
    REFERENCES `grupo33`.`estudiante` (`tarjeta_identidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudiante_asignatura_asignatura1`
    FOREIGN KEY (`asignatura_codigo`)
    REFERENCES `grupo33`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
