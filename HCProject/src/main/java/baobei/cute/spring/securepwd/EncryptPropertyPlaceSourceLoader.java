package baobei.cute.spring.securepwd;

import baobei.cute.utils.DESUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by tangminyan on 2019/4/29.
 */
@Slf4j
public class EncryptPropertyPlaceSourceLoader extends PropertiesPropertySourceLoader {
    //需要加密的字段数组
    private String[] encryptPropNames = {"spring.datasource.password", "spring.rabbitmq.password"};

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if(profile == null) {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            if(!properties.isEmpty()) {
                for (String propName : encryptPropNames) {
                    if(properties.keySet().contains(propName)) {
                        String tmp = properties.getProperty(propName);
                        try {
                            String val = DESUtil.getDecryptString(tmp);
                            properties.put(propName, val);
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
                return new PropertiesPropertySource(name, properties);
            }
        }
        return null;
    }

    /**
     * 是否加密（备用方法）
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptPropNames) {
            if(encryptPropName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}
