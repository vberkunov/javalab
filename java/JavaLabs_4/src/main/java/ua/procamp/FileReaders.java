package ua.procamp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;


public class FileReaders {


    public static String readWholeFile(String fileName) {
        Path filePath = createPathFromFileName(fileName);
        try (Stream<String> fileLinesStream = OpenFileLinesStream(filePath)){
            return fileLinesStream.collect(joining("\n"));
        }

    }

    private static Path createPathFromFileName(String fileName) {
        Objects.requireNonNull(fileName);
        URL fileUrl = FileReaders.class.getClassLoader().getResource(fileName);
        try{
            return Paths.get(fileUrl.toURI());
        }
        catch (URISyntaxException e){
            throw new FileReaderException("Invalid file URL", e);
        }

    }
    private static Stream<String> OpenFileLinesStream(Path filePath){
        try {
            return Files.lines(filePath);
        }
        catch (IOException e) {
            throw new FileReaderException("Cannot create a stream of file lines", e);
        }
    }
}
