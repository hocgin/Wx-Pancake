package in.hocg.defaults.dialect;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * Created by hocgin on 16-12-19.
 */
public class MySQL5DialectUTF8 extends MySQL5Dialect {
	@Override
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
}
