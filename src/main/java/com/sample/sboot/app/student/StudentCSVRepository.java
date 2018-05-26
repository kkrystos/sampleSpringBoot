package com.sample.sboot.app.student;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class StudentCSVRepository {

    private static final String FILE_PATH = "src/student.csv";

    public List<String[]> readAll() {
        try (Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
//             CSVReader csvReader = new CSVReader(reader);
             CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            List<String[]> strings = csvReader.readAll();
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeAll(PrintWriter printWriter) {

        try (
                // Writer writer = Files.newBufferedWriter(Paths.get("src/student.csv"));

                CSVWriter csvWriter = new CSVWriter(printWriter,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
            String[] headerRecord = {"id", "name", "passportNumber"};
            csvWriter.writeNext(headerRecord);

            csvWriter.writeNext(new String[]{"11", "KaMcIaX", "321"});
            csvWriter.writeNext(new String[]{"22", "Myfff", "432"});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
