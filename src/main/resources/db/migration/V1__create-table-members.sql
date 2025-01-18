CREATE TABLE members (
    id BIGINT NOT NULL auto_increment,
    alias VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(300) NOT NULL UNIQUE,
    password VARCHAR(300) NOT NULL,

    PRIMARY KEY(id)
);