--- The following script should be used to create the table article which will be used.

CREATE TABLE public.article111 (
	id int8 NOT NULL,
	author varchar(511) NULL,
	description text NULL,
	published_date timestamp NULL,
	title varchar(1023) NULL,
	CONSTRAINT article111_pkey PRIMARY KEY (id)
);

CREATE INDEX article_author_idx ON public.article111 (author);

CREATE INDEX article111_description_idx ON public.article111 (description,title);

