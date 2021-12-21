package com.tarhan.springboot.controller;

import com.tarhan.springboot.converter.CommentConverter;
import com.tarhan.springboot.converter.UserConverter;
import com.tarhan.springboot.dto.CommentDTO;
import com.tarhan.springboot.dto.UserDTO;
import com.tarhan.springboot.entity.CommentOfProduct;
import com.tarhan.springboot.entity.User;
import com.tarhan.springboot.entityService.CommentEntityService;
import com.tarhan.springboot.exception.CommentByUserNotFoundException;
import com.tarhan.springboot.exception.CommnetByProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentEntityService commentEntityService;

    @GetMapping("/userid/{id}")
    public List<CommentDTO> findCommentByUsername(@PathVariable Long id){

        List<CommentOfProduct> commentOfProductList = commentEntityService.findCommentsByUser(id);
        if(commentOfProductList == null){
            throw new CommentByUserNotFoundException(id + " Id'li kullanıcı henüz yorum yazmamıştır");
        }
        List<CommentDTO> commentDTOList = CommentConverter.INSTANCE.convertAllCommentListToCommentDTOList(commentOfProductList);

        return commentDTOList;
    }
    @GetMapping("/productid/{id}")
    public List<CommentDTO> findCommentByProductId(@PathVariable Long id){

        List<CommentOfProduct> commentOfProductList = commentEntityService.findCommentsByproduct(id);
        if(commentOfProductList == null){
            throw new CommnetByProductNotFoundException(id + " Id'li ürün hakkında henüz yorum yazmamıştır");
        }
        List<CommentDTO> commentDTOList = CommentConverter.INSTANCE.convertAllCommentListToCommentDTOList(commentOfProductList);

        return commentDTOList;
    }
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CommentDTO commentDTO){

        CommentOfProduct commentOfProduct = CommentConverter.INSTANCE.convertCommentDTOToComment(commentDTO);

        commentOfProduct = commentEntityService.save(commentOfProduct);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(commentOfProduct.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("/{id}")
    public void delete(Long id){
        commentEntityService.deleteById(id);
    }

}
