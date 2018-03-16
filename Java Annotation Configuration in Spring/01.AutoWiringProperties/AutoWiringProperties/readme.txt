01.Autowiring
=============

If you take a look on Java Spring Application Basics (first Spring intro), project 'autoXXXXXXX'.
In these project the configuration is made using 'appContext.xml' file.

Now, in next example, we'll use Annotations, that's, we remove some information from appContext.xml file and place the information in Java code.

For your info, the configuration of the context, usually is, by xml (as previous String intro), using Annotations(aka Attributes) or by code using Java.


In this case, we need to modify appContext.xml file to add 'context' namespace. On Eclipse, when you open an appContext.xml file, some tab appears below the file.
Choose 'Namespace' tab and add Context schema. If doesn't works, try to add:

xmlns:context="http://www.springframework.org/schema/context"

Also, add <context:annotation-config/> to indicate that will use Annotations in this app

Then in Meal.java class, add @Autowired attribute in each field or in the setXXXXXXX

Also, you can try @Autowired (required=false) in one private field and remove from appContext.xml and the app doesn't crash.

As well, you can use @Qualifier attribute on java class field. 

@Qualifier(<uniqueIdBean>)
private <thetpye> <thename>

eg:
@Qualifier("unique_id_fruit")
private Fruit fruit;

Or add a <qualifier> tag into the bean on .xml, eg:

	<bean id="unique_id_fruit" class="foo.Fruit">
		<qualifier value="bigFruit" />
	</bean>

On .java, you will need to use
@Qualifier(value="bigFruit").

As opposite, the attribute @Required, force in compile time that a property need to be set. If not, the compilation will fail.

For init and destroy method, we can use attributes as well:
@PostConstruct. Add it this attribute to force to run the method on init 
@PreDestroy. Force to run the method at the desctrution