package jpabook.jpashop.domain;

import lombok.Getter;
import javax.persistence.Embeddable;

@Embeddable
//@Embeddable: 값 타입을 정의하는 곳에 표시
//@Embedded: 값 타입을 사용하는 곳에 표시
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
