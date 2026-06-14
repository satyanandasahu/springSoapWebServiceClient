# Spring Boot SOAP Client (springSoapWebServiceClient)

This project is a **SOAP client** built with Spring Boot, designed to consume the web service from the companion project:  
👉 [Springbootsoapws](https://github.com/satyanandasahu/Springbootsoapws)


## ⚙️ How to Use

1. **Deploy the Web Service**  
   Run the `Springbootsoapws` project on your server.

2. **Update WSDL URL**  
   In the main class of this client project, update the WSDL URL to point to your deployed service.

---

## 🔨 Maven Plugins for WSDL/XSD Code Generation

You can use different Maven plugins in your `pom.xml` to generate Java classes from WSDL or XSD.  
This project uses **XJC** to generate classes from XSD, but here are other options:

### 1. **JAX-WS Maven Plugin**

```xml
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
```

---

### 2. **JAXB2 Maven Plugin**

```xml
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>jaxb2-maven-plugin</artifactId>
  <version>3.1.0</version>
</plugin>

<plugin>
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
```

---

### 3. **Apache CXF Codegen Plugin**

> ⚠️ Requires adding the Apache CXF dependency in your `pom.xml`.

```xml
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
```

```xml
<dependency>
  <groupId>org.apache.cxf</groupId>
  <artifactId>cxf-rt-frontend-jaxws</artifactId>
</dependency>
```

---

## 🎥 Video Walkthrough

For a step‑by‑step explanation, watch the YouTube tutorial:  
👉 [SOAP Client Project Walkthrough](https://youtu.be/SZ9kshBcvFA)

---

Would you like me to also add a **Quick Start section** with commands to run the client (like `mvn spring-boot:run`), so new users can immediately test it after setup?
