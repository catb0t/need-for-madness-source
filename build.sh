#!/bin/bash
$(printf "%s%s%s" "$JDKPATH" "$(test -z "$JDKPATH" || echo /)" javac) -d BUILD $(find . -name "*.java")
cd BUILD || exit
$(printf "%s%s%s" "$JDKPATH" "$(test -z "$JDKPATH" || echo /)" jar) cmvf ../MANIFEST.MF ../OBJ/Game.jar $(find . -iname "*.class")
