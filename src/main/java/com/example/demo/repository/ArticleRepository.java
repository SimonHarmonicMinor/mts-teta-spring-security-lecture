package com.example.demo.repository;

import com.example.demo.domain.Article;
import java.util.List;

public interface ArticleRepository {

  List<Article> findAll();

  Article findById(Long id);

  void deleteById(Long id);
}
