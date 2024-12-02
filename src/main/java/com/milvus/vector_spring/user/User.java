package com.milvus.vector_spring.user;

import com.milvus.vector_spring.common.BaseTimeEntity;
import com.milvus.vector_spring.content.Content;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.milvus.vector_spring.project.Project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user")
public class User extends BaseTimeEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "login_at")
    private LocalDateTime loginAt;

    @OneToMany(mappedBy = "createdContentUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Content> createdContentUser = new ArrayList<>();

    @OneToMany(mappedBy = "updatedContentUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Content> updatedContentUser= new ArrayList<>();

    @OneToMany(mappedBy = "createdProjectUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> createdProjectUser = new ArrayList<>();

    @OneToMany(mappedBy = "updatedProjectUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> updatedProjectUser= new ArrayList<>();

    @Builder
    public User(long id, String email, String username, String password, LocalDateTime loginAt) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.loginAt = loginAt;
    }

    public User updateLoginAt(LocalDateTime loginAt) {
        this.loginAt = loginAt;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }
}
