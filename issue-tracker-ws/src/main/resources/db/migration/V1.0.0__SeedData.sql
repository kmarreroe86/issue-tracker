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

/*MySQL allow insert autoincrements values without needs to set off*/

insert into projects(id, project_name) values
(1, 'Spring-Demo'),
(2, 'Spring-Data'),
(3, 'Spring-Boot'),
(4, 'Spring-Cloud'),
(5, 'Spring-Security'),
(6, 'Spring-Android'),
(7, 'Spring-LDAP'),
(8, 'Spring-KAFKA');

insert into users(id, username, rol, email, password) values
(1, 'karel', 'DEVELOPER', 'karel@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(2, 'lerak', 'DEVELOPER', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(3, 'Yalexis', 'PO', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(4, 'Yeny', 'PO', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(5,'Jade', 'DESIGNER', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(6, 'Annieris', 'QA', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(7, 'Leandro', 'DEVELOPER', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(8, 'Rafael', 'DEVELOPER', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(9, 'JohnD', 'QA', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(10, 'JohnT', 'QA', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(11, 'Luis', 'DEVELOPER', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(12, 'Liam', 'PO', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(13, 'William', 'QA', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(14, 'Michael', 'QA', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(15, 'Noah', 'DESIGNER', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm'),
(16, 'James', 'DEVELOPER', 'test@gmail.com', '$2a$10$VahSNsWalmFKtfHBgN8oduT1v340etl1OazlzL59XYmiAc29vkHlm');

insert into issues(id, title, description, issue_type, priority, status, story_points, created_date, modified_date, project_id, user_id) values
(1, 'Issue1', 'description1', 'ENHANCEMENT', 'LOW', 'OPEN', 	  1, '2018-03-27 10:30:00', '2018-04-27 10:30:00', 1, 1),
(2, 'Issue2', 'description2', 'BUG', 		 'LOW', 'OPEN', 	  2, '2018-04-26 09:30:00', '2018-04-28 09:30:00', 1, 1),
(3, 'Issue3', 'description3', 'BUG', 		 'LOW', 'CLOSED', 	  3, '2018-04-25 12:00:00', '2018-04-29 12:00:00', 1, 2),
(4, 'Issue4', 'description4', 'TASK', 		 'LOW', 'OPEN', 	  5, '2018-04-23 10:30:00', '2018-04-27 10:30:00', 1, 3),
(5, 'Issue5', 'description5', 'TASK', 		 'LOW', 'INPROGRESS', 5, '2018-04-27 10:30:00', '2018-04-27 10:30:00', 1, 3),

(6, 'Issue1', 'description1', 'BUG',   'HIGH', 'INPROGRESS', 2, '2018-04-23 10:30:00', '2018-04-27 10:30:00', 2, 7),
(7, 'Issue2', 'description2', 'TASK',  'LOW',  'OPEN', 	     1, '2018-04-23 10:30:00', '2018-04-27 10:30:00', 2, 4),
(8, 'Issue3', 'description3', 'BUG',   'LOW',  'OPEN', 	     2, '2018-04-23 10:30:00', '2018-04-27 10:30:00', 2, 6),
(9, 'Issue4', 'description4', 'STORY', 'HIGH', 'INPROGRESS', 1, '2018-04-22 10:30:00', '2018-04-27 10:30:00', 2, 7),
(10, 'Issue5', 'description5', 'BUG',   'LOW',  'OPEN', 		 3, '2018-04-22 10:30:00', '2018-04-27 10:30:00', 2, 7),

(11, 'Issue1', 'description1', 'STORY', 		 'LOW',  'DONE', 	   3, '2018-04-27 10:30:00', '2018-04-27 10:30:00', 3, 6),
(12, 'Issue2', 'description2', 'BUG', 		 'HIGH', 'OPEN', 	   2, '2018-04-26 10:30:00', '2018-04-27 10:30:00', 3, 8),
(13, 'Issue3', 'description3', 'ENHANCEMENT', 'LOW',  'OPEN', 	   1, '2018-04-26 10:30:00', '2018-04-27 10:30:00', 3, 8),
(14, 'Issue4', 'description4', 'TASK', 		 'LOW',  'OPEN', 	   5, '2018-04-26 10:30:00', '2018-04-27 10:30:00', 3, 12),
(15, 'Issue5', 'description5', 'BUG', 		 'LOW',  'INPROGRESS', 8, '2018-04-26 10:30:00', '2018-04-27 10:30:00', 3, 5),

(16, 'Issue1', 'description1', 'TASK',  'HIGH', 'DONE', 		 1, '2018-04-20 10:30:00', '2018-04-27 10:30:00', 4, 5),
(17, 'Issue2', 'description2', 'TASK',  'HIGH', 'OPEN', 		 8, '2018-04-20 10:30:00', '2018-04-27 10:30:00', 4, 11),
(18, 'Issue3', 'description3', 'TASK',  'LOW', 'DONE', 		 8, '2018-04-20 10:30:00', '2018-04-27 10:30:00', 4, 11),
(19, 'Issue4', 'description4', 'BUG',   'LOW', 'OPEN', 		 1, '2018-04-20 10:30:00', '2018-04-27 10:30:00', 4, 11),
(20, 'Issue5', 'description5', 'STORY', 'HIGH', 'INPROGRESS', 1, '2018-04-20 10:30:00', '2018-04-27 10:30:00', 4, 14),

(21, 'Issue1', 'description1', 'STORY', 'LOW',    'INPROGRESS', 2, '2018-04-21 10:30:00', '2018-04-27 10:30:00', 5, 14),
(22, 'Issue2', 'description2', 'BUG',   'MEDIUM', 'INPROGRESS', 2, '2018-04-21 10:30:00', '2018-04-27 10:30:00', 5, 13),
(23, 'Issue3', 'description3', 'TASK',  'HIGH',   'OPEN', 	   3, '2018-04-21 10:30:00', '2018-04-27 10:30:00', 5, 9),
(24, 'Issue4', 'description4', 'BUG',   'LOW',    'DONE', 	   3, '2018-04-22 10:30:00', '2018-04-27 10:30:00', 5, 16),
(25, 'Issue5', 'description5', 'STORY', 'MEDIUM', 'OPEN', 	   1, '2018-04-23 10:30:00', '2018-04-27 10:30:00', 5, 16),

(26, 'Issue1', 'description1', 'TASK',  'LOW',    'DONE', 5, '2018-04-25 10:30:00', '2018-04-27 10:30:00', 6, 2),
(27, 'Issue2', 'description2', 'STORY', 'HIGH',   'OPEN', 3, '2018-04-26 10:30:00', '2018-04-27 10:30:00', 6, 2),
(28, 'Issue3', 'description3', 'BUG',   'LOW',    'DONE', 2, '2018-04-26 10:30:00', '2018-04-27 10:30:00', 6, 10),
(29, 'Issue4', 'description4', 'TASK',  'HIGH',   'OPEN', 1, '2018-04-24 10:30:00', '2018-04-27 10:30:00', 6, 10),
(30, 'Issue5', 'description5', 'BUG',   'MEDIUM', 'DONE', 1, '2018-04-24 10:30:00', '2018-04-27 10:30:00', 6, 3),

(31, 'Issue1', 'description1', 'TASK',  'MEDIUM', 'INPROGRESS', 2, '2018-04-22 10:30:00', '2018-04-27 10:30:00', 7, 4),
(32, 'Issue2', 'description2', 'BUG',   'LOW',    'OPEN', 	   2, '2018-04-23 10:30:00', '2018-04-27 10:30:00', 7, 6),
(33, 'Issue3', 'description3', 'STORY', 'MEDIUM', 'INPROGRESS', 3, '2018-04-24 10:30:00', '2018-04-27 10:30:00', 7, 6),
(34, 'Issue4', 'description4', 'BUG',   'LOW',    'OPEN', 	   1, '2018-04-25 10:30:00', '2018-04-27 10:30:00', 7, 1),
(35, 'Issue5', 'description5', 'STORY', 'MEDIUM', 'INPROGRESS', 3, '2018-04-25 10:30:00', '2018-04-27 10:30:00', 7, 2),

(36, 'Issue1', 'description1', 'ENHANCEMENT', 'LOW',  'DONE', 	   13, '2018-04-26 10:30:00', '2018-04-27 10:30:00', 8, 8),
(37, 'Issue2', 'description2', 'STORY', 		 'HIGH', 'DONE', 	   2, '2018-04-25 10:30:00', '2018-04-27 10:30:00', 8, 8),
(38, 'Issue3', 'description3', 'TASK', 		 'HIGH', 'OPEN', 	   1, '2018-04-24 10:30:00', '2018-04-27 10:30:00', 8, 9),
(39, 'Issue4', 'description4', 'BUG', 		 'LOW',  'INPROGRESS', 1, '2018-04-23 10:30:00', '2018-04-27 10:30:00', 8, 11),

(40, 'Issue6', 'description6', 'STORY', 		 'MEDIUM', 'OPEN', 	 	 5, '2018-04-23 10:30:00', '2018-04-27 10:30:00', 1, 10),
(41, 'Issue7', 'description7', 'BUG',   		 'MEDIUM', 'INPROGRESS', 5, '2018-04-24 10:30:00', '2018-04-27 10:30:00', 1, 15),
(42, 'Issue8', 'description8', 'ENHANCEMENT', 'HIGH',   'OPEN', 		 1, '2018-04-25 10:30:00', '2018-04-27 10:30:00', 1, 15);

insert into project_user(project_id, user_id) values
(1, 1),
(1, 2),
(1, 3),
(1, 10),
(1, 15),
(2, 7),
(2, 4),
(2, 6),
(3, 6),
(3, 8),
(3, 12),
(3, 5),
(4, 5),
(4, 11),
(4, 14),
(5, 14),
(5, 13),
(5, 9),
(5, 16),
(6, 2),
(6, 10),
(6, 3),
(7, 4),
(7, 6),
(7, 1),
(7, 2),
(8, 8),
(8, 9),
(8, 11);

