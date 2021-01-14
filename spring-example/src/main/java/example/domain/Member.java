package example.domain;

import javax.persistence.*;

// jpa
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // db 가 알아서 id값 생성 해준다는 표시
    private Long id;    // 시스템에 저장되는 아이디

    @Column(name = "name")
    private String name;    // 이름

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
