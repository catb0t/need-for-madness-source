#!/bin/bash
command rm -v *.class {ibxm,ds}/**/*.class
command rm BUILD/** -r
mkdir -p BUILD