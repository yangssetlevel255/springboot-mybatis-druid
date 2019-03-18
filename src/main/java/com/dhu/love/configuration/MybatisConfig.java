package com.dhu.love.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

//@Configuration
//@AutoConfigureAfter(name="DataSource")
public class MybatisConfig {

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("DataSource")DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        SqlSessionFactory sqlSessionFactory=null;
        try {
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
            sqlSessionFactory=sqlSessionFactoryBean.getObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory ;
    }

    @Bean(name="SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.dhu.love.manage");
        return mapperScannerConfigurer;
    }
}
