package com.github.LazaroBitencourt.DevTalksAPI.util.fileResponse;

import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FileResponseUtilImpl implements FileResponseUtil {
    @Override
    public String getContentType(HttpServletRequest request, Resource resource) {
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR WHILE ACCESSING FILE", ex);
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return contentType;
    }

    @Override
    public String getHeaderValue(Resource resource) {
        return "attachment; fileName=\"" + resource.getFilename() + "\"";
    }
}
