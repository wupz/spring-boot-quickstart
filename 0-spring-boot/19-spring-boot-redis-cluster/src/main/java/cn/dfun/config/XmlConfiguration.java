package cn.dfun.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
@Configuration
@ImportResource(locations={"classpath:applicationContext-jedis.xml"})
public class XmlConfiguration {

}
