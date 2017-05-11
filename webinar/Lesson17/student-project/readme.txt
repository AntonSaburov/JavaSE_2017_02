JDBC - Java Database Connectivity

JDBC Driver
1. JDBC - ODBC
2. Native JDBC - Java, JNI (C, Asm)
3. JDBC Server
4. JDBC - Pure Java



1. Загрузить JDBC Driver - реализация java.sql.Driver для определенного типа базы данных
2. Получить соединение - реализация java.sql.Connection
3. Создать запрос - Statement, PreparedStatement, CallableStatement
4. Исполнить запрос - ResultSet
5. Выбрать данные из ResultSet
6. Освободить ресурсы - close


String name, curator, spec;

Srting sql = "INSERT INTO st_group (groupName, curator, speciality) VALUES ('"
 + name + "','" + curator + "','" + spec +"')";

String id = "15";

String id = "15; DELETE FROM st_group";
"SELECT * FROM st_group where group_id=" + id;
