package example.domain;

public class Member {

    private Long id;    // 시스템에 저장되는 아이디
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
