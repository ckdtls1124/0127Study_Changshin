package org.spring.security01.config;

import lombok.RequiredArgsConstructor;
import org.spring.security01.entity.MemberEnt;
import org.spring.security01.repository.MemberRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepo memberRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<MemberEnt> memberEnt=memberRepo.findByEmail(email);
        if(!memberEnt.isPresent()){
            throw new UsernameNotFoundException("사용자 없음");
        }

        MemberEnt memberEnt1=memberEnt.get();
        System.out.println("email in User->"+email);
        System.out.println("email in Entity->"+memberEnt1.getEmail());


        return User.builder()
                .username(memberEnt1.getEmail())
                .password(memberEnt1.getPassword())
                .roles(memberEnt1.getRole().toString())
                .build();
    }
}
