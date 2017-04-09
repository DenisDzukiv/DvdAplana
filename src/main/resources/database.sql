CREATE SCHEMA `dvd_aplana` ;
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
  dvd_name VARCHAR(255) not null,
  dvd_owner int (11) not null,
  given int(1) default 0 ,
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
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- User_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;
-- Insert data
INSERT INTO users VALUES (1,'dennis', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG'); -- 12345678
INSERT INTO users VALUES (2,'anna', '$2a$11$AExaafXF6quNVOJUoL0PA.4I89aC2VWkZxr99NjN2oXjjkHnRaeou'); -- asdfghjk
commit;

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');
commit;

INSERT INTO user_roles VALUES (1, 1);
INSERT INTO user_roles VALUES (2, 1);
commit;

INSERT INTO dvd VALUES (1, 'DVD_1',1,1);
INSERT INTO dvd VALUES (2, 'DVD_2',1,1);
INSERT INTO dvd VALUES (3, 'DVD_3',1,0);
INSERT INTO dvd VALUES (4, 'DVD_4',1,0);
INSERT INTO dvd VALUES (5, 'DVD_5',2,1);
INSERT INTO dvd VALUES (6, 'DVD_6',2,1);
INSERT INTO dvd VALUES (7, 'DVD_7',2,0);
INSERT INTO dvd VALUES (8, 'DVD_8',2,0);
commit;

INSERT INTO location_disk VALUES (1,5);
INSERT INTO location_disk VALUES (1,6);
INSERT INTO location_disk VALUES (2,1);
INSERT INTO location_disk VALUES (2,2);
commit;
