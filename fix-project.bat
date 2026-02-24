@echo off
echo ================================================
echo    LIMPEZA E CONFIGURACAO DO PROJETO
echo ================================================
echo.

echo [1/5] Removendo arquivos de configuracao antigos...
if exist ".idea" rmdir /s /q ".idea"
if exist "*.iml" del /q "*.iml"
if exist "out" rmdir /s /q "out"
if exist "build" rmdir /s /q "build"
if exist ".gradle" rmdir /s /q ".gradle"
echo OK

echo.
echo [2/5] Removendo .git incorreto dentro de src...
if exist "src\.git" rmdir /s /q "src\.git"
echo OK

echo.
echo [3/5] Aguarde... O IntelliJ IDEA vai reabrir o projeto.
echo IMPORTANTE: Quando o IntelliJ abrir:
echo   - Ele vai detectar o projeto Gradle automaticamente
echo   - Clique em "Load Gradle Project" ou "Import Gradle Project"
echo   - Aguarde a indexacao completa
echo.
pause

echo.
echo [4/5] Abrindo IntelliJ IDEA...
start "" idea64.exe "%cd%"

echo.
echo [5/5] Concluido!
echo.
echo ================================================
echo PROXIMOS PASSOS NO INTELLIJ:
echo ================================================
echo 1. Aguarde a importacao do Gradle terminar
echo 2. File ^> Invalidate Caches ^> Invalidate and Restart
echo 3. O projeto deve funcionar normalmente!
echo ================================================
pause
