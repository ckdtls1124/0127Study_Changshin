package org.spring.security01.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.spring.security01.entity.MemberEnt;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;



@Setter
@Getter
@ToString
@Log4j2
public class SecurityUser extends User{

    private MemberEnt memberEnt;

    public SecurityUser(MemberEnt memberEnt){
        super(memberEnt.getEmail(), memberEnt.getPassword(), AuthorityUtils.createAuthorityList(memberEnt.getEmail().toString()));

        System.out.println("memberEnt"+memberEnt.getEmail());


        this.memberEnt = memberEnt;

    }

}
