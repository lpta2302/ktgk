package bit.ueh.user_service.DTO;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String cccdNumber;
    private String phoneNumber;
    private String fullName;
    private LocalDateTime dateOfBirth;
    private String address;
}