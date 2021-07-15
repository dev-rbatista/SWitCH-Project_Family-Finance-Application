# README #

This is the repository used for the SWitCH 2020/2021 **(Postgraduate in Software Development course @ Instituto Superior de Engenharia do Porto) project - Family Finance Management Application.**

This is an Application using **DDD, Onion Architecture, Java, Javascript, HTML5, CSS, SpringBoot, React and H2 (Also PostgreSQL).**

This started as a simple application (Back-End only) with a layered architecture and during the second semester we performed a major Refactor, having DDD and Onion Architecture as reference.

Then, the SpringBoot Framework was introduced and later on React, in order to make it to a Single Page Application.

More information can be found in the Wiki section of this Repository (Documentation is currently in Portuguese)


## What is this repository for? ##

It contains the project developed by the group 3 in the context of the course (Postgraduate in Software Development course @ Instituto Superior de Engenharia do Porto).


## Who do I talk to? ##
Group 3 Members:

- Bruno Tamames
- Diogo Ribeiro
- João Pinto
- Manuel Almeida
- Miguel Loureiro
- Ricardo Batista
- Ricardo Nogueira
- Tomás Osswald


## How was the .gitignore file generated? ##
.gitignore file was generated based on https://www.gitignore.io/ with the following keywords:
  - Java
  - Maven
  - Eclipse
  - NetBeans
  - Intellij

## How do I use Maven? ##

### How to run unit tests? ###
Execute the "test" goals.
`$ mvn test`

### How to generate the javadoc for source code? ###
Execute the "javadoc:javadoc" goal.

`$ mvn javadoc:javadoc`

This generates the source code javadoc in folder "target/site/apidocs/index.html".

### How to generate the javadoc for test cases code? ###
Execute the "javadoc:test-javadoc" goal.

`$ mvn javadoc:test-javadoc`

This generates the test cases javadoc in folder "target/site/testapidocs/index.html".

### How to generate Jacoco's Code Coverage Report? ###
Execute the "jacoco:report" goal.

`$ mvn test jacoco:report`

This generates a jacoco code coverage report in folder "target/site/jacoco/index.html".

### How to generate PIT Mutation Code Coverage? ###
Execute the "org.pitest:pitest-maven:mutationCoverage" goal.

`$ mvn test org.pitest:pitest-maven:mutationCoverage`

This generates a PIT Mutation coverage report in folder "target/pit-reports/YYYYMMDDHHMI".

### How to combine different maven goals in one step? ###
You can combine different maven goals in the same command. For example, to locally run your project just like on jenkins, use:

`$ mvn clean test jacoco:report org.pitest:pitest-maven:mutationCoverage`

### How to perform a faster analysis ###
Do not clean build => remove "clean"

Set a specific file for the reports => add "-DhistoryInputFile=target/fasterPitMutationTesting-history.txt -DhistoryOutputFile=target/fasterPitMutationTesting-history.txt"

Reuse the previous report => add "-Dsonar.pitest.mode=reuseReport"

Use more threads to perform the analysis. The number is dependent on each computer CPU => add "-Dthreads=4"

Example:

`mvn test jacoco:report org.pitest:pitest-maven:mutationCoverage -DhistoryInputFile=target/fasterPitMutationTesting-history.txt -DhistoryOutputFile=target/fasterPitMutationTesting-history.txt -Dsonar.pitest.mode=reuseReport -Dthreads=4`

### How to perform faster refactoring based on mutation coverage ###

Temporarily remove timestamps from reports.

Example:

`mvn test jacoco:report org.pitest:pitest-maven:mutationCoverage -DhistoryInputFile=target/fasterPitMutationTesting-history.txt -DhistoryOutputFile=target/fasterPitMutationTesting-history.txt -Dsonar.pitest.mode=reuseReport -Dthreads=4 -DtimestampedReports=false`
