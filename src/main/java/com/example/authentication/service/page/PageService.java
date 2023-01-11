package com.example.authentication.service.page;

import com.example.authentication.model.page.Page;
import com.example.authentication.payload.PageResponse;

import java.util.List;

public interface PageService {

    Page save(Page page);
    Page update(int id, Page page);
    Page getById(int id);
    void delete(int id);
    PageResponse findAll(int pageNumber, int pageSize, String sortBy, String sortDir);
}
