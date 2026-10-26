package com.vinayak.blogapp.domain.entities;

import com.vinayak.blogapp.domain.Poststatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String UUID;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String Content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Poststatus status;


    @Column(nullable = false)
    private Integer readingTime;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(UUID, post.UUID) && Objects.equals(title, post.title) && Objects.equals(Content, post.Content) && status == post.status && Objects.equals(readingTime, post.readingTime) && Objects.equals(createdAt, post.createdAt) && Objects.equals(updatedAt, post.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UUID, title, Content, status, readingTime, createdAt, updatedAt);
    }

    @PrePersist
    protected void onCreate(){
        LocalDateTime now  = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt= now;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
        
    }


}

