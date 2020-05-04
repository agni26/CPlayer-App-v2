#user DockerFile

FROM java:8-jre
COPY ./target/user-0.0.1-SNAPSHOT.jar /usr/src/user-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src
CMD ["java","-jar","user-0.0.1-SNAPSHOT.jar"]
