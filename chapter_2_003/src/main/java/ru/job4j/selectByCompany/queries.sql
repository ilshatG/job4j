SELECT p.name FROM person AS p
INNER JOIN company AS c on c.id = p.company_id
WHERE c.id <> 5;

SELECT c.name, COUNT(p.name) FROM company AS c
INNER JOIN person as p on c.id = p.company_id
GROUP BY c.name
;

SELECT c.name, COUNT(p.name) maximum FROM company AS c
INNER JOIN person as p on c.id = p.company_id
GROUP BY c.name
ORDER BY maximum DESC
LIMIT 1
;