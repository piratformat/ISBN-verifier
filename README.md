# ISBN-verifier
A simple java application for verifying ISBN 10 or ISBN 13 numbers.

<h3> Framework used </h3>
The application runs a version of JAX-RS from jakarta, the reason why it is the jakarta version is that the javax version is deprecated.

<h3> File/Package structure </h3>
<li><b>Resource</b> package is for endpoint classes.</li>
<li><b>Service</b> package is for data verification classes & business logic.</li>

<h3>How to run application</h3>

The application is built to be run on tomcat server 10. <br>

1. First we will need to build ourselves a war file of the application, since maven is our best friend we will make maven do it for us: 
<b> mvn clean install </b> in project root dir.

2. When maven is done we can find our <b>.war</b> file in our target directory, the file should look like this <b>ISBN.war</b>

3. Now when we have our WAR file we can just deploy it to our Tomcat server running version 10.

4. Go to browser and go to the address where our tomcat is hosted and input


<b>proclaimer:</b> <br>
We have used the following dependencies to make jakarta JAX-RS work with tomcat since tomcat is not working well with JavaEE products: <br>
<b>jersey-container-servlet</b> <br>
<b>jersey-hk2</b> <br>
<b>jersey-media-json-jackson</b> <br>
