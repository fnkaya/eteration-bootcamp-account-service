CREATE TABLE IF NOT EXISTS account (
                                       id INT NOT NULL,
                                       email varchar(250) NOT NULL UNIQUE,
    passwd varchar (250) NOT NULL
    PRIMARY KEY (id)
    );