package org.study_mode;

public enum StudyMode {
    FLIP_MODE("Flip Mode", "Flip the card to see the answer"),
    TYPING_MODE("Typing Mode", "Type the correct answer");

    private final String modeName;
    private final String description;

    StudyMode(String modeName, String description) {
        this.modeName = modeName;
        this.description = description;
    }

    public String getModeName() {
        return modeName;
    }

    public String getDescription() {
        return description;
    }
}
