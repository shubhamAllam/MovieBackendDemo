FROM openjdk
WORKDIR usr/lib
ENV MYSQL_DATABASE=User_Db_V3
ENV MYSQL_URL=jdbc:mysql://localhost:3306/User_Db_V3?createDatabaseIfNotExist=true
ADD ./target/UserAuthentication-0.0.1-SNAPSHOT.jar /usr/lib/UserAuthentication-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","UserAuthentication-0.0.1-SNAPSHOT.jar"]