# Project Name
####[News Portal App](https://github.com/linusmbae/News-Portal-App.git)
# Author Name
Mbae Linus Mutugi

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
