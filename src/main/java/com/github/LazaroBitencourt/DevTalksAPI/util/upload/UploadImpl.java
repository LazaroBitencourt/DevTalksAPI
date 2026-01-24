package com.github.LazaroBitencourt.DevTalksAPI.util.upload;

import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Log4j2
@Component
public class UploadImpl implements Upload {

    @Value("${path.upload.directory}")
    private String directoryUploads;

    @Override
    public String uploadFile(MultipartFile file, UUID id, String directoryName) {
        log.info("[start] UploadImpl - uploadFile - Saving file");
        if (!file.isEmpty() && id != null) {
            String fileName = StringUtils.cleanPath(id + "_" + file.getOriginalFilename());
            try {
                File directory = new File(this.directoryUploads, directoryName);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                File outputFile = new File(directory.getAbsolutePath() + File.separator + fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(outputFile));
                stream.write(file.getBytes());
                stream.close();
                log.info("[finish] UploadImpl - uploadFile - File saved");
                return fileName;
            } catch (Exception ex) {
                throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "AN ERROR OCCURRED WHILE SAVING THE IMAGE TO THE SERVER", ex);
            }
        } else {
            throw APIException.build(HttpStatus.BAD_REQUEST, "INVALID UPLOAD REQUEST, FILE IS EMPTY OR ID NOT PROVIDED");
        }
    }
}


