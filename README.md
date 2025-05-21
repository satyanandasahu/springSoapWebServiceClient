
This project is a soap client project for spring boot ws soap project here is the @Springbootsoapws link https://github.com/satyanandasahu/Springbootsoapws Deploy the Webservice on the server
Goto the Main class of this project and accordingly change the wsdl url to make the client program work.


Here are different Maven Plugins you can use in your pom file to generate the class files from wsdl. I have used xjc to generate the class files from XSD.
<plugin>
	<groupId>com.sun.xml.ws</groupId>
	<artifactId>jaxws-maven-plugin</artifactId>
	<version>3.0.0</version>
	<executions>
		<execution>
			<goals>
				<goal>wsimport</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<packageName>com.example.consumingwebservice.wsdl</packageName>
		<wsdlUrls>
			<wsdlUrl>http://localhost:8080/ws/countries.wsdl</wsdlUrl>
		</wsdlUrls>
		<sourceDestDir>${sourcesDir}</sourceDestDir>
		<destDir>${classesDir}</destDir>
		<extension>true</extension>
	</configuration>
</plugin>

<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>jaxb2-maven-plugin</artifactId>
	<version>3.1.0</version>
	<groupId>org.jvnet.jaxb2.maven2</groupId>
	<artifactId>maven-jaxb2-plugin</artifactId>
	<version>0.15.3</version> 
	<executions>
		<execution>
			<goals>
				<goal>generate</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<generatePackage>com.example.satya.vo</generatePackage>
		<generateDirectory>${project.basedir}/src/main/java</generateDirectory>
		<schemaDirectory>${project.basedir}/src/main/resources/wsdl</schemaDirectory>
		<schemaIncludes>
			<include>*.wsdl</include>
		</schemaIncludes>
	</configuration>
</plugin>

#For this below plugin apache cxf plugin you need to add the dependency given below the plugin into your pom file
<plugin>
	<groupId>org.apache.cxf</groupId>
	<artifactId>cxf-codegen-plugin</artifactId>
	<version>3.5.0</version>
	<executions>
		<execution>
			<goals>
				<goal>generate</goal>
			</goals>
			<configuration>
				<sourceRoot>${project.build.directory}/generated-sources</sourceRoot>
				<wsdlOptions>
					<wsdlOption>
						<wsdl>http://www.yourwsdlservice.com/wsdl</wsdl>
					</wsdlOption>
				</wsdlOptions>
			</configuration>
		</execution>
	</executions>
</plugin>
        
        
#Apache CXF for generating Java classes from WSDL
<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-rt-frontend-jaxws</artifactId>
</dependency> 

Note: Watch the video for better understanding the content of the project. Here is the youtube link https://youtu.be/SZ9kshBcvFA

