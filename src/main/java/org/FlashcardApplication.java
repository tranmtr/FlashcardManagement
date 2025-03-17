package org;

import org.study_mode.StudyMode;

public class FlashcardApplication {
    public static void main(String[] args) {
        StudyMode currentMode = StudyMode.FLIP_MODE;

        System.out.println("Bạn đang học theo chế độ: " + currentMode.getModeName());
        System.out.println("Mô tả: " + currentMode.getDescription());
    }
}