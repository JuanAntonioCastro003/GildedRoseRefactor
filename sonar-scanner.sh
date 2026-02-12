#!/usr/bin/env bash

set -e

# Cargar variables desde .env
if [ -f .env ]; then
  export $(grep -v '^#' .env | xargs)
else
  echo "No se encontró el archivo .env"
  exit 1
fi

# Validaciones mínimas
if [ -z "$SONAR_PROJECT_KEY" ] || [ -z "$SONAR_TOKEN" ]; then
  echo "Faltan variables obligatorias en .env"
  exit 1
fi


docker run --rm \
  --network "sonarqube-net" \
  -e SONAR_HOST_URL="http://sonarqube:9000" \
  -e SONAR_TOKEN="${SONAR_TOKEN}" \
  -v "$(pwd):/usr/src" \
  sonarsource/sonar-scanner-cli \
  sonar-scanner \
  -Dsonar.projectKey="${SONAR_PROJECT_KEY}" \
  -Dproject.settings=/usr/src/sonar-scanner.properties
