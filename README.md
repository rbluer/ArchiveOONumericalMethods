This archive contains the book of Didier Besset in its original form. 

The `OONumericalMethodsAsGiven` folder contains the original files.

The `NumericalMethods` folder contains a version fixed to rebuild the book using a modern LaTeX toolchain.

Based on it we prepared a new version without the Java code but it is hosted in another repository.


<hr />

The Java source has been cleaned up with the elimination of all compiler warnings and errors, and has been
place in the project's 'src' directory. The original LaTeX directories have not been touched.  The 
"other repository" is unknown at this time.

Setting java 17 as the primary version.

Using Gradle as the build tools.  Java 17 requires the use of Gradle v7.3.

[https://docs.gradle.org/current/userguide/compatibility.html](https://docs.gradle.org/current/userguide/compatibility.html)

The version of gradle can be changed by using the following command in the project's terminal.
Opening a terminal for the project (linux on Windows) is beyond the scope of this comment, but see
the Window's git tool SourceTree's "Terminal" button within the project, or use a terminal within
MS's Visual Studio Code as 2 examples on who to get a functional linux shell on windows.

To "set" the gradle version to use, use this command. It only sets the intended version, but does not
apply it (does not download and does not install it).  It will do so on the next gradle command that 
is issued:
`./gradlew wrapper --gradle-version 7.3`

The check the version to apply the gradle version change:
`./gradlew --version`

NOTE: in the example above, the unix version of "gradlew" was used on windows in a terminal.  If on windows, 
using the window's `cmd` shell, then you can also use `gradlew.bat` instead.

