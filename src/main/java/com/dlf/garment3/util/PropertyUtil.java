package com.dlf.garment3.util;


import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by dlf on 2018/2/26 0026.
 * Email 1429264916@qq.com
 */
public class PropertyUtil {
    public static final Logger logger = Logger.getLogger(PropertyUtil.class);
    private static Properties props;

    public PropertyUtil() {
    }

    private static synchronized void loadProps() {
        logger.info("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;

        try {
            in = PropertyUtil.class.getClassLoader().getResourceAsStream("sqlConfig.properties");
            props.load(new InputStreamReader(in, "utf-8"));
        } catch (FileNotFoundException var12) {
            logger.error("jdbc.properties文件未找到");
        } catch (IOException var13) {
            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException var11) {
                logger.error("jdbc.properties文件流关闭出现异常", var11);
            }

        }

        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }

    public static String getPropery(String key) {
        if(null == props) {
            loadProps();
        }

        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }

        return props.getProperty(key, defaultValue);
    }

    static {
        loadProps();
    }
}
