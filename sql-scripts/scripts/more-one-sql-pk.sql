-- Таблица со списком компаний
CREATE TABLE company(
    id SERIAL PRIMARY KEY ,
    name TEXT NOT NULL
);

CREATE TABLE employee(
    id SERIAL,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    company_id int REFERENCES company (id) ON DELETE CASCADE,
    salary int NOT NULL,

--  создание составного первичного ключа
    PRIMARY KEY (id, first_name)
);