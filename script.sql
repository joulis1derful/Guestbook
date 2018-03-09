CREATE TABLE `guestbook`.`page` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `guestbook`.`visitor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `tel` VARCHAR(45) NOT NULL,
  `dob` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `guestbook`.`guestbook` (
  `id_record` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  `page_id` INT NULL,
  `visitor_id` INT NULL,
  PRIMARY KEY (`id_record`),
  INDEX `page_id_idx` (`page_id` ASC),
  INDEX `visitor_id_idx` (`visitor_id` ASC),
  CONSTRAINT `page_id`
    FOREIGN KEY (`page_id`)
    REFERENCES `guestbook`.`page` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `visitor_id`
    FOREIGN KEY (`visitor_id`)
    REFERENCES `guestbook`.`visitor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

