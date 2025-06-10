--liquibase formatted sql

--changeset andrii.kolomoiets:03-populate-news-table
INSERT INTO news (content)
VALUES
    ('Breaking'),
    ('Announcement'),
    ('Feature Spotlight'),
    ('Reminder'),
    ('Community');
