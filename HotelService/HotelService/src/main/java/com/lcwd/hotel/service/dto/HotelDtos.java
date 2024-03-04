package com.lcwd.hotel.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDtos {
    private String hotelId;
    private String name;
    private String location;
    private String about;
}
