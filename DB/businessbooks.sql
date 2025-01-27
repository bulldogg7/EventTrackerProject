-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema businessbooksdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `businessbooksdb` ;

-- -----------------------------------------------------
-- Schema businessbooksdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `businessbooksdb` DEFAULT CHARACTER SET utf8 ;
USE `businessbooksdb` ;

-- -----------------------------------------------------
-- Table `business_book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `business_book` ;

CREATE TABLE IF NOT EXISTS `business_book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `category` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `number_of_pages` INT NULL,
  `purchase_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `finish_date` DATETIME NULL,
  `image_url` VARCHAR(200) NULL,
  `rating` INT NULL,
  `review` TEXT NULL,
  `recommend` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS entrepreneur@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'entrepreneur'@'localhost' IDENTIFIED BY 'entrepreneur';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'entrepreneur'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `business_book`
-- -----------------------------------------------------
START TRANSACTION;
USE `businessbooksdb`;
INSERT INTO `business_book` (`id`, `title`, `category`, `author`, `number_of_pages`, `purchase_date`, `last_update`, `finish_date`, `image_url`, `rating`, `review`, `recommend`) VALUES (1, 'Rich Dad Poor Dad', 'Finance', 'Robert Kiyosaki', 336, '2008-9-13', '2011-11-5', '2008-9-25', 'https://m.media-amazon.com/images/I/71o4HTng33L.jpg', 8, 'Good first book for a beginner in business.', 10);

COMMIT;

