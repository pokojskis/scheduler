--liquibase formatted sql
--changeset spokojski:1
CREATE TABLE TEST (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(400) NOT NULL,
    created timestamp
);