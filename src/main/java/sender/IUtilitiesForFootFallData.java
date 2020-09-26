package sender;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.*;
import java.util.*;
public interface IUtilitiesForFootFallData {
					public List<String> getAllFootFallRecordsAsAListOfStrings(Path pathToFootFallDataFile) throws IOException;
					public void writeFootFallDataToConsoleAsAString(Path pathToFootFallDataFile) throws IOException;
}
