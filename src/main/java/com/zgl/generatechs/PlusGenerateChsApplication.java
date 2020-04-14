package com.zgl.generatechs;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.zgl.generatechs.config.GenerateDataSourceConfig;
import com.zgl.generatechs.config.PlusGenerateConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * 运行此mian方法可以自动生成mybaits-plus相关的java bean代码
 *
 */
@SpringBootApplication
public class PlusGenerateChsApplication {

    public static void main(String[] args) {
        //读取配置文件
        ConfigurableApplicationContext run = SpringApplication.run(PlusGenerateChsApplication.class, args);
        PlusGenerateConfig plusGenerateConfig = run.getBean(PlusGenerateConfig.class);
        GenerateDataSourceConfig generateDataSourceConfig = run.getBean(GenerateDataSourceConfig.class);
        // 代码生成器
        System.out.println("====================================开始生成代码文件================================================");
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        if (StringUtils.isBlank(plusGenerateConfig.getOutputDir())){
            String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath + "/src/main/code");
        }else {
            gc.setOutputDir(plusGenerateConfig.getOutputDir());
        }
        gc.setAuthor(plusGenerateConfig.getAuthor());
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        gc.setSwagger2(Boolean.parseBoolean(plusGenerateConfig.getSwaggerOpen()));
        gc.setFileOverride(Boolean.parseBoolean(plusGenerateConfig.getFileOverride()));
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(generateDataSourceConfig.getUrl());
        dsc.setDriverName(generateDataSourceConfig.getDriverClassName());
        dsc.setUsername(generateDataSourceConfig.getName());
        dsc.setPassword(generateDataSourceConfig.getPassword());
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(Boolean.parseBoolean(plusGenerateConfig.getLombokModel()));
        String includeTables = plusGenerateConfig.getInclude();
        if (StringUtils.isNotBlank(includeTables)){
            String[] tableArray = includeTables.split(",");
            strategy.setInclude(tableArray);
        }
        if (StringUtils.isNotBlank(plusGenerateConfig.getTablePrefix())){
            strategy.setTablePrefix(plusGenerateConfig.getTablePrefix());
        }
        if (StringUtils.isNotBlank(plusGenerateConfig.getFieldPrefix())){
            strategy.setFieldPrefix(plusGenerateConfig.getFieldPrefix());
        }
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(plusGenerateConfig.getModuleName());
        pc.setParent(plusGenerateConfig.getParent());
        mpg.setPackageInfo(pc);
        mpg.execute();
        System.out.println("====================================·结束生成代码文件================================================");
    }

}
