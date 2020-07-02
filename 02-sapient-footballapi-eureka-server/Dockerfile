FROM java:8-jre
ADD target/02-sapient-footballapi-eureka-server-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","/app.jar"]
HEALTHCHECK --interval=10s --timeout=5s CMD curl -f http://192.168.99.100:8761/health || exit 1
EXPOSE 8761