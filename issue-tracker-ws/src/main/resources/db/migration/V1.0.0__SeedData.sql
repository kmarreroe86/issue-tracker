/*
create table issues
(
	id BIGINT not null auto_increment,
	title varchar(255) not null,
	description varchar(255) not null,
	issue_type varchar(255),
	priority varchar(255),
	status varchar(255),
	storyPoints int,
	created_date date,
	modified_date date,
	PRIMARY KEY (id)
);
*/
insert into issues(title, description, issue_type, priority, status, story_points, created_date, modified_date) values
('Issue1', 'description1', 'BUG', 'LOW', 'OPEN', 1, '2018-04-27 10:30:00', '2018-04-27 10:30:00'),
('Issue2', 'description2', 'BUG', 'LOW', 'OPEN', 1, '2018-04-28 09:30:00', '2018-04-28 09:30:00'),
('Issue3', 'description3', 'BUG', 'LOW', 'CLOSED', 1, '2018-04-29 12:00:00', '2018-04-29 12:00:00');

insert into users(username, rol) values
('karel', 'DEVELOPER'),
('lerak', 'DEVELOPER');

insert into projects(project_name) values
('Spring-Demo');
