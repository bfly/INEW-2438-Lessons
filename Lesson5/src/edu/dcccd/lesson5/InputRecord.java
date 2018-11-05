package edu.dcccd.lesson5;

import lombok.Data;

@Data
public class InputRecord {
    private String source;
    private String target;
    private int cost;
    private int time;

    InputRecord(String[] data) {
        this.source = data[0];
        this.target = data[1];
        this.cost = Integer.parseInt(data[2]);
        this.time = Integer.parseInt(data[3]);
    }
}
