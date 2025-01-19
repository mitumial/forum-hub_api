CREATE TABLE topics (
    id BIGINT NOT NULL SERIAL,
    title VARCHAR(300) NOT NULL,
    message TEXT NOT NULL,
    date_posted TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status post_status NOT NULL DEFAULT 'ACTIVE',
    original_poster_id BIGINT,
    course_id BIGINT,

    PRIMARY KEY(id),
    CONSTRAINT fk_original_poster FOREIGN KEY (original_poster_id) REFERENCES members(id),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES courses(id)
);