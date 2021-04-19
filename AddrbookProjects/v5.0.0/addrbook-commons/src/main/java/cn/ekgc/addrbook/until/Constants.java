package cn.ekgc.addrbook.until;

import java.io.InputStream;
import java.util.Properties;

/**
 * <b>常量工具类</b>
 * @version 5.0.0
 */
public class Constants {
	private static Properties props = new Properties();

	static {
		try {
			InputStream in = Constants.class.getClassLoader().getResourceAsStream("addrbook.properties");
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>分页信息：默认当前页码</b>
	 */
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));

	/**
	 * <b>分页信息：默认每页显示数量</b>
	 */
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));
}
