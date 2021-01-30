#
# A simple makefile for compiling three java classes
#

# define a makefile variable for the java compiler
#
JCC = javac

JC = java

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g -cp src/

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: PlayBack.class Transound.class ReadAudio.class Execute.class 

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#


PlayBack.class: src/com/example/PlayBack.java
	$(JCC) $(JFLAGS) src/com/example/PlayBack.java

Execute.class: src/com/test/Execute.java
	$(JCC) $(JFLAGS) src/com/test/Execute.java

Transound.class: src/com/example/Transound.java
	$(JCC) $(JFLAGS) src/com/example/Transound.java

ReadAudio.class: src/com/example/ReadAudio.java
	$(JCC) $(JFLAGS) src/com/example/ReadAudio.java

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
	$(RM) *.class $(RM) src/com/example/*.class $(RM) src/com/test/*.class
