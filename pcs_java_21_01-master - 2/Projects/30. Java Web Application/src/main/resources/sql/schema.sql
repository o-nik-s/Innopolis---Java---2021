create table account (
    id bigserial primary key,
    first_name varchar(40),
    last_name varchar(40),
    email varchar(40),
    password varchar(40)
);

drop  table if exists  file_info;

create table file_info (
    id bigserial primary key,
    original_file_name varchar(100),
    storage_file_name varchar(100),
    size bigint,
    mime_type varchar(30),
    description varchar(100)
);