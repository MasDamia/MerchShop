create database merchandiseShop;

use merchandiseShop;

create table Stock (
stockID int primary key not null auto_increment,
stockName varchar(100),
stockQtt int,
stockPrice decimal
);

create table Customer (
customerID int primary key auto_increment,
username varchar(50),
password varchar(50),
emailAddress varchar(50)
);

create table Orders (
orderID int primary key auto_increment,
custID int references Customer(custID),
orderDate date,
orderStatus varchar(50),
address varchar(100)
);

create table OrderDetails(
stockID int references Stock(stockID),
orderID int references Orders(orderID)
);

create table Payment (
paymentID int primary key auto_increment,
orderID int references Orders(orderID),
paymentDate date,
paymentMethod varchar(20),
amount decimal
);

create table Manager (
managerID int primary key auto_increment,
username varchar(50),
password varchar(50),
emailAddress varchar(50)
);

create table Report (
reportID int primary key auto_increment,
reportDate date,
stockID int references Stock(stockID),
orderID int references Orders(orderID),
paymentID int references Payment(paymentID),
managerID int references Manager(managerID)
);

create table Feedback (
feedbackID int primary key auto_increment,
customerID int references Customer(customerID),
feedbackDetails varchar(500),
rate int,
feedbackResponse varchar(500)
);

create table Staff (
staffID int primary key auto_increment,
username varchar(50),
password varchar(50),
emailAddress varchar(50)
);

create table StaffResponse(
feedbackID int references Feedback(feedbackID),
staffID int references Staff(staffID)
);
