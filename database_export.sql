--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: proiect3; Type: SCHEMA; Schema: -; Owner: user_p3
--

CREATE SCHEMA proiect3;


ALTER SCHEMA proiect3 OWNER TO user_p3;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: consultatie; Type: TABLE; Schema: proiect3; Owner: user_p3
--

CREATE TABLE proiect3.consultatie (
    id_pacient bigint,
    id_medicament bigint
);


ALTER TABLE proiect3.consultatie OWNER TO user_p3;

--
-- Name: medic; Type: TABLE; Schema: proiect3; Owner: user_p3
--

CREATE TABLE proiect3.medic (
    id_medic bigint NOT NULL,
    nume_medic character varying(64) NOT NULL,
    prenume_medic character varying(64) NOT NULL,
    specializare character varying(32)
);


ALTER TABLE proiect3.medic OWNER TO user_p3;

--
-- Name: medic_id_medic_seq; Type: SEQUENCE; Schema: proiect3; Owner: user_p3
--

CREATE SEQUENCE proiect3.medic_id_medic_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE proiect3.medic_id_medic_seq OWNER TO user_p3;

--
-- Name: medic_id_medic_seq; Type: SEQUENCE OWNED BY; Schema: proiect3; Owner: user_p3
--

ALTER SEQUENCE proiect3.medic_id_medic_seq OWNED BY proiect3.medic.id_medic;


--
-- Name: medic_pacient; Type: TABLE; Schema: proiect3; Owner: user_p3
--

CREATE TABLE proiect3.medic_pacient (
    id_medic bigint,
    id_pacient bigint
);


ALTER TABLE proiect3.medic_pacient OWNER TO user_p3;

--
-- Name: medicament; Type: TABLE; Schema: proiect3; Owner: user_p3
--

CREATE TABLE proiect3.medicament (
    id_medicament bigint NOT NULL,
    denumire character varying(64) NOT NULL,
    diagnostic character varying(32) NOT NULL,
    doza character varying(16) NOT NULL,
    date character varying(32) NOT NULL
);


ALTER TABLE proiect3.medicament OWNER TO user_p3;

--
-- Name: medicament_id_medicament_seq; Type: SEQUENCE; Schema: proiect3; Owner: user_p3
--

CREATE SEQUENCE proiect3.medicament_id_medicament_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE proiect3.medicament_id_medicament_seq OWNER TO user_p3;

--
-- Name: medicament_id_medicament_seq; Type: SEQUENCE OWNED BY; Schema: proiect3; Owner: user_p3
--

ALTER SEQUENCE proiect3.medicament_id_medicament_seq OWNED BY proiect3.medicament.id_medicament;


--
-- Name: pacient; Type: TABLE; Schema: proiect3; Owner: user_p3
--

CREATE TABLE proiect3.pacient (
    id_pacient bigint NOT NULL,
    cnp character varying(13) NOT NULL,
    nume character varying(64) NOT NULL,
    prenume character varying(64) NOT NULL,
    adresa character varying(64) NOT NULL,
    asigurat boolean NOT NULL
);


ALTER TABLE proiect3.pacient OWNER TO user_p3;

--
-- Name: pacient_id_pacient_seq; Type: SEQUENCE; Schema: proiect3; Owner: user_p3
--

CREATE SEQUENCE proiect3.pacient_id_pacient_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE proiect3.pacient_id_pacient_seq OWNER TO user_p3;

--
-- Name: pacient_id_pacient_seq; Type: SEQUENCE OWNED BY; Schema: proiect3; Owner: user_p3
--

ALTER SEQUENCE proiect3.pacient_id_pacient_seq OWNED BY proiect3.pacient.id_pacient;


--
-- Name: users; Type: TABLE; Schema: proiect3; Owner: user_p3
--

CREATE TABLE proiect3.users (
    id_user bigint NOT NULL,
    username character varying(64) NOT NULL,
    password character varying(512) NOT NULL,
    role character varying(16) NOT NULL
);


ALTER TABLE proiect3.users OWNER TO user_p3;

--
-- Name: users_id_user_seq; Type: SEQUENCE; Schema: proiect3; Owner: user_p3
--

CREATE SEQUENCE proiect3.users_id_user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE proiect3.users_id_user_seq OWNER TO user_p3;

--
-- Name: users_id_user_seq; Type: SEQUENCE OWNED BY; Schema: proiect3; Owner: user_p3
--

ALTER SEQUENCE proiect3.users_id_user_seq OWNED BY proiect3.users.id_user;


--
-- Name: medic id_medic; Type: DEFAULT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.medic ALTER COLUMN id_medic SET DEFAULT nextval('proiect3.medic_id_medic_seq'::regclass);


--
-- Name: medicament id_medicament; Type: DEFAULT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.medicament ALTER COLUMN id_medicament SET DEFAULT nextval('proiect3.medicament_id_medicament_seq'::regclass);


--
-- Name: pacient id_pacient; Type: DEFAULT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.pacient ALTER COLUMN id_pacient SET DEFAULT nextval('proiect3.pacient_id_pacient_seq'::regclass);


--
-- Name: users id_user; Type: DEFAULT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.users ALTER COLUMN id_user SET DEFAULT nextval('proiect3.users_id_user_seq'::regclass);


--
-- Data for Name: consultatie; Type: TABLE DATA; Schema: proiect3; Owner: user_p3
--

COPY proiect3.consultatie (id_pacient, id_medicament) FROM stdin;
1	1
1	2
2	3
\.


--
-- Data for Name: medic; Type: TABLE DATA; Schema: proiect3; Owner: user_p3
--

COPY proiect3.medic (id_medic, nume_medic, prenume_medic, specializare) FROM stdin;
2	Popescu	Alexandru	Dermatologie
3	Ionescu	Camelia	Oncologie
1	Teodorescu	Matei	Pediatrie
\.


--
-- Data for Name: medic_pacient; Type: TABLE DATA; Schema: proiect3; Owner: user_p3
--

COPY proiect3.medic_pacient (id_medic, id_pacient) FROM stdin;
3	3
1	3
1	1
\.


--
-- Data for Name: medicament; Type: TABLE DATA; Schema: proiect3; Owner: user_p3
--

COPY proiect3.medicament (id_medicament, denumire, diagnostic, doza, date) FROM stdin;
1	Paracetamol	Durere cap	16	Mon Jan 11 2021, 14:17
2	Theraflu	Raceala	2	Mon Jan 11 2021, 14:17
3	Fiobilin	Digestie grea	8	Mon Jan 11 2021, 14:17
\.


--
-- Data for Name: pacient; Type: TABLE DATA; Schema: proiect3; Owner: user_p3
--

COPY proiect3.pacient (id_pacient, cnp, nume, prenume, adresa, asigurat) FROM stdin;
3	2560317889900	Alexandrescu	Maria	Str. Metalurgiei 15	f
1	1980803111111	Papurica	Razvan	Str. Florilor 27	t
2	28703456677	Marinescu	Teodora	Str. Petuniei 88	t
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: proiect3; Owner: user_p3
--

COPY proiect3.users (id_user, username, password, role) FROM stdin;
1	admin	c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec	ADMIN
2	user	b14361404c078ffd549c03db443c3fede2f3e534d73f78f77301ed97d4a436a9fd9db05ee8b325c0ad36438b43fec8510c204fc1c1edb21d0941c00e9e2c1ce2	USER
\.


--
-- Name: medic_id_medic_seq; Type: SEQUENCE SET; Schema: proiect3; Owner: user_p3
--

SELECT pg_catalog.setval('proiect3.medic_id_medic_seq', 3, true);


--
-- Name: medicament_id_medicament_seq; Type: SEQUENCE SET; Schema: proiect3; Owner: user_p3
--

SELECT pg_catalog.setval('proiect3.medicament_id_medicament_seq', 3, true);


--
-- Name: pacient_id_pacient_seq; Type: SEQUENCE SET; Schema: proiect3; Owner: user_p3
--

SELECT pg_catalog.setval('proiect3.pacient_id_pacient_seq', 3, true);


--
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: proiect3; Owner: user_p3
--

SELECT pg_catalog.setval('proiect3.users_id_user_seq', 2, true);


--
-- Name: medic medic_pkey; Type: CONSTRAINT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.medic
    ADD CONSTRAINT medic_pkey PRIMARY KEY (id_medic);


--
-- Name: medicament medicament_pkey; Type: CONSTRAINT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.medicament
    ADD CONSTRAINT medicament_pkey PRIMARY KEY (id_medicament);


--
-- Name: pacient pacient_pkey; Type: CONSTRAINT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.pacient
    ADD CONSTRAINT pacient_pkey PRIMARY KEY (id_pacient);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_user);


--
-- Name: medic_pacient medic_fk; Type: FK CONSTRAINT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.medic_pacient
    ADD CONSTRAINT medic_fk FOREIGN KEY (id_medic) REFERENCES proiect3.medic(id_medic) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: consultatie medicament_fk; Type: FK CONSTRAINT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.consultatie
    ADD CONSTRAINT medicament_fk FOREIGN KEY (id_medicament) REFERENCES proiect3.medicament(id_medicament) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: medic_pacient pacient_fk; Type: FK CONSTRAINT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.medic_pacient
    ADD CONSTRAINT pacient_fk FOREIGN KEY (id_pacient) REFERENCES proiect3.pacient(id_pacient) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: consultatie pacient_fk; Type: FK CONSTRAINT; Schema: proiect3; Owner: user_p3
--

ALTER TABLE ONLY proiect3.consultatie
    ADD CONSTRAINT pacient_fk FOREIGN KEY (id_pacient) REFERENCES proiect3.pacient(id_pacient) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

