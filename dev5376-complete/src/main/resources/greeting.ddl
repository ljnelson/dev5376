CREATE TABLE IF NOT EXISTS GREETING (
    SALUTATION VARCHAR(64) NOT NULL PRIMARY KEY,
    RESPONSE VARCHAR(64) NOT NULL
);

MERGE INTO GREETING (SALUTATION, RESPONSE) VALUES ('Marco', 'Polo');
