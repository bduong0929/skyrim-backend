-- ROLES
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'DEFAULT');

-- CATEGORYS
INSERT INTO categories (id, name) VALUES (1, 'Shop All');
INSERT INTO categories (id, name) VALUES (2, 'Weapons');
INSERT INTO categories (id, name) VALUES (3, 'Armors');
INSERT INTO categories (id, name) VALUES (4, 'Accessories');

-- PRODUCTS

--- Weapons
INSERT INTO products (id, name, description, img, price, stock, category_id) 
  VALUES (1, 'Akatosh Talon', 'Akatosh Talon is a unique warhammer. It is acquired through the Battle of the Champions quest.', 'akatosh_talon', 4832, 10, 2);

INSERT INTO products (id, name, description, img, price, stock, category_id)
  VALUES (2, 'Blade Of Woe', 'The Blade of Woe is a unique dagger belonging to Astrid, the leader of the only remaining Dark Brotherhood group in Skyrim.', 'blade_of_woe', 880, 10, 2);

INSERT INTO products (id, name, description, img, price, stock, category_id)
  VALUES (3, 'Bloodscythe', 'Bloodscythe is a scimitar which is one of the twin swords of the legendary Nord pirate captain Haknir Death-Brand.', 'bloodscythe', 1859, 10, 2);

