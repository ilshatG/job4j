CREATE TABLE deals
(
  id serial NOT NULL,
  description character varying(255),
  created timestamp without time zone,
  done boolean,
  CONSTRAINT deals_pkey PRIMARY KEY(id)
)