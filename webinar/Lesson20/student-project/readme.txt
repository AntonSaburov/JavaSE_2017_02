1. Создать приложение web с определенной структурой каталогов и файлов
2. Собрать все в архив - .war (Web Archive)
3. Установить web-приложение на web-server


API - Application Programming Interface

GET /web-ui-1.0/simple?name1=value1&name1=value2 HTTP/1.1
Host: mail.ru
Content-Type:pdf


1. Web Server преобразует текст в набор объектов
2. Web Server должен найти Web-компонент
3. Web Server передает управление web-компоненту


Виды компонентов
1. Servlet - class HttpServlet
Life Cycle:
- init
- service
- destroy

Как найти компонент
1. ContextRoot (ContextPath) - строка, под которой регистрируется приложение
2. url-pattern

1. web.xml - класс <-> url-pattern
2. Аннотация


MVC - Model, View, Controller
MVC2 - Model, View, Controller