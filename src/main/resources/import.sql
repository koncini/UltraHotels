INSERT INTO users (username, name, last_name, gender, document_type, document_number, email, password, enabled, last_login) VALUES ('admin', 'user', 'user', 'male', 'CC', 10562080, 'user.user@ultra.com.co', '$2a$10$uoxBSo1vDV5UvB8VTPItu.8jLzJwMVfAnllZbl4yjpYWcpmXV1T1S', 1, '2023-02-22 15:40:10');
INSERT INTO users (username, name, last_name, gender, document_type, document_number, email, password, enabled, last_login) VALUES ('basic', 'user1', 'user1', 'male', 'CC', 10562081, 'user1.user1@ultra.com.co','$2a$10$YV65ExjewVvYKW10p6mhwugtMlvYVKR/jcKkRC1FoN0GMr7fiht1W', 1, '2023-02-22 15:40:10');

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_STAFF');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_MANAGER');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');  

INSERT INTO hotels (name, enabled) VALUES ("ultraColombia", true);
INSERT INTO hotels (name, enabled) VALUES ("ultraPeru", true);
INSERT INTO hotels (name, enabled) VALUES ("ultraEcuador", true);
INSERT INTO hotels (name, enabled) VALUES ("ultraChile", false);

INSERT INTO rooms (hotel_id, details, base_price, tax, room_type, location, enabled) VALUES (1, "ultraHotel1", 25, 2, "basic room", 50, true);
INSERT INTO rooms (hotel_id, details, base_price, tax, room_type, location, enabled) VALUES (2, "ultra", 25, 2, "basic room", 10, true);
INSERT INTO rooms (hotel_id, details, base_price, tax, room_type, location, enabled) VALUES (3, "ultraHotel", 25, 2, "basic room", 1, true);
INSERT INTO rooms (hotel_id, details, base_price, tax, room_type, location, enabled) VALUES (4, "ultrapremium", 25, 2, "premium room", 40, true);

INSERT INTO reservations (room_id, user_id, detail, start_date, finish_date) VALUES (1, 1, "Two Adults One Children", '2023-02-22 15:40:10', '2023-02-24 15:40:10');