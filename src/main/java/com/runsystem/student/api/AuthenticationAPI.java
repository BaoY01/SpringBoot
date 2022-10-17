package com.runsystem.student.api;

import com.runsystem.student.api.input.UserInput;
import com.runsystem.student.api.input.UserRegisterInput;
import com.runsystem.student.api.output.DataResponse;
import com.runsystem.student.constant.ConstantSystem;
import com.runsystem.student.dto.UserDTO;
import org.springframework.security.core.Authentication;
import com.runsystem.student.security.JwtTokenProvider;
import com.runsystem.student.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

/**
 * Controller for authentication API.
 */
@RestController
@RequestMapping("api")
public class AuthenticationAPI {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    ConstantSystem constantSystem;

    @PostMapping("/loginJwt")
    public ResponseEntity<?> loginJwt(@RequestBody UserInput userInput) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userInput.getUserName(),
                            userInput.getPassWord()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = tokenProvider.generateToken(user.getUsername());
            UserDTO userInfo = userService.findByUserName(userInput.getUserName());

            return ResponseEntity.ok(new DataResponse<UserDTO>(token, userInfo, LocalDateTime.now().toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("registerJwt")
    public ResponseEntity<?> registerJwt(@RequestBody UserRegisterInput request) {
        // Kiem tra password confirm va password
        if (!request.getPassword().equals(request.getPassWordConfirm())) {
            return ResponseEntity.ok(new DataResponse<UserDTO>(constantSystem.PASSWORD_PASSWORKCONFIRM, null, LocalDateTime.now().toString()));
        }

        String result = "";
        UserDTO dto = null;
        try {
            request.setPassword(passwordEncoder.encode(request.getPassword()));
            dto = userService.registerUser(request);
            if (dto != null) {
                result = constantSystem.REGISTER_SUCCESS;
            } else {
                result = constantSystem.ACCOUNT_ALREADY;
            }
        } catch (Exception ex) {
            result = constantSystem.SERVER_ERROR;
        }
        return ResponseEntity.ok(new DataResponse<UserDTO>(result, dto, LocalDateTime.now().toString()));
    }
}
