package com.example.demo.repository;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import com.example.demo.domain.Article;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class InMemoryArticleRepository implements
    ArticleRepository {

  private static final Map<Long, Article> ARTICLES = Stream.of(
          new Article(1L, "java", "java для начинающих"),
          new Article(2L, "python", "python для продвинутых"),
          new Article(2L, "javascript", "javascript для бэкенда")
      )
      .collect(toMap(Article::getId, identity()));

  @Override
  public List<Article> findAll() {
    return new ArrayList<>(ARTICLES.values());
  }

  @Override
  public Article findById(Long id) {
    return ARTICLES.get(id);
  }
}
