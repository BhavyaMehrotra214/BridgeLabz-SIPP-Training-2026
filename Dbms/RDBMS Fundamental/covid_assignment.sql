CREATE DATABASE covid_database;
USE covid_database;
CREATE TABLE covid_cases (
    Country VARCHAR(50),
    Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    Population BIGINT
);
CREATE TABLE covid_deaths (
    Country VARCHAR(50),
    Date DATE,
    Total_Deaths INT,
    Death_Rate DECIMAL(5,2)
);
CREATE TABLE covid_vaccines (
    Country VARCHAR(50),
    Date DATE,
    Total_Vaccinated BIGINT,
    Fully_Vaccinated BIGINT,
    Vaccine_Name VARCHAR(100)
);
INSERT INTO covid_cases
(Country, Date, Confirmed_Cases, Deaths, Recoveries, Population)
VALUES
('India', '2021-01-01', 10300000, 149000, 9900000, 1380004385),
('India', '2021-02-01', 10700000, 154000, 10400000, 1380004385),
('USA', '2021-01-01', 20100000, 347000, 11900000, 331002651),
('USA', '2021-02-01', 26300000, 443000, 16500000, 331002651),
('UK', '2021-01-01', 2600000, 74000, 1800000, 67886011),
('UK', '2021-02-01', 3800000, 106000, 2500000, 67886011);
SELECT * FROM covid_cases;
UPDATE covid_cases
SET Confirmed_Cases = 10750000
WHERE Country = 'India'
AND Date = '2021-02-01';
SELECT * FROM covid_cases;
INSERT INTO covid_cases
VALUES
('IN', '2021-02-01', 10750000, 154000, 10400000, 1380004385);
DELETE FROM covid_cases
WHERE Country = 'IN';
SELECT * FROM covid_cases;
ALTER TABLE covid_cases
ADD vaccination_rate DECIMAL(5,2);
UPDATE covid_cases
SET vaccination_rate = 72.50
WHERE Country = 'India';

UPDATE covid_cases
SET vaccination_rate = 68.90
WHERE Country = 'USA';

UPDATE covid_cases
SET vaccination_rate = 78.40
WHERE Country = 'UK';
SELECT * FROM covid_cases;