CREATE TABLE IF NOT EXISTS account (
    id serial PRIMARY KEY,
    email varchar (250) UNIQUE NOT NULL,
    passwd varchar (250) NOT NULL
);