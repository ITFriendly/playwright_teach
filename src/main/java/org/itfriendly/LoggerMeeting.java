package org.itfriendly;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class LoggerMeeting {

    public static final String str = "hello log";

    public static void main(String[] args) {
        log.info("Just info message");
        log.error("Error + this is errroooooor");
        log.debug("Debug of  " + Main.class.getName().toLowerCase());
        log.trace("trace");
        log.info(getString(str));

        Lombokeeting show = new Lombokeeting();
        log.info(show.getStr());
        log.info("a is - " + show.getA());
    }


    private static String getString(String str) {
        return str + " hello java ) ";
    }
}
