package com.tarhan.springboot.converter;

import com.tarhan.springboot.dto.CommentDTO;
import com.tarhan.springboot.dto.UserDTO;
import com.tarhan.springboot.entity.CommentOfProduct;
import com.tarhan.springboot.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentConverter {
    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "userId", source = "user.id")
    CommentDTO convertCommentToCommentDTO(CommentOfProduct commentOfProduct);

    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "user.id", source = "userId")
    CommentOfProduct convertCommentDTOToComment(CommentDTO commentDTO);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "userId", source = "user.id")
    List<CommentDTO> convertAllCommentListToCommentDTOList(List<CommentOfProduct> commentOfProductList);

    @AfterMapping
    default void setNulls(@MappingTarget final CommentOfProduct commentOfProduct, CommentDTO commentDTO){
        if (commentDTO.getProductId() == null){
            commentOfProduct.setProduct(null);
        }
        if (commentDTO.getUserId() == null){
            commentOfProduct.setUser(null);
        }
    }
}
