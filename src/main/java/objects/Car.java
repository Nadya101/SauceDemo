package objects;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private String make;
    private String model;
    private int speed;
    private int doors;




}
