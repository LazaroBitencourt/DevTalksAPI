package com.github.LazaroBitencourt.DevTalksAPI.util.fileResponse;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;

public interface FileResponseUtil {
    public String getContentType(HttpServletRequest request, Resource resource);
    public String getHeaderValue(Resource resource);
}
