package me.puras.mo.common.util;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by puras on 6/28/16.
 */
public class MultipartUtils {
    public static void saveFile(MultipartFile multipartFile, File target) throws IOException {
        if (target.getParentFile() != null && !target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }
        final InputStream is = multipartFile.getInputStream();
        try {
            Files.copy(is, target.toPath());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    /**
     * 保存文件
     * @param multipartFile 要保存的文件
     * @param directory 文件保存目录
     * @return
     * @throws IOException
     */
    public static File saveFile(MultipartFile multipartFile, String directory) throws IOException {
        SavingStrategy strategy = new UUIDStrategy(directory);
        return saveFile(multipartFile, strategy);
    }

    /**
     * 保存文件
     * @param multipartFile 要保存的文件
     * @param strategy 文件保存使用的策略对象
     * @return
     * @throws IOException
     */
    public static File saveFile(MultipartFile multipartFile, SavingStrategy strategy) throws IOException {
        File targetFile = strategy.getTargetFile(multipartFile);
        saveFile(multipartFile, targetFile);
        return targetFile;
    }

    /**
     * 保存multipartRequest包含的全部文件
     * @param multipartRequest MultipartRequest请求对象
     * @param strategy 文件保存使用的策略对象
     * @throws IOException
     */
    public static void saveAllFiles(MultipartRequest multipartRequest, SavingStrategy strategy) throws IOException {
        MultiValueMap<String, MultipartFile> fileMap = multipartRequest.getMultiFileMap();
        for (Iterator<List<MultipartFile>> it = fileMap.values().iterator(); it.hasNext(); ) {
            List<MultipartFile> fileList = it.next();
            for (MultipartFile file : fileList) {
                saveFile(file, strategy.getTargetFile(file));
            }
        }
    }

    /**
     * 实现此类自定义保存策略
     */
    public interface SavingStrategy {
        File getTargetFile(MultipartFile multipartFile);
    }

    public static class UUIDStrategy implements SavingStrategy {

        private String parentDir;

        public UUIDStrategy(String parentDir) {
            this.parentDir = parentDir;
        }

        public File getTargetFile(MultipartFile multipartFile) {
            String fileName = multipartFile.getOriginalFilename();
            int lastDot = fileName.lastIndexOf(".");
            String suffix = lastDot == -1 ? "" : fileName.substring(lastDot);
            return new File(parentDir, UUID.randomUUID().toString() + suffix.toLowerCase());

        }
    }
}
