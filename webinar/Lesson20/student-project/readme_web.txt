1. Устанвить TCP/IP соединение
2. Посылать HTTP-запросы
- GET
- POST
- PUT
- DELETE
- HEAD
- TRACE
- OPTIONS
- CONNECT


GET /start?page=18&size=50&locale=ru HTTP/1.1
User-Agent: Mozilla
Accept:xml



POST /start HTTP/1.1
User-Agent: Mozilla
Content-length:25
Accept:xml

page=18&size=50&locale=ru


1. Команда
2. Имя ресурса
3. Версия протокола
4. Headers
5. Параметры
- В командной строке - GET
- В теле запроса - POST, PUT


URI = URL + URN

URI - Uniform resource id - http://host:port/start
URL - Uniform resource locator - http://host:port
URN - Uniform resource name - /start


1. Tomcat - Web Server - Servlet + JSP
2. WildFly - Application Server - Java EE
3. IBM WebSphere - Application Server - Java EE
4. Oracle WebLogic - Application Server - Java EE
5, Jetty

Установить Tomcat
1. Скачать ZIP-файл
2. Установить (проверить наличие) переменной среды JAVA_HOME