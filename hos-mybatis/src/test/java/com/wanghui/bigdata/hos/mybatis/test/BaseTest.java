package com.wanghui.bigdata.hos.mybatis.test;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wanghui.bigdata.hos.mybatis.HosDataSourceConfig;

/**
 * Created by jixin on 18-3-8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(HosDataSourceConfig.class)
@PropertySource("classpath:application.properties")
@ComponentScan("com.wanghui.bigdata.*")
@MapperScan("com.wanghui.bigdata.*")
public class BaseTest {

}
