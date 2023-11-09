INSERT INTO users (username, name, last_name, gender, document_type, document_number, email, password, enabled, last_login) VALUES ('admin', 'user', 'user', 'male', 'CC', 10562080, 'user.user@ultra.com.co', '$2a$10$uoxBSo1vDV5UvB8VTPItu.8jLzJwMVfAnllZbl4yjpYWcpmXV1T1S', 1, '2023-02-22 15:40:10');
INSERT INTO users (username, name, last_name, gender, document_type, document_number, email, password, enabled, last_login) VALUES ('basic', 'user1', 'user1', 'male', 'CC', 10562081, 'user1.user1@ultra.com.co','$2a$10$YV65ExjewVvYKW10p6mhwugtMlvYVKR/jcKkRC1FoN0GMr7fiht1W', 1, '2023-02-22 15:40:10');

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_STAFF');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_MANAGER');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');  

INSERT INTO hotels (name, enabled) VALUES ('ultra1', 1);
INSERT INTO hotels (name, enabled) VALUES ('ultra2', 1);
INSERT INTO hotels (name, enabled) VALUES ('ultra3', 1);
INSERT INTO hotels (name, enabled) VALUES ('ultra4', 1);
INSERT INTO hotels (name, enabled) VALUES ('ultra5', 1);
