package com.dhriti.user.userService.entities;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating implements Serializable {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;

    private Hotel hotel;


    @Override
    public String toString() {
        return "Rating{" +
                "ratingId='" + ratingId + '\'' +
                ", userId='" + userId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", rating=" + rating +
                ", remark='" + remark + '\'' +
                '}';
    }
}
