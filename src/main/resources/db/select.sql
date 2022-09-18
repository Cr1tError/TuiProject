SELECT count(*) count, goal  goal FROM sold_trips
WHERE departure_date BETWEEN '01.01.2022' AND '31.12.2022'
GROUP BY  goal ORDER BY count desc ;

SELECT *  FROM clients
LEFT outer JOIN sold_trips st on clients.id = st.client_id
AND st.departure_date BETWEEN '01.01.2022' AND '31.12.2022'
WHERE st.id IS NULL;


SELECT trip_id trip, sum(payed) summ, avg(payed) avg FROM sold_trips
GROUP BY trip_id;