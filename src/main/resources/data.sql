-- Authorities

-- Product Authorities
insert into authority(authority_id, permission, created_date, updated_date) values ('67cdcff0-f180-421a-bd5f-69cbc62f3cfe', 'product.create', sysdate(), sysdate());
insert into authority(authority_id, permission, created_date, updated_date) values ('f06cc9be-0c37-4dac-8d36-941e7dd03e95', 'product.read', sysdate(), sysdate());
insert into authority(authority_id, permission, created_date, updated_date) values ('1fba12c8-da0d-4d15-be62-5cdcc0d40240', 'product.update', sysdate(), sysdate());
insert into authority(authority_id, permission, created_date, updated_date) values ('4a12573c-288f-4218-9a1f-8effcd2b8637', 'product.delete', sysdate(), sysdate());

-- Roles

INSERT INTO ROLE(role_id, role_name, created_date, updated_date) VALUES ('100ad35e-04ee-4da5-952c-e840b7a8d1ea', 'ADMIN', sysdate(), sysdate());
INSERT INTO ROLE(role_id, role_name, created_date, updated_date) VALUES ('0bbf5895-9084-4b8d-860c-c722d649ff66', 'CUSTOMER_SERVICE_AGENT', sysdate(), sysdate());
INSERT INTO ROLE(role_id, role_name, created_date, updated_date) VALUES ('fbf390fc-99b7-40ad-b368-20523dda8e12', 'CUSTOMER_SERVICE_MANAGER', sysdate(), sysdate());

-- Role Authority Relationship

-- Admin Role
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('100ad35e-04ee-4da5-952c-e840b7a8d1ea', '67cdcff0-f180-421a-bd5f-69cbc62f3cfe');
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('100ad35e-04ee-4da5-952c-e840b7a8d1ea', 'f06cc9be-0c37-4dac-8d36-941e7dd03e95');
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('100ad35e-04ee-4da5-952c-e840b7a8d1ea', '1fba12c8-da0d-4d15-be62-5cdcc0d40240');
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('100ad35e-04ee-4da5-952c-e840b7a8d1ea', '4a12573c-288f-4218-9a1f-8effcd2b8637');

-- Customer Service Agent Role
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('0bbf5895-9084-4b8d-860c-c722d649ff66', 'f06cc9be-0c37-4dac-8d36-941e7dd03e95');

-- Customer Service Manager Role
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('fbf390fc-99b7-40ad-b368-20523dda8e12', '67cdcff0-f180-421a-bd5f-69cbc62f3cfe');
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('fbf390fc-99b7-40ad-b368-20523dda8e12', 'f06cc9be-0c37-4dac-8d36-941e7dd03e95');
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('fbf390fc-99b7-40ad-b368-20523dda8e12', '1fba12c8-da0d-4d15-be62-5cdcc0d40240');
INSERT INTO ROLE_AUTHORITY(role_id, authority_id) VALUES ('fbf390fc-99b7-40ad-b368-20523dda8e12', '4a12573c-288f-4218-9a1f-8effcd2b8637');

-- Users

INSERT INTO SECURITY_USER(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled, created_date, updated_date) VALUES ('3375d2ab-5b0f-4da2-a26b-abf7354086f4', 'john', '{bcrypt}$2a$10$RILDxbGK4jPwVu4LLtAzJ.inZyTZIIif0L8JdFAZo7BscxhtQCEgu', true, true, true, true, sysdate(), sysdate());
INSERT INTO SECURITY_USER(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled, created_date, updated_date) VALUES ('ac5f043b-67b0-4878-8819-5d47ed8dad29', 'mary', '{bcrypt}$2a$10$A//IPwppA4uxB9ElZk/R.OqSy9xs5RPwBWCyTjtiqVcUlPv/2e6E6', true, true, true, true, sysdate(), sysdate());
INSERT INTO SECURITY_USER(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled,created_date, updated_date) VALUES ('cabcab65-a744-4e09-a727-ba686d20127c', 'cindy', '{bcrypt}$2a$10$JhPtDZiWLU.G3YX.oAhz2uXB0PYBhzlJ7q6QTf2a1ZhU83SheFtq.', true, true, true, true, sysdate(), sysdate());


-- User Role Relationship

INSERT INTO USER_ROLE(user_id, role_id) VALUES ('3375d2ab-5b0f-4da2-a26b-abf7354086f4', '100ad35e-04ee-4da5-952c-e840b7a8d1ea');
INSERT INTO USER_ROLE(user_id, role_id) VALUES ('ac5f043b-67b0-4878-8819-5d47ed8dad29', '0bbf5895-9084-4b8d-860c-c722d649ff66');
INSERT INTO USER_ROLE(user_id, role_id) VALUES ('cabcab65-a744-4e09-a727-ba686d20127c', 'fbf390fc-99b7-40ad-b368-20523dda8e12');

-- Product

INSERT INTO PRODUCT(product_id, product_name, product_type, product_description, product_price) values ('17c20874-37c7-4fdf-b3c0-b1e4a40c6c94', 'i-phone 12', 'mobile', 'apple phone', 999.99);
INSERT INTO PRODUCT(product_id, product_name, product_type, product_description, product_price) values ('ae352785-3e97-4acb-b5b5-6cf31494e4f7', 'i-pad air', 'tablet', 'apple ipad', 1299.99);
INSERT INTO PRODUCT(product_id, product_name, product_type, product_description, product_price) values ('36e261e9-40bf-4891-8d76-df4546ae4cd8', 'Macbook pro', 'laptop', 'apple laptop', 1999.99);

