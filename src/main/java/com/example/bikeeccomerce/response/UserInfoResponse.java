package com.example.bikeeccomerce.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private Long userId;
    private String displayName;

}
