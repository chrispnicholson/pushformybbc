# pushformybbc
Spring Boot REST application that can push notifications to PushBullet

1. Download this code by either using 'git clone https://github.com/chrispnicholson/pushformybbc.git' on the command line **or** simply download this project as a zip file and unzip to your local drive
1. Navigate to <install_root>\pushformybbc\src\main\resources\config and find application.properties
1. Edit application.properties by setting test.access-token to your own PushBullet token
1. Navigate to <install_root>\pushformybbc
1. Run 'mvn clean install' on the command line - this should compile, run tests and install a war file in <install_root>\pushformybbc\target
1. Copy the pushformybbc-0.0.1-SNAPSHOT.war file to your Apache Tomcat installation webapps directory <TOMCAT_HOME>\webapps\pushformybbc.war (missing out the number and SNAPSHOT suffix)
1. Go to <TOMCAT_HOME>\bin and run startup from the command line
1. Install the Postman plugin into a Chrome browser
1. Issue a POST request http://localhost:8080/pushformybbc/v1/users with the JSON {"username": "yourUsername", "accessToken": "yourAccessToken"}
1. Issue a GET request http://localhost:8080/pushformybbc/v1/users
1. Issue a POST request http://localhost:8080/pushformybbc/v1/push with the JSON {"username":"yourUsername", "note": "Don't forget the milk again"}
