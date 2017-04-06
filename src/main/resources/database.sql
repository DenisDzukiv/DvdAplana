-- CREATE SCHEMA `dvd_aplana` ;
-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: dvd
CREATE TABLE dvd (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dvd_name VARCHAR(255),
  dvd_owner int (11),
  given int(1),
  FOREIGN KEY (dvd_owner) REFERENCES users (id)
  )
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE location_disk (
  user_id INT NOT NULL,
  dvd_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (dvd_id) REFERENCES dvd (id),
  UNIQUE (user_id, dvd_id)
)
  ENGINE = InnoDB;
--
-- Insert data
INSERT INTO users VALUES (1,'Denis', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG'); -- 12345678
INSERT INTO users VALUES (2,'Anna', '$2a$11$5XZdAX4BElpIPHK3y8jg.eaSZQiC5AbkbstB/1oTSA0tzgCGxUiaS');

INSERT INTO dvd VALUES (1, 'DVD_1',1);
INSERT INTO dvd VALUES (2, 'DVD_2',2);
INSERT INTO dvd VALUES (3, 'DVD_3',1);
INSERT INTO dvd VALUES (4, 'DVD_4',2);
INSERT INTO dvd VALUES (5, 'DVD_5');
commit;

INSERT INTO dvd_aplana.location_disk VALUES (1,1);
INSERT INTO dvd_aplana.location_disk VALUES (1,3);
INSERT INTO dvd_aplana.location_disk VALUES (2,4);
commit;
