**URL app**

**Problem description**


**Description**


Most of us are familiar with seeing URLs like bit.ly or t.co on our Twitter or Facebook
feeds. These are examples of shortened URLs, which are a short alias or pointer to a
longer page link. For example, I can send you the shortened
URL http://bit.ly/SaaYw5 that will forward you to a very long Google URL with search
results on how to iron a shirt. 
Requirements
	Design and implement an API for short URL creation
	There should be some form of persistent storage, but don’t waste too much time on database configuration  simple file holding records or transitory runtime object is enough,
	Implement forwarding of short URLs to the original ones,
	Assume application will be distributed as Docker image. Provide Dockerfile, but don’t waste too much time for building and testing docker image, focus on functionality. 
	Assume importance levels:

-  Code working as described in requirements,
-  Application is building with simple javac, mvn install or gradle build command (or any basic build command working on behalf of programming language you choose),
-  Unit tests are included. Coverage level depends on time you have left to complete the assignment, but we would like to see business logic (service layer) coverage at 60%,
-  Other things you would like to implement for this project (ex. Database, application test coverage over 90%, API for gathering different statistics,  UI or whatever else you think would make your application extraordinary),




**How to build**

This project is a maven based project and you can use the below command to build it:

`mvn clean install`

**Deployment**

You can create a docker file with this command:

`docker build -t url-shortner:latest .`

**Running with docker composer**

This command is used to run with docker composer

`docker-compose up -d`

to stop running docker container:

`docker-compose down`


`Endpoints`
--------------------------------------------
`/resources/urls`   |  `GET`   | gives a url query string and returns original url
--------------------------------------------
`/resources/urls`  | `POST`  |   generates a new shortened url and save it 
`content-type: application/json`
--------------------------------------------

** sample code **
-  to save a url

`curl -X POST \
  http://URL:8081/resources/urls \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: c16a74c3-e71d-bb65-76a7-c34cc45a4243' \
  -d '{
	"url":"test/amir"
}'`

-  to get a url

`curl -X GET \
   'http://URL:8081/resources/urls?url=https%3A%2F%2Fbit.ly%2F77981f9d2f' \
   -H 'cache-control: no-cache' \
   -H 'postman-token: e93e4408-ad47-9058-384c-a098b8c6acb4'`