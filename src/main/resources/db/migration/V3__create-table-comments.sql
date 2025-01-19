CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    message TEXT NOT NULL,
    date_posted TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_solution BOOLEAN NOT NULL,
    commenter_id BIGINT,

    CONSTRAINT fk_commenter FOREIGN KEY (commenter_id) REFERENCES members(id)
);