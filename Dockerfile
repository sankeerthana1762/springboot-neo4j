FROM openjdk:11
ADD /target/neo4j-0.0.1-SNAPSHOT.jar neo4j-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","neo4j-0.0.1-SNAPSHOT.jar"]

