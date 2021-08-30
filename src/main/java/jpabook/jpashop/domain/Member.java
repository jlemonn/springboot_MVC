package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter // lombok
public class Member {

    @Id // primary key
    @GeneratedValue // 주키의 값을 자동으로 생성
    @Column(name="number_id") // pk의 name
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // mappedBy: 이 order는 memer에 mapping되어 있다. order에서 PK를 통해 mappedby 된 값을 바꿀 수 있다.
    private List<Order> orders = new ArrayList<>();
}
