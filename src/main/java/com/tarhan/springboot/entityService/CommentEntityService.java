package com.tarhan.springboot.entityService;

import com.tarhan.springboot.dao.CommentDao;
import com.tarhan.springboot.entity.CommentOfProduct;
import com.tarhan.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentEntityService {
    @Autowired
    private CommentDao commentDao;

    public List<CommentOfProduct> findCommentsByUser(Long id){

        return (List<CommentOfProduct>) commentDao.findCommentsByUser(id);
    }
    public List<CommentOfProduct> findCommentsByproduct(Long productId){

        return (List<CommentOfProduct>) commentDao.findCommentsByproduct(productId);
    }
    public CommentOfProduct save(CommentOfProduct commentOfProduct){
        return commentDao.save(commentOfProduct);
    }
    public void deleteById(Long id){
        commentDao.deleteById(id);
    }

}
