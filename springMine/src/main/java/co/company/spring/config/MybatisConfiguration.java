package co.company.spring.config;

import java.io.IOException;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"co.company.**.dao"})
public class MybatisConfiguration {

	@Autowired
	ApplicationContext applicationContext;

	@Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/*.xml"));
        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
    	// sqlSession : JdbcTemplate 와 같은 역할을 해주는 클래스
    	// MapperScan ? 에서 중요한게 sqlSession. MyBatis에서 지원해줌.

        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
