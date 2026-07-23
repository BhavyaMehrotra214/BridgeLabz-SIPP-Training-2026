SHOW DATABASES;
USE covid_db;
SHOW TABLES;
DESC covid_vaccine_statewise;
CREATE INDEX idx_country_date
ON covid_cases (Country, Date);
USE covid_database;
SHOW TABLES;
CREATE INDEX idx_country_date
ON covid_cases (Country, Date);
CREATE INDEX idx_date
ON covid_cases(Date);
SHOW INDEX FROM covid_cases;
CREATE INDEX idx_infection_rate
ON covid_cases(infection_rate);
DESC covid_cases;
ALTER TABLE covid_cases
ADD COLUMN infection_rate DECIMAL(5,2);
UPDATE covid_cases
SET infection_rate = (Confirmed_Cases * 100.0) / Population;
CREATE INDEX idx_infection_rate
ON covid_cases(infection_rate);
EXPLAIN
SELECT
    c.Country,
    c.Confirmed_Cases,
    d.Total_Deaths,
    d.Death_Rate
FROM covid_cases c
JOIN covid_deaths d
ON c.Country = d.Country
AND c.Date = d.Date
WHERE c.Country = 'India';
SHOW TABLES;
DESC covid_vaccines;
START TRANSACTION;
SHOW COLUMNS FROM covid_vaccines;
INSERT INTO covid_vaccines
(Country, Date, Total_Vaccinated, Fully_Vaccinated, Vaccine_Name)
VALUES
('India', '2021-07-15', 500000, 350000, 'Covaxin');
INSERT INTO covid_vaccines
(Country, Date, Total_Vaccinated, Fully_Vaccinated, Vaccine_Name)
VALUES
('USA', '2021-07-15', 800000, 650000, 'Pfizer');
COMMIT;
START TRANSACTION;

INSERT INTO covid_vaccines
(Country, Date, Total_Vaccinated, Fully_Vaccinated, Vaccine_Name)
VALUES
('Japan', '2021-07-15', 300000, 200000, 'Moderna');

ROLLBACK;
SELECT * FROM covid_vaccines;
