CREATE TABLE carBody (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50)
);

CREATE TABLE engine (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50)
);

CREATE TABLE transmission (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50)
);

CREATE TABLE car (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50),
  id_carBody INTEGER REFERENCES carBody(id),
  id_engine INTEGER REFERENCES engine(id),
  id_transmission INTEGER REFERENCES transmission(id)
);
