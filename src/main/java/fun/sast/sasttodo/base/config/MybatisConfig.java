package fun.sast.sasttodo.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("fun.sast.sasttodo.*.mapper")
public class MybatisConfig {
}