# Start with a base image containing Java runtime
FROM adoptopenjdk:11-jdk-hotspot

# Add Maintainer Info
LABEL maintainer="pedrohosantana@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8084 available to the world outside this container
EXPOSE 8084

# The application's jar file
ARG JAR_FILE=/build/libs/compra-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} compra.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/compra.jar"]
