# Test task Tikholoz Andriy

___
## Requirements
### For building and running the application you need:
* JDK 11
* Maven 3
* MongoDB installed locally(all connection properties are in *application.properties*)

### How to start service locally
1. Build the jar file: for this you need to do: *mvn clean install*;
2. Make sure that the folder called *java* which is in the path *target/generated-sources/test-task/src/main/java* 
is marked as sources;
3. Execute the main method in the *Application* class.

## General info
#### This project is the implementation of the test task.
#### Realized in this version: project implementation with registration of user, create, update and delete of note. 
* Both a registered user and an anonymous user can create a post. 
* Verification that the user is registered occurs through Basic Auth. 
* Registered users and anonymous can get a list of all notes. 
* Only registered user can get a list of his own notes. 
* Lists of notes can be received in sorted form from newest to oldest. 
* Only registered user can put like and delete it on notes.
* Data is stored in MongoDB.

In the *resources* you can find file *Test-task-ProxyBand.postman_collection.json* where a collection of requests for 
each method of this service is presented.

The project uses the OpenAPI specification. In the *resources* you can find configuration file *noteApi.yaml*.