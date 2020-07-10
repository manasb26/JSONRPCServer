# JSON RPC 2.0 Server Implementation

This project is a server side implementation of JSON RPC 2.0 specification, which can  be found on the following link. The project is built with following technologies: Java 8, Spring Boot, and Maven.  
https://www.jsonrpc.org/specification

The project has following features:
1. Basic implementation of request, response, and error specification.
2. The Batch and Notification request specifications are not implemented.
3. The request and response use HTTP protocol for communication in synchronous way.

Here are the steps to build, and run the server using command line terminal
1. Clone the project and go to the root directory JSONRPCServer.
2. Open a terminal window/tab in the current directory (root directory of the project).
3. To build the project, use command: mvn clean install -DskipTests
4. To run the project, use command: java -jar target/*.jar
5. Send the request to server using curl or Postman tool

Example of Successful Request and Response body:  
Request:  
{
    "jsonrpc": "2.0",
    "method": "system.login",
    "params": { "username":"Manas", "password":"secret"},
    "id": 123
}  
Response:  
{
    "id": 123,
    "result": {
        "username": "Manas",
        "password": "secret"
    },
    "jsonrpc": "2.0"
}
