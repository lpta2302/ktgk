package bit.ueh.user_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CCCD {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String cccdNumber;

    private String fullName;
    private String dateOfBirth;
    private String address;
}