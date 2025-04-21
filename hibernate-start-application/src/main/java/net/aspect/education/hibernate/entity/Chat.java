package net.aspect.education.hibernate.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="chat")
public class Chat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name_chat", unique = true, nullable=false)
    private String name;

    @Builder.Default
    @ManyToMany(mappedBy="chats")
    private List<UserChat> userChat = new ArrayList<>();
}


