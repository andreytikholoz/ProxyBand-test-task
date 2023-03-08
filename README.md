# Test task Tikholoz Andriy

___

## General info
####This project is the implementation of a test task.
####Realized in this version: project implementation with registration of user, create, update and delete of note. 
* Both a registered user and an anonymous user can create a post. 
* Verification that the user is registered occurs through Basic Auth. 
* Users and anonymous can get a list of all notes. 
* Only user can get a list of his own notes. 
* Lists of notes can be received in sorted form from newest to oldest. 
* Only user can put likes and dislikes on notes.
* Data is stored in MongoDB.

In the *resources* you can find file *Test-task-ProxyBand.postman_collection.json* where a collection of requests for 
each method of this service is presented.

The project uses the OpenAPI specification. In the *resources* you can find configuration file *noteApi.yaml*.