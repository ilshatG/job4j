INSERT INTO carBody (name) VALUES ('Седан');
INSERT INTO carBody (name) VALUES ('Универсал');
INSERT INTO carBody (name) VALUES ('Хэтчбек');
INSERT INTO carBody (name) VALUES ('Кабриолет');

INSERT INTO engine (name) VALUES ('Дизельный');
INSERT INTO engine (name) VALUES ('Бензиновый');
INSERT INTO engine (name) VALUES ('Газгольдер');

INSERT INTO transmission (name) VALUES ('АКПП');
INSERT INTO transmission (name) VALUES ('МКПП');
INSERT INTO transmission (name) VALUES ('Вариатор');
INSERT INTO transmission (name) VALUES ('Безредукторная трансмиссия');

INSERT INTO car (name, id_carBody, id_engine, id_transmission) VALUES ('Toyota Camry', 1, 2, 1);
INSERT INTO car (name, id_carBody, id_engine, id_transmission) VALUES ('Lada Vesta', 1, 2, 2);
INSERT INTO car (name, id_carBody, id_engine, id_transmission) VALUES ('Mazda CX-5', 2, 1, 3);
INSERT INTO car (name) VALUES ('Гужевая повозка');
