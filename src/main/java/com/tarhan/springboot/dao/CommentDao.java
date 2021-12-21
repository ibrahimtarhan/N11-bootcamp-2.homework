package com.tarhan.springboot.dao;

import com.tarhan.springboot.entity.CommentOfProduct;
import com.tarhan.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<CommentOfProduct,Long> {
    @Query("select comment from CommentOfProduct comment where comment.user.id = :id")
    List<CommentOfProduct> findCommentsByUser(Long id);

    @Query("select comment from CommentOfProduct comment where comment.product.id = :productId")
    List<CommentOfProduct> findCommentsByproduct(Long productId);
}
