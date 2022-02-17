CREATE DATABASE blog

CREATE TABLE users(
id INT NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
email TEXT NOT NULL,
mobile VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
avatar TEXT NOT NULL
)

CREATE TABLE tag(
id INT NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL
)

CREATE TABLE post(
id INT NOT NULL PRIMARY KEY,
title TEXT NOT NULL,
content TEXT NOT NULL,
description TEXT NOT NULL,
author_id INT NOT NULL,
thumbnail TEXT NOT NULL,
status TEXT NOT NULL,
create_at DATE NOT NULL,
published_at DATE NOT NULL,
view_count INT NOT NULL,
vote_score INT NOT NULL,
post_type TEXT NOT NULL
)

CREATE TABLE post_tag(
post_id INT NOT NULL,
tag_id INT NOT NULL,
PRIMARY KEY(post_id,tag_id),
FOREIGN KEY (post_id) REFERENCES post(id),
FOREIGN KEY (tag_id) REFERENCES tag(id)
)

CREATE TABLE discuss(
id INT NOT NULL PRIMARY KEY,
post_id INT NOT NULL,
author_id INT NOT NULL,
text TEXT NOT NULL,
is_public TEXT NOT NULL,
create_at DATE NOT NULL,
FOREIGN KEY (post_id) REFERENCES post(id)
)