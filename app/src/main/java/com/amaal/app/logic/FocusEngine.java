package com.amaal.app.logic;

import com.amaal.app.data.Deed;
import java.util.*;

public class FocusEngine {

    public static Deed selectFocus(List<Deed> deeds) {

        long now = System.currentTimeMillis();
        Deed best = null;
        int bestScore = Integer.MIN_VALUE;

        for (Deed d : deeds) {

            if (d.completedToday) continue;

            // Jamāʿah priority gate
            if (d.isPrayer && d.usesJamaah) {
                Calendar j = Calendar.getInstance();
                j.set(Calendar.HOUR_OF_DAY, d.jamaahHour);
                j.set(Calendar.MINUTE, d.jamaahMinute);

                long diff =
                    (j.getTimeInMillis() - now) / 60000;

                if (diff < 0 || diff > d.priorityWindowMinutes)
                    continue;
            }

            int score = categoryWeight(d.category);
            score += d.isPrayer ? 300 : 0;
            score -= d.estimatedMinutes;

            if (score > bestScore) {
                bestScore = score;
                best = d;
            }
        }
        return best;
    }

    private static int categoryWeight(String c) {
        switch (c) {
            case "FARD_AYN": return 1000;
            case "FARD_KIFAYAH": return 800;
            case "SUNNAH_MUAKKADAH": return 600;
            case "SUNNAH_GHAYR": return 400;
            case "MUSTAHAB": return 200;
            case "NAWAFIL": return 100;
            case "MUBAH": return 50;
            default: return 0;
        }
    }
}