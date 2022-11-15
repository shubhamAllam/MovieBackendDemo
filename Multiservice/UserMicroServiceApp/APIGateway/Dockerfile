FROM openjdk
WORKDIR usr/lib
ADD ./target/APIGateway-0.0.1.jar /usr/lib/APIGateway-0.0.1.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","APIGateway-0.0.1.jar"]