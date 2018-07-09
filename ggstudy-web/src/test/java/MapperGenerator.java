import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.ConnectionFactory;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.JDBCConnectionFactory;

public class MapperGenerator {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		final boolean overwrite = true;
		File configFile = new File("/Users/xiachunjun/git/myself/ggstudy/ggstudy-web/src/test/resources/mysqlGeneratorConfig.xml");
		
		// System.out.println("config fiel is in : " +
		// configFile.getAbsoluteFile());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration configuration;
		try {
			configuration = cp.parseConfiguration(configFile);
//			 ConnectionFactory connectionFactory= new JDBCConnectionFactory(configuration.getContext("mysqlTables").getJdbcConnectionConfiguration());
//			 Connection conn= connectionFactory.getConnection();
//			 PreparedStatement pst= conn.prepareStatement("select column_name,column_comment,data_type from information_schema.columns where table_name='isv_voucher_0'");
//			 ResultSet rs= pst.executeQuery();
//			 while (rs.next()) {
//				 System.out.println(rs.getString(1));
//				 System.out.println(rs.getString(2));
//				 System.out.println(rs.getString(1));
//				rs.getString(1);
//			}
			 DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator mybatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
			mybatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
