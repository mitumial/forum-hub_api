CREATE TABLE topics (
    id BIGINT NOT NULL auto_increment,
    title VARCHAR(300) NOT NULL,
    message TEXT NOT NULL,
    date_posted TIMESTAMP NOT NULL,
    course VARCHAR(300) NOT NULL,
    status VARCHAR(6) NOT NULL,
    original_poster_id BIGINT,

    PRIMARY KEY(id)
    CONSTRAINT fk_original_poster FOREIGN KEY (original_poster_id) REFERENCES members(id)
);