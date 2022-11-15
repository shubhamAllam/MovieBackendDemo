FROM openjdk
WORKDIR usr/lib
ADD ./target/EurekaServer-0.0.1.jar /usr/lib/EurekaServer-0.0.1.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "EurekaServer-0.0.1.jar"]