DROP SEQUENCE pono_gen_sequence;
DROP TABLE orderlineitems;
DROP TABLE products;
DROP TABLE suppliers;
DROP TABLE orders;
DROP TABLE shippinginfo;
DROP TABLE customers;

CREATE SEQUENCE pono_gen_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE customers (
  cust_id NUMBER PRIMARY KEY,
  cust_name VARCHAR2(100),
  email VARCHAR2(100),
  phone VARCHAR2(20)
);
CREATE TABLE shippinginfo (
  ship_cust_id NUMBER PRIMARY KEY,
  street VARCHAR2(50),
  city VARCHAR2(50),
  state VARCHAR2(2),
  zip VARCHAR2(5),
  FOREIGN KEY(ship_cust_id) REFERENCES customers(cust_id)
);
CREATE TABLE suppliers (
  sup_id NUMBER PRIMARY KEY,
  sup_name VARCHAR2(100),
  email VARCHAR2(100),
  phone VARCHAR2(20)
);
CREATE TABLE products (
  prod_id NUMBER PRIMARY KEY,
  sup_id NUMBER,
  prod_name VARCHAR2(100),
  price NUMBER(12,2),
  FOREIGN KEY(sup_id) REFERENCES suppliers(sup_id)
);
CREATE TABLE orders(
  pono NUMBER PRIMARY KEY,
  cust_id NUMBER,
  order_date DATE,
  FOREIGN KEY(cust_id) REFERENCES customers(cust_id)
);
CREATE TABLE orderlineitems(
  itemno NUMBER,
  pono NUMBER ,
  prod_id NUMBER,
  quantity NUMBER(10),
  PRIMARY KEY(itemno, pono),
  FOREIGN KEY(pono) REFERENCES orders(pono),
  FOREIGN KEY(prod_id) REFERENCES products(prod_id)
);

INSERT INTO customers VALUES(1, 'Maya Silver', 'mayas@mail.com', '(515)567-7777');
INSERT INTO customers VALUES(2, 'John Medica', 'johnm@mail.com', '(247)312-3429');

INSERT INTO shippinginfo VALUES(1, '1200 Charade Rd', 'Seattle', 'WA', '98197');
INSERT INTO shippinginfo VALUES(2, '1478 Baker Blvd', 'Eugene', 'OR', '97401');

INSERT INTO suppliers VALUES(1, 'Tortuga Trading', 'tort@mail.com', '(650)437-7659');
INSERT INTO suppliers VALUES(2, 'Pavlenko Ltd.', 'pavlj@mail.com', '(517)768-1852');

INSERT INTO products VALUES(1, 1, 'Necktie', 19.95);
INSERT INTO products VALUES(2, 1, 'White shirt', 41.50);

INSERT INTO products VALUES(3, 2, 'T-shirt', 25.45);
INSERT INTO products VALUES(4, 2, 'Running shoes', 135.00);


INSERT INTO orders VALUES(pono_gen_sequence.nextval, 1, SYSDATE);
INSERT INTO orders VALUES(pono_gen_sequence.nextval, 1, SYSDATE);
INSERT INTO orders VALUES(pono_gen_sequence.nextval, 2, SYSDATE);

INSERT INTO orderlineitems VALUES(1, 1, 1, 2);
INSERT INTO orderlineitems VALUES(2, 1, 2, 1);
INSERT INTO orderlineitems VALUES(1, 2, 1, 1);
INSERT INTO orderlineitems VALUES(1, 3, 3, 1);
INSERT INTO orderlineitems VALUES(2, 3, 4, 1);

CREATE OR REPLACE FUNCTION sum_total(supplier VARCHAR2)
RETURN NUMBER AS
sup_sum NUMBER;
BEGIN
 SELECT SUM(p.price*l.quantity) INTO sup_sum FROM orders o 
 JOIN orderlineitems l ON o.pono=l.pono 
 JOIN products p ON l.prod_id=p.prod_id 
 JOIN suppliers s ON p.sup_id=s.sup_id 
 WHERE sup_name = supplier;
 RETURN sup_sum;
END;
/
