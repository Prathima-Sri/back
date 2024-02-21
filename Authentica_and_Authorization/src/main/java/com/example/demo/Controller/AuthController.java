package com.example.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/signup")
    
    public String showSignupForm(Model model) { 
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/login";

    }

    
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userRepository.findByEmail(email);
//        System.out.println(user);
        if (user != null && user.getPassword().equals(password)) {
            // TODO: Implement successful login logic
            // For simplicity, redirect to a welcome page.
//            System.out.println("inside if "+user);

//            return "redirect:/welcome";
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
    
    
    
//    @RequestMapping(value = "/getme", method = RequestMethod.GET)
//    public String getme() {
//    	return "login";
//    }
    @GetMapping("/getme")
    public String getme() {
    	return "login";
    }
    
    
    @GetMapping("/getmee")
    public String getmee() {
        return "redirect:/home";
    }
    
    @GetMapping("/categories")
    public String categories() {
        return "categories";
    }
    @GetMapping("/start")
    public String start() {
        return "start";
    }
    
    

//        @Autowired
//        private UserRepository userRepository1;
//
//        @PostMapping("/signup")
//        public ResponseEntity<String> signup11(@RequestBody User user) {
//            try {
//                userRepository.save(user);
//                return ResponseEntity.ok("User registered successfully!");
//            } catch (DataIntegrityViolationException e) {
//                // Handle constraint violation (duplicate entry)
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                        .body("Email address is already in use. Please use another email address.");
//            }
//        }
//
//        // Other methods...
//   
    }


