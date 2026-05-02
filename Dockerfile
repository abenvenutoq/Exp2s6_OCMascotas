FROM eclipse-temurin:22-jdk AS buildstage 

RUN apt-get update && apt-get install -y maven

WORKDIR /ocmascotas

COPY pom.xml .

COPY src /ocmascotas/src

COPY Wallet_BDExp1S1 /ocmascotas/wallet

ENV TNS_ADMIN=/ocmascotas/wallet

RUN mvn clean package

FROM eclipse-temurin:22-jdk 

COPY --from=buildstage /ocmascotas/target/ocmascotas-0.0.1-SNAPSHOT.jar /ocmascotas/ocmascotas.jar

COPY Wallet_BDExp1S1 /ocmascotas/wallet

ENV TNS_ADMIN=/ocmascotas/wallet

EXPOSE 8080

ENTRYPOINT [ "java", "-jar","/ocmascotas/ocmascotas.jar" ]