package com.metacoding.springv1.reply;

import org.springframework.stereotype.Repository;

import com.metacoding.springv1.board.Board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ReplyRepository {
    private final EntityManager em;

    public void save(Reply reply) {
        em.persist(reply);
    }

    public Optional<Reply> findById(Integer id) {
        Reply reply = em.find(Reply.class, id);
        return Optional.ofNullable(reply);
    }

    public void delete(Reply reply) {
        em.remove(reply);
    }
}
