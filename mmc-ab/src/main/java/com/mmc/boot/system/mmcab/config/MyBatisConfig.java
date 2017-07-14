// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** 
 * className: MyBatisConfig<br/>
 * Description: mybatis配置<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月13日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
@Configuration
@ConditionalOnClass({ EnableTransactionManagement.class, SqlSessionFactoryBean.class, SqlSessionFactory.class})
@AutoConfigureAfter({ DataSourceConfig.class })
public class MyBatisConfig {

	// logger
	private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);
	
	// 扫描mapper包
	private static String mapperScannerPackage = "com.mmc.boot.system.mmcab";
	private static String sqlMap_config = "classpath:sqlmap/sqlmap-config.xml";
//	private static String mapper_config = "classpath:sqlmap/mapper/*.xml";
	
	/**
	 * Description：sqlSesssionFactoryBean<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 * @throws IOException 
	 */
	@Bean("sqlSessionFactory")
	@ConditionalOnMissingBean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		try {
			SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
			sessionFactoryBean.setDataSource(dataSource);
			// 配置mapper中xml映射
//			sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(sqlMap_config));
			sessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(sqlMap_config));
			return sessionFactoryBean;
		} catch (Exception e) {
			logger.error("初始化sqlsessionFactoryBean 异常", e);
		}
		return null;
	}
	
	/**
	 * Description：自动扫描<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		configurer.setBasePackage(mapperScannerPackage);
		return configurer;
	}
	
	/**
	 * Description：事物管理<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	@Bean
    @ConditionalOnMissingBean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
