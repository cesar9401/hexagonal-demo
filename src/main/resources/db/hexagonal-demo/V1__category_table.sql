CREATE TABLE public.sa_category
(
    category_id        BIGINT  NOT NULL,
    parent_category_id BIGINT,
    cat_description    VARCHAR NOT NULL,
    CONSTRAINT sa_category_pk PRIMARY KEY (category_id)
);


ALTER TABLE public.sa_category
    ADD CONSTRAINT sa_category_sa_category_fk
        FOREIGN KEY (parent_category_id)
            REFERENCES public.sa_category (category_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;
