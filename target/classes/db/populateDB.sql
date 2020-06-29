DELETE
FROM users;
DELETE
FROM users_roles;
DELETE
FROM maseges;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users(name, password, email)
VALUES ('user', 'password', 'user@yandex.ru'),
       ('admin', 'admin', 'admin@gmail.com'),
       ('user3', 'pasword3', 'user3@gooole.com');

INSERT INTO users_roles (user_id, role)
VALUES (1000, 'ROLE_USER'),
       (1001, 'ROLE_USER'),
       (1002, 'ROLE_ADMIN');

INSERT INTO maseges (text, user_id)
VALUES ('text1', 1000),
       ('text2', 1000),
       ('text3', 1001),
       ('text4', 1002);


