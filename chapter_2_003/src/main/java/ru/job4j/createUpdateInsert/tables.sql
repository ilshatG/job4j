CREATE TABLE user_roles (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE user_permissions (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE role_permissions (
	role_id INTEGER REFERENCES user_roles(id),
	user_permission_id INTEGER REFERENCES user_permissions(id)
);

CREATE TABLE USERS (
	ID SERIAL PRIMARY KEY,
	NAME VARCHAR(50),
	user_role_id INTEGER REFERENCES user_roles(id)
);


CREATE TABLE order_categories (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE order_states (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE orders (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	description VARCHAR(100),
	create_date TIMESTAMP,
	user_id INTEGER REFERENCES users(id),
	categorie_id INTEGER REFERENCES order_categories(id),
	state_id INTEGER REFERENCES order_states(id)
);

CREATE TABLE comments (
	id SERIAL PRIMARY KEY,
	name TEXT,
	create_date timestamp,
	order_id INTEGER REFERENCES orders(id)
);

CREATE TABLE attachs (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	content BYTEA,
	order_id INTEGER REFERENCES orders(id)
);
