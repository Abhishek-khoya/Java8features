import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Project {
    private String projectCode;
    private String name;
    private String client;
    private String buLeadName;
}
