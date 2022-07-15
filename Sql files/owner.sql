CREATE TABLE flat_info(
    flat_no INT NOT NULL PRIMARY KEY,
    bedrooms INT NOT NULL,
    vacent VARCHAR(10)
    CONSTRAINT bool CHECK(vacent='yes' or vacent= 'no')
);
CREATE TABLE maintenance_info(
    flat_no INT NOT NULL PRIMARY KEY,
    cost NUMERIC(19,2) NOT NULL,
    paid VARCHAR(20),
    CONSTRAINT bool CHECK(paid='yes' or paid= 'no')
);
CREATE TABLE owner_info (
    id INT NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    flat_no INT NOT NULL,
    CONSTRAINT flat_link FOREIGN KEY(flat_no) REFERENCES flat_info(flat_no),
    CONSTRAINT maintenance_link FOREIGN KEY(flat_no) REFERENCES maintenance_info(flat_no),
    UNIQUE(flat_no)
);
insert into flat_info (flat_no,bedrooms,vacent) values(1,3,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(2,2,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(3,2,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(4,3,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(5,3,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(6,3,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(7,3,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(8,3,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(9,2,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(10,3,'no');
insert into flat_info (flat_no,bedrooms,vacent) values(11,3,'yes');
insert into flat_info (flat_no,bedrooms,vacent) values(12,3,'yes');

insert into maintenance_info(flat_no,cost,paid) values(1,4000,'yes');
insert into maintenance_info(flat_no,cost,paid) values(2,3000,'yes');
insert into maintenance_info(flat_no,cost,paid) values(3,3000,'yes');
insert into maintenance_info(flat_no,cost,paid) values(4,4000,'no');
insert into maintenance_info(flat_no,cost,paid) values(5,4000,'yes');
insert into maintenance_info(flat_no,cost,paid) values(6,4000,'yes');
insert into maintenance_info(flat_no,cost,paid) values(7,4000,'no');
insert into maintenance_info(flat_no,cost,paid) values(8,4000,'yes');
insert into maintenance_info(flat_no,cost,paid) values(9,3000,'yes');
insert into maintenance_info(flat_no,cost,paid) values(10,4000,'yes');

insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (1, 'Caprice','Jaher','cjaher0@tripadvisor.com', 'Female',1);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (2, 'Gene','Patchett','gpatchett1@ed.gov', 'Male',2);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (3, 'Edmund', 'Gurg', 'egurg6@blogs.com', 'Male',3);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (4,'Gasparo', 'Burleton', 'gburleton7@harvard.edu', 'Male',4);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (5,'Nerita', 'Philipp', 'nphilipp3@java.com', 'Female',5);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (6, 'Savina', 'Schutze', 'sschutze5@altervista.org', 'Female',6);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (7, 'Cleve', 'Houseley', 'chouseleyi@acquirethisname.com', 'Male',7);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (8, 'Prentice', 'Peasey', 'ppeaseyk@printfriendly.com', 'Male',8);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (9, 'Xerxes', 'Karpman', 'xkarpmanl@parallels.com', 'Male',9);
insert into owner_info (id, first_name,last_name, email , gender, flat_no) values (10, 'Bradford', 'Shearme', 'bshearmeo@go.com', 'Male',10);

