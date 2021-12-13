package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //기간
    @Embedded
    private Period workperiod;

    //주소
    @Embedded
    private Address homeaddress;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city",column=@Column(name = "WORK_CITY"))
            ,@AttributeOverride(name = "street",column = @Column(name = "WORK_STREET"))
            ,@AttributeOverride(name = "zipcode",column = @Column(name = "WORK_ZIPCODE"))})
    private Address workaddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getWorkperiod() {
        return workperiod;
    }

    public void setWorkperiod(Period workperiod) {
        this.workperiod = workperiod;
    }

    public Address getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(Address homeaddress) {
        this.homeaddress = homeaddress;
    }
}