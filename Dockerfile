FROM gcr.io/distroless/java21-debian12

WORKDIR /app
COPY build/libs/*.jar app.jar
ENV TZ="Europe/Oslo"
EXPOSE 8080
USER nonroot
CMD [ "app.jar" ]