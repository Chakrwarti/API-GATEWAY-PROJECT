package com.lcwd.rating.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;
}
