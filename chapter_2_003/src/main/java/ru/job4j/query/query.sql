SELECT p.id, p.name, p.expired_date, p.price  FROM product as p
INNER JOIN type AS t ON p.type_id = t.id
WHERE t.name = 'СЫР'
;

SELECT * FROM product
WHERE name like '%мороженое%'
;

SELECT * FROM product
WHERE expired_date BETWEEN  '01.12.2018' AND '31.12.2018'
;

SELECT * FROM product
WHERE price = (SELECT MAX(price) FROM product)
;

SELECT COUNT(p) FROM product AS p
INNER JOIN type as t ON p.type_id = t.id
WHERE t.name = 'МОЛОКО'
;

SELECT * FROM product AS p
INNER JOIN type as t ON p.type_id = t.id
WHERE t.name = 'МОЛОКО' OR t.name = 'СЫР'
;

SELECT t.name, COUNT(t.name) AS cnt FROM product AS p
INNER JOIN type as t ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(t.name) > 10
;

SELECT p.name, t.name FROM product as p
INNER JOIN type as t ON p.type_id = t.id
;
