/**
 * LeetCode 401 - Binary Watch (Easy)
 * Day 12 - Backtracking
 *
 * Problem: A binary watch has 4 LEDs on top for the hours (0-11) and
 * 6 LEDs on the bottom for the minutes (0-59). Given turnedOn, the
 * number of LEDs currently lit, return all possible times the watch
 * could show. Hours have no leading zero, minutes are two digits.
 * Example: turnedOn = 1 -> ["0:01","0:02","0:04","0:08","0:16",
 *          "0:32","1:00","2:00","4:00","8:00"]
 *
 * Approach: The watch can show only 12 x 60 = 720 times, so just try
 * them all. For each (hour, minute) pair, count the set bits in the
 * hour plus the set bits in the minute — that is how many LEDs are
 * lit for that time. If the count equals turnedOn, format it as
 * "H:MM" and keep it. Integer.bitCount does the bit counting.
 *
 * Time: O(1) — a fixed 720 hour/minute pairs, independent of input
 *       | Space: O(1) — apart from the output list
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        // Every time the watch can display, hour 0-11, minute 0-59.
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // LEDs lit = set bits in the hour + set bits in the minute.
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    // Hour without leading zero, minute always two digits.
                    result.add(hour + ":" + String.format("%02d", minute));
                }
            }
        }
        return result;
    }
}
