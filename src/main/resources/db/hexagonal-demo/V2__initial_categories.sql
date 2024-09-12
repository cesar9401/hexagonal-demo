INSERT INTO public.sa_category (category_id, parent_category_id, cat_description) VALUES
(500, null, 'Entity_Status'),
(501, 500, 'ES_Active'),
(502, 500, 'ES_Inactive'),
(503, 500, 'ES_Deleted'),
(504, 500, 'ES_Locked');
