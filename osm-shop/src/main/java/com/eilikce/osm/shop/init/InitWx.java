package com.eilikce.osm.shop.init;

import org.apache.log4j.Logger;

import com.qcloud.weapp.Configuration;
import com.qcloud.weapp.ConfigurationException;
import com.qcloud.weapp.ConfigurationManager;

/**
 * 初始化微信SDK
 * @author Eilik
 *
 */
public class InitWx {
	private String serverHost;
	private String authServerUrl;
	private String tunnelServerUrl;
	private String tunnelSignatureKey;
	private int networkTimeout;

	private static Logger logger = Logger.getLogger(InitWx.class);
	
	/**
	 * 微信SDK初始化方法
	 */
	public void init() {
		Configuration configuration = new Configuration();

		// 业务服务器访问域名
		configuration.setServerHost(serverHost);
		// 鉴权服务地址
		configuration.setAuthServerUrl(authServerUrl);
		// 信道服务地址
		configuration.setTunnelServerUrl(tunnelServerUrl);
		// 信道服务签名 key
		configuration.setTunnelSignatureKey(tunnelSignatureKey);
		// 网络请求超时设置，单位为秒
		configuration.setNetworkTimeout(networkTimeout);

		try {
			ConfigurationManager.setup(configuration);
		} catch (ConfigurationException e) {
			logger.error("微信配置时产生的异常",e);
		}
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public String getAuthServerUrl() {
		return authServerUrl;
	}

	public void setAuthServerUrl(String authServerUrl) {
		this.authServerUrl = authServerUrl;
	}

	public String getTunnelServerUrl() {
		return tunnelServerUrl;
	}

	public void setTunnelServerUrl(String tunnelServerUrl) {
		this.tunnelServerUrl = tunnelServerUrl;
	}

	public String getTunnelSignatureKey() {
		return tunnelSignatureKey;
	}

	public void setTunnelSignatureKey(String tunnelSignatureKey) {
		this.tunnelSignatureKey = tunnelSignatureKey;
	}

	public int getNetworkTimeout() {
		return networkTimeout;
	}

	public void setNetworkTimeout(int networkTimeout) {
		this.networkTimeout = networkTimeout;
	}

}
