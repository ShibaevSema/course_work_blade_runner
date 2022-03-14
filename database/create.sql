CREATE TABLE IF NOT EXISTS LOCATION
(
    ID        SERIAL PRIMARY KEY,
    PLANET    varchar(255) NOT NULL,
    LATITUDE  INTEGER      NOT NULL,
    LONGITUDE INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS ENTITY
(
    ID          SERIAL PRIMARY KEY,
    FULL_NAME   varchar(255) NOT NULL,
    BIRTH_DATE  DATE,
    IS_HUMAN    BOOLEAN,
    LOCATION_ID INTEGER REFERENCES LOCATION (ID),
    DEATH_DATE  DATE,
    SEX         BOOLEAN      NOT NULL
);

CREATE TABLE IF NOT EXISTS ACTION
(
    ID            SERIAL PRIMARY KEY,
    NAME          varchar(255) NOT NULL,
    DESCRIPTION   TEXT,
    benefitOrHarm boolean
);

CREATE TABLE IF NOT EXISTS IMPACT_ON_SOCIETY
(
    ID        SERIAL PRIMARY KEY,
    ACTION_ID INTEGER REFERENCES action (ID),
    ENTITY_ID INTEGER REFERENCES entity (ID)
);

CREATE TABLE IF NOT EXISTS DESCENDANTS
(
    ID         SERIAL PRIMARY KEY,
    PARENT1_ID INTEGER REFERENCES entity (ID),
    PARENT2_ID INTEGER REFERENCES entity (ID),
    CHILD_ID   INTEGER REFERENCES entity (ID)
);

CREATE TABLE IF NOT EXISTS VOIGHT_KAMPF_TEST
(
    ID              SERIAL PRIMARY KEY,
    ENTITY_ID       INTEGER REFERENCES entity (ID),
    EYE_MOVEMENT    BOOLEAN,
    BRAIN_REACTION  BOOLEAN,
    COMPLETION_DATE DATE,
    RESULT          BOOL NOT NULL
);

CREATE TABLE IF NOT EXISTS QUESTIONS
(
    ID            SERIAL PRIMARY KEY,
    QUESTION_TEXT TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS VOIGHT_KAMPF_TEST_ANSWERS
(
    QUESTION_ID        INTEGER REFERENCES questions (ID),
    VOIGHT_KAMPF_TEST_ID INTEGER REFERENCES VOIGHT_kampf_test (ID),
    PRIMARY KEY (QUESTION_ID, VOIGHT_KAMPF_TEST_ID),
    ANSWER text,
    RESULT bool NOT NULL
);


CREATE TABLE IF NOT EXISTS PROFESSION
(
    ID          SERIAL PRIMARY KEY,
    NAME        varchar(255) NOT NULL,
    DESCRIPTION TEXT
);

CREATE TABLE IF NOT EXISTS WORKERS
(
    ID            SERIAL PRIMARY KEY,
    ENTITY_ID     INTEGER REFERENCES entity (ID),
    PROFESSION_ID INTEGER REFERENCES profession (ID)
);

CREATE TABLE IF NOT EXISTS BLADE_RUNNERS_HQ
(
    ID          SERIAL PRIMARY KEY,
    LOCATION_ID INTEGER REFERENCES location (ID),
    DESCRIPTION TEXT
);

CREATE TABLE IF NOT EXISTS CORPORATION
(
    ID          SERIAL PRIMARY KEY,
    NAME        varchar(255) NOT NULL UNIQUE,
    DESCRIPTION TEXT
);

CREATE TABLE IF NOT EXISTS REPLICANT_MODEL
(
    ID             SERIAL PRIMARY KEY,
    NAME           varchar(255) NOT NULL UNIQUE,
    DESCRIPTION    TEXT,
    CORPORATION_ID INTEGER REFERENCES corporation (ID)
);
CREATE TABLE IF NOT EXISTS POSITION
(
    ID          SERIAL PRIMARY KEY,
    NAME        varchar(255) NOT NULL,
    DESCRIPTION TEXT
);

CREATE TABLE IF NOT EXISTS BLADE_RUNNER
(
    ID          SERIAL PRIMARY KEY,
    ENTITY_ID   INTEGER REFERENCES ENTITY (ID),
    HQ_ID       INTEGER REFERENCES blade_runners_hq (ID),
    POSITION_ID INTEGER REFERENCES position (ID),
    FREE        BOOL NOT NULL
);

CREATE TABLE IF NOT EXISTS REPLICANT
(
    ID                 SERIAL PRIMARY KEY,
    ENTITY_ID          INTEGER REFERENCES ENTITY (ID),
    REPLICANT_MODEL_ID INTEGER REFERENCES replicant_model (ID),
    LIFESPAN           INTEGER CHECK ( LIFESPAN > 0)
);


CREATE TABLE IF NOT EXISTS REPLICANT_SEARCH
(
    ID              SERIAL PRIMARY KEY,
    BLADE_RUNNER_ID INTEGER REFERENCES blade_runner (ID),
    REPLICANT_ID    INTEGER REFERENCES replicant (ID),
    RESULT          BOOLEAN
);