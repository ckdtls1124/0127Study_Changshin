package org.spring.security01;

import org.junit.jupiter.api.Test;
import org.spring.security01.constant.Role;
import org.spring.security01.entity.MemberEnt;
import org.spring.security01.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest

public class SecurityTest {

//    @Autowired
//    private MemberRepo memberRepo;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Test
//    public void userInsert(){
//
//        memberRepo.save(MemberEnt.builder()
//                .email("admin@email.com")
//                .password(passwordEncoder.encode("1111"))
//                .role(Role.ADMIN)
//                .build());
//
//        memberRepo.save(MemberEnt.builder()
//                .email("member@email.com")
//                .password(passwordEncoder.encode("1111"))
//                .role(Role.MEMBER)
//                .build());
//
//        memberRepo.save(MemberEnt.builder()
//                .email("manager@email.com")
//                .password(passwordEncoder.encode("1111"))
//                .role(Role.MANAGER)
//                .build());
//
//
//    }
}
