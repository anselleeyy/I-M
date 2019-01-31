package cn.ltysyn.infiniti.common.props;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "security.oauth2")
public class PermitUrlProperties {

	/**
	 * 监控中心和 swagger 需要访问的 url
	 */
	private static final String[] ENDPOINTS = { "/**/v2/api-docs/**", "/**/swagger-ui.html" };

	private String[] ignored;

	/**
	 * 需要放开权限的url
	 *
	 * @param urls 自定义的url
	 * @return 自定义的url和监控中心需要访问的url集合
	 */
	public String[] getIgnored() {
		if (ignored == null || ignored.length == 0) {
			return ENDPOINTS;
		}

		List<String> list = new ArrayList<>();
		for (String url : ENDPOINTS) {
			list.add(url);
		}
		for (String url : ignored) {
			list.add(url);
		}

		return list.toArray(new String[list.size()]);
	}

	public void setIgnored(String[] ignored) {
		this.ignored = ignored;
	}

}
