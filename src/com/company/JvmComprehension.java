package com.company;

public class JvmComprehension {
//    JVM загружает пул констант, который содержит в себе все данные о классе. Пул констант это массив, в котором каждая константа занимает один элемент массива.
//    JVM загружает нужный класс через Classloaders, сначала Bootstrap, прародитель всех классов, он загружает платформенные классы.
//    Extension Classloader загружает классы расшерений. Application Classloader потомок Extension Classloader, загружает классы из ClassPath, из катологов или jar- файлов.
//    Если JVM не удается загрузить файл с помощью этих Classloader - ов и не прописан собственный загрузчик классов, будет выброс исключения "classNotFoundException".
//    Далее запускается процесс Связывания (Linking), подготовка классов к выполнению. Данный процесс делится на части:
//    1) Проверка байт - кода (нет ли ошибок в байт - коде).
//    2) Инициализация статических полей и выделения памяти под них.
//    3) Разрешение символьных ссылок.
//

    public static void main(String[] args) {
//  JVM получает поток байтовых для каждого метода из класса. Байт - код выполняется "лениво", только при вызове метода. Поток байт - кода метода - это инструкции для JVM.
//  Инструкция состоит из кода операции и операндов. По коду операции JVM понимает, что именно необходимо сделать.
//
        int i = 1;                      // 1
//  код операции iconst_1 указывает JVM, что это целочисленное значение, которое ровно 1.
//  JVM сохраняет это значение в стеке.

        Object o = new Object();        // 2
//  JVM загружает класс с помощью загрузчика и сохраняет в стеке ссылку на объект, а свойства и данные об объекте и сам экзимпляр объекта сохраняет в хипе.
        Integer ii = 2;                 // 3
//  JVM загружает класс с помощью загрузчика и сохраняет в стеке ссылку на объект, а свойства и данные об объекте и сам экзимпляр объекта сохраняет в хипе.
        printAll(o, i, ii);             // 4
//  При вызове метода "printAll" в стеке создается фрейм со ссылкой на объекты "о" и "ii", данные которого хранятся в хипе.
//  Также передается примитив "i", данные, которого хранятся напрямую в стеке.
        System.out.println("finished"); // 7
//  Создается новый фрейм в стеке.
//  JVM с помощью платформенных классов (System -> Output -> PrintStream), потоково выводит строку "finished"
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5
//  JVM загружает класс с помощью загрузчика и сохраняет в стеке ссылку на объект, а свойства и данные об объекте и сам экзимпляр объекта сохраняет в хипе.
        System.out.println(o.toString() + i + ii);  // 6
//  В стеке создается новый фрейм, в который передаются полученные ссылки и примитивные данные (28 и 29 строки).
//  После чего JVM выполняет операцию и выводит в консоль только ссылку на объект в виде текста.


//        Окончательный вывод в консоль : текстовая ссылка на объект и строка "finished"
//        Паралельно в процессе работы программы, функционирует сборщик муссора, который останавливает работу программы,
//        анализирует данные при помощи разных методов, в зависимости от сборщика, и чистит память (хип).
    }
}
