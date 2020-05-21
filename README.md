# ida803f20

We are developing a tool for managing a kitchen garden. The tool consists of a Java application and a MySQL database.

This is how you do:

Accept the email invitation to collaborate.

Clone this repository to your computer. For instructions using Netbeans watch this video from 10:44 https://www.youtube.com/watch?v=5yukeBNBs3w

Set up the database 'kitchengarden' by running the sql script named database_installer_script.sql in MySQL Workbench.

Install the JDBC driver.

Add/import JavaFX13 to the project library.

Now you can run the Java application MyKitchenGarden.java that connects java with your local MySQL database and makes a query.

From now on before working on code, remember to make a pull first (Team -> Git -> Remote -> Pull).
When you finish writing your code, the procedure is to commit (Team -> Commit) and then push (Team -> Git -> Remote -> Push)


Known potential bugs:

After adding the Library "mysql-connector-java-8.0.19.jar", when making a pull request, a warning can come up. There are 3 options: revert, something, cancel. Choose revert. 
Then add the library agian to your project. After this, go to the files section in the project, and locate the file ".gitignore". In this file add: "mysql-connector-java-8.0.19.jar" below ".nb-gradle/" 
Now netbeans should ignore this file when using Git.

Cant find the javafx library:
Add the library to your project. The library to be added is javafx13.
If you get an javafx error - then try --> properties --> run --> and change the file location to a library location. hint: look at an earlier project that uses javafx) 
