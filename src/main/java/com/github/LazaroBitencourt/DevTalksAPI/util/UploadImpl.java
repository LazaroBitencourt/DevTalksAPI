package com.github.LazaroBitencourt.DevTalksAPI.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Component
public class UploadImageImpl implements UploadImage {
    @Value("${path.upload.diretory}")
    private String ServerUploadDirectory;

    @Override
    public boolean uploadImage(MultipartFile file, UUID id) throws Exception {

        if (!file.isEmpty() && id != null) {
            String fileName = id.toString() + "_" + file.getOriginalFilename();
            try {
                File diretory = new File(ServerUploadDirectory);
                if (!diretory.exists()) {
                    diretory.mkdirs();
                    File serveFile = new File(diretory.getAbsolutePath() + File.separator + fileName);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serveFile));
                    stream.write(file.getBytes());
                    stream.close();
                    return true;
                }
            } catch (Exception ex) {
                throw new Exception("AN ERROR OCCURRED WHILE SAVING THE IMAGE TO THE SERVER");
            }
        }else if{
            throw new Exception("INVALID UPLOAD REQUEST FILE IS EMPTY OR ID NOT PROVIDED");
        }
       return false;
    }
}

