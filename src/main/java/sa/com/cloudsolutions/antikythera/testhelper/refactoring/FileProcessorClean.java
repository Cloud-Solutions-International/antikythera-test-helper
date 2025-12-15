package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clean version of FileProcessor with extracted helper methods.
 * This is the expected result after refactoring FileProcessorDup.
 */
public class FileProcessorClean {

    private List<String> readAndFilter(String filename, String keyword) throws IOException {
        List<String> matches = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(keyword)) {
                matches.add(line);
            }
        }
        reader.close();
        return matches;
    }

    public List<String> readAndFilterLog(String logFile, String keyword) throws IOException {
        return readAndFilter(logFile, keyword);
    }

    public List<String> readAndFilterConfig(String configFile, String section) throws IOException {
        return readAndFilter(configFile, section);
    }

    private void writeWithWrapper(String filename, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("=== Report ===\n");
        writer.write(content);
        writer.write("\n=== End ===\n");
        writer.close();
    }

    public void writeReport(String filename, String content) throws IOException {
        writeWithWrapper(filename, content);
    }

    public void writeSummary(String filename, String data) throws IOException {
        writeWithWrapper(filename, data);
    }
}
