package com.simcontrol.k.sco;

/**
 * Created by Administrator on 10/2/2017.
 */

public class Alarm {
    private String Time;
    private String Status;

    public Alarm(String time, String status) {
        Time = time;
        Status = status;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
