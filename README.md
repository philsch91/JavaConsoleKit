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
```

## Build
```
jar cvf JavaConsoleKit.jar ./build/classes/com/schunker/java/*.class ./build/classes/com/schunker/java/model/*.class
```
