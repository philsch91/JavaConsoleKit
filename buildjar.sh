#!/bin/bash
# buildjar.sh

# jar cvfm JavaConsoleKit.jar META-INF/MANIFEST.MF *.class
jar cvf JavaConsoleKit.jar ./build/classes/com/schunker/java/*.class ./build/classes/com/schunker/java/model/*.class
