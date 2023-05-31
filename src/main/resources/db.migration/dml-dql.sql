-- Список наборов карточек;
SELECT flashcard_set.id    AS id,
       flashcard_set.title AS title
FROM flashcard_set;

-- Добавление наборов карточек;
INSERT INTO flashcard_set (title)
VALUES ('Английский: Цвета');

INSERT INTO flashcard_set (title)
VALUES ('Программирование: ООП');

INSERT INTO flashcard_set (title)
VALUES ('Английский: Животные');

INSERT INTO flashcard_set (title)
VALUES ('Французский');

-- Удаление набора карточек
DELETE
FROM flashcard_set
WHERE flashcard_set.id = 3;

-- Список карточек
SELECT flashcard.Id       AS id,
       flashcard.question AS question,
       flashcard.answer   AS answer,
       flashcard.learned  AS learned
FROM flashcard
WHERE flashcard.set_id = 2;

-- Добавление карточек
INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (4, 'Красный', 'Red', false);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (4, 'Зеленый', 'Green', true);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (4, 'Желтый', 'Yellow', false);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (5, 'Кот', 'Cat', false);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (5, 'Собака', 'Dog', true);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (5, 'Слон', 'Elephant', false);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (2, 'Размер типа данных int (байт)', '4 байта', false);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (2, 'Размер типа данных char (байт)', '1 байт', true);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (2, 'Размер типа данных double (байт)', '8 байт', false);

INSERT INTO flashcard (set_id, question, answer, learned)
VALUES (2, 'Размер типа данных short (байт)', '2 байта', false);

-- Удаление карточки
DELETE
FROM flashcard
WHERE flashcard.id = 10;

-- Список наборов карточек со счётчиком
SELECT flashcard_set.id    AS id,
       flashcard_set.title AS title,
       count(flashcard.id)    FILTER ( WHERE flashcard.learned ) AS learned_flashcard_count, count(flashcard.id) AS total_flashcards_count
FROM flashcard_set
         LEFT JOIN flashcard ON flashcard_set.id = flashcard.set_id
GROUP BY flashcard_set.id;

-- Тренировка
SELECT flashcard.id       AS id,
       flashcard.question AS question,
       flashcard.answer   AS answer,
       flashcard.learned  AS leared
FROM flashcard
WHERE flashcard.set_id = 5
  AND NOT flashcard.learned
  AND flashcard.id > 4
ORDER BY flashcard.id LIMIT 1;






