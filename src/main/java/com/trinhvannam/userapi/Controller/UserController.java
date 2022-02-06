package com.trinhvannam.userapi.Controller;

import com.trinhvannam.userapi.Exception.ResourceNotFoundException;
import com.trinhvannam.userapi.Model.User;
import com.trinhvannam.userapi.Repository.UserRepository;
import com.trinhvannam.userapi.Service.DTO.request.UserRequestDTO;
import com.trinhvannam.userapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("/findUserByName")
    public ResponseEntity<List<User>> findUserByName(@RequestParam String name) {
        return ResponseEntity.ok().body(userService.findUserByName(name));
    }

    @GetMapping("/findUserByEmail")
    public ResponseEntity<List<User>> findUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(userService.findUserByEmail(email));
    }

    // thêm user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok().body(userService.createNewUser(userRequestDTO));
    }

    // lấy user theo id
    @GetMapping("{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable  long id){
        User user  = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(user);
    }

    // update user
    @PutMapping("{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable long id,@RequestBody User userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        updateUser.setUserName(userDetails.getUserName());
        updateUser.setUserPhone(userDetails.getUserPhone());
        updateUser.setUserEmail(userDetails.getUserEmail());
        updateUser.setUserAddress(userDetails.getUserAddress());
        updateUser.setUserPass(userDetails.getUserPass());
        updateUser.setAdmin(userDetails.isAdmin());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    //delete User
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
