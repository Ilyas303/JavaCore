#!/bin/sh
echo "Waiting for database to start..."
until nc -z postgres_db 5432; do
  sleep 1
done

echo "Starting application..."
exec java -jar app.jar