// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/** 
 * className: DataSourceConfig<br/>
 * Description: 数据源配置<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月13日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	
	// logger
	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	@Autowired
	private JDBCConfig config;
	
	/**
	 * Description：声明dataSource<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	@Bean(initMethod="init", destroyMethod="close")
	public DataSource createDataSource() {
		try {
			// 使用alibb druid数据源
			logger.info("init datasource start .......");
			DruidDataSource dataSource = new DruidDataSource();
			dataSource.setDriverClassName(config.driverClass);
			dataSource.setUrl(config.url);
			dataSource.setUsername(config.userName);
			dataSource.setPassword(config.password);
			dataSource.setInitialSize(config.initSize);
			dataSource.setMinIdle(config.minIdle);
			dataSource.setMaxActive(config.maxActive);
			dataSource.setMaxWait(config.maxWait);
			dataSource.setTimeBetweenEvictionRunsMillis(config.timeBetweenEvictionRunsMillis);
			dataSource.setMinEvictableIdleTimeMillis(config.minEvictableIdleTimeMillis);
			dataSource.setTestWhileIdle(config.testWhileIdle);
			dataSource.setTestOnBorrow(config.testOnBorrow);
			dataSource.setTestOnReturn(config.testOnReturn);
			dataSource.setPoolPreparedStatements(config.poolPreparedStatements);
			dataSource.setMaxPoolPreparedStatementPerConnectionSize(config.maxPoolPreparedStatementPerConnectionSize);
			dataSource.setRemoveAbandoned(config.removeAbandoned);
			dataSource.setRemoveAbandonedTimeout(config.removeAbandonedTimeout);
			dataSource.setLogAbandoned(config.logAbandoned);
			dataSource.setFilters(config.filters);
			logger.info("init datasource end .......");
			return dataSource;
		} catch (Exception e) {
			logger.error(String.format("初始化数据源异常 cause:%s", e.getMessage()), e);
		}
		return null;
	}
	
	/**
	 * className: JDBCConfig<br/>
	 * Description: JDBC配置参数<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年7月13日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	@Component
	@PropertySource("classpath:property/datasource.properties")
	static class JDBCConfig {
		
		// 数据库驱动
		@Value("${datasource.driverClassName}")
		private String driverClass;
		// 数据库url
		@Value("${datasource.url}")
		private String url;
		// 数据库登录用户名
		@Value("${datasource.username}")
		private String userName;
		// 数据库登录密码
		@Value("${datasource.password}")
		private String password;
		
		// 数据源初始化大小
		@Value("${druid.initialSize}")
		private int initSize;
		// 连接池最小空闲
		@Value("${druid.minIdle}")
		private int minIdle;
		// 最大连接数
		@Value("${druid.maxActive}")
		private int maxActive;
		// 连接最大等待时间（配置获取连接等待超时的时间） 单位：毫秒
		@Value("${druid.maxWait}")
		private long maxWait;
		// 逐出连接的检测时间间隔（配置间隔多久才进行一次检测，检测需要关闭的空闲连接）单位：毫秒
		@Value("${druid.timeBetweenEvictionRunsMillis}")
		private long timeBetweenEvictionRunsMillis;
		// 最小逐出时间（配置一个连接在池中最小生存的时间）单位：毫秒
		@Value("${druid.minEvictableIdleTimeMillis}")
		private long minEvictableIdleTimeMillis;
		// 连接空闲时测试是否有效
		@Value("${druid.testWhileIdle}")
		private boolean testWhileIdle; 
		// 获取连接时测试是否有效
		@Value("${druid.testOnBorrow}")
		private boolean testOnBorrow;
		// 归还连接时是否测试有效
		@Value("${druid.testOnReturn}")
		private boolean testOnReturn;
		// 是否打开PSCache
		@Value("${druid.poolPreparedStatements}")
		private boolean poolPreparedStatements;
		// Statement缓存大小
		@Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
		private int maxPoolPreparedStatementPerConnectionSize;
		// 打开removeAbandoned功能
		@Value("${druid.removeAbandoned}")
		private boolean removeAbandoned;
		// 连接泄漏的超时时间（1800秒，也就是30分钟） 单位：秒
		@Value("${druid.removeAbandonedTimeout}")
		private int removeAbandonedTimeout;
		// 关闭泄漏的连接时打印堆栈信息（关闭abanded连接时输出错误日志）
		@Value("${druid.logAbandoned}")
		private boolean logAbandoned;
		// 连接池扩展（配置监控统计拦截的filters）
		@Value("${druid.filters}")
		private String filters;
		/**
		 * @return the driverClass
		 */
		public String getDriverClass() {
			return driverClass;
		}
		/**
		 * @param driverClass the driverClass to set
		 */
		public void setDriverClass(String driverClass) {
			this.driverClass = driverClass;
		}
		/**
		 * @return the url
		 */
		public String getUrl() {
			return url;
		}
		/**
		 * @param url the url to set
		 */
		public void setUrl(String url) {
			this.url = url;
		}
		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}
		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the initSize
		 */
		public int getInitSize() {
			return initSize;
		}
		/**
		 * @param initSize the initSize to set
		 */
		public void setInitSize(int initSize) {
			this.initSize = initSize;
		}
		/**
		 * @return the minIdle
		 */
		public int getMinIdle() {
			return minIdle;
		}
		/**
		 * @param minIdle the minIdle to set
		 */
		public void setMinIdle(int minIdle) {
			this.minIdle = minIdle;
		}
		/**
		 * @return the maxActive
		 */
		public int getMaxActive() {
			return maxActive;
		}
		/**
		 * @param maxActive the maxActive to set
		 */
		public void setMaxActive(int maxActive) {
			this.maxActive = maxActive;
		}
		/**
		 * @return the maxWait
		 */
		public long getMaxWait() {
			return maxWait;
		}
		/**
		 * @param maxWait the maxWait to set
		 */
		public void setMaxWait(long maxWait) {
			this.maxWait = maxWait;
		}
		/**
		 * @return the timeBetweenEvictionRunsMillis
		 */
		public long getTimeBetweenEvictionRunsMillis() {
			return timeBetweenEvictionRunsMillis;
		}
		/**
		 * @param timeBetweenEvictionRunsMillis the timeBetweenEvictionRunsMillis to set
		 */
		public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
			this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
		}
		/**
		 * @return the minEvictableIdleTimeMillis
		 */
		public long getMinEvictableIdleTimeMillis() {
			return minEvictableIdleTimeMillis;
		}
		/**
		 * @param minEvictableIdleTimeMillis the minEvictableIdleTimeMillis to set
		 */
		public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
			this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
		}
		/**
		 * @return the testWhileIdle
		 */
		public boolean isTestWhileIdle() {
			return testWhileIdle;
		}
		/**
		 * @param testWhileIdle the testWhileIdle to set
		 */
		public void setTestWhileIdle(boolean testWhileIdle) {
			this.testWhileIdle = testWhileIdle;
		}
		/**
		 * @return the testOnBorrow
		 */
		public boolean isTestOnBorrow() {
			return testOnBorrow;
		}
		/**
		 * @param testOnBorrow the testOnBorrow to set
		 */
		public void setTestOnBorrow(boolean testOnBorrow) {
			this.testOnBorrow = testOnBorrow;
		}
		/**
		 * @return the testOnReturn
		 */
		public boolean isTestOnReturn() {
			return testOnReturn;
		}
		/**
		 * @param testOnReturn the testOnReturn to set
		 */
		public void setTestOnReturn(boolean testOnReturn) {
			this.testOnReturn = testOnReturn;
		}
		/**
		 * @return the poolPreparedStatements
		 */
		public boolean isPoolPreparedStatements() {
			return poolPreparedStatements;
		}
		/**
		 * @param poolPreparedStatements the poolPreparedStatements to set
		 */
		public void setPoolPreparedStatements(boolean poolPreparedStatements) {
			this.poolPreparedStatements = poolPreparedStatements;
		}
		/**
		 * @return the maxPoolPreparedStatementPerConnectionSize
		 */
		public int getMaxPoolPreparedStatementPerConnectionSize() {
			return maxPoolPreparedStatementPerConnectionSize;
		}
		/**
		 * @param maxPoolPreparedStatementPerConnectionSize the maxPoolPreparedStatementPerConnectionSize to set
		 */
		public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
			this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
		}
		/**
		 * @return the removeAbandoned
		 */
		public boolean isRemoveAbandoned() {
			return removeAbandoned;
		}
		/**
		 * @param removeAbandoned the removeAbandoned to set
		 */
		public void setRemoveAbandoned(boolean removeAbandoned) {
			this.removeAbandoned = removeAbandoned;
		}
		/**
		 * @return the removeAbandonedTimeout
		 */
		public int getRemoveAbandonedTimeout() {
			return removeAbandonedTimeout;
		}
		/**
		 * @param removeAbandonedTimeout the removeAbandonedTimeout to set
		 */
		public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
			this.removeAbandonedTimeout = removeAbandonedTimeout;
		}
		/**
		 * @return the logAbandoned
		 */
		public boolean isLogAbandoned() {
			return logAbandoned;
		}
		/**
		 * @param logAbandoned the logAbandoned to set
		 */
		public void setLogAbandoned(boolean logAbandoned) {
			this.logAbandoned = logAbandoned;
		}
		/**
		 * @return the filters
		 */
		public String getFilters() {
			return filters;
		}
		/**
		 * @param filters the filters to set
		 */
		public void setFilters(String filters) {
			this.filters = filters;
		}
	}
}
