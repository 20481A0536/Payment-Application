package com.example.Project1.Service;

// import com.example.Project1.Model.Users;
// import com.example.Project1.Repository.Usersrepo;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {
//     final Usersrepo usersRepo;
//     private final PasswordEncoder passwordEncoder;

//     // Inject PasswordEncoder in the constructor
//     @Autowired
//     public CustomUserDetailsService(Usersrepo usersRepo, PasswordEncoder passwordEncoder) {
//         this.usersRepo = usersRepo;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         // Attempt to find user by email
//         Users user = usersRepo.findByEmailId(username);
        
//         // If not found by email, try finding by phone number
//         if (user == null) {
//             user = usersRepo.findByPhonenumber(Long.parseLong(username));
//         }

//         if (user == null) {
//             throw new UsernameNotFoundException("User not found with email or phone number: " + username);
//         }

//         return User.withUsername(username)
//                 .password(passwordEncoder.encode(user.getPassword()))  // Use the injected passwordEncoder
//                 .roles("USER")
//                 .build();
//     }
// }
// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final Usersrepo usersRepo;
//     private final PasswordEncoder passwordEncoder;  // No circular dependency here

//     @Autowired
//     public CustomUserDetailsService(Usersrepo usersRepo, PasswordEncoder passwordEncoder) {
//         this.usersRepo = usersRepo;
//         this.passwordEncoder = passwordEncoder;  // Injecting PasswordEncoder directly
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Users user = usersRepo.findByEmailId(username);
        
//         if (user == null) {
//             user = usersRepo.findByPhonenumber(Long.parseLong(username));
//         }

//         if (user == null) {
//             throw new UsernameNotFoundException("User not found");
//         }

//         return User.withUsername(username)
//                 .password(passwordEncoder.encode(user.getPassword()))  // Use injected passwordEncoder
//                 .roles("USER")
//                 .build();
//     }
// }




