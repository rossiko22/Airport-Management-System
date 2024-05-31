
## Introduction to Application

To use this application, you need to have installed :

    -PostgreSQL Database
    -Java Developement Kit (JDK)
    -Database Structure

    Clone the repository in your IDE.

    Proceed with installation of PostgreSQL and JDK for running the application.

    After installation of PostgreSQL and JDK you need to install the text file with SQL queries
    that you are going to run in the database and fill it with the desired information.

        Open the application.properties (You can find this in /resources/ in cloned repository)
        It should look like this:
                spring.application.name=test
                spring.datasource.url=jdbc:postgresql://localhost:5432/{databaseName}
                spring.datasource.username=
                spring.datasource.password=
                spring.jpa.hibernate.ddl-auto=create
        
        -Enter the name of database that you have created and is going to store all information in postgres.

        -Enter your database username and password (postgres by default , and the password you have set during setup installation)
        

    After installation just open the folder using some IDE , 
    recommended Intelij Community Edition run and dont forget to have Fun.

You can install the requirements from here :

[PostgreSQL](https://www.postgresql.org/)

[JDK](https://download.oracle.com/java/21/archive/jdk-21.0.2_windows-x64_bin.exe)

[Database Query]()

