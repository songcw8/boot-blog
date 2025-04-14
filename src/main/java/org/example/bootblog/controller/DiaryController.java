package org.example.bootblog.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootblog.model.dto.DiaryForm;
import org.example.bootblog.model.entity.Diary;
import org.example.bootblog.service.DiaryService;
import org.example.bootblog.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.xml.transform.Result;

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;
    private final UploadService uploadService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("message", "List");
        model.addAttribute("list", diaryService.getAllDiaryList());
        return "diary/list";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("message", "Form");
        model.addAttribute("form", new DiaryForm("", "", null));
        return "diary/form";
    }

    @PostMapping("/new")
    public String save(DiaryForm form, RedirectAttributes redirectAttributes) {
        String imageUrl = uploadService.upload(form.imageFile());
        Diary diary = new Diary();
        diary.setTitle(form.title());
        diary.setContent(form.content());
        diary.setImageUrl(imageUrl);
        Diary result = diaryService.createDiary(diary);
        redirectAttributes.addFlashAttribute("message", result.getUuid());
        return "redirect:/diary";
    }
}
