package com.example.authentication.repo.page;

import com.example.authentication.model.page.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepo extends JpaRepository<Page,Integer> {
}
