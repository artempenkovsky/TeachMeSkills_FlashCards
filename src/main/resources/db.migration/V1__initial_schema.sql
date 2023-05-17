CREATE TABLE flashcard_set
(
    id    BIGSERIAL PRIMARY KEY,
    title TEXT NOT NULL
);

CREATE TABLE flashcard
(
    id       BIGSERIAL PRIMARY KEY,
    set_id   BIGINT  NOT NULL REFERENCES flashcard_set ON DELETE CASCADE,
    question TEXT    NOT NULL,
    answer   TEXT    NOT NULL,
    learned  BOOLEAN NOT NULL
);
