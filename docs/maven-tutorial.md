# Maven Tutorial for Java Developers

## What is Maven?

Maven is a build automation and project management tool for Java projects. Think of it as a more powerful alternative to manually compiling with `javac` and creating JARs with `jar`. Maven handles:

- **Dependency management**: Automatically downloads and manages external libraries
- **Build lifecycle**: Standardized phases for compiling, testing, and packaging
- **Project structure**: Consistent directory layout across projects
- **Plugin ecosystem**: Extensible build process

## Maven vs Manual JAR Building

When you manually build a JAR, you typically:
1. Compile `.java` files with `javac`
2. Package `.class` files with `jar`
3. Manually manage classpath and dependencies

Maven automates this entire process and much more.

## Project Structure

Maven uses a standard directory layout:

```
my-app/
├── pom.xml                 # Project configuration file
├── src/
│   ├── main/
│   │   ├── java/          # Your Java source code
│   │   └── resources/     # Configuration files, properties, etc.
│   └── test/
│       ├── java/          # Test source code
│       └── resources/     # Test resources
└── target/                # Generated files (compiled classes, JARs, etc.)
```

## Creating Your First Maven Project

Let's create a complete working example:

### 1. Create the Project Structure

First, create the directory structure:

```bash
mkdir -p my-app/src/main/java/com/example/app
mkdir -p my-app/src/test/java/com/example/app
cd my-app
```

### 2. Create the POM File

The `pom.xml` (Project Object Model) is Maven's configuration file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
    <modelVersion>4.0.0</modelVersion>
    
    <!-- Project coordinates -->
    <groupId>com.example</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    
    <!-- Project metadata -->
    <name>My Application</name>
    <description>A sample Maven project</description>
    
    <!-- Java version -->
    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <!-- Dependencies -->
    <dependencies>
        <!-- JUnit for testing -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.9.2</version>
            <scope>test</scope>
        </dependency>
        
        <!-- Apache Commons Lang for utility functions -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.12.0</version>
        </dependency>
    </dependencies>
    
    <!-- Build configuration -->
    <build>
        <plugins>
            <!-- Compiler plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
            
            <!-- Surefire plugin for running tests -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0</version>
            </plugin>
            
            <!-- JAR plugin configuration to avoid empty JAR warning -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.3.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>com.example.app.App</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### 3. Create the Main Application Class

Create `src/main/java/com/example/app/App.java`:

```java
package com.example.app;

import org.apache.commons.lang3.StringUtils;

/**
 * Main application class demonstrating Maven build process.
 */
public class App {
    
    /**
     * Main method - entry point of the application.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello Maven World!");
        
        // Demonstrate using an external dependency
        String message = "  maven tutorial  ";
        String cleanMessage = StringUtils.trim(message);
        String capitalizedMessage = StringUtils.capitalize(cleanMessage);
        
        System.out.println("Original: '" + message + "'");
        System.out.println("Processed: '" + capitalizedMessage + "'");
        
        // Call our utility method
        MathUtils mathUtils = new MathUtils();
        int result = mathUtils.add(5, 3);
        System.out.println("5 + 3 = " + result);
    }
}
```

### 4. Create a Utility Class

Create `src/main/java/com/example/app/MathUtils.java`:

```java
package com.example.app;

/**
 * Utility class for mathematical operations.
 */
public class MathUtils {
    
    /**
     * Adds two integers.
     * 
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Multiplies two integers.
     * 
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }
}
```

### 5. Create a Test Class

Create `src/test/java/com/example/app/MathUtilsTest.java`:

```java
package com.example.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MathUtils class.
 */
public class MathUtilsTest {
    
    private MathUtils mathUtils;
    
    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }
    
    @Test
    void testAdd() {
        assertEquals(8, mathUtils.add(5, 3));
        assertEquals(0, mathUtils.add(-1, 1));
        assertEquals(-5, mathUtils.add(-2, -3));
    }
    
    @Test
    void testMultiply() {
        assertEquals(15, mathUtils.multiply(5, 3));
        assertEquals(0, mathUtils.multiply(0, 5));
        assertEquals(-10, mathUtils.multiply(-2, 5));
    }
}
```

## Maven Build Lifecycle

Maven has three built-in build lifecycles:

### Default Lifecycle (most commonly used)
- **validate**: Validate project structure
- **compile**: Compile source code
- **test**: Run unit tests
- **package**: Create JAR/WAR file
- **verify**: Run integration tests
- **install**: Install to local repository
- **deploy**: Deploy to remote repository

### Key Maven Commands

```bash
# Clean previous builds
mvn clean

# Compile source code
mvn compile

# Run tests
mvn test

# Create JAR file
mvn package

# Clean and package (common combination)
mvn clean package

# Run all phases up to verify (includes integration tests)
mvn clean verify

# Install to local Maven repository
mvn clean install

# Run the application
java -jar target/my-app-1.0.0.jar
```

## Building and Running Your Project

1. **Navigate to your project directory**:
   ```bash
   cd my-app
   ```

2. **Clean and package**:
   ```bash
   mvn clean package
   ```

3. **Run the application**:
   ```bash
   java -jar target/my-app-1.0.0.jar
   ```

Expected output:
```
Hello Maven World!
Original: '  maven tutorial  '
Processed: 'Maven tutorial'
5 + 3 = 8
```

## Understanding the POM File

### Project Coordinates
```xml
<groupId>com.example</groupId>        <!-- Organization/company -->
<artifactId>my-app</artifactId>       <!-- Project name -->
<version>1.0.0</version>              <!-- Project version -->
```

### Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.12.0</version>
        <scope>compile</scope>  <!-- Default scope -->
    </dependency>
</dependencies>
```

### Dependency Scopes
- **compile**: Available in all phases (default)
- **test**: Only available during testing
- **runtime**: Not needed for compilation, but required for execution
- **provided**: Available during compilation but not packaged

## Avoiding the Empty JAR Warning

The empty JAR warning occurs when Maven creates a JAR without any compiled classes. Our tutorial avoids this by:

1. **Including actual source code** in `src/main/java`
2. **Proper package structure** with classes that will be compiled
3. **Correct POM configuration** that doesn't exclude source files

The warning typically appears when:
- No source files exist in `src/main/java`
- Source files are in wrong directories
- Compilation fails silently

## Common Maven Commands Cheat Sheet

```bash
# Project setup
mvn archetype:generate -DgroupId=com.example -DartifactId=my-app

# Build commands
mvn clean                    # Remove target directory
mvn compile                  # Compile main source code
mvn test-compile            # Compile test source code
mvn test                    # Run unit tests
mvn package                 # Create JAR file
mvn verify                  # Run integration tests
mvn install                 # Install to local repository

# Useful combinations
mvn clean compile           # Clean and compile
mvn clean test             # Clean, compile, and test
mvn clean package          # Clean, compile, test, and package
mvn clean verify           # Full build with integration tests

# Information commands
mvn dependency:tree        # Show dependency tree
mvn help:effective-pom     # Show effective POM
mvn versions:display-dependency-updates  # Check for updates
```

## Next Steps

Now that you have a working Maven project:

1. **Explore Maven plugins** for additional functionality
2. **Learn about profiles** for different build configurations
3. **Understand dependency management** and version conflicts
4. **Explore Maven repositories** like Maven Central
5. **Consider multi-module projects** for larger applications

## Troubleshooting

### Common Issues

1. **Java version mismatch**: Ensure `maven.compiler.source` and `maven.compiler.target` match your Java version

2. **Dependencies not found**: Check your internet connection and Maven repository settings

3. **Tests failing**: Run `mvn test` to see detailed test output

4. **Empty JAR**: Ensure you have source files in `src/main/java` with proper package structure

This tutorial provides a solid foundation for using Maven in your Java projects. The key advantage over manual JAR building is Maven's automatic dependency management, standardized build process, and extensive plugin ecosystem.
