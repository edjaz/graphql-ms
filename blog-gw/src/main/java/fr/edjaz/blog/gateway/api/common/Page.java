package fr.edjaz.blog.gateway.api.common;

import java.util.List;

public class Page<T> {
    int totalPages;
    long totalElements;
    List<T> content;

    public Page() {
    }

    public Page(int totalPages, long totalElements, List<T> content) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public List<T> getContent() {
        return content;
    }
}
