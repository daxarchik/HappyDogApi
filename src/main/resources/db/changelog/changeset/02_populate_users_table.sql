--liquibase formatted sql

--changeset andrii.kolomoiets:02-populate-users-table
INSERT INTO users (telegram_id, username, settings_id, score, upgrade1, upgrade2)
VALUES
    (1111, 'alice', 1,  50, 1, 2),
    (2222, 'bob',   2,  75, 2, 1),
    (3333, 'carol', 3, 100, 3, 3),
    (4444, 'dave',  4, 150, 5, 2),
    (5555, 'eve',   5, 200, 4, 4);
