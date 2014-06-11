CREATE DATABASE smartpass
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

--PASSWORD
CREATE SEQUENCE password_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE password_id
  OWNER TO postgres;

CREATE TABLE password(
  password_id bigint NOT NULL DEFAULT nextval('password_id'::regclass),
  password_encryption_key character varying(16) ,
  password_iv character varying(16) ,
  password_cipher_text bytea,
  password_caesar_number integer DEFAULT 0,
  password_caesar_encrypted character varying(50),
CONSTRAINT password_pkey PRIMARY KEY (password_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE password
  OWNER TO postgres;


--CREDENTIAL
CREATE SEQUENCE credential_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE credential_id
  OWNER TO postgres;

CREATE TABLE credential(
  credential_id bigint NOT NULL DEFAULT nextval('credential_id'::regclass),
  credential_system character varying(50),
  credential_login character varying(50),
  credential_password bigint,
  credential_users bigint,
CONSTRAINT credential_pkey PRIMARY KEY (credential_id)
)
WITH (
  OIDS=FALSE
);

ALTER TABLE credential
  OWNER TO postgres;


--USER
CREATE SEQUENCE users_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE users_id
  OWNER TO postgres;

CREATE TABLE users(
  users_id bigint NOT NULL DEFAULT nextval('users_id'::regclass),
  users_login character varying(50),
  users_password bigint,
  users_credential bigint,
  users_public_key bigint,
  users_private_key bigint,
CONSTRAINT users_pkey PRIMARY KEY (users_id)
)
WITH (
  OIDS=FALSE
);

ALTER TABLE users
  OWNER TO postgres;
  
--RSA_KEYS
CREATE SEQUENCE public_key_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public_key_id
  OWNER TO postgres;

CREATE TABLE public_key(
  public_key_id bigint NOT NULL DEFAULT nextval('public_key_id'::regclass),
  public_key_first character varying,
  public_key_last character varying,
  public_key_user character varying(100),
CONSTRAINT public_key_pkey PRIMARY KEY (public_key_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public_key
  OWNER TO postgres;  
  
CREATE SEQUENCE private_key_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE private_key_id
  OWNER TO postgres;

CREATE TABLE private_key(
  private_key_id bigint NOT NULL DEFAULT nextval('private_key_id'::regclass),
  private_key_first character varying,
  private_key_last character varying,
CONSTRAINT private_key_pkey PRIMARY KEY (private_key_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE private_key
  OWNER TO postgres;    
  

--FKs
ALTER TABLE credential
ADD CONSTRAINT credential_password_id_fkey
FOREIGN KEY (credential_password)
REFERENCES password(password_id);

ALTER TABLE credential
ADD CONSTRAINT credential_users_id_fkey
FOREIGN KEY (credential_users)
REFERENCES users(users_id);

ALTER TABLE users
ADD CONSTRAINT users_password_id_fkey
FOREIGN KEY (users_password)
REFERENCES password(password_id);

ALTER TABLE users
ADD CONSTRAINT users_credential_id_fkey
FOREIGN KEY (users_credential)
REFERENCES credential(credential_id);

ALTER TABLE users
ADD CONSTRAINT users_public_key_id_fkey
FOREIGN KEY (users_public_key)
REFERENCES public_key(public_key_id);

ALTER TABLE users
ADD CONSTRAINT users_private_key_id_fkey
FOREIGN KEY (users_private_key)
REFERENCES private_key(private_key_id);



