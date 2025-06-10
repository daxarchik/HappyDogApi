--liquibase formatted sql

--changeset andrii.kolomoiets:02-create-users-table
CREATE TABLE users
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    telegram_id BIGINT        NOT NULL UNIQUE,
    username    VARCHAR(50)   NOT NULL UNIQUE,
    settings_id BIGINT UNIQUE NOT NULL,
    score       BIGINT,
    upgrade1    INT,
    upgrade2    INT,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_users_settings FOREIGN KEY(settings_id) REFERENCES settings(id) ON DELETE SET NULL ON UPDATE CASCADE
);
