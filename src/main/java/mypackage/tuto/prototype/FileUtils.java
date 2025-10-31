package mypackage.tuto.prototype;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class FileUtils {
	static final Logger logger=Logger.getAnonymousLogger();
public static void main(String[] args) throws URISyntaxException, IOException {
	String nameFile="map01";
	String folder="/"+"panel/play/field/maps";
	String location=folder+"/"+nameFile;
	readFile(location);
}

private static List<String> readFile(String location) throws IOException, URISyntaxException {
	URL url=FileUtils.class.getResource(location);
	FileUtils.class.getClassLoader();
	Path path = Paths.get(url.toURI());
	List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	for (String line: lines) {
		logger.info(line);
	}
	return lines;
}
}
