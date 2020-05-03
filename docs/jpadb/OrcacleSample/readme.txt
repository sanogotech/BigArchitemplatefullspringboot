To set up the sample, follow the instructions below:

Set up the database for the sample:

1. Create a database user in your Oracle database, granting the CONNECT and RESOURCE roles to it.
2. Connect as the newly created user and run the dbsamplesetup.sql script containing all the statements required to create the database for the sample.

Compile and deploy the sample:

1. Compile the sources using javac by issuing the following command:

javac -d target\WEB-INF\classes src\jpqlexample\entities\*.java src\jpqlexample\servlets\*.java

2. Move on to the target directory and create the deployment package by issuing the following command:

jar cvf jpqlsample.war .

3. Launch your WebLogic application server.

4. Run the Administration Console and deploy the deployment package.


Now you can run the sample servlets by pointing your browser to a servlet of interest. Look at the web.xml configuration file to see the url-pattern for each servlet.