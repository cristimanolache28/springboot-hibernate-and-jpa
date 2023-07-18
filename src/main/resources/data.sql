INSERT INTO course (id, name) VALUES (10001, 'JPA in 50 Steps');
INSERT INTO course (id, name) VALUES (10002, 'Dummy1');
INSERT INTO course (id, name) VALUES (10003, 'Dummy2');
INSERT INTO course (id, name) VALUES (100011, 'Dummy3');
INSERT INTO course (id, name) VALUES (10004, 'Dummy4');
INSERT INTO course (id, name) VALUES (10005, 'Dummy5');
INSERT INTO course (id, name) VALUES (10006, 'Dummy6');
INSERT INTO course (id, name) VALUES (10007, 'Dummy7');
INSERT INTO course (id, name) VALUES (10008, 'Dummy8');
INSERT INTO course (id, name) VALUES (10009, 'Dummy9');
INSERT INTO course (id, name) VALUES (10010, 'Dummy10');

INSERT INTO review (id, rating, description, course_id) VALUES (50001, '4.8', 'Great Course', 10001);
INSERT INTO review (id, rating, description, course_id) VALUES (50002, '3.4', 'Wonderful Course', 10001);
INSERT INTO review (id, rating, description, course_id) VALUES (50003, '4.1', 'Awesome Course', 10003);

INSERT INTO passport (id, number) VALUES (40001, 'E123456');
INSERT INTO passport (id, number) VALUES (40002, 'NMDAS31');
INSERT INTO passport (id, number) VALUES (40003, 'M12A512');

INSERT INTO student (id, name, passport_id) VALUES (20001, 'Ranga', 40001);
INSERT INTO student (id, name, passport_id) VALUES (20002, 'Adam', 40002);
INSERT INTO student (id, name, passport_id) VALUES (20003, 'Jane', 40003);

insert into student_course(student_id, course_id) values (20001, 10001);
insert into student_course(student_id, course_id) values (20002, 10001);
insert into student_course(student_id, course_id) values (20003, 10001);
insert into student_course(student_id, course_id) values (20001, 10003);
