package me.puras.mo.common.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  上午11:08
 */
public class IOUtils {
    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) try {
            closeable.close();
        } catch (Throwable t) {
            throw new IOException("exception occurred while trying to close resource.", t);
        }

    }
}
