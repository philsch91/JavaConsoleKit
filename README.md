# JavaConsoleKit

## Download Dependencies
```
mvn dependency:resolve
```

## Verify Dependencies
```
mvn -X dependency:tree
mvn dependency:tree | grep <dependency-name>
```

## Test
```
mvn test
```

## Package
```
mvn [--settings settings.xml] clean package
// List contents for packaged .jar file
jar tvf target/JavaConsoleKit-1.0-SNAPSHOT.jar
```

## Install
```
// Install JAR into local Maven repository
mvn install:install-file \
    -Dfile=./target/JavaConsoleKit-1.0-SNAPSHOT.jar \
    -DgroupId=com.schunker.java \
    -DartifactId=JavaConsoleKit \
    -Dversion=1.0-SNAPSHOT \
    -Dpackaging=jar \
    -DgeneratePom=true
```

## Build
```
jar cvf JavaConsoleKit.jar ./build/classes/com/schunker/java/*.class ./build/classes/com/schunker/java/model/*.class
```
