package edu.gatech.cs2340.spacetraderredux.ViewModels;

import android.widget.TextView;

import edu.gatech.cs2340.spacetraderredux.Model.*;

public class ConfigurationViewModel {
    static Game game;

    public static String updateDifficulty(String oldDifficultyString, boolean up) {
        String newDifficultyString = "";
        oldDifficultyString = oldDifficultyString.toUpperCase();
        Difficulty[] valuesArray = Difficulty.values();
        for(int i = 0; i < valuesArray.length; i++) {
            Difficulty value = Difficulty.values()[i];
            String valueString = value.toString();
            if(valueString.equals(oldDifficultyString)) {
                int valueOrdinal = value.ordinal();
                if (up) {
                    int newOrdinal = (valueOrdinal + 1) % valuesArray.length;
                    Difficulty newValue = valuesArray[newOrdinal];
                    return newValue.toString();
                } else {
                    int newOrdinal = (valueOrdinal + valuesArray.length - 1) % valuesArray.length;
                    Difficulty newValue = valuesArray[newOrdinal];
                    return newValue.toString();
                }
            }

        }
        return oldDifficultyString;
    }

    public static String updateSkill(String skillPoints, boolean up) {
        int skill = Integer.parseInt(skillPoints);
        if (up) {
            if (skill == 16) {
                return "16";
            } else {
                return skill + 1 + "";
            }
        } else {
            if (skill == 0) {
                return "0";
            } else {
                return skill - 1 + "";
            }
        }
    }

    public static boolean validPlayer(String nameText, String difficultyText, String pilotText, String fighterText,
                                      String traderText, String engineerText) {
        int pilotSkill = Integer.parseInt(pilotText);
        int fighterSkill = Integer.parseInt(fighterText);
        int traderSkill = Integer.parseInt(traderText);
        int engineerSkill = Integer.parseInt(engineerText);

        if (nameText == null || nameText.length() <= 0) {
            return false;
        } else if (pilotSkill + fighterSkill + traderSkill + engineerSkill > 16) {
            return false;
        } else {
            Difficulty[] valuesArray = Difficulty.values();
            Difficulty difficulty = valuesArray[0];
            for(int i = 0; i < valuesArray.length; i++) {
                Difficulty value = Difficulty.values()[i];
                String valueString = value.toString();
                if(valueString.equals(difficultyText)) {
                    difficulty = valuesArray[i];
                }
            }
            game = new Game(new Player(fighterSkill, traderSkill, fighterSkill, engineerSkill), difficulty);
            return true;
        }
    }
}
