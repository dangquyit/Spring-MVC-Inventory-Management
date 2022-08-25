DROP DATABASE inventory_management;

CREATE DATABASE inventory_management
CHARACTER SET utf8
COLLATE utf8_general_ci;

CREATE TABLE inventory_management.users (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) DEFAULT NULL,
    `name` VARCHAR(100) NOT NULL,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.user_role (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_id` INT(11) NOT NULL,
    `role_id` INT(11) NOT NULL,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.role(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `role_name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(200) NOT NULL,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.auth(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `role_id` INT(11) NOT NULL,
    `menu_id` INT(11) NOT NULL,
    `premisstion` INT(1) NOT NULL DEFAULT 1,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.menu(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `parent_id` INT(11) NOT NULL,
    `url` VARCHAR(100) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `order_index` INT(1) NOT NULL DEFAULT 0,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.category(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `code` VARCHAR(50) NOT NULL,
    `description` TEXT,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.product_in_stock(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `product_id` INT(11) NOT NULL,
    `quantity` INT(11) NOT NULL,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.history(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `action_name` VARCHAR(100) NOT NULL,
    `type` INT(1) NOT NULL,
    `product_id` INT(11) NOT NULL,
    `quantity` INT(11) NOT NULL,
    `price` DECIMAL(15,2) NOT NULL,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.invoice(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `code` VARCHAR(50) NOT NULL,
    `type` INT(1) NOT NULL,
    `product_id` INT(11) NOT NULL,
    `quantity` INT(11) NOT NULL,
    `price` DECIMAL(15,2) NOT NULL,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE inventory_management.product_info(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `category_id` INT(11) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `code` VARCHAR(50) NOT NULL,
    `description` TEXT,
    `img_url` VARCHAR(200) NOT NULL,
    `active_flag` INT(1) NOT NULL DEFAULT 1,
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);


ALTER TABLE `inventory_management`.`user_role` 
ADD CONSTRAINT `userid_foreign_key`
FOREIGN KEY (`user_id`)
REFERENCES `inventory_management`.`users` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE `inventory_management`.`user_role` 
ADD CONSTRAINT `roleid_foreign_key`
FOREIGN KEY (`role_id`)
REFERENCES `inventory_management`.`role` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE `inventory_management`.`auth` 
ADD CONSTRAINT `auth_roleid_foreign_key`
FOREIGN KEY (`role_id`)
REFERENCES `inventory_management`.`role` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE `inventory_management`.`auth` 
ADD CONSTRAINT `auth_menu_id_foreign_key`
FOREIGN KEY (`menu_id`)
REFERENCES `inventory_management`.`menu` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE `inventory_management`.`product_in_stock` 
ADD CONSTRAINT `product_id_foreign_key`
FOREIGN KEY (`product_id`)
REFERENCES `inventory_management`.`product_info` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE `inventory_management`.`product_info` 
ADD CONSTRAINT `category_id_foreign_key`
FOREIGN KEY (`category_id`)
REFERENCES `inventory_management`.`category` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE `inventory_management`.`history` 
ADD CONSTRAINT `history_product_id_foreign_key`
FOREIGN KEY (`product_id`)
REFERENCES `inventory_management`.`product_info` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE `inventory_management`.`invoice` 
ADD CONSTRAINT `invoice_product_id_foreign_key`
FOREIGN KEY (`product_id`)
REFERENCES `inventory_management`.`product_info` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;




