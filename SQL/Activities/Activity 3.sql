REM   Script: Activity 3
REM   3

create table salesman;

create table salesman;

create table salesman (salesman_id int,salesman_name varchar2(20),salesman_city varchar2(20),commission int);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5001,'James Hoog','New York',15);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5002,'Nail Knite','Paris',13);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5005,'Pit Alex','London',11);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5006,'McLyon','Paris',14);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5007,'Paul Adam','Rome',13);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5003,'Lauson Hen','San Jose ',12);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5002,'Nail Knite','Paris',13);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5005,'Pit Alex','London',11);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5006,'McLyon','Paris',14);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5007,'Paul Adam','Rome',13);

insert into salesman (salesman_id,salesman_name,salesman_city,commission) 
    values (5003,'Lauson Hen','San Jose ',12);

select * from salesman;

select salesman_id ,salesman_city from salesman;

select * from salesman where salesman_city='Paris';

select * from salesman;

select salesman_id,salesman_name,salesman_city,commission,count(*) as cnt from salesman group by salesman_id,salesman_name,salesman_city,commission 
having count(*)>1;

DELETE t1 FROM salesman t1   
    INNERJOIN salesman t2    
    WHERE   
        t1.salesman_name = t2.salesman_name AND   
        t1.salesman_id = t2.salesman_id;

DELETE t1 FROM salesman t1   
    INNERJOIN salesman t2    
    WHERE   
        t1.salesman_name = t2.salesman_name AND   
        t1.salesman_id = t2.salesman_id;

DELETE t1 FROM salesman t1   
    INNERJOIN salesman t2    
    WHERE   
        t1.salesman_name = t2.salesman_name ;

select salesman_id,commission from salesman where salesman_name = 'Paul Adam';

delete from salesman where salesman_id = 5002;

delete from salesman where salesman_id = 5005;

delete from salesman where salesman_id = 5006;

delete from salesman where salesman_id = 5007;

delete from salesman where salesman_id = 5003;

select * from salesman;

insert into salesman (salesman_id,salesman_name,salesman_city,commission)  
    values (5002,'Nail Knite','Paris',13);

insert into salesman (salesman_id,salesman_name,salesman_city,commission)  
    values (5005,'Pit Alex','London',11);

insert into salesman (salesman_id,salesman_name,salesman_city,commission)  
    values (5006,'McLyon','Paris',14);

insert into salesman (salesman_id,salesman_name,salesman_city,commission)  
    values (5007,'Paul Adam','Rome',13);

insert into salesman (salesman_id,salesman_name,salesman_city,commission)  
    values (5003,'Lauson Hen','San Jose ',12);

select * from salesman;

select salesman_id ,salesman_city from salesman;

select * from salesman where salesman_city='Paris';

select salesman_id,commission from salesman where salesman_name = 'Paul Adam';

select salesman_id,commission,salesman_name from salesman where salesman_name = 'Paul Adam';

