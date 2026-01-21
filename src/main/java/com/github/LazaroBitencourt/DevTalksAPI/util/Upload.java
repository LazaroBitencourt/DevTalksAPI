package com.github.LazaroBitencourt.DevTalksAPI.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface Upload {
    String uploadFile(MultipartFile file, UUID id, String diretoryName);
}
