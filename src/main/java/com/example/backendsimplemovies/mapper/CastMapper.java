package com.example.backendsimplemovies.mapper;

import com.example.backendsimplemovies.dto.cast.CastDto;
import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.entity.Cast;
import com.example.backendsimplemovies.entity.Genre;
import com.example.backendsimplemovies.form.cast.CreateCastForm;
import com.example.backendsimplemovies.form.cast.UpdateCastForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CastMapper {

    @Mapping(source = "castName", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "profilePath", target = "profilePath")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminCreateMapping")
    Cast fromCreateCastFormToEntity(CreateCastForm createCastForm);

    @Mapping(source = "castName", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "profilePath", target = "profilePath")
    @Mapping(source = "status", target = "status")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminUpdateMapping")
    void fromUpdateCastFormtoEntity(UpdateCastForm updateCastForm, @MappingTarget Cast cast);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "castName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "profilePath", target = "profilePath")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "modifiedDate", target = "modifiedDate")
    @Mapping(source = "status", target = "status")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminGetMapping")
    CastDto fromEntityToAdminDto(Cast cast);

    @IterableMapping(elementTargetType = CastDto.class, qualifiedByName = "adminGetMapping")
    List<CastDto> fromEntityListToCastDtoList(List<Cast> casts);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "castName")
//    @Mapping(source = "profilePath", target = "profilePath")
//    @BeanMapping(ignoreByDefault = true)
//    @Named("castGetMapping")
//    CastDto fromEntityToDto(Cast cast);
//
//    @IterableMapping(elementTargetType = CastDto.class, qualifiedByName = "castGetMapping")
//    @Named("castsGetMapping")
//    List<CastDto> fromEntityListToDtoList(List<Cast> casts);
}
