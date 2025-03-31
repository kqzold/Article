package com.example.Article.interfaces;

import com.example.Article.entity.Tag;
import java.util.List;

public interface TagService {
    List<Tag> getAllTags();
    Tag getTagById(Long id);
    void createTag(Tag tag);
    Tag updateTag(Long id, Tag tag);
    void deleteTag(Long id);
}