package net.aspect.education.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="profile")
public class Profile{

    @Id
    @Column(name="user_id")
    private Long user_id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    private String street;
    private String language;

    public void setUser(User user){
        this.user = user;
        user.setProfile(this);
        user_id = user.getId();
    }
}
