use eobrazovanjedb;

#password: bcrypt('pass') - 12 rounds - https://bcrypt-generator.com/
#Promeniti pasworde po potrebi
#Users:
INSERT INTO users (deleted, password, username, version)
	VALUES(0, '$2y$12$mvdrWHVgJ7q.0iBSCYQbeetmOkambxEcCvXLnUPyRoecmWEZ4ebIO', 'johnd', current_timestamp());
INSERT INTO users (deleted, password, username, version)
	VALUES(0, '$2y$12$mvdrWHVgJ7q.0iBSCYQbeetmOkambxEcCvXLnUPyRoecmWEZ4ebIO', 'peterp', current_timestamp());
INSERT INTO users (deleted, password, username, version)
	VALUES(0, '$2y$12$mvdrWHVgJ7q.0iBSCYQbeetmOkambxEcCvXLnUPyRoecmWEZ4ebIO', 'kevinm', current_timestamp());
INSERT INTO users (deleted, password, username, version)
	VALUES(0, '$2y$12$mvdrWHVgJ7q.0iBSCYQbeetmOkambxEcCvXLnUPyRoecmWEZ4ebIO', 'freemang', current_timestamp());
INSERT INTO users (deleted, password, username, version)
	VALUES(0, '$2y$12$mvdrWHVgJ7q.0iBSCYQbeetmOkambxEcCvXLnUPyRoecmWEZ4ebIO', 'adminstudent_courses', current_timestamp());
    
#Roles:
INSERT INTO roles(name)
	VALUES('ROLE_ADMINISTRATOR');
INSERT INTO roles(name)
	VALUES('ROLE_STUDENT');
INSERT INTO roles(name)
	VALUES('ROLE_PROFESOR');

#user_role
INSERT INTO user_role(user_id, role_id)
	VALUES(1, 2);
INSERT INTO user_role(user_id, role_id)
	VALUES(2, 2);
INSERT INTO user_role(user_id, role_id)
	VALUES(3, 3);
INSERT INTO user_role(user_id, role_id)
	VALUES(4, 3);
INSERT INTO user_role(user_id, role_id)
	VALUES(5, 1);

#Students:
INSERT INTO students(account_balance, adress, deleted, first_name, id_number, last_name, phone_number, version, user_id)
	VALUES(0.0, 'Main street 1', 0, 'Johnathan', 'PR103', 'Meek', '06006662626',  current_timestamp(), 1);
INSERT INTO students(account_balance, adress, deleted, first_name, id_number, last_name, phone_number, version, user_id)
	VALUES(0.0, 'Main street 2', 0, 'Michael', 'PR104', 'Deen', '060066542626',  current_timestamp(), 2);
    
#Academic roles:
INSERT INTO academic_roles (deleted, name, version)
	VALUES(0, 'Assistent', current_timestamp());
INSERT INTO academic_roles (deleted, name, version)
	VALUES(0, 'Professor', current_timestamp());
    
#Staff:
INSERT INTO staff(deleted, firstname, lastname, version, academic_role_id, user_id)
	VALUES(0, 'Jack', 'Jones', current_timestamp(), 1, 3); 
INSERT INTO staff(deleted, firstname, lastname, version, academic_role_id, user_id)
	VALUES(0, 'Ross', 'Henderson', current_timestamp(), 2, 4); 
    
#Courses:
INSERT INTO courses (deleted, name, year, version)
	VALUES(0, 'DB Basics 1', '2019', current_timestamp());
INSERT INTO courses (deleted, name, year, version)
	VALUES(0, 'DB Basics 2', '2019', current_timestamp());
    
#Engagements:
INSERT INTO engagements(staff_id, academic_role_id, course_id , version, deleted)
	VALUES(1, 2, 1, current_timestamp(), 0);
INSERT INTO engagements(staff_id, academic_role_id, course_id , version, deleted)
	VALUES(2, 2, 2, current_timestamp(), 0);

#Student courses:
INSERT INTO student_courses(student_id, course_id)
	VALUES(1, 1);
INSERT INTO student_courses(student_id, course_id)
	VALUES(1, 2);
INSERT INTO student_courses(student_id, course_id)
	VALUES(2, 1);
INSERT INTO student_courses(student_id, course_id)
	VALUES(2, 2);
    
#Terms:
#YYYY-MM-dd HH:mm:ss
INSERT INTO terms(date_start, date_end, name, deleted, version, current)
	VALUES('2019-01-01', '2019-01-30', 'January term', 0, current_timestamp(), 0); 
INSERT INTO terms(date_start, date_end, name, deleted, version, current)
	VALUES('2019-04-01', '2019-04-30', 'April term', 0, current_timestamp(), 1); 
INSERT INTO terms(date_start, date_end, name, deleted, version, current)
	VALUES('2019-06-01', '2019-06-30', 'June term', 0, current_timestamp(), 0); 
INSERT INTO terms(date_start, date_end, name, deleted, version, current)
	VALUES('2019-09-01', '2019-09-30', 'September term', 0, current_timestamp(), 0); 
    
#Grades lookup:
INSERT INTO grades_lookup(grade, min_points, max_points)
	VALUES(5, 0, 50);
INSERT INTO grades_lookup(grade, min_points, max_points)
	VALUES(6, 51, 60);
INSERT INTO grades_lookup(grade, min_points, max_points)
	VALUES(7, 61, 70);
INSERT INTO grades_lookup(grade, min_points, max_points)
	VALUES(8, 71, 80);
INSERT INTO grades_lookup(grade, min_points, max_points)
	VALUES(9, 81, 90);
INSERT INTO grades_lookup(grade, min_points, max_points)
	VALUES(10, 91, 100);
    
#Exam registrations:
INSERT INTO exam_registrations(exam_registration_date, deleted, version, course_id, student_id, term_id)
	VALUES(current_date(), 0, current_timestamp(), 1, 1, 2);
INSERT INTO exam_registrations(exam_registration_date, deleted, version, course_id, student_id, term_id)
	VALUES(current_date(), 0, current_timestamp(), 1, 2, 2);

#Grades:
INSERT INTO grades(grade, total_points, student_id, course_id, version, deleted)
	VALUES(8, 79, 1, 1, current_timestamp(), 0);

#Pre exam obligations:
INSERT INTO pre_exam_obligations(name, points, student_id, course_id, version, deleted)
	VALUES('Written exam 1', 25, 1, 1, current_timestamp(), 0);
INSERT INTO pre_exam_obligations(name, points, student_id, course_id, version, deleted)
	VALUES('Written exam 2', 24, 1, 1, current_timestamp(), 0);
INSERT INTO pre_exam_obligations(name, points, student_id, course_id, version, deleted)
	VALUES('Spoken exam', 30, 1, 1, current_timestamp(), 0);

#Payments:
INSERT INTO payments(payment_purpose, amount, date, student_id, version, deleted)
	VALUES('Exam registration', 200, current_date(), 1, current_timestamp(), 0);
INSERT INTO payments(payment_purpose, amount, date, student_id, version, deleted)
	VALUES('Exam registration', 200, current_date(), 2, current_timestamp(), 0);
    
#Documents
INSERT INTO documents(name, file_name, uri, student_id, version, deleted)
	VALUES('Scanned id card', 'idcard.pdf' 'ftp://localhost/files/idcard.pdf', 1, current_timestamp(), 0);
INSERT INTO documents(name, file_name, uri, student_id, version, deleted)
	VALUES('Scanned high school diploma', 'file_name.pdf', 'ftp://localhost/files/file_name.pdf', 1, current_timestamp(), 0);