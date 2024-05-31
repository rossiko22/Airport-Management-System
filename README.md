
# Airport Management System

This is an Simple Airport Manage System made by rossiko22


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

## GET Endpoints

| /flights             |Get all flights                                                                |
| ----------------- | ------------------------------------------------------------------ |
| /flight/{flightId} | Retrieves a specific flight by its ID  |
| /flights/{OriginCountry}/{destinationCountry}| Retrieves a list of flights from the specified origin country to the specified destination country |
| /flight/{flightId}/airplane | Retrieves the airplane associated with the specified flight ID  |
| /flight/{flightId}/bookings | Retrieves a list of bookings for the specified flight ID  |
|/flight/{flightId}/seats-availability| Retrieves a list of available seats for the specified flight ID |
| /flight/{flightId}/check-seat-availability/{seatId} | Checks the availability of a specific seat on the specified flight |
| /flight-changes| Retrieves a list of recent changes made to flights |
| /flight-cancellations| Retrieves a list of recently canceled flights |
| /cancel/flight/{flightId}| Cancels the specified flight |
| /seats| Retrieves a list of all seats across all flights |
| /loyality-programs| Retrieves a list of all loyalty programs |
| /flight-providers| Retrieves a list of all flight providers that our agency works with |
| /countries| Retrieves a list of all countries that our agency works with |
| /airports| Retrieves a list of all airports that our agency works with |
| /airports/{countryName}| Retrieves a list of airports from the specified country |
| /airport-type| Retrieves a list of all airport types that our agency works with |
| /airplane-models| Retrieves a list of all airplane models that our agency works with |
| /airplanes| Retrieves a list of all airplanes that we currently have |
|/airplane/{id}| Retrieves an airplane by its ID |

## Authors

- [@rossiko22](https://github.com/rossiko22)

