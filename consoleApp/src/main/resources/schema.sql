CREATE TABLE IF NOT EXISTS film
(
    id         SERIAL PRIMARY KEY,
    rate       FLOAT,
    rate_date  DATE,
    name       VARCHAR(1023),
    year       INT,
    cnt_voters BIGINT
);