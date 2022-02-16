CREATE DATABASE movie

CREATE TABLE directors(
id INT NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
avatar TEXT NOT NULL,
description TEXT
)

CREATE TABLE category(
id INT NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL
)

CREATE TABLE actor(
id INT NOT NULL PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
avatar TEXT NOT NULL
)

CREATE TABLE film(
id INT NOT NULL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description TEXT,
poster TEXT NOT NULL,
length INT NOT NULL,
rating INT NOT NULL,
id_directors INT NOT NULL,
FOREIGN KEY (id_directors) REFERENCES directors(id),
release_date DATE NOT NULL
)

CREATE TABLE film_actor(
id_film INT NOT NULL,
id_actor INT NOT NULL,
PRIMARY KEY (id_film,id_actor),
FOREIGN KEY (id_film) REFERENCES film(id),
FOREIGN KEY (id_actor) REFERENCES actor(id)
)

CREATE TABLE film_category(
id_film INT NOT NULL,
id_category INT NOT NULL,
PRIMARY KEY (id_film,id_category),
FOREIGN KEY (id_film) REFERENCES film(id),
FOREIGN KEY (id_category) REFERENCES category(id)
)