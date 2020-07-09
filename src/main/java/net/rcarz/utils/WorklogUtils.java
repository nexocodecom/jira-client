package net.rcarz.utils;

import net.rcarz.jiraclient.WorkLog;

import java.time.Duration;

/**
 * Created by mariusmerkevicius on 1/30/16.
 * A set of utils static methods help set {@link WorkLog}
 */
public class WorklogUtils {

    /**
     * Formats duration time into pretty string format
     * Does not output seconds
     *
     * @param durationInSeconds provided duration to format
     * @return formatted duration
     */
    public static String formatDurationFromSeconds(long durationInSeconds) {
        if (durationInSeconds < 60)
            return "0m";
        StringBuilder builder = new StringBuilder();

        Duration duration = Duration.ofSeconds(durationInSeconds);
        if (duration.toHours() != 0)
            builder.append(duration.toHours()).append("h").append(" ");
        long minutes = duration.toMinutes() % 60;
        if (minutes != 0)
            builder.append(minutes).append("m").append(" ");
        if ((builder.length() > 0) && builder.charAt(builder.length() - 1) == " ".charAt(0))
            builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

}
