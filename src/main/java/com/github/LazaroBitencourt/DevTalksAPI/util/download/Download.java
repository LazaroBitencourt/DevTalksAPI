package com.github.LazaroBitencourt.DevTalksAPI.util.download;

import org.springframework.core.io.Resource;

public interface Download {
    Resource downloadFile(String directoryName, String fileName);
}
