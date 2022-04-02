package com.example.demo.repository;

import com.example.demo.domain.Article;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

  List<Article> findAll();

  Optional<Article> findById(Long id);

  void deleteById(Long id);
}
