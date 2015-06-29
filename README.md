# Manage My Money Server - MyBatis
 *Manage My Money* is a simple application to record and analyze your income and expenses. It demonstrates best practices in developing applications using Java, REST and [MyBatis](http://mybatis.github.io/mybatis-3/). Its functionality is the same as that of the [JavaScript version](https://github.com/archfirst/manage-my-money-server). There is also an AngularJS based front-end [here](https://github.com/archfirst/manage-my-money-client).

## Domain Model
![Domain Model](https://github.com/archfirst/manage-my-money-server/blob/master/domain-model/manage-my-money.png)

## Requirements

- [Java SE 8 (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven version 3.x](https://maven.apache.org/)
- [PostgreSQL](http://www.postgresql.org/) and postgresql93-devel (development header files and libraries)

## Quick Start
- Create a Postgres database called `manage-my-money`
- Download the following files that will be used to initialize the database

    - [create-schema.sql](https://github.com/archfirst/manage-my-money-server/blob/master/sql/create-schema.sql)
    - [load-data.sql](https://github.com/archfirst/manage-my-money-server/blob/master/sql/load-data.sql)
- Change directory to the location where you downloaded the files and initialize the database:

        $ psql manage-my-money
        manage-my-money=# \i create-schema.sql
        manage-my-money=# \i load-data.sql

- Open a terminal (command line) window

- Clone this repo

- Make sure that `src/main/resources/mybatis-config.xml` has the correct database parameters

Run the application locally:

```bash
$ mvn spring-boot:run
```

To verify that the application is working correctly, point your browser to [http://localhost:8080/accounts](http://localhost:8080/accounts) - you should see a response with a list of accounts in JSON format.

## Folder Structure

```
manage-my-money-mybatis/src/main/java/org/archfirst/mmm
    /adapter
    /application
    /domain
    /persisence
```

The source folders arrange the application into logical layers as suggested by the [Hexagonal Architecture](http://alistair.cockburn.us/Hexagonal+architecture) (a.k.a. the [Onion Architecture](http://jeffreypalermo.com/blog/the-onion-architecture-part-1/)):

- The `adapter` layer *adapts* interactions from the external world to the application layer. This layer contains the REST adapter that converts incoming HTTP messages to a format acceptable by the application layer.

- The `application` layer coordinates high-level activities such as creation of the domain objects and asking them to perform tasks requested by the external world.

- The `domain` layer encapsulate the state and behavior of the business domain. It consists of entities and value objects. See [this article](https://archfirst.org/domain-driven-design/) for a detailed description of the domain layer.

- The `persistence` layer is responsible for storing and retrieving the domain objects using the persistence library called [MyBatis](http://mybatis.github.io/mybatis-3/).