package org.spring.security01.service;

import lombok.RequiredArgsConstructor;
import org.spring.security01.constant.Role;
import org.spring.security01.dto.MemberDto;
import org.spring.security01.entity.MemberEnt;
import org.spring.security01.repository.MemberRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServ {


    private final MemberRepo memberRepo;
    private final PasswordEncoder passwordEncoder; // in registration, PasswordEncoder Bean cannot be used


    public void insertNew(MemberDto memberDto) {
        if(memberDto.getEmail().equals("admin")){
            memberRepo.save(MemberEnt.builder()
                    .email(memberDto.getEmail())
                    .password(passwordEncoder.encode(memberDto.getPassword()))
                    .role(Role.ADMIN)
                    .build());
        } else if(memberDto.getEmail().equals("manager")){
            memberRepo.save(MemberEnt.builder()
                    .email(memberDto.getEmail())
                    .password(passwordEncoder.encode(memberDto.getPassword()))
                    .role(Role.MANAGER)
                    .build());
        } else {
            memberRepo.save(MemberEnt.builder()
                    .email(memberDto.getEmail())
                    .password(passwordEncoder.encode(memberDto.getPassword()))
                    .role(Role.MEMBER)
                    .build());
        }

    }
}
