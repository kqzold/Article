package com.example.Article.controllers;

import com.example.Article.entity.Tag;
import com.example.Article.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public String getAllTags(Model model) {
        List<Tag> tags = tagService.getAllTags();
        model.addAttribute("tags", tags);
        return "tags/list";
    }

    @GetMapping("/{id}")
    public String getTagById(@PathVariable Long id, Model model) {
        Tag tag = tagService.getTagById(id);
        model.addAttribute("tag", tag);
        return "tags/details";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("tag", new Tag());
        return "tags/add";
    }

    @PostMapping
    public String createTag(@ModelAttribute Tag tag) {
        tagService.createTag(tag);
        return "redirect:/tags";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tag tag = tagService.getTagById(id);
        model.addAttribute("tag", tag);
        return "tags/edit";
    }

    @PostMapping("/update/{id}")
    public String updateTag(@PathVariable Long id, @ModelAttribute Tag tag) {
        tagService.updateTag(id, tag);
        return "redirect:/tags";
    }
    @GetMapping("/delete/{id}")
    public String deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "redirect:/tags";
    }

}