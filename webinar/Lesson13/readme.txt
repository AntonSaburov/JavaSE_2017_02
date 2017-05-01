1. Старт тредов
- Thread
- Runnable

Thread.start();


2. ExecutorService
- Runnable
- Callable


3. Exception

public void run() {
  try {
  } catch(IOException e) {
  }
}


4. Синхронизация
- Использовать локальные объекты
- Неизменяемые объекты

thread-safe

- Java Memory Model
  - Happens before - https://habrahabr.ru/post/133981/

  - Creation
ComplexClass s1;
Thread 1
s1 = new ComplexClass();
Thread 2
s1 == null

  - Order
class Simple 
{
   private Long b1 = null;
   private Long b2 = null;

   void test() {
     b1 = new Long(10);
     if(b1 != null && b2 == null) {
       b2 = new Long(30);
     }
   }

   void test2() {
     b1 = new Long(10);
     test();
     b2 = new Long(70);
   }
}


- Atomic operation
  - long, double > <current> - atomic
  - volatile - atomic
