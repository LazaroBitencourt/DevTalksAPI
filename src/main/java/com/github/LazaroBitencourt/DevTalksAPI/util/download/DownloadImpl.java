package com.github.LazaroBitencourt.DevTalksAPI.util.download;

import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

@Log4j2
@Component
public class DownloadImpl implements Download {

    @Value("${path.upload.directory}")
    private String directoryUploads;

    @Override
    public Resource downloadFile(String directoryName,String fileName) {
        log.info("[start] DownloadImpl - downloadFile");
        Path uploadDirectory = Paths.get(directoryUploads,directoryName).normalize();
        Stream<Path> stream = null;
        try {
            stream = Files.list(uploadDirectory);
            Optional<Path> foundFile = stream
                    .filter(file -> file.getFileName().toString().equals(fileName))
                    .findFirst();
            if (foundFile.isPresent()) {
                log.info("[finish] DownloadImpl - downloadFile");
                return new UrlResource(foundFile.get().toUri());
            } else {
                throw APIException.build(HttpStatus.NOT_FOUND, "FILE NOT FOUND");
            }
        } catch (IOException ex) {
            throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "INVALID FILE URI");
        }finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}
