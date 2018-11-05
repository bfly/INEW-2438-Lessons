package edu.dcccd;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class EnrollmentCombo {
    private String courseId;
    private String courseName;
    private String instructor;
    private String term;
    private String classPeriod;
    private String name;
}
