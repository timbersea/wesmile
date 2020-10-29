package com.qian.wesmile.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class FileAccessTokenManager implements AccessTokenManager {
    private static final Logger log = LoggerFactory.getLogger(FileAccessTokenManager.class);

    private static final File ACCESS_TOKEN_FILE = new File("access_toke.cache");

    static {
        createFile();
    }

    private static void createFile() {
        if (!ACCESS_TOKEN_FILE.exists()) {
            try {
                ACCESS_TOKEN_FILE.createNewFile();
            } catch (IOException e) {
                log.error("can't create cache access_token file,path:{}", ACCESS_TOKEN_FILE.getAbsolutePath());
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    @Override
    public String getAccessToken() {
        RandomAccessFile r = null;
        try {
            r = new RandomAccessFile(ACCESS_TOKEN_FILE, "r");
            long length = r.length();
            if (length <= 0) {
                return "null";
            } else {
                byte[] bytes = new byte[Math.toIntExact(length)];
                r.readFully(bytes);
                return new String(bytes);
            }
        } catch (IOException e) {
            log.warn("read access_token from file failed,reason:{},return null value,let's the framework correct it",
                    e.getMessage());
            return null;
        } finally {
            if (r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    //ignore it
                }
            }
        }
    }

    @Override
    public void saveAccessToken(String accessToken) {
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile(ACCESS_TOKEN_FILE, "rw");
            rw.seek(0);
            rw.setLength(0);
            rw.write(accessToken.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.warn("save to file {} failed,reason:{}", ACCESS_TOKEN_FILE.getAbsolutePath(), e.getMessage());
            log.warn("save failed,while next read will return an incorrect access token,cause at least 3 times http request get correct result");
        } finally {
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    //ignore it
                }
            }
        }
    }
}
