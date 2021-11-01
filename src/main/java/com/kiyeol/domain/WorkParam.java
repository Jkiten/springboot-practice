package com.kiyeol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkParam {
    long user_id;
    double start_latitude;
    double start_Longitude;
    double desti_latitude;
    double desti_Longitude;
}

