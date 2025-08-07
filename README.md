# Maven Example Project

This is a complete working Maven project that demonstrates the concepts from the Maven tutorial.

## Project Structure

```
maven-example/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── app/
│   │                   ├── App.java
│   │                   └── MathUtils.java
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── app/
│                       └── MathUtilsTest.java
└── target/ (generated after build)
```

## How to Build and Run

1. **Navigate to the project directory**:
   ```bash
   cd maven-example
   ```

2. **Build the project**:
   ```bash
   mvn clean package
   ```

3. **Run the application**:
   ```bash
   java -jar target/my-app-1.0.0.jar
   ```

## Expected Output

```
Hello Maven World!
Original: '  maven tutorial  '
Processed: 'Maven tutorial'
5 + 3 = 8
```

## Key Features

- **No empty JAR warning**: The project includes actual source code in the correct directory structure
- **External dependencies**: Uses Apache Commons Lang3 for string utilities
- **Unit tests**: Includes JUnit 5 tests that run during the build
- **Proper packaging**: Configured with a main class for easy execution

## Maven Commands to Try

```bash
# Clean previous builds
mvn clean

# Compile only
mvn compile

# Run tests
mvn test

# Package into JAR
mvn package

# Full build with verification
mvn clean verify

# Install to local repository
mvn install
```

This example demonstrates all the concepts covered in the Maven tutorial and provides a solid foundation for understanding Maven builds.

## Successful Build

When running `mvn clean verify`, the compiled JARs will be placed into the `target` directory.

The results needs to include two sets of lines that indicate success. First is the overall success mesage as follows.

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

Additionally, the output must not include the following warning indicating that no code was included.

```
[WARNING] JAR will be empty - no content was marked for inclusion!
```
