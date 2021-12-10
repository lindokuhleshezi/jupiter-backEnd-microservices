CREATE TABLE public.oauth_access_token
(
token_id character varying(256),
token bytea,
authentication_id character varying(256) NOT NULL,
user_name character varying(256),
client_id character varying(256),
authentication bytea,
refresh_token character varying(256),
CONSTRAINT oauth_access_token_pkey PRIMARY KEY (authentication_id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.oauth_access_token
OWNER TO hookup24;
-----------------------------------------------------------------
CREATE TABLE public.oauth_approvals
(
userid character varying(256),
clientid character varying(256),
scope character varying(256),
status character varying(10),
expiresat timestamp without time zone,
lastmodifiedat timestamp without time zone
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.oauth_approvals
OWNER TO hookup24;
-----------------------------------------------------

CREATE TABLE public.oauth_client_details
(
  client_id character varying(255) NOT NULL,
  client_secret character varying(255) NOT NULL,
  web_server_redirect_uri character varying(2048) DEFAULT NULL::character varying,
  scope character varying(255) DEFAULT NULL::character varying,
  access_token_validity integer,
  refresh_token_validity integer,
  resource_ids character varying(1024) DEFAULT NULL::character varying,
  authorized_grant_types character varying(1024) DEFAULT NULL::character varying,
  authorities character varying(1024) DEFAULT NULL::character varying,
  additional_information character varying(4096) DEFAULT NULL::character varying,
  autoapprove character varying(255) DEFAULT NULL::character varying,
  CONSTRAINT oauth_client_details_pkey PRIMARY KEY (client_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.oauth_client_details
  OWNER TO hookup24;

-----------------------------------------------------
-- Table: public.oauth_client_token

-- DROP TABLE public.oauth_client_token;

CREATE TABLE public.oauth_client_token
(
  token_id character varying(256),
  token bytea,
  authentication_id character varying(256) NOT NULL,
  user_name character varying(256),
  client_id character varying(256),
  CONSTRAINT oauth_client_token_pkey PRIMARY KEY (authentication_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.oauth_client_token
  OWNER TO hookup24;
------------------------------------------------------

CREATE TABLE public.oauth_code
(
  code character varying(256),
  authentication bytea
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.oauth_code
  OWNER TO hookup24;

 CREATE TABLE public.oauth_refresh_token
(
  token_id character varying(256),
  token bytea,
  authentication bytea
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.oauth_refresh_token
  OWNER TO hookup24;


INSERT INTO public.oauth_client_details (
client_secret, client_id, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, authorities) VALUES (
'{bcrypt}$2a$10$.QJYqYXKQOE1gyo8Ha4Viu6IM5AHRSvbMx1PoagNVW6mBxIe40Vca'::character varying, 'hookup24'::character varying, 'ALL'::character varying, '3600'::integer, '3600'::integer, 'hookup24'::character varying, 'password, authorization_code, refresh_token'::character varying, 'CUSTOMER_ACCESS, VENDOR_ACCESS, ADMIN_ACCESS, ORDER_ACCESS, PAYMENT_ACCESS'::character varying)
 returning client_id;
