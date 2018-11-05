package edu.dcccd;

import lombok.*;

@Data
@AllArgsConstructor
public class Enrollment {
    private long courseId;
    private long studentId;
}
