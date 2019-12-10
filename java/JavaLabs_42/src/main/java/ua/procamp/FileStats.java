package ua.procamp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;



public class FileStats {
    private final Map<Character, Long> characterCountMap;
    private  final char mostPopularCharacters;




    public static FileStats from(String fileName) {
        return new FileStats(fileName);
    }
    private FileStats(String fileName){
        Path filePath = getFilePath(fileName);
        characterCountMap = computeCharacterMap(filePath);
        mostPopularCharacters = findMostPopularCharacter(characterCountMap);
    }

    private Map<Character, Long> computeCharacterMap(Path filePath) {
        try(Stream<String> lines = Files.lines(filePath)) {
            return collectCharactersToCountMap(lines);

        }
        catch (IOException e){
            throw new FileStatsException("Cannot read the file", e);
        }
    }

    private Map<Character, Long> collectCharactersToCountMap(Stream<String> linesStream) {
        return  linesStream
                .flatMapToInt(String::chars)
                .filter(a -> a != 32)
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));
    }


    private char findMostPopularCharacter(Map<Character, Long> characterCountMap) {
        return characterCountMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow(() -> new FileStatsException("File is empty"))
                .getKey();
    }



    private Path getFilePath(String fileName) {
        Objects.requireNonNull(fileName);
        URL fileUrl = getFileUrl(fileName);
        try {
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw new FileStatsException("Wrong file path", e);
        }

    }

    private URL getFileUrl(String fileName){
        URL fileUrl = getClass().getClassLoader().getResource(fileName);
        if (fileUrl == null) {
            throw new FileStatsException("Wrong file path");
        }
        return fileUrl;
    }


    public int getCharCount(char character) {
      return characterCountMap.get(character).intValue();
    }


    public char getMostPopularCharacter() {
        return  mostPopularCharacters;
    }


    public boolean containsCharacter(char character) {
       return characterCountMap.containsKey(character);
    }
}
