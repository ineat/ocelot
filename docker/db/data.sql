CREATE TABLE beer (
  id SERIAL PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE ingredient (
  id SERIAL PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE beer_ingredient (
  beer_id    int REFERENCES beer (id) ON UPDATE CASCADE ON DELETE CASCADE,
  ingredient_id int REFERENCES ingredient (id) ON UPDATE CASCADE,
  CONSTRAINT beer_ingredient_pkey PRIMARY KEY (beer_id, ingredient_id)
);


INSERT INTO beer (name) VALUES ('Hoegaarden'), ('Paix Dieux');

INSERT INTO ingredient (name) VALUES ('Saaz'), ('White Wheat Malt'), ('Belgian Pils'), ('Wheat Raw'), ('Corn Flakes'), ('Pilsner'), ('Caramunich Malt'), ('Caravienne Malt'), ('Candi Sugar'), ('Abbey Ale'), ('Styrian Goldings');

INSERT INTO beer_ingredient (beer_id, ingredient_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (2, 6), (2, 7), (2, 8), (2, 9), (2, 10), (2, 11);

commit;