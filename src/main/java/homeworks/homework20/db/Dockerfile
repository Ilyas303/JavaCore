FROM postgres:15

COPY init.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_DB=javacore
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=12345

EXPOSE 5432