--liquibase formatted sql

--changeset andrii.kolomoiets:03-create-news-table
CREATE TABLE news
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    content    TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);