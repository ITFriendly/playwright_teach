package org.itfriendly;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

/** Чтоб такое не писать - используем аннотацию lombok @SLF4J -
 * см классы Lombokeeting и LoggerMeeting */
        Logger log = LoggerFactory.getLogger(Main.class);

        log.info("info");
        System.out.println("Hello world!");
        log.error("error");
        int x = 1;
        log.info("hi  {}", x);

    }
}