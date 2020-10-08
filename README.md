# CDI Java EE Example

This is a project to show how to use Contexts and Dependency Injection (CDI) from Java EE.

## Technologies

- Maven
- Java EE (CDI)

## Getting Started

The Java EE appliation can be deployed in a web server like Glassfish, Payara or WildFly.

### Deployment on Payara

1. Install Payara (MacOS):

    ```
    brew install payara
    ```

2. Start Payara:

    ```
    asadmin start-domain --verbose domain
    ```
      
3. Go to Payara administration console at `localhost:8080`. The first time it will ask you to set a password for the admin user.                                                                                                             
4. Build the application:

    ```
    mvn clean install
    ```

5. Deploy the application: go to Applications>Deploy... and choose the file 
 `my-mdb/target/cdi-javaee-example-1.0.war`.
 
 >Glassfish version 5.1.0 has a bug in the deployment form (GUI internal error: Archive Path is NULL). 
 >The fix is either modifying the html in the browser or 
 >opening `/usr/local/Cellar/glassfish/5.1.0/libexec/glassfish/modules/console-common.jar` and
 > replace `<sun:form id="form">` with `<sun:form id="form" enctype="multipart/form-data">` in `applications/uploadFrame.jsf`.

 ```
 vi console-common.jar
 applications/uploadFrame.jsf
 ```
        
7. Access API:

```
http://localhost:8080/cdi-javaee-example/bean
http://localhost:8080/cdi-javaee-example/qualifier
http://localhost:8080/cdi-javaee-example/inject-list
```
   
### Deployment on WildFly

1. Install WildFly (MacOS):

    ```
    brew install wildfly-as
    ```
   
   Add to `.bash_profile` or `.zshrc`:
   
    ```
    export JBOSS_HOME=/usr/local/opt/wildfly-as/libexec
    export PATH=${PATH}:${JBOSS_HOME}/bin
    ```
   
2. Start WildFly:

    ```
    brew services start wildfly-as
    ```

3. Go to `localhost:9990`
4. Build project and deploy beans and client. 
>Remember, WildFly 20 is not compatible with business interface dependency injection, 
>you have to use JNDI lookup instead.
   