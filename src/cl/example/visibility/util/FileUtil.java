package cl.example.visibility.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileUtil {

	
	
	public static List<String> getCsvFile(String fileName) {

		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {

			list = stream.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		return list;
	}
	

	


	public static Map<Integer, Integer> getCsvFileToMap(String fileName) {

		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();

		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {

			resultMap = stream.map(line -> line.split(","))
					.collect(Collectors.toMap(line -> Integer.valueOf(line[0]), line -> Integer.valueOf(line[1])));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		return resultMap;
	}



	
}
