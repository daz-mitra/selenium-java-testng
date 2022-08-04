package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStamp {
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    public String getTimestamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return sdf1.format(timestamp);
    }

}
