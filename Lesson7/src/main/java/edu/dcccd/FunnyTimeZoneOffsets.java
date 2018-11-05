package edu.dcccd;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.util.Comparator.comparingInt;

public class FunnyTimeZoneOffsets {
    public static void main(String[] args) {
        new FunnyTimeZoneOffsets().go();
    }

    private void go() {
        Instant instant = Instant.now();
        ZonedDateTime current = instant.atZone(ZoneId.systemDefault());
        System.out.printf("Current time is %s %n %n", current);
        System.out.printf("%10s %20s  %13s  %n", "Offset", "ZoneId", "Time");

        ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId :: of)
                .filter(zoneId -> {
                    ZoneOffset offset = instant.atZone(zoneId).getOffset();
                    return offset.getTotalSeconds() % (60 * 60) != 0;
                })
                .sorted(comparingInt(zoneId ->
                        instant.atZone(zoneId).getOffset().getTotalSeconds()))
                .forEach(zoneId -> {
                    ZonedDateTime zdt = current.withZoneSameInstant(zoneId);
                    System.out.printf("%10s %25s %10s%n",
                            zdt.getOffset(), zoneId,
                            zdt.format(DateTimeFormatter.ofLocalizedTime(
                                    FormatStyle.SHORT)));
                });
        System.out.println("This program took " +
                Duration.between(instant, Instant.now()).toMillis() +
                " milliseconds to run.");

    }
}