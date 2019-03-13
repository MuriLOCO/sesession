DO
$body$
    BEGIN
        IF NOT EXISTS (
            SELECT *
            FROM   pg_catalog.pg_user
            WHERE  usename = 'secure_session_user') THEN
                CREATE USER secure_session_user WITH PASSWORD 'c0c0nut';
        END IF;
    END
$body$;

GRANT ALL PRIVILEGES ON DATABASE secure_session TO secure_session_user;

GRANT ALL PRIVILEGES ON SCHEMA public TO secure_session_user;

-- Table: secure_session_key

-- DROP TABLE secure_session_key;

CREATE TABLE secure_session_key
(
  id INT NOT NULL,
  private_key BYTEA NOT NULL,
  public_key BYTEA NOT NULL,
  session_time TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE secure_session_key
  OWNER TO secure_session_user;
  GRANT ALL ON TABLE secure_session_key TO secure_session_user;
  
  
-- Sequence: hibernate_sequence

-- DROP SEQUENCE hibernate_sequence;
  
CREATE SEQUENCE hibernate_sequence;