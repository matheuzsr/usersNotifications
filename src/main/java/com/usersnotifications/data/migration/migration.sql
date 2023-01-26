CREATE TABLE user (
id INTEGER primary key AUTOINCREMENT not null,
username varchar(100) not null,
encrypt_password varchar(100) not null,
type varchar(100) not null,
actived_at date
);

CREATE TABLE notification (
id INTEGER primary key AUTOINCREMENT not null,
description varchar(100) not null,
read_at date,
from_user_id int,
to_user_id int,
sent_at date,
FOREIGN KEY (from_user_id) REFERENCES user(id),
FOREIGN KEY (to_user_id) REFERENCES user(id)
);