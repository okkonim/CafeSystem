package cafeSystem.restImpl;

import cafeSystem.constents.CafeConstants;
import cafeSystem.dao.UserDao;
import cafeSystem.jwt.JwtUtil;
import cafeSystem.pojo.User;
import cafeSystem.rest.UserRest;
import cafeSystem.service.UserService;
import cafeSystem.wrapper.UserWrapper;
import cafeSystem.wrapper.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserRestImpl implements UserRest {
    private final UserService userService;

    @Override
    public ResponseEntity<String> signUp(UserDTO userDTO) {
        try{
            Map<String, String> requestMap = new HashMap<>();
            requestMap.put("name", userDTO.getName());
            requestMap.put("contactNumber", userDTO.getContactNumber());
            requestMap.put("email", userDTO.getEmail());
            requestMap.put("password", userDTO.getPassword());
            return userService.signup(requestMap);
        } catch (Exception exception){
            log.error("Error in signUp", exception);
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        try{
            return userService.login(requestMap);
        } catch (Exception exception){
            log.error("Error in login", exception);
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<UserWrapper>> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (Exception exception){
            log.error("Error in getAllUsers", exception);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            return userService.update(requestMap);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> checkToken() {
        try {
            return userService.checkToken();
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
        try{
            return userService.changePassword(requestMap);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> forgotPassword(Map<String, String> requestMap) {
        try {
            return userService.forgotPassword(requestMap);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<UserWrapper> getCurrent() {
        try {
            UserWrapper currentUser = userService.getCurrent();
            if (currentUser != null) {
                return new ResponseEntity<>(currentUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            log.error("Error in getCurrent", exception);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
