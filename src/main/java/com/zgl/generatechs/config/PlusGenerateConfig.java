package com.zgl.generatechs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author zgl
 * @Date 2020/4/12 12:28
 * @Version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "plusconfig")
public class PlusGenerateConfig {

    private String parent;

    private String moduleName;

    private String outputDir;

    private String swaggerOpen;

    private String lombokModel;

    private String fileOverride;

    private String author;

    private String include;

    private String tablePrefix;

    private String fieldPrefix;

}
