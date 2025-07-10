package cafeSystem.rest;

import cafeSystem.wrapper.UserWrapper;
import cafeSystem.wrapper.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
public interface UserRest {
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody UserDTO userDTO);
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> requestMap);
    @GetMapping("/get")
    public ResponseEntity<List<UserWrapper>> getAllUsers();
    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Map<String, String> requestMap);
    @GetMapping("/check-token")
    public ResponseEntity<String> checkToken();
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody Map<String, String> requestMap);
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> requestMap);

    @GetMapping("/getCurrentUser")
    public ResponseEntity<UserWrapper> getCurrent();



}
