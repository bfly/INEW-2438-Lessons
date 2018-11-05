package edu.dcccd.lesson5;

import lombok.Data;

@Data
class RequestedRecord {
    private String from;
    private String to;
    private char stipulation;

    RequestedRecord(String[] data) {
        this.from = data[0];
        this.to = data[1];
        this.stipulation = data[2].charAt(0);
    }
}