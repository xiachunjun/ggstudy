package com.ggstudy.jpa.common;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configurable
@EnableJpaRepositories(basePackages = {"hello"})
//@Import(RepositoryRestMvcConfiguration.class)
public class Application {

    private String dbPassword="cptopr";
    private String dbUserName="cptopr";
    private String dbUrl="jdbc:oracle:thin:@10.213.57.209:10521:zxdev";
    private String dbDriverClassName="oracle.jdbc.driver.OracleDriver";

    @Bean(name="dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setPassword(dbPassword);
        dataSource.setUsername(dbUserName);
        dataSource.setUrl(dbUrl);
        dataSource.setDriverClassName(dbDriverClassName);

//        <!--初始化连接数：默认为0，启动时创建的连接数,1.2版本之后才支持，建议初始1-->
//        <property name="initialSize" value="1"/>
        dataSource.setInitialSize(1);
//        <!--最大活跃连接数：默认为8，连接池同时可分配的最大连接数，如果设负数为无限制（不建议），建议15-->
//        <property name="maxActive" value="15"/>
//        dataSource.setMax
//        <!--最大空闲连接数：默认为8，连接池允许保留的的最大空闲连接数，如果设负数为无限制（不建议），建议接近maxActive-->
//        <property name="maxIdle" value="15"/>
        dataSource.setMaxIdle(15);
//        <!--最小空闲连接数：默认为0，连接池允许保留的的最小空闲连接数，建议5-->
//        <property name="minIdle" value="5"/>
        dataSource.setMinIdle(15);
//        <!--获取连接时的最大等待时间，默认无限制，单位milliseconds，建议5000/1000=5秒-->
//        <property name="maxWait" value="5000"/>
        dataSource.setMaxWaitMillis(500);
//        <!-- 是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除。建议开启 -->
//        <property name="testWhileIdle" value="true"/>
        dataSource.setTestWhileIdle(true);
//        <!-- 是否从连接池中取出连接前进行检验,如果检验失败, 则从池中去除连接并尝试取出另一个。建议开启-->
//        <property name="testOnBorrow" value="false"/>
        dataSource.setTestOnBorrow(false);
//        <!-- 是否在归还到连接池中前进行检验，建议开启上一项关闭此项 -->
//        <property name="testOnReturn" value="false"/>
        dataSource.setTestOnReturn(false);
//        <!-- 检测用SQL，验证从连接池取出的连接,在将连接返回给调用者之前，以上三项有一项为true时必须指定，mysql改用s.elect 1-->
//        <property name="validationQuery">
//        <value>select 1 from dual</value>
//        </property>
        dataSource.setValidationQuery("select 1 from dual");
//        <!--空闲连接回收器线程运行期间休眠的时间值，默认-1(不运行)，单位milliseconds(毫秒)，建议间隔10000/1000=10秒-->
//        <property name="timeBetweenEvictionRunsMillis" value="10000"/>
        dataSource.setTimeBetweenEvictionRunsMillis(10000);
//        <!--每次空闲连接回收器线程(如果有)运行时检查的连接数量，默认3，建议3-->
//        <property name="numTestsPerEvictionRun" value="3"/>
        dataSource.setNumTestsPerEvictionRun(3);
//        <!--连接在池中保持空闲而不被空闲连接回收器线程(如果有)回收的最小时间值，默认1000 * 60 * 30，单位milliseconds(毫秒)，建议使用默认值（可以不配此项）-->
//        <property name="minEvictableIdleTimeMillis" value="1800000"/>
        dataSource.setMinEvictableIdleTimeMillis(1800000);
//        <!--是否自动回收超时连接，建议开启-->
//        <property name="removeAbandoned" value="true"/>
        dataSource.setRemoveAbandonedOnBorrow(true);
//        <!--超时时间,默认300，单位seconds，建议60秒，如果有特殊需求的可以增加-->
//        <property name="removeAbandonedTimeout" value="60"/>
        dataSource.setRemoveAbandonedTimeout(60);

//        </bean>
        return dataSource;
    }

    @Bean
    @Autowired
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("hello");

        factory.setDataSource(dataSource);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurerAdapter() {

            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                config.setBasePath("/");
            }
        };
    }


    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
