package com.bananApple.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @Description:IP工具类
 */
public class IpUtils
{

	private static Logger logger = LoggerFactory.getLogger(IpUtils.class);

	public static String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
	}

	/**
	 * @Description:获取服务器的ip地址
	 */
	public static String getServerIp()
	{
		String serverIp = "";
		List<String> ipList = new ArrayList<String>();
		try
		{
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)
			{
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)
				{
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()
							&& inetAddress.isSiteLocalAddress())
					{
						ipList.add(inetAddress.getHostAddress().toString());
					}

				}
			}
		}
		catch (SocketException ex)
		{
			logger.error(ex.getMessage(), ex);
		}
		if (ipList.size() == 0)
		{
			serverIp = "127.0.0.1";
		}
		else if (ipList.size() == 1)
		{
			serverIp = ipList.get(0);
		}
		else
		{
			serverIp = ipList.get(ipList.size() - 1);
		}

		return serverIp;
	}




	public class Result
	{

		boolean result;
		String resultCode;
		String msg;

		private Result()
		{
			super();
		}

		private Result(boolean reulst, String resultCode, String msg)
		{
			super();
			this.result = reulst;
			this.resultCode = resultCode;
			this.msg = msg;
		}

		public boolean isResult()
		{
			return result;
		}

		public void setResult(boolean result)
		{
			this.result = result;
		}

		public String getMsg()
		{
			return msg;
		}

		public void setMsg(String msg)
		{
			this.msg = msg;
		}

		public String getResultCode()
		{
			return resultCode;
		}

		public void setResultCode(String resultCode)
		{
			this.resultCode = resultCode;
		}

	}
}
