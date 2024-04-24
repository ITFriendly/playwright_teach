Running Codegen 
для запуска генератора :

mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"

Maven положил в папку .\src\resources\maven\bin\mvn проекта.
Строка вызова из корня проекта выглядит так:
.\src\resources\maven\bin\mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"

Добавил логирование slf4j и lombok. Приверы в классе [LoggerMeeting.java].
Детальнее посмотреть про Simple Loggin Facade for Java -> https://www.youtube.com/watch?v=yTokW18ujZI 
Примеры и почитать -> https://sematext.com/blog/slf4j-tutorial/
Уровни логирования:
ALL - The ALL has the lowest possible rank and is intended to turn on all logging.
DEBUG - The DEBUG Level designates fine-grained informational events that are most useful to static final Level
ERROR - The ERROR level designates error events that might still allow the application to continue running.
FATAL - The FATAL level designates very severe error events that will presumably lead the application to abort.
INFO - The INFO level designates informational messages that highlight the progress of the application at coarse-grained level.
OFF - The OFF has the highest possible rank and is intended to turn off logging.
TRACE - The TRACE Level designates finer-grained informational events than the DEBUG level.
WARN - The WARN level designates potentially harmful situations.


UPD - Тесты разбил по сьютам. Сейчас 3и сьюта - ITfriendly, Example (примеры) и раздел AlertsFramesWindows.
для отдельного запуска в папке проекта запускаем "mvn test -P{название сьюта" 
например "mvn test -PItfriendly" или "mvn test -PExample"
Сьюты пока лежат в корне, подробнее в pom.xml

