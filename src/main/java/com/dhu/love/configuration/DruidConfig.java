package com.dhu.love.configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DruidConfig {
    @Autowired
    private Environment environment;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.druid.filter}")
    private String filter;

    @Value("${spring.datasource.druid.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.druid.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.druid.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.druid.maxWait}")
    private String maxWait;

    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Bean(name="DataSource")
    public DataSource getDataSource() throws SQLException {
        DruidDataSource dataSource =new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //dataSource.setConnectProperties(Properties.Entry());
        dataSource.setFilters(filter);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setKeepAlive(true);
        List<Filter> filterList=new ArrayList();
        filterList.add(getWallFilter());
        dataSource.setProxyFilters(filterList);
        return dataSource;
    }

    private WallFilter getWallFilter() {
        WallConfig wallConfig =new WallConfig();
        wallConfig.setSelectAllColumnAllow(true);
        wallConfig.setSelectIntoAllow(false);
        wallConfig.setDeleteAllow(true);
        wallConfig.setUpdateAllow(true);
        wallConfig.setInsertAllow(true);
        wallConfig.setReplaceAllow(false);
        wallConfig.setMergeAllow(false);
        wallConfig.setSetAllow(true);
        wallConfig.setTruncateAllow(false);
        wallConfig.setCreateTableAllow(false);
        wallConfig.setAlterTableAllow(false);
        wallConfig.setDropTableAllow(false);

        wallConfig.setCallAllow(true);
        wallConfig.setNoneBaseStatementAllow(false);
        wallConfig.setSelectIntoOutfileAllow(false);

        wallConfig.setMustParameterized(true);
        wallConfig.setMetadataAllow(false);
        wallConfig.setWrapAllow(false);

        wallConfig.setCommentAllow(true);
        wallConfig.setCommitAllow(true);
        wallConfig.setMultiStatementAllow(true);
        wallConfig.setRollbackAllow(true);

        wallConfig.setSelectWhereAlwayTrueCheck(true);

        WallFilter wallFilter=new WallFilter();
        wallFilter.setConfig(wallConfig);
        wallFilter.setDbType(JdbcConstants.MYSQL);
        return wallFilter;

    }

    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean servletRegistrationBean =new ServletRegistrationBean();
        servletRegistrationBean.addUrlMappings("/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername",environment.getProperty("spring.datasource.druid.username"));
        servletRegistrationBean.addInitParameter("loginPassword",environment.getProperty("spring.datasource.druid.password"));
        servletRegistrationBean.addInitParameter("logSlowSql",environment.getProperty("spring.datasource.druid.logSlowSql"));
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean =new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addUrlPatterns("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }



}
