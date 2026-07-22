CREATE DATABASE covid_constraints_db;
USE covid_constraints_db;
CREATE TABLE covid_cases (
    Country VARCHAR(50) NOT NULL,
    Report_Date DATE NOT NULL,
    Confirmed_Cases INT NOT NULL,
    Deaths INT,
    Recoveries INT,
    Population BIGINT,
    PRIMARY KEY (Country, Report_Date)
);
DESCRIBE covid_cases;
CREATE TABLE countries (
    Country VARCHAR(50) PRIMARY KEY,
    Continent VARCHAR(50),
    Population BIGINT
);
INSERT INTO countries
VALUES
('India', 'Asia', 1380004385),
('USA', 'North America', 331002651),
('UK', 'Europe', 67886011);
DROP TABLE covid_cases;
CREATE TABLE covid_cases (
    Country VARCHAR(50) NOT NULL,
    Report_Date DATE NOT NULL,
    Confirmed_Cases INT NOT NULL,
    Deaths INT,
    Recoveries INT,
    Population BIGINT,

    PRIMARY KEY (Country, Report_Date),

    FOREIGN KEY (Country)
    REFERENCES countries(Country)
);
INSERT INTO covid_cases
VALUES
('India','2021-01-01',100,2,50,1380004385);
DROP TABLE covid_cases;
CREATE TABLE covid_cases (

    Country VARCHAR(50) NOT NULL,

    Report_Date DATE NOT NULL,

    Confirmed_Cases INT NOT NULL,

    Deaths INT,

    Recoveries INT,

    Population BIGINT,

    PRIMARY KEY (Country, Report_Date),

    FOREIGN KEY (Country)
    REFERENCES countries(Country),

    CHECK (Deaths <= Confirmed_Cases)
);
INSERT INTO covid_cases
VALUES
('India','2021-02-01',100,10,70,1380004385);
DROP TABLE covid_cases;
CREATE TABLE covid_cases (

    Country VARCHAR(50) NOT NULL,

    Report_Date DATE NOT NULL,

    Confirmed_Cases INT NOT NULL,

    Deaths INT,

    Recoveries INT DEFAULT 0,

    Population BIGINT,

    Last_Updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (Country, Report_Date),

    FOREIGN KEY (Country)
    REFERENCES countries(Country),

    CHECK (Deaths <= Confirmed_Cases)
);
INSERT INTO covid_cases
(Country, Report_Date, Confirmed_Cases, Deaths, Population)
VALUES
('India','2021-04-01',150,5,1380004385);
SELECT * FROM covid_cases;
CREATE TABLE covid_cases_unique (

    Country VARCHAR(50),

    Report_Date DATE,

    Confirmed_Cases INT,

    UNIQUE (Country, Report_Date)
);
INSERT INTO covid_cases_unique
VALUES
('India','2021-01-01',100);
INSERT INTO covid_cases_unique
VALUES
('India','2021-01-01',200);