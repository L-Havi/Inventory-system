   CREATE TABLE CUSTOMER (
    customer_id INTEGER PRIMARY KEY AUTOINCREMENT,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    customer_address varchar(255) not null,
    customer_phone int not null,
    customer_email varchar not null,
    staff_id INTEGER,
    foreign key (staff_id) references staff (staff_id),
    last_update bigint not null
    )