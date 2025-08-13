-- Restaurants
INSERT INTO restaurant (rname) VALUES ('Spicy Kitchen');
INSERT INTO restaurant (rname) VALUES ('Coastal Flavours');
INSERT INTO restaurant (rname) VALUES ('Pizza Palace');

-- Menus for Restaurants
INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (1, 'Biryani', '1');
INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (1, 'Paneer Butter Masala', '2');
INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (1, 'Veg Thali', '3');

INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (2, 'Fish Curry', '1');
INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (2, 'Prawns Fry', '2');
INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (2, 'Neer Dosa', '3');

INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (3, 'Margherita', '1');
INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (3, 'Pepperoni', '2');
INSERT INTO restaurant_rmenu (restaurant_rid, rmenu, rmenu_key) VALUES (3, 'Veg Supreme', '3');

-- Orders
INSERT INTO orders (status, cid, rid) VALUES (true, 101, 1);
INSERT INTO orders (status, cid, rid) VALUES (false, 102, 2);
INSERT INTO orders (status, cid, rid) VALUES (true, 103, 3);
INSERT INTO orders (status, cid, rid) VALUES (false, 104, 1);
INSERT INTO orders (status, cid, rid) VALUES (true, 105, 2);

-- Items for Orders
INSERT INTO order_items (order_oid, items, items_key) VALUES (1, 'Biryani', '1');
INSERT INTO order_items (order_oid, items, items_key) VALUES (1, 'Veg Thali', '2');

INSERT INTO order_items (order_oid, items, items_key) VALUES (2, 'Fish Curry', '1');

INSERT INTO order_items (order_oid, items, items_key) VALUES (3, 'Margherita', '1');
INSERT INTO order_items (order_oid, items, items_key) VALUES (3, 'Veg Supreme', '2');

INSERT INTO order_items (order_oid, items, items_key) VALUES (4, 'Paneer Butter Masala', '1');

INSERT INTO order_items (order_oid, items, items_key) VALUES (5, 'Prawns Fry', '1');
INSERT INTO order_items (order_oid, items, items_key) VALUES (5, 'Neer Dosa', '2');
