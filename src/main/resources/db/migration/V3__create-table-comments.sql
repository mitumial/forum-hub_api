CREATE TABLE comments (
    id BIGINT NOT NULL SERIAL,
    message TEXT NOT NULL,
    date_posted TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    solution BOOLEAN NOT NULL,
    commenter_id BIGINT,
    topic_id BIGINT,

    PRIMARY KEY(id),
    CONSTRAINT fk_commenter FOREIGN KEY (commenter_id) REFERENCES members(id),
    CONSTRAINT fk_topic FOREIGN KEY (topic_id) REFERENCES topics(id)
);