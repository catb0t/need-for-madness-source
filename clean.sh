#!/bin/bash
command rm -v *.class {ibxm,ds}/**/*.class
command rm BUILD/** -r
command rm OBJ/*.log
command mkdir -p BUILD