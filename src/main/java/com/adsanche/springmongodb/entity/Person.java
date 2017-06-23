package com.adsanche.springmongodb.entity;

import com.adsanche.springmongodb.constant.GenderEnum;
import lombok.Builder;
import lombok.Data;

/**
 * Created by adsanche on 20/06/17.
 */
@Data
@Builder
public class Person {

    private GenderEnum gender;

    private String firstName;

    private String lastName;

    private Integer age;
}
