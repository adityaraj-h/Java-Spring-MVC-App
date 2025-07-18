# Springboot-MVC-Application with Solr Search Integration

Things you will need to set this up locally:

Java JDK version above 17 : https://www.oracle.com/in/java/technologies/downloads/
Extension pack for Springboot: based on your IDE
- VS Code : https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack
- Eclipse: https://spring.io/tools

Go to this SpringBoot official website link and follow the steps after "Starting with Spring Initializr" and manually initialise the project! 
https://spring.io/guides/gs/spring-boot

Follow the file structure in this repo and drop a question if you have any!


Description of the Application Structure:

Core functions are present in this directory and also the MVC architecture can be viewed here : /src/main/java/com/example/demo/
- DemoApplication.java is the entry point to the application
- /controller is the control point of the application and is responsible for navigating each request to the correct service/logic. The userService object is injected here
- /service contains the service logic for each function and utilizes the correct function from the Mapper Interface
- /mapper executes the functions defined in the Service class
  
The Object-Data mapping is done in this directory: /src/main/java/com/example/demo/resources
- /mapper folder here contains the XML file that interacts with to the MySQL db
- /templates contains the view of the application and contains the HTML files
- application-sample.properties contains the db connectivity configurations and passwords to your db
