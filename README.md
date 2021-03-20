
<!-- TABLE OF CONTENTS -->
## Table of Contents

<details open="open">
   <ul>
      <li>
         <a href="#getting-started">Getting Started</a>
         <ul>
            <li><a href="#prerequisites">Prerequisites</a></li>
         </ul>
      </li>
      <li>
         <a href="#installing">Installing</a>
         <ul>
            <li><a href="#running-the-application-with-maven">Running the application with Maven</a></li>
            <li>
               <a href="#running-the-application-with-executable-jar">Running the application with Executable JAR</a>
            </li>
         </ul>
      </li>
       <li>
         <a href="#using-the-app">Using the app</a>
         <ul>
            <li><a href="#creating-task-on-Trello">Creating task on Trello</a></li>
         </ul>
      </li>
   </ul>
</details>

## Getting Started

This is a excersice's recruiment for NaNLabs.

### Prerequisites

*	Create a **apikey.properties** file inside the directory: **scr/main/resources/** with the following values:

	~~~
	API_KEY = Public alphanumeric key generated by Trello App
	API_Secret = Private alphanumeric token generated by Trello App 
	~~~

*	Overwrite the **BOARD_ID** value on the file **aditional.properties** file inside the directory: **scr/main/resources/** with the IdBoard where you want to create the task


## Installing
#### Running the application with Maven

You can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ git clone https://github.com/farmandosb/nanlabs.git
$ mvn spring-boot:run
```

#### Running the application with Executable JAR

The code can also be built into a jar and then executed/run by using the command 

```shell
$ git clone https://github.com/farmandosb/nanlabs.git
$ mvn clean install
$ java -jar target/recruitment-1.0.0.jar
```

To shutdown the jar, follow the below mentioned steps on a Windows machine.

*	On Windows type **ctrl+c**

## Using the app


#### Creating task on Trello

* 	Send a POST request to this URL: **http://localhost:3000/** with the following structure

```shell
Content-Type: application/json
{"type":"issue",
"title":"Send message",
"description":"Let pilots send messages"}
```
<!-- CONTACT -->
## Contact

Freddy Suarez - [@farmandosb](https://www.armandocode.com) - freddy.armando.suarez@gmail.com
