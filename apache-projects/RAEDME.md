SLF4J全称The Simple Logging Facade for Java
Log4j 2是log4j 1.x和logback的改进版

slf4j-log4j12 is a bridge between SLF4J and Log4j 1.2. Its versioning follows SLF4J.
log4j-slf4j-impl is a bridge between SLF4J 1.x (up to 1.7.x) and Log4j 2.x. Its versioning follows LOG4J2.
log4j-slf4j2-impl is a bridge between SLF4J 2.x (or higher) and Log4j 2.x. Its versioning follows LOG4J2.

SLF4J & Logback：这样看上去也挺美好的，但是log4j的作者觉得JCL不好用，自己开发出SLF4J（Simple Logging Facade for Java），它跟JCL类似，本身不替供日志具体实现，只对外提供接口或门面。目的就是为了替代JCL。同时，还开发出logback，一个比log4j拥有更高性能的组件，目的是为了替代log4j。

## commons-compress
https://commons.apache.org/proper/commons-compress/examples.html