package com.tarhan.springboot.converter;
import com.tarhan.springboot.dto.CategoryDTO;
import com.tarhan.springboot.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {
    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    CategoryDTO convertCategoryToCategoryDTO(Category category);

    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    List<CategoryDTO> convertAllCategoryListToCategoryDTOList(List<Category> categoryList);

    @Mapping(target = "parentCategory.id", source = "parentCategoryId")
    Category convertCategoryDTOToCategory(CategoryDTO categoryDTO);

    @AfterMapping
    default void setNulls(@MappingTarget Category category, CategoryDTO categoryDTO){
        if (categoryDTO.getParentCategoryId() == null){
            category.setParentCategory(null);
        }
    }
}
