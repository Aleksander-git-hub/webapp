CREATE DATABASE `project_db` ENCODING 'UTF-8';

DROP TABLE IF EXISTS "attribute";
DROP TABLE IF EXISTS "geometry";
DROP TABLE IF EXISTS "projects";

CREATE SEQUENCE project_id_seq;

CREATE TABLE "projects" (
    project_id INT NOT NULL DEFAULT nextval('project_id_seq'),
    project_name VARCHAR (100) NOT NULL,
    PRIMARY KEY(project_id)
);

CREATE TABLE "geometry" (
    geometry_project_id INT NOT NULL,
    geometry_id SERIAL NOT NULL,
    geometry_name VARCHAR (100) NOT NULL,
    PRIMARY KEY (geometry_id),
    FOREIGN KEY (geometry_project_id) REFERENCES projects (project_id) ON DELETE RESTRICT
);

CREATE TABLE "attribute" (
    attribute_project_id INT NOT NULL,
    attribute_geometry_id INT,
    attribute_id SERIAL NOT NULL,
    attribute_name VARCHAR (100) NOT NULL,
    PRIMARY KEY (attribute_id),
    FOREIGN KEY (attribute_project_id) REFERENCES projects (project_id) ON DELETE RESTRICT,
    FOREIGN KEY (attribute_geometry_id) REFERENCES geometry (geometry_id) ON DELETE RESTRICT
);