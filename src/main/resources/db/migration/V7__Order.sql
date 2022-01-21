   CREATE TABLE ORDER (
    order_id INTEGER PRIMARY KEY AUTOINCREMENT,
    order_quantity int not null,
    order_date DATE not null,
    customer_id INTEGER,
    product_id INTEGER,
    foreign key (customer_id) references customer (customer_id),
    foreign key (product_id) references product (product_id),
    last_update bigint not null
    )