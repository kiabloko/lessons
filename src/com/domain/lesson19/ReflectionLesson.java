package com.domain.lesson19;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.Text;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
//    static {
//        if (System.getSecurityManager() == null){   //не дает вызывать setAccessible
//            System.setSecurityManager(new SecurityManager());
//        }
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        //Reflection API класс Class
        System.out.println(String.class);
        System.out.println(int.class);
        System.out.println(TextMessage.class);

        //класс также можно получить через объект

        TextMessage textMessage = new TextMessage("Срочно", "Провести совещание");
        System.out.println(textMessage.getClass());

        Class cls = textMessage.getClass(); //ссылка на класс текстмесседж
        System.out.println(cls.getName()); //возвращает имя класса
        System.out.println(Arrays.toString(cls.getInterfaces())); //вернет все интерфейсы класса( в данном случае сериалайзбл)
        System.out.println(cls.getSuperclass()); //возвращает родительский класс,если он есть
        System.out.println(cls.getSuperclass().getSuperclass());  //возвращает Object
        System.out.println(cls.getSuperclass().getSuperclass().getSuperclass()); //возвращает null

        //доступ к компонентам класса
        Class<TextMessage> textMessageClass = TextMessage.class;

        //доступ к полям класса/У всех полей тип данных Field
        Field[] fields = textMessageClass.getFields(); //возвращает массив всех публичных полей,включая поля родителя
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = textMessageClass.getDeclaredFields(); //возвращает все поля класса,даже приват
        System.out.println(Arrays.toString(declaredFields));

        //доступ к методам
        Method[] methods = textMessageClass.getMethods(); //все публичные и родительские методы, вплоть до Object
        System.out.println(Arrays.toString(methods));
        Method[] declaredMethods = textMessageClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));


        //доступ к конструторам
        Constructor[] declaredConstructors = textMessageClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        //доступ к конкретному полю/методу

        Field field = textMessageClass.getDeclaredField("text");//передаем конкретное поле. если нет такого поля - иксепшн
        System.out.println(field.getType()); //вернет тип данных, в данном случае стринг
        field.setAccessible(true);
        System.out.println(field.get(textMessage)); //если доступ позволяет,то гет вернет значение поля для конкретного объекта. если не позволяет,то иксепшн
        field.set(textMessage, "Новое сообщение"); //устанавливает значение поля для конкретного объекта, если есть доступ

        Method method = textMessageClass.getDeclaredMethod("getMessageInfo"); //если нет такого, то иксепшн
        //если метод принимает аргументы, то далее в скобках типы данных,которые он принимает
        method.setAccessible(true);
        String messageResult = (String) method.invoke(textMessage);
        System.out.println("getMessageInfo " + messageResult);

        Method method1 = textMessageClass.getDeclaredMethod("printTitle", String.class);
        printTitleMethod.invoke(textMessage(textMessage, "printTitle method" ));
        System.out.println("printTitle");

        Constructor<TextMessage> tmConstructor = textMessageClass.getDeclaredConstructor(String.class, String.class);
        TextMessage message = tmConstructor.newInstance("Reflect Message", "Obj created");  //возвращает объект с такой сигнатурой
        message.printTitle();

        boolean isPrivate = Modifier.isPrivate(field.getModifiers()); //возвращает все модификаторы
        System.out.println("is 'text' private " + isPrivate);
    }
}
