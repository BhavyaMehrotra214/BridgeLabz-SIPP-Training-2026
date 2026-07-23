CREATE DATABASE covid_advanced_db;
USE covid_advanced_db;
CREATE TABLE covid_cases(
    Country VARCHAR(50),
    Report_Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT
);
INSERT INTO covid_cases VALUES
('India','2021-01-01',100000,2000,90000),
('India','2021-02-01',120000,2500,110000),
('USA','2021-01-01',200000,5000,170000),
('USA','2021-02-01',250000,6000,220000),
('UK','2021-01-01',70000,1200,65000),
('UK','2021-02-01',90000,1500,85000);
SELECT * FROM covid_cases;
CREATE VIEW LatestCovidData AS
SELECT Country,
Report_Date,
Confirmed_Cases,
Deaths,
Recoveries
FROM covid_cases c1
WHERE Report_Date=
(
SELECT MAX(c2.Report_Date)
FROM covid_cases c2
WHERE c1.Country=c2.Country
);
SELECT * FROM LatestCovidData;
DELIMITER $$

CREATE FUNCTION CalculateMortalityRate(
p_country VARCHAR(50),
p_date DATE
)
RETURNS DECIMAL(5,2)

DETERMINISTIC

BEGIN

DECLARE rate DECIMAL(5,2);

SELECT (Deaths/Confirmed_Cases)*100
INTO rate

FROM covid_cases

WHERE Country=p_country
AND Report_Date=p_date;

RETURN rate;

END $$

DELIMITER ;
SELECT CalculateMortalityRate('India','2021-02-01');
DELIMITER $$

CREATE PROCEDURE UpdateCovidStats(

IN p_country VARCHAR(50),

IN p_date DATE,

IN p_cases INT,

IN p_deaths INT,

IN p_recoveries INT

)

BEGIN

UPDATE covid_cases

SET

Confirmed_Cases=p_cases,

Deaths=p_deaths,

Recoveries=p_recoveries

WHERE Country=p_country

AND Report_Date=p_date;

END $$

DELIMITER ;
CALL UpdateCovidStats(
'India',
'2021-02-01',
125000,
2600,
115000
);
SELECT * FROM covid_cases;
DELIMITER $$

CREATE FUNCTION CalculateRecoveryRate(

p_country VARCHAR(50)

)

RETURNS DECIMAL(5,2)

DETERMINISTIC

BEGIN

DECLARE rate DECIMAL(5,2);

SELECT (Recoveries/Confirmed_Cases)*100

INTO rate

FROM covid_cases

WHERE Country=p_country

ORDER BY Report_Date DESC

LIMIT 1;

RETURN rate;

END $$

DELIMITER ;
SELECT CalculateRecoveryRate('India');
CREATE TABLE covid_audit(

AuditID INT AUTO_INCREMENT PRIMARY KEY,

Country VARCHAR(50),

OldCases INT,

NewCases INT,

UpdatedOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);
DELIMITER $$

CREATE TRIGGER covid_audit_trigger

BEFORE UPDATE

ON covid_cases

FOR EACH ROW

BEGIN

INSERT INTO covid_audit(

Country,

OldCases,

NewCases

)

VALUES(

OLD.Country,

OLD.Confirmed_Cases,

NEW.Confirmed_Cases

);

END $$

DELIMITER ;
UPDATE covid_cases

SET Confirmed_Cases=130000

WHERE Country='India'

AND Report_Date='2021-02-01';
SELECT * FROM covid_audit;
