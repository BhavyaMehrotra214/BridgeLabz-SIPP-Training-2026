CREATE DATABASE covid_analysis_db;
USE covid_analysis_db;
CREATE TABLE covid_cases (
    Country VARCHAR(50),
    State VARCHAR(50),
    Report_Date DATE,
    Confirmed_Cases INT,
    Vaccinated INT,
    Unvaccinated INT
);
CREATE TABLE covid_deaths (
    Country VARCHAR(50),
    Report_Date DATE,
    Deaths INT
);
INSERT INTO covid_cases VALUES
('India','Mumbai','2021-01-01',900000,600000,300000),
('India','Mumbai','2021-02-01',1200000,800000,400000),
('India','Delhi','2021-01-01',700000,500000,200000),
('USA','New York','2021-01-01',1500000,1000000,500000),
('USA','California','2021-01-01',1800000,1200000,600000),
('UK','London','2021-01-01',500000,350000,150000);
INSERT INTO covid_deaths VALUES
('India','2021-01-01',12000),
('India','2021-02-01',18000),
('USA','2021-01-01',35000),
('UK','2021-01-01',5000),
('Brazil','2021-01-01',15000);
SELECT AVG(Deaths)
FROM covid_deaths;
SELECT Country, Deaths
FROM covid_deaths
WHERE Deaths >
(
SELECT AVG(Deaths)
FROM covid_deaths
);
SELECT DISTINCT Country
FROM covid_cases
WHERE Country IN
(
SELECT Country
FROM covid_cases
GROUP BY Country
HAVING MAX(Confirmed_Cases) > 1000000
);
SELECT Report_Date,
Confirmed_Cases
FROM covid_cases c1
WHERE State='Mumbai'
AND Confirmed_Cases =
(
SELECT MAX(Confirmed_Cases)
FROM covid_cases c2
WHERE c1.State=c2.State
);
SELECT Country,
Vaccinated AS Population,
'Vaccinated' AS Status
FROM covid_cases

UNION

SELECT Country,
Unvaccinated,
'Unvaccinated'
FROM covid_cases;
SELECT Country
FROM covid_deaths
WHERE Country NOT IN
(
SELECT Country
FROM covid_cases
);
SELECT * FROM covid_cases;
SELECT * FROM covid_deaths;