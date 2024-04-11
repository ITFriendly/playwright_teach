Running Codegen 
для запуска генератора :

mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"

Maven положил в папку .\src\resources\maven\bin\mvn проекта.
Строка вызова из корня проекта выглядит так:
.\src\resources\maven\bin\mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"
