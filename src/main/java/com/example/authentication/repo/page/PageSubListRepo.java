package com.example.authentication.repo.page;

import com.example.authentication.model.page.Page;
import com.example.authentication.model.page.PageSubList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageSubListRepo extends JpaRepository<PageSubList,Integer> {
}
