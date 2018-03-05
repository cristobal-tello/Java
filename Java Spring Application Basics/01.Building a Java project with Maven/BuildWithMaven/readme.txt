1) We create a simple Java project, we call it BuildWithMaven
2) We create in 'src' folder, another folder call 'main'
3) Inside 'main' folder, we create another folder call 'java'
This is the main default layout folders for a 'maven' Java project
src
+-main
  +-java
4) Select 'main.java' folder and convert them into 'Source Folder' ,using right click, Build Path->Source folder. Remove previous 'src'
5) Add new class, package foodDemo, name'HelloFood'. Select as main 
6) Create Fruit and Vegetable class with talkAboutYourSelf methods
7) Run it and check out if it's working as we expect
8) Create the Project Object Module file, pom.xml
9) Fill it (take a look the file)
10) Run 'cmd' and go to the project folder and type: mvn package. A 'target' folder will be created
11) Inside 'target' folder, try to run the app: java -jar HelloFood-0.1.0.jar



