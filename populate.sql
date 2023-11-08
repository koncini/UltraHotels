/*hotels fields and rooms*/
CREATE TABLE `ultragroup_hotels`.`hotels` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45),
  `enabled` BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
  );
  
 CREATE TABLE `ultragroup_hotels`.`rooms` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hotel_id` INT NOT NULL,
  `details` VARCHAR(50),
  `base_price` INT,
  `tax` INT,
  `room_type` VARCHAR(50),
  `latitude` DECIMAL(18,9) NOT NULL,
  `longitude` DECIMAL(18,9) NOT NULL,
  `enabled` BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_rooms_hotels`
    FOREIGN KEY (`zone_id`)
    REFERENCES `ultragroup_hotels`.`hotels` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

 CREATE TABLE `ultragroup_hotels`.`reservations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `room_id` INT NOT NULL,
  `settings` VARCHAR(5000) NOT NULL,
  `metrics` VARCHAR(10000) NOT NULL,
  `enabled` BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_rooms_hotels`
    FOREIGN KEY (`zone_id`)
    REFERENCES `ultragroup_hotels`.`hotels` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

/*Users and authorities*/

CREATE TABLE `ultragroup_hotels`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45),
  `document_type` VARCHAR(45),
  `document_number` BIGINT,
  `email` VARCHAR(45),
  `password` VARCHAR(60) NOT NULL,
  `enabled` BOOLEAN NOT NULL DEFAULT 1,
  `last_login` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE
);

CREATE TABLE `ultragroup_hotels`.`authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_authorities_unique` (`user_id` ASC, `authority` ASC) VISIBLE,
  CONSTRAINT `fk_authorities_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `ultragroup_hotels`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

/*Users and authorities*/
INSERT INTO users (username, name, last_name, gender, document_type, document_number, email, password, enabled, last_login) VALUES ('admin', 'user', 'user', 'male', 'CC', 10562080, 'user.user@ultra.com.co', '$2a$10$uoxBSo1vDV5UvB8VTPItu.8jLzJwMVfAnllZbl4yjpYWcpmXV1T1S', 1, '2023-02-22 15:40:10');
INSERT INTO users (username, name, last_name, gender, document_type, document_number, email, password, enabled, last_login) VALUES ('basic', 'user1', 'user1', 'male', 'CC', 10562081, 'user1.user1@ultra.com.co','$2a$10$YV65ExjewVvYKW10p6mhwugtMlvYVKR/jcKkRC1FoN0GMr7fiht1W', 1, '2023-02-22 15:40:10');

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_STAFF');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_MANAGER');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');  
  