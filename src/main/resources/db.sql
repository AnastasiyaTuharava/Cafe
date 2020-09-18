create table CAFE_PRODUCTS
(
	ID int auto_increment,
	TITLE VARCHAR(40) not null,
	PRICE DOUBLE not null,
	CURRENCY VARCHAR(3) not null,
	DESCRIPTION VARCHAR(240) null,
	constraint CAFE_PRODUCTS_pk
		primary key (ID)
);