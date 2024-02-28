package com.springboot.blogapp.payload;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtAuthResponse {

    private String accessToken;

    private String tokenType="Bearer";
}
