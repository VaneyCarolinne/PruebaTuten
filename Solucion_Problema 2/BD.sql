

--create database prueba;




COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 140387)
-- Name: testapi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.testapi (
    id integer NOT NULL,
    dato1 character varying NOT NULL,
    dato2 character varying NOT NULL
);


ALTER TABLE public.testapi OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 140385)
-- Name: testapi_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.testapi_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.testapi_id_seq OWNER TO postgres;

--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 196
-- Name: testapi_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.testapi_id_seq OWNED BY public.testapi.id;


--
-- TOC entry 2040 (class 2604 OID 140390)
-- Name: testapi id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testapi ALTER COLUMN id SET DEFAULT nextval('public.testapi_id_seq'::regclass);


--
-- TOC entry 2165 (class 0 OID 140387)
-- Dependencies: 197
-- Data for Name: testapi; Type: TABLE DATA; Schema: public; Owner: postgres
--




--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 196
-- Name: testapi_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.testapi_id_seq', 1, false);


--
-- TOC entry 2042 (class 2606 OID 140392)
-- Name: testapi testapi_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testapi
    ADD CONSTRAINT testapi_pkey PRIMARY KEY (id);


-- Completed on 2020-06-25 20:32:50

--
-- PostgreSQL database dump complete
--

