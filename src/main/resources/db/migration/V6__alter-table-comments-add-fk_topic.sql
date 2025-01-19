ALTER TABLE comments ADD COLUMN topic_id BIGINT;
ALTER TABLE comments
ADD CONSTRAINT fk_topic FOREIGN KEY (topic_id) REFERENCES topics(id);