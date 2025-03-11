package bit.ueh.user_service.service;

import bit.ueh.user_service.DTO.UserRequestDTO;
import bit.ueh.user_service.entity.CCCD;
import bit.ueh.user_service.entity.User;
import bit.ueh.user_service.repository.CCCDRepository;
import bit.ueh.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CCCDRepository cccdRepository;
    @Transactional
    public User createUser(UserRequestDTO userRequest) {
        // Kiểm tra nếu số điện thoại đã tồn tại
        if (userRepository.findByPhoneNumber(userRequest.getPhoneNumber()).isPresent()) {
            throw new RuntimeException("Số điện thoại đã được đăng ký!");
        }

        // Tạo CCCD mới
        CCCD cccd = cccdRepository.findByCccdNumber(userRequest.getCccdNumber())
            .orElseThrow(()-> new EntityNotFoundException("not found CCCD"));

        // Tạo User mới
        User user = new User();
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setCccd(cccd);
        user.setCard(null); // Ban đầu không có Card

        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(long userId) {
        return userRepository.findById(userId)
            .orElseThrow(()-> new EntityNotFoundException("not found user"));
    }
}