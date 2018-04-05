package com.example.kolvir.test.AuxiliaryForHistory;

import android.widget.TextView;

public class DelayedPrinter {

    private static Word word;
    private static TextView textView;
    private static Runnable runnable;
    public static Boolean isRunning = false;

    public static void printText(final Word word, final TextView textView) {
        isRunning = true;
        DelayedPrinter.word = word;
        DelayedPrinter.textView = textView;

        runnable = new Runnable() {
            @Override
            public void run() {
                    if (!isRunning) return;
                    String charAt = String.valueOf(word.word.charAt(word.currentCharacterIndex));
                    ++word.currentCharacterIndex;
                    textView.setText(textView.getText() + charAt);
                    if (word.currentCharacterIndex >= word.word.length()) {
                        isRunning = false;
                        return;
                    }

                    printText(word, textView);
            }
        };

        long finalDelay = 60;

        textView.postDelayed(runnable, finalDelay);
    }

    public static void setIsRunning(Boolean isRunning) {
        DelayedPrinter.isRunning = isRunning;
    }

    public static Boolean getIsRunning() {
        return isRunning;
    }

    public static class Word {

        private String word;
        private int currentCharacterIndex;

        public Word(String word) {
            this.word = word;
        }
    }
}