package effective_java.item_3;

import java.io.Serializable;

public class ElvisTwo implements Serializable {
    private static final ElvisTwo INSTANCE = new ElvisTwo();

    private ElvisTwo() {}

    public static ElvisTwo getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        //Something..
    }

    private Object readResolve() {
        // 원래의 ElvisTwo를 반환하고, 가짜 ElvisTwo는 GC에 의해 반환
        return INSTANCE;
    }
}
