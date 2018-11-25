SELECT c.name, b.name, e.name, t.name FROM car as c
LEFT OUTER JOIN carBody as b ON b.id = id_carBody
LEFT OUTER JOIN engine as e ON e.id = id_engine
LEFT OUTER JOIN transmission as t ON t.id = id_transmission
;

SELECT b.name FROM car as c
RIGHT OUTER JOIN carBody as b ON b.id = id_carbody
WHERE c.id is NULL
;

SELECT e.name FROM car as c
RIGHT OUTER JOIN engine as e ON e.id = id_engine
WHERE c.id is NULL
;

SELECT t.name FROM car as c
RIGHT OUTER JOIN transmission as t ON t.id = id_transmission
WHERE c.name is NULL
;
