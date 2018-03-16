04.Component Scanner
The goal of Component Scanner is remove ALL the beans in context.xml file and use Annotations to indicates how Spring 
needs to create our classes.

Only I need to add into context xml file next line:

<context:component-scan base-package="<package>" />	On '<package' we need to modify by the package name where I can find the class

The class will have @Component("<unique_id_name>") attribute 
