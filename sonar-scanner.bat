@echo off
setlocal enabledelayedexpansion

:: 1. Cargar variables desde .env
if exist .env (
    for /f "tokens=*" %%i in ('type .env ^| findstr /v "^#"') do (
        set "%%i"
    )
) else (
    echo [ERROR] No se encontro el archivo .env
    exit /b 1
)

:: 2. Validaciones minimas
if "%SONAR_PROJECT_KEY%"=="" (
    echo [ERROR] Falta SONAR_PROJECT_KEY en .env
    exit /b 1
)
if "%SONAR_TOKEN%"=="" (
    echo [ERROR] Falta SONAR_TOKEN en .env
    exit /b 1
)

if "%SONAR_SERVER%"=="" (
    echo [ERROR] Falta SONAR_SERVER en .env
    exit /b 1
)

:: 3. Ejecucion de Docker
:: Usamos %cd% para el directorio actual
echo %SONAR_SERVER%
echo %SONAR_PROJECT_KEY%
echo %SONAR_TOKEN%
echo "Lanzando docker"
docker run --rm ^
  --network "sonarqube-net" ^
  -e SONAR_HOST_URL="http://%SONAR_SERVER%" ^
  -e SONAR_TOKEN="%SONAR_TOKEN%" ^
  -v "%cd%:/usr/src" ^
  sonarsource/sonar-scanner-cli ^
  sonar-scanner ^
  -Dsonar.projectKey="%SONAR_PROJECT_KEY%" ^
  -Dproject.settings=/usr/src/sonar-scanner.properties

endlocal