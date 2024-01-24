CREATE TABLE shareholder
(
    shareholder_id            SERIAL PRIMARY KEY,
    name          VARCHAR(255),
    national_code int unique ,
    phone_number  varchar(255)
);

CREATE TABLE brand
(
    brand_id      SERIAL PRIMARY KEY,
    name    VARCHAR(255) unique ,
    website VARCHAR(255),
    description varchar(255)
);

CREATE TABLE category
(
    category_id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) unique ,
    description TEXT
);

CREATE TABLE product
(
    product_id          SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    create_date DATE,
    category_id INT references category(category_id),
    brand_id    INT references  brand(brand_id)

);

CREATE TABLE "user"
(
    user_id       SERIAL PRIMARY KEY,
    name     VARCHAR(255),
    username  VARCHAR(255) unique ,
    email    VARCHAR(255) unique ,
    password VARCHAR(255)
);

CREATE TABLE Shareholder_Brand
(
    id             SERIAL PRIMARY KEY,
    shareholder_id INT references  shareholder(shareholder_id),
    brand_id       INT references brand (brand_id)

);