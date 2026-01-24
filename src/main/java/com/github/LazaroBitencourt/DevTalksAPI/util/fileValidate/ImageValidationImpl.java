package com.github.LazaroBitencourt.DevTalksAPI.util.fileValidate;

import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@Slf4j
@Component
public class ImageValidationImpl implements ImageValidation {

    private final Set<String> ALLOWED_FILETYPES =
            Set.of(MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE);

    private final Tika TIKA = new Tika();

    public void validate(MultipartFile multipartFile) {
        log.info("[start] ImageValidationUtilImpl - validate");
        if (!(multipartFile == null) && !multipartFile.isEmpty()) {
            try (InputStream inputStream = multipartFile.getInputStream()) {
                String mimeType = TIKA.detect(inputStream);
                if (!ALLOWED_FILETYPES.contains(mimeType)) {
                    throw APIException.build(HttpStatus.BAD_REQUEST,
                            "INVALID FILE TYPE. ONLY JPEG/PNG ARE ALLOWED.");
                }
            } catch (IOException ex) {
                throw APIException.build(HttpStatus.BAD_REQUEST,
                        "UNABLE TO DETECT FILE TYPE", ex);
            }
        }
        log.info("[finish] ImageValidationUtilImpl - validate");
    }
}
