## Part 1: Writing

1. I'm currently working on a project which refers to archeological research. The development team consists of two and a half developer positions. The focal point of this project is the implementation of an excavation system. It was intended to ship the implementation work to an external company. The company has resigned the contract after a while. From the beginning of the year 2015 we were obliged to implement the entire system from the scratch. I'm proud of the work we've done and the current implementation status. I'm proud of this because we reached our achievements although the project situation is very complex and difficult.
2. I would like to mention my doctoral thesis. It's a technical book about monitoring and data processing. I like this book because I wrote it by my own and it deals with data stream processing, data mining and anomaly detection. In my mind, data processing and mining are most important use cases in the future required over all application domains. This is the reason why you should read my book.

## Part 2: Coding

The conding part has been implmented by means of Eclipse within a Maven project.
The basis of the RESTful API is the Jersey framework.

The RESTful API is fully documented under the following resoure:
http://localhost:8080/recruitment-tests/rest/application.wadl

Simple JUnit tests have been implemented using the integrated Jersey Test Framework which are automatically
executed via the Maven build process.

The application provides both JSON and XML formats. To switch between both formats it's possible to change 
the ACCEPT header or to use the 'dot-notation' e.g.: .json + .xml.

A browser or curl can be used to interact with the News Application like so:

1. GET:
	- curl -i -H "Accept:application/json" http://localhost:8080/recruitment-tests/rest/v1/news
	- curl -i http://localhost:8080/recruitment-tests/rest/v1/news.json

2. POST:
	- curl -i -H "Content-Type: application/xml" -X POST -d @news.xml http://localhost:8080/recruitment-tests/rest/v1/news
	- curl -i -H "Content-Type: application/json" -X POST -d @news.json http://localhost:8080/recruitment-tests/rest/v1/news

3. PUT:
	- curl -i -H "Content-Type: application/xml" -X PUT -d @put.xml http://localhost:8080/recruitment-tests/rest/v1/news/5731d173-063f-4921-99dd-9e417d64171a

4. DELETE:
	- curl -i -X DELETE http://localhost:8080/recruitment-tests/rest/v1/news/071c74c2-1885-4739-8690-af9907afb977

The 'news'-resource allows some parameters. In order to keep is stupid and simple, parameters are mutually exclusive and weighted as follows: author beats everything, keyword beats period and period beats empty parameter e.g.:

	- http://localhost:8080/recruitment-tests/rest/v1/news?author=
	- http://localhost:8080/recruitment-tests/rest/v1/news?keyword=
	- http://localhost:8080/recruitment-tests/rest/v1/news?period=
	- http://localhost:8080/recruitment-tests/rest/v1/news
