package com.vti.demorail79app.specification;

import com.vti.demorail79app.entity.Post;
import com.vti.demorail79app.form.PostFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form){
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            var search = form.getSearch();
            if(StringUtils.hasText(search)){
                var pattern = "%" + search.trim() +"%";
                var predicate = builder.like(root.get("title"), pattern); //From post where (this code = )title like '%JAVA%^'
                predicates.add(predicate);
            }

            var minCreatedDate = form.getMinCreatedDate();
            if (minCreatedDate != null){
                var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                var predicate = builder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
                predicates.add(predicate);
            }

            var maxCreatedDate = form.getMaxCreatedDate();
            if(maxCreatedDate != null){
                var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                var predicate = builder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
                predicates.add(predicate);
            }

            if (minCreatedDate != null && maxCreatedDate != null) {
                var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);

                var betweenPredicate = builder.between(root.get("createdAt"), minCreatedAt, maxCreatedAt);
                predicates.add(betweenPredicate);
            }
            return builder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };
    }
}
