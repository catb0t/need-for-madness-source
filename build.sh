#!/bin/bash
echo "$($(printf "%s%s%s" "$JDKPATH" "$(test -z "$JDKPATH" || echo /)" java) -version 2>&1 | head -n1)"
echo "JDKPATH=$JDKPATH"
echo "JREPATH=$JREPATH"
echo
$(printf "%s%s%s" "$JDKPATH" "$(test -z "$JDKPATH" || echo /)" javac) "$@" -d BUILD $(find . -name "*.java")
cd BUILD || exit
$(printf "%s%s%s" "$JDKPATH" "$(test -z "$JDKPATH" || echo /)" jar) cmvf ../MANIFEST.MF ../OBJ/Game.jar $(find . -iname "*.class") >/dev/null
