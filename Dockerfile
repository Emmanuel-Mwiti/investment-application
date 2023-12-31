

#FROM jboss/wildfly:latest
#
#COPY target/investmentapp.war /opt/jboss/wildfly/standalone/deployments/


# Build Stage
FROM maven:3.6.3 AS build
WORKDIR /app
COPY . .
RUN mvn clean compile package

# Deployment Stage
FROM jboss/wildfly:latest AS deploy
COPY --from=build /app/target/investmentapp.war /opt/jboss/wildfly/standalone/deployments/
RUN rm /opt/jboss/wildfly/standalone/configuration/standalone.xml
COPY --from=build app/standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
COPY --from=build /app/mysql  /opt/jboss/wildfly/modules/system/layers/base/com


EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]

# Stage 1: Build the application with Maven
#FROM maven:3.9.5 as build
#
#WORKDIR /app
#
#COPY pom.xml .
#
#RUN mvn install
#
#COPY . .
#
#RUN mvn clean compile package
#
## Stage 2: Deploy the application to WildFly
#FROM jboss/wildfly:latest AS deploy
#
## Remove the default standalone.xml file from WildFly
#RUN rm /opt/jboss/wildfly/standalone/configuration/standalone.xml
#
#COPY --from=build /app/target/investmentapp.war /opt/jboss/wildfly/standalone/deployments/
#
#COPY --from=build /app/standalone.xml /opt/jboss/wildfly/standalone/configuration/
#
## Create the directory for the MySQL module
#RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
#COPY --from=build /app/mysql/main/module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main
#
## Download the MySQL Connector/J JAR file
#RUN curl -o /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/mysql-connector-java-8.0.17.jar \
#    https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.17/mysql-connector-java-8.0.17.jar
#
## Expose the default WildFly HTTP port
#EXPOSE 8080
#
## Start WildFly
#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]


# FROM maven:3.9.5 as build

# WORKDIR /app

# COPY pom.xml .

# RUN mvn install

# COPY . .

# RUN mvn clean compile package

# FROM jboss/wildfly:latest AS deploy

# RUN rm /opt/jboss/wildfly/standalone/configuration/standalone.xml

# COPY --from=build /app/target/Tours-system.war /opt/jboss/wildfly/standalone/deployments/

# COPY --from=build /app/standalone.xml /opt/jboss/wildfly/standalone/configuration/

# COPY --from=build /app/mysql /opt/jboss/wildfly/modules/system/layers/base/com/

# RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/ \
#     && curl -o /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/mysql-connector-java-8.0.17.jar \
#     https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.17/mysql-connector-java-8.0.17.ja



# EXPOSE 8080

# CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]



#
#FROM maven:3.9.5 as build
#
#WORKDIR /app
#
#COPY . .
#
#RUN mvn clean compile package
#
## Stage 2: Deploy the application to WildFly
#FROM jboss/wildfly:latest AS deploy
#
#COPY --from=build /app/target/investmentapp.war /opt/jboss/wildfly/standalone/deployments/
#
#EXPOSE 8080
#
#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]