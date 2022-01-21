   CREATE TABLE PRODUCT (
    product_id INTEGER PRIMARY KEY AUTOINCREMENT,
    product_name varchar(255) not null,
    product_description varchar(255) not null,
    product_quantity int not null,
    supplier_id INTEGER,
    foreign key (supplier_id) references supplier(supplier_id),
    last_update bigint not null
    )