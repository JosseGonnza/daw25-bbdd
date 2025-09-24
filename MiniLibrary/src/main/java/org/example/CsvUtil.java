package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvUtil {
    public static String sanitize(String s) {
        if (s == null) {
            return "";
        } else {
            return s.replace(";", ",").trim();
        }
    }

    public static void ensureParentDir(Path file) throws IOException {
        Path parent = file.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}
