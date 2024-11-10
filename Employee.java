import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Employee {
    private int id;
    private String name;
    private String dept;
    private List<Project> projects;
    private double salary;
    private String gender;
}
