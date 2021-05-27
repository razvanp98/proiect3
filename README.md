# Medical Dashboard - Spring Boot
Medical Dashboard is an intuitive platform that offers users ability to manage all patient records and appointments in a medical office, while providing two-level privilege access that restricts actions on data using Spring Boot as backend technology.

## Prerequisites
This application runs on top of JVM with Spring Boot and Hibernate ORM.  Prior to deployment, you should have the following installed and configured.

 1. **Java Development Kit** (at least JDK 11)
 2. **PostgreSQL 13 Server** (configured and having the database tables imported from self-contained `database_export.sql`) **NOTE**: *Once configured,  you need to change database, username and password in `/src/main/resources/hibernate.cfg.xml` file*
 3. **IntelliJ IDEA** - to build and run the project

## Running Application

When running application, the following view should pop up:

![Login Screen](https://imgur.com/GU18YrL)

You can create and ADMIN or USER account (USER account cannot delete any records in dashboard).

Once logged in, the following view will appear:

![Main Page](https://imgur.com/aUMhjJg)
