package com.example.backendsimplemovies.entity.criteria;

import com.example.backendsimplemovies.entity.Genre;
import com.example.backendsimplemovies.entity.Movie;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
public class GenreCriteria {
    private Long id;
    private String name;

    public Specification<Genre> getSpecification(){
        return new Specification<>(){
            @Override
            public Predicate toPredicate(Root<Genre> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(getId() != null){
                    predicates.add(criteriaBuilder.equal(root.get("id"), getId()));
                }

                if(!StringUtils.isEmpty(getName())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + getName().toLowerCase() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
