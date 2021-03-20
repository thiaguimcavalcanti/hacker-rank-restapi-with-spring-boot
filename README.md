# Assignment: URL Shortener

## Description

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Mandatory Requirements

This application creates REST APIs to solve these requirements:

1. The service should be able to erase all the events by the DELETE request at /erase. The HTTP response code should be 200.
2. The service should be able to add a new event by the POST request at /events. The event JSON is sent in the request body. If an event with the same id already exists then the HTTP response code should be 400, otherwise, the response code should be 201.
3. The service should be able to return the JSON array of all the events by the GET request at /events. The HTTP response code should be 200. The JSON array should be sorted in ascending order by event ID.
4. The service should be able to return the JSON array of all the events which are performed by the actor ID by the GET request at /events/actors/{actorID}. If the requested actor does not exist then HTTP response code should be 404, otherwise, the response code should be 200. The JSON array should be sorted in ascending order by event ID.
5. The service should be able to update the avatar URL of the actor by the PUT request at /actors. The actor JSON is sent in the request body. If the actor with the id does not exist then the response code should be 404, or if there are other fields being updated for the actor then the HTTP response code should be 400, otherwise, the response code should be 200.
6. The service should be able to return the JSON array of all the actors sorted by the total number of associated events with each actor in descending order by the GET request at /actors. If there are more than one actors with the same number of events, then order them by the timestamp of the latest event in the descending order. If more than one actors have the same timestamp for the latest event, then order them by the alphabetical order of login. The HTTP response code should be 200.
7. The service should be able to return the JSON array of all the actors sorted by the maximum streak (i.e., the total number of consecutive days actor has pushed an event to the system) in descending order by the GET request at /actors/streak. If there are more than one actors with the same maximum streak, then order them by the timestamp of the latest event in the descending order. If more than one actors have the same timestamp for the latest event, then order them by the alphabetical order of login. The HTTP response code should be 200.

## Technologies

- Java 8
- Spring Boot 2.1.3.RELEASE
- Hibernate 5.3.7.Final
- REST API

## How to compile and run the application with an example for each call

Install: git clone https://github.com/thiaguimcavalcanti/hacker-rank-restapi-with-spring-boot.git

Build: mvn package
- Note: After executing the build command, please to refresh the project files

Deploy: mvn spring-boot:run

## Examples for each call

{{URL}}/events
{{URL}}/events/actors/2790320
{{URL}}/actors/streak
{{URL}}/actors
{{URL}}/erase

To facilitate the execution of the calls:

All the others requests are in the file "SpringBoot.postman_collection.json" in the "src/main/resources/postman/" folder with its configuration ("Spring Boot.postman_environment.json").
The file must be imported into the Postman (https://www.getpostman.com/) application. 
How-to: https://support.smartbear.com/readyapi/docs/testing/integrations/postman.html#importing-a-postman-collection