--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tasks; Type: TABLE; Schema: public; Owner: oppilas
--

CREATE TABLE public.tasks (
    id integer NOT NULL,
    task text NOT NULL,
    description text,
    user_id integer,
    due date,
    rank integer,
    state integer,
    category text
);


ALTER TABLE public.tasks OWNER TO oppilas;

--
-- Name: tasks_id_seq; Type: SEQUENCE; Schema: public; Owner: oppilas
--

CREATE SEQUENCE public.tasks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tasks_id_seq OWNER TO oppilas;

--
-- Name: tasks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oppilas
--

ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: oppilas
--

CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    level integer,
    mon integer
);


ALTER TABLE public.users OWNER TO oppilas;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: oppilas
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO oppilas;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oppilas
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: tasks id; Type: DEFAULT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: oppilas
--

COPY public.tasks (id, task, description, user_id, due, rank, state, category) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: oppilas
--

COPY public.users (id, username, password, level, mon) FROM stdin;
\.


--
-- Name: tasks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oppilas
--

SELECT pg_catalog.setval('public.tasks_id_seq', 1, false);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oppilas
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: tasks tasks_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

