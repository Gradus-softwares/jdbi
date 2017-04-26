jDBI provides a convenience interface for SQL operations in Java. It is not
intended as an abstraction layer, but rather a library which makes the common
things easy and the hard things possible, to paraphrase Larry Wall.

Documentation is at http://jdbi.org/

There is a mailing list at http://groups.google.com/group/jdbi

[![Build Status](https://travis-ci.org/jdbi/jdbi.svg?branch=master)](https://travis-ci.org/jdbi/jdbi)


To Build:

1-
create file ~.m2/toolchain.xml
see: https://maven.apache.org/guides/mini/guide-using-toolchains.html
eg: src/build/travis-toolchains.xml

2- generate antlr sources
mvn generate-sources

3- build
mvn clean install