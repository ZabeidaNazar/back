DROP TABLE IF EXISTS note;

CREATE TABLE note (
	id BIGSERIAL PRIMARY KEY,
	title varchar(200) NOT NULL CONSTRAINT note_title_length CHECK (length(title) >= 1),
	content varchar NOT NULL CONSTRAINT note_content_length CHECK (length(content) >= 5)
);