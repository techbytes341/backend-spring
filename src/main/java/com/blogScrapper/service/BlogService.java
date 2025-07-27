package com.blogScrapper.service;

import com.blogScrapper.dto.BlogPageResponseDTO;
import com.blogScrapper.dto.BlogResponseDTO;
import com.blogScrapper.mapper.BlogMapper;
import com.blogScrapper.model.Blog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlogService {

    private  final EntityManager entityManager;
    private  final BlogMapper blogMapper;

    public BlogPageResponseDTO getFilteredBlogs(String company, String theme, int page, int limit){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Blog> query = cb.createQuery(Blog.class);
        Root<Blog> blog = query.from(Blog.class);

        Predicate filterPredicate = buildFilterPredicate(cb,blog,company,theme);

        query.where(filterPredicate);
        query.orderBy(cb.desc(blog.get("createdAt")));

        TypedQuery<Blog> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(page*limit)
                .setMaxResults(limit);
        List<Blog> blogs = typedQuery.getResultList();
        List<BlogResponseDTO> blogPageResponseDTOS = blogMapper.toDTOList(blogs);


        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Blog> countRoot = countQuery.from(Blog.class);
        Predicate countFilterPredicate = buildFilterPredicate(cb, countRoot, company, theme);

        countQuery.select(cb.count(countRoot));
        countQuery.where(countFilterPredicate);

        Long totalCount = entityManager.createQuery(countQuery).getSingleResult();
        return new BlogPageResponseDTO(blogPageResponseDTOS,totalCount);
    }
    private Predicate buildFilterPredicate(CriteriaBuilder cb, Root<Blog> root, String company, String theme) {
        List<Predicate> predicates = new ArrayList<>();

        if (company != null && !company.isEmpty()) {
            predicates.add(cb.equal(cb.lower(root.get("company")), company.toLowerCase()));
        }

        if (theme != null && !theme.isEmpty()) {
            predicates.add(cb.equal(cb.lower(root.get("theme")), theme.toLowerCase()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }

}
