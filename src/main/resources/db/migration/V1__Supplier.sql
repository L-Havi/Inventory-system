   CREATE TABLE SUPPLIER (
    supplier_id INTEGER PRIMARY KEY AUTOINCREMENT,
    supplier_name varchar(255) not null,
    supplier_address varchar(255) not null,
    supplier_phone int not null,
    supplier_email varchar(255) not null,
    last_update bigint not null
    )