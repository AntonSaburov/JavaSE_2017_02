package edu.javacourse.third.db;

import edu.javacourse.third.db.reflection.CallMe;
import edu.javacourse.third.domain.StudentOrder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by antonsaburov on 23.03.17.
 */
public class FactoryDataSource
{
    private static String className = "edu.javacourse.third.db.FakeDataSource";

    private static String cName = "edu.javacourse.third.db.reflection.FlexibleDataSource";
    private static String mName = "getAllOrders";

    public static StudentOrderDataSource getDataSource() {
        try {
            Class aClass = Class.forName(className);
            Object o = aClass.newInstance();
            StudentOrderDataSource ds = (StudentOrderDataSource)o;
            return ds;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new FakeDataSource();
    }

    public static List<StudentOrder> getOrderList() {
        try {
            Class aClass = Class.forName(cName);
            Object ds = aClass.newInstance();

            Method method = aClass.getMethod(mName);
            Object invoke = method.invoke(ds);
            return (List<StudentOrder>)invoke;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void fieldExample() {
        try {
            Class aClass = Class.forName(cName);
            Object ds = aClass.newInstance();

            Field field = aClass.getDeclaredField("name");
            field.setAccessible(true);
            field.set(ds, "12345");
            Object o = field.get(ds);
            System.out.println(o);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void constructorExample() {
        try {
            Class aClass = Class.forName(cName);
            Constructor con = aClass.getConstructor(String.class);
            Object ds = con.newInstance("Super Hero !!!");

            Field field = aClass.getDeclaredField("name");
            field.setAccessible(true);
            Object o = field.get(ds);
            System.out.println(o);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void annotationExample() {
        try {
            Class aClass = Class.forName(cName);
            Object ds = aClass.newInstance();

            Method[] ms = aClass.getDeclaredMethods();
            for(Method m : ms) {
                CallMe cm = m.getAnnotation(CallMe.class);
                if(cm != null) {
                    System.out.println(cm.comment());
                    m.invoke(ds);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
