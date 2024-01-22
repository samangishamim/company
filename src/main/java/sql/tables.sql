CREATE TABLE Shareholder
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255),
    national_code VARCHAR(255),
    phone_number  VARCHAR(255)
);

CREATE TABLE Brand
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255),
    website VARCHAR(255)
);

CREATE TABLE Category
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT
);

CREATE TABLE Product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    create_date DATE,
    category_id INT,
    brand_id    INT,
    FOREIGN KEY (category_id) REFERENCES Category (id),
    FOREIGN KEY (brand_id) REFERENCES Brand (id)
);

CREATE TABLE "user"
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255),
    username  VARCHAR(255) unique ,
    email    VARCHAR(255) unique ,
    password VARCHAR(255)
);

CREATE TABLE Shareholder_Brand
(
    id             SERIAL PRIMARY KEY,
    shareholder_id INT,
    brand_id       INT,
    FOREIGN KEY (shareholder_id) REFERENCES Shareholder (id),
    FOREIGN KEY (brand_id) REFERENCES Brand (id)
);