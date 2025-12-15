package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class with duplicates involving file I/O operations.
 * This tests Bertie's ability to handle exception handling and file operations.
 */
public class FileProcessorDup {

    public List<String> readAndFilterLog(String logFile, String keyword) throws IOException {
        List<String> matches = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(logFile));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(keyword)) {
                matches.add(line);
            }
        }
        reader.close();
        return matches;
    }

    public List<String> readAndFilterConfig(String configFile, String section) throws IOException {
        List<String> matches = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(configFile));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(section)) {
                matches.add(line);
            }
        }
        reader.close();
        return matches;
    }

    public void writeReport(String filename, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("=== Report ===\n");
        writer.write(content);
        writer.write("\n=== End ===\n");
        writer.close();
    }

    public void writeSummary(String filename, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("=== Report ===\n");
        writer.write(data);
        writer.write("\n=== End ===\n");
        writer.close();
    }
}
