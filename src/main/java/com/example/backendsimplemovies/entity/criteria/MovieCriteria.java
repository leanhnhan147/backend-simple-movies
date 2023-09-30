package com.example.backendsimplemovies.entity.criteria;

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
public class MovieCriteria {
    private Long id;
    private String title;

    public Specification<Movie> getSpecification(){
        return new Specification<>(){
            @Override
            public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(getId() != null){
                    predicates.add(criteriaBuilder.equal(root.get("id"), getId()));
                }

                if(!StringUtils.isEmpty(getTitle())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + getTitle().toLowerCase() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
