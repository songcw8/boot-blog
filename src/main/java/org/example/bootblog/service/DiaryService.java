package org.example.bootblog.service;

import lombok.RequiredArgsConstructor;
import org.example.bootblog.model.entity.Diary;
import org.example.bootblog.model.repository.DiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;

    public List<Diary> getAllDiaryList() {
        return diaryRepository.findAll();
    }

    public Diary createDiary(Diary diary) {
        return diaryRepository.save(diary);
    }
}
