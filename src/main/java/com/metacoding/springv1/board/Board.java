package com.metacoding.springv1.board;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;

import com.metacoding.springv1.reply.Reply;
import com.metacoding.springv1.user.User;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "board_tb")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // List가 없으면 null이 아닌 [] 빈 배열 반환
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // reply 필드 연결
    private List<Reply> replies = new ArrayList<>();

    @Builder
    public Board(Integer id, String title, String content, Timestamp createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    };

}