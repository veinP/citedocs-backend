package citedocs.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import citedocs.Entity.UserEntity;
import citedocs.Exception.ResourceNotFoundException;
import citedocs.Repository.UserRepository;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public UserEntity findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public UserEntity update(int id, UserEntity payload) {
        UserEntity existing = findById(id);
        existing.setName(payload.getName());
        existing.setEmail(payload.getEmail());
        existing.setPassword(payload.getPassword());
        existing.setRole(payload.getRole());
        existing.setSid(payload.getSid());
        existing.setAid(payload.getAid());
        return userRepository.save(existing);
    }

    public void delete(int id) {
        UserEntity existing = findById(id);
        userRepository.delete(existing);
    }
}
