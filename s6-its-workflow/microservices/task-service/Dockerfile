FROM adoptopenjdk:11.0.8_10-jre-hotspot as builder
WORKDIR extracted
ADD ./build/libs/task-service-0.1.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM adoptopenjdk:11.0.8_10-jre-hotspot
WORKDIR application
COPY --from=builder extracted/dependencies/ ./
COPY --from=builder extracted/spring-boot-loader/ ./
COPY --from=builder extracted/snapshot-dependencies/ ./
COPY --from=builder extracted/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
