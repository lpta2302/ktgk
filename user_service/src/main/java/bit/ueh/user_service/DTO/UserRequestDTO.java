package bit.ueh.user_service.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String phoneNumber;
    private String cccdNumber;
    private String fullName;
    private String dateOfBirth;
    private String address;
}