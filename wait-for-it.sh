#!/bin/sh

# Wait for the db
echo "Waiting for the database to be ready..."
while ! nc -z db 3309; do
  sleep 1
done

# Execute the app
java -jar calculator-backend.jar