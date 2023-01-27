package org.spring.security01.dto;

import lombok.*;
import org.spring.security01.constant.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class MemberDto {


    public Long id;

    @NotBlank(message = "email은 필수 사항입니다.")
    @Size(min = 3, max = 10, message = "email은 3에서 10글자 이내로 입력")
    public String email;


    @NotBlank(message = "password는 필수 사항입니다.")
    @Size(min = 3, message = "password는 3글자 이상으로 입력해주세요")
    public String password;


    private Role role;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;


}
