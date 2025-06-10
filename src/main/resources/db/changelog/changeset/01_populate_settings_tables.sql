--liquibase formatted sql

--changeset andrii.kolomoiets:01-populate-settings-table
INSERT INTO settings (sound, music)
VALUES
    (false, false),
    (false, false),
    (false, false),
    (false, false),
    (false, false);
