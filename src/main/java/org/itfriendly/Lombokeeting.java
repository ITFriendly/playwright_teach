package org.itfriendly;

import lombok.Data;

@Data
public class Lombokeeting {

    private int a = 123;
    private String str  = Lombokeeting.class.getName();

    // пример аннотации @Data от lombok - getter for int a only, далее в LogMeeting
    public int getA() {
        return a;
    }
}
