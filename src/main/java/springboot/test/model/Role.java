package springboot.test.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name= "roles")
public class Role {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "roleName")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Role(){}

    public Role(String roleName){
        this.name = roleName;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }


    public void setUser(User user){
        this.user = user;
    }

}
