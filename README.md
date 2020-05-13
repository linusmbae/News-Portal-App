# Project Name
#### [News Portal App](https://github.com/linusmbae/News-Portal-App.git)
# Author Name
Mbae Linus Mutugi

# Description
The news portal app is intended to be used by an organization to pass their news to the other employees. The news can be either departmental or general news.

# Project Setup
### Database Setup
Click this [link](https://www.postgresql.org/download/) to install postgreSQL if you don't have one.

for ubuntu users use the following in the terminal:

> sudo apt-get update

> sudo apt-get install postgresql postgresql-contrib libpq-dev


 ##### creating database
open your terminal and paste the following:
> psql <drop.sql 

This will clear the databases created with same name

> psql <create.sql

This will create all tables required for the system

### cloning project

Click [here](https://github.com/linusmbae/News-Portal-App.git) and fork this repository to your github.

Copy the clone link.

Navigate through your local storage to your favourite directory using terminal.

Clone the App to your local storage and launch it.
 
 
 # Getting things ready
 navigate to your project and make necessary changes to the following files
 #### path
 > News-Portal-App/src/main/java/App

>>  String connectionString = "jdbc:postgresql://localhost:5432/news_portal_database";

>>  Sql2o sql2o = new Sql2o(connectionString, "user", "pass");

> News-Portal-App/src/test/java/models/dao/

make necessary changes to the database links in the test files

>>  String connectionString = "jdbc:postgresql://localhost:5432/news_portal_database_test";

>>  Sql2o sql2o = new Sql2o(connectionString, "user", "pass");

 ## Live Link
 [Live Link](https://news-portal-app-api.herokuapp.com/)
 
 # Api Documentation
 
 ## users
 
 ### new user
 
 > http://localhost:4567/users/new

 {
 
"name":"Mbae",

"email":"mbae@gmail.com",

"phone":"0712345678",

"idNumber":"12345"

}

### get all users

> http://localhost:4567/users

### get user by id

> http://localhost:4567/user/:id

replace :id with the user id (eg 2)

### remove user by id

> http://localhost:4567/users/:id/remove

replace :id with the user id (eg 2)

### Clear entire database

> http://localhost:4567/users/clear

## Department

### New department

> http://localhost:4567/department/new

{

	"name":"Customer Desk",
	
	"floor":"Ground"
	
}

### get all departments

> http://localhost:4567/departments

### get department by id

> http://localhost:4567/department/:id

replace :id with the department id (eg 2)

### remove department by id

> http://localhost:4567/departments/:id/remove

replace :id with the department id (eg 2)

### clear department database

> http://localhost:4567/departments/remove/all

## General news

### new

> http://localhost:4567/news/general-news/new

{

	"content":"Tomorrow is a long holiday",
	
	"type":"General News"
	
}

### fetch general news 

> http://localhost:4567/news/general-news/

### clear the database

> http://localhost:4567/news/general-news/clear

## Department news

### new

> http://localhost:4567/news/department-news/new

{

	"content":"public holiday approaching",
	
	"type":"Department News"
	
}

## fetch department news

> http://localhost:4567/news/department-news

### clear the database

> http://localhost:4567/news.department-news/clear
 
## Reach me
[Email](linusmutugi5178@gmail.com) 

# CopyRight & License
MIT License

#### News-Portal-App

Copyright (c) [2020] [Linus Mutugi Mbae]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
