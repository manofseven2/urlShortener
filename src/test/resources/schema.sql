
DROP TABLE  IF EXISTS URLS;
create table URLS
(
	ID BIGINT  auto_increment
		primary key,
	ORIGINAL_URL VARCHAR(1500)
		unique,
	SHORTENED_URL VARCHAR(200)
	  unique
);