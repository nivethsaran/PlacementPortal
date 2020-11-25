create database preparely;

use preparely;

create table faculty(
fullname varchar(50),
facultyid varchar(20) primary key,
authpassword varchar(30),
avatarurl varchar(100),
mobilenumber varchar(15),
email varchar(30),
department varchar(10)
);



create table student(
fullname varchar(50),
rollno varchar(20) primary key,
authpassword varchar(30),
avatarurl varchar(100),
mobilenumber varchar(15),
email varchar(30),
department varchar(10)
);

create table quiz(
quizid integer primary key auto_increment,
facultyid varchar(20),
quizname varchar(20),
quizdescription varchar(100),
numofquestions integer,
quizdate date,
quizstarttime time,
quizendtime time,
duration integer,
department varchar(6),
topic varchar(20),
pin integer,
foreign key (facultyid) references faculty(facultyid)
);

create table question(
quizid integer,
questionid varchar(10),
questioncontent varchar(100),
answer varchar(2),
optiona varchar(100),
optionb varchar(100),
optionc varchar(100),
optiond varchar(100),
foreign key (quizid) references quiz(quizid),
primary key (quizid,questionid)
);


create table courses(
courseid integer primary key auto_increment,
coursename varchar(100),
topicname varchar(100),
department varchar(100),
courseurl varchar(100),
facultyid varchar(100),
foreign key (facultyid) references faculty(facultyid)
);

create table coding(
problemid integer primary key auto_increment,
problemname varchar(20),
problemdesc varchar(200),
problemdifficulty varchar(10),
facultyid varchar(20),
foreign key (facultyid) references faculty(facultyid)
);

create table feedback(
facultyid varchar(20),
feedbackid integer primary key auto_increment,
pace integer,
onlinetoolsusgae integer,
effectiveness integer,
approachability integer,
recommend varchar(5),
optadvanced varchar(5),
suggestions varchar(150),
courseid integer,
foreign key (courseid) references courses(courseid),
foreign key (facultyid) references faculty(facultyid)
);

create table companyregistration(
facultyid varchar(20),
formid integer primary key auto_increment,
companyname varchar(20),
deadline date,
formurl varchar(100),
foreign key (facultyid) references faculty(facultyid));

create table scores(
scoreid integer primary key auto_increment,
quizid integer,
rollno varchar(20),
total integer,
studentscore integer,
foreign key (rollno) references student(rollno),
foreign key (quizid) references quiz(quizid)
);

create table placementexperience(
experienceid integer primary key auto_increment,
rollno  varchar(100),
experiencecontent varchar(5000),
companyname varchar(100),
posttime datetime,
foreign key (rollno) references student(rollno)
);

create table studentnotes(
noteid integer primary key auto_increment,
notetitle varchar(50),
notecontent varchar(200),
notedate date,
rollno varchar(20),
foreign key (rollno) references student(rollno)
);

create table events(
eventid integer primary key auto_increment,
eventdate date,
eventtitle varchar(50),
eventdesc varchar(200)
);

SET SQL_SAFE_UPDATES = 0;
-- SET SQL_SAFE_UPDATES = 1; 

delete from faculty;
delete from student;
delete from quiz;
delete from question;
delete from courses;
delete from coding;
delete from feedback;
delete from companyregistration;
delete from scores;
delete from placementexperience;
delete from studentnotes;
delete from events;

drop table faculty;
drop table student;
drop table quiz;
drop table question;
drop table courses;
drop table coding;
drop table feedback;
drop table companyregistration;
drop table scores;
drop table placementexperience;
drop table studentnotes;	
drop table events;

describe student;
describe faculty;
describe quiz;
describe question;
describe courses;
describe coding;
describe feedback;
describe companyregistration;
describe scores;
describe placementexperience;
describe studentnotes;
describe events;
show tables;

select * from student;
select * from faculty;
select * from quiz;
select * from question;
select * from courses;
select * from coding;
select * from feedback;
select * from companyregistration;
select * from scores;
select * from placementexperience;
select * from studentnotes;
select * from events;

insert into faculty values ("Ashwin Bala","CB.EN.U4CSEFAC01","$Qwer1234","https://i.imgur.com/nJK5tHV.jpg","7878787878","ashwin@gmail.com","CSE");

insert into student values ("Niveth Saran","CB.EN.U4CSE17337","$Qwer1234","https://i.imgur.com/nJK5tHV.jpg","7878787878","nive@gmail.com","CSE");

insert into quiz (facultyid,quizname,quizdescription,numofquestions,quizdate,quizstarttime,quizendtime,duration,department,topic,pin) values ("CB.EN.U4CSEFAC01","J2EE","Testing J2EE Basic Undestanding",5,'2020-10-07','01:00:00','01:30:00',15,"CSE","NCP",1234);
insert into question values(1,1,"J2EE full form","a","Java Enterprise Edition","Java Server Pages","Entensive Markup Language","Hypertext Markup Language");
insert into question values(1,2,"JSP full form","b","Java Enterprise Edition","Java Server Pages","Entensive Markup Language","Hypertext Markup Language");
insert into question values(1,3,"XML full form","c","Java Enterprise Edition","Java Server Pages","Entensive Markup Language","Hypertext Markup Language");
insert into question values(1,4,"HTML full form","d","Java Enterprise Edition","Java Server Pages","Entensive Markup Language","Hypertext Markup Language");
insert into question values(1,5,"HTTPS full form","a","Hypertext Transfer Protocol","Java Server Pages","Entensive Markup Language","Hypertext Markup Language");

insert into courses (coursename,topicname,department,courseurl,facultyid) values ("NCP","J2EE","CSE","https://www.youtube.com/watch?v=vJ-Zn4fo0MQ","CB.EN.U4CSEFAC01");

insert into coding (problemname,problemdesc,problemdifficulty,facultyid) values ("Reverse LL","Reverse a LinkedList","Easy","CB.EN.U4CSEFAC01");

insert into feedback (facultyid,pace,onlinetoolsusgae,effectiveness,approachability,recommend,optadvanced,suggestions,courseid) values ("CB.EN.U4CSEFAC01",9,9,9,9,"no","yes","Keep up the good work","1");

insert into companyregistration(facultyid,companyname,deadline,formurl) values ("CB.EN.U4CSEFAC01","Cisco","2020-11-05","notavailable");

insert into scores(quizid,rollno,total,studentscore) values (1,"CB.EN.U4CSE17337",5,3);

insert into placementexperience(rollno,experiencecontent,companyname,posttime) values ("CB.EN.U4CSE17337","Great Exp","Cisco","2020-10-07 12:00:00");

insert into studentnotes(notetitle,notecontent,notedate,rollno) values ("NCP Review","3 more days left","2020-10-23","CB.EN.U4CSE17337");

insert into events(eventdate,eventtitle,eventdesc) values ("2020-10-10","Cisco Approaching","3 Rounds");

update coding set problemname="Odd or Even", problemdesc ="None", problemdifficulty = "Medium" where problemid=4;
SELECT * FROM question;

Select quizid from quiz order by quizid desc limit 1; 

SELECT * FROM QUIZ;
Select * from question;

select * from scores;
update quiz set quizdate="2020-11-20", quizstarttime = "13:35:00", quizendtime ="22:00:00", duration=1 where quizid = 1;

delete from question where quizid=10;
INSERT INTO question(quizid,questionid,questioncontent,answer,optiona,optionb,optionc,optiond) values (1,10,'J2EE Stands for','a','Java 2EE','JSP 2EE','Jugo 2EE','Jug 2EE');

delete from quiz;

INSERT INTO question(quizid,questionid,questioncontent,answer,optiona,optionb,optionc,optiond) values (11,1,'two pllus two','d','1','2','3','4');