package bit.ueh.user_service.service;

import bit.ueh.user_service.DTO.UserRequestDTO;
import bit.ueh.user_service.entity.CCCD;
import bit.ueh.user_service.entity.User;
import bit.ueh.user_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(UserRequestDTO userRequest) {
        // Kiểm tra nếu số điện thoại đã tồn tại
        if (userRepository.findByPhoneNumber(userRequest.getPhoneNumber()).isPresent()) {
            throw new RuntimeException("Số điện thoại đã được đăng ký!");
        }

        // Tạo CCCD mới
        CCCD cccd = new CCCD();
        cccd.setCccdNumber(userRequest.getCccdNumber());
        cccd.setFullName(userRequest.getFullName());
        cccd.setDateOfBirth(userRequest.getDateOfBirth());
        cccd.setAddress(userRequest.getAddress());

        // Tạo User mới
        User user = new User();
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setCccd(cccd);
        user.setCard(null); // Ban đầu không có Card

        return userRepository.save(user);
    }
}