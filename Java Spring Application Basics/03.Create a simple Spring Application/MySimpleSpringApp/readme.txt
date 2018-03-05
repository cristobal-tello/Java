1) We're going to create a Spring project using maven from scracth.

I created this project using Eclipse. File->New->Maven Project. 
Make sure 'Create a simple project (skip archetype selection) is CHECKED. Click next and fill groupID, name...eg: mySimpleSpringApp
Take a look the folders layout. These 'layout' is the standard for Maven projects.

2) Make sure myApp.java file is selected as main. Create Fruit and Vegetable classes

3) On pom.xml we need to add spring libraries in order to use spring framework
Open pom.xml file, and you will see there are a few tab on the bottom of the file: "Overview", "Dependencies" ...
Select "Dependencies" tab. Click on Add button and search for "springframe"
You need to include spring-core, 4.0.6
Also, look for 'spring beans' and 'spring context'

Also, take a look on Maven Dependencies folder. More dependencies were automatically added!!

4) Right click on the project, add New Spring Bean Definition file. Named 'appContext.xml' and click Finish
5) Check the appContext.xml file. You will see how to create a bean. Also, take a look on main class to see how to use it.




