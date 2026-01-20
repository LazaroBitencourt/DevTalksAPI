package com.github.LazaroBitencourt.DevTalksAPI.util;

import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Component
public class UploadImpl implements Upload {

    @Value("${path.upload.diretory}")
    public String ServerUploadDirectoryRoot;

    public enum DitetoryType {
        CATEGORY("category"),
        USER("user"),
        POST("post");
        private final String value;

        DitetoryType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public String uploadImage(MultipartFile file, UUID id, UploadImpl.DitetoryType ditetoryType) {

        if (!file.isEmpty() && id != null) {
            String fileName = id + "_" + file.getOriginalFilename();
            try {
                File diretory = new File(ServerUploadDirectoryRoot, ditetoryType.getValue());
                if (!diretory.exists()) {
                    diretory.mkdirs();
                }
                File serveFile = new File(diretory.getAbsolutePath() + File.separator + fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serveFile));
                stream.write(file.getBytes());
                stream.close();
                return "/upload/" + ditetoryType.getValue() + "/" + fileName;

            } catch (Exception ex) {
                throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "AN ERROR OCCURRED WHILE SAVING THE IMAGE TO THE SERVER", ex);
            }
        } else {
            throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "INVALID UPLOAD REQUEST FILE IS EMPTY OR ID NOT PROVIDED");
        }
    }
}


