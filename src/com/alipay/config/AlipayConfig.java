package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2021000118610171";
			
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC7NLU15ab98PhxfqBI0cUU/6w/+4rngeGRvzp4D4IpgWrRCAYJgZQSMNFXod0ouyXdO1KKtaX/TOwPaAyAH7iT+gc/zsYL3T5XIE2GzT4KD3KMFkQvX5XfCT/AAhrMoYRHmodbbfNIAzOxaqsmKWvhmMWcuNkorWDnbcxQTMZPq0341EvRtjtwSy+ok0MY9FLv1RUlGs60sj/K/k2MP3bFJrFP0ApfF86mQd8+IopbB5lo6BX0PpektXMcN0D7hLMLaRneubAtPGO5ZkpYvrKdy2niXpUcL3/edeIY8Pjn30GUlxioYMTgMOjfeVf6/q2IbBeUgU9Cga+gIJda7T4bAgMBAAECggEAY0ZGOni4n73j4jvmP/eN7d7Pt3ZraO2Fc0bXeMewnNYWkRcSLIRcw3DD8xbRM0JbiABne0ts5gAixuDEkEVCGqbipUG/4JbI8mcc9blthuQ+OG+uZPjpf0dmWSpEj/OvNFGMKj4aXzvjc9g/PpOEtDPRx5R3BI088D1XtdWg7Knf1kjqjMaQBOrvxz15WvBCX/F2j3Tzea2mna1VafkTVSkzT0XSjd9ytqidQRyCfpBr2nzYCD3QYcDIfrKA5XnIaEkRPPcSQoJqyqvtwSlWN9H/4uL+rF9tAy49kuadn+xLT+yaqsNg0FhJWvZj+6KVDHDYt/1fLktvAdaIjJBp8QKBgQDy1ODd5zedelj3m4LuwzgAt9zI7x8tEDCPeUqKkfxscg+2PiHpazV5WMdNgv6BTYDobyKhZdICl1eVpxyetBGZgY9wyVR9PCQWEVvcH8fYc/aB/r2Y+s8m/9UUWONIYilQPp78mOOgLV/ngiWR8liINSOgIfwkptSl8uM0hJlFXwKBgQDFW5pw8/0WHqTbAG3b+HCh8oYevaPOcDbJ2tgGKUD0F5FuPcPcIGAF+CuIN1HL1T4h71IzveRk2hcenxVNymI3tZgAwRD+9ImKH6zKQsDKNviamRPtmCzoOTEkuGBr1lNRG5JZu9qyBpcB123MWopqOEtrURAYrnv8KHKnkbakxQKBgHSY2tAx8XZgBM//j8LtYbqWjiC9EI8msupxJuWaa0X3DqxG8SmPHMIDas9BEssrV7ZDhrFQnqI34Qouj4N0mu7GUwWo5jSr5/fgpebwK5k3NSn+EzOdWlIzjTCT7a4X1BZ/uv82ujVzFBWpXDjT0Ma2HUEKkHNY18pG8emJsb6pAoGBALBYJIyvBsKACTAClydJO2MJcFwBeV+ZlusQl5wRuo8gi/skR2DmsMZEtKkXPQhT9xudWycOkwimcqgS35dNsiszIKnz2TrmyAraOKvVr6xAKC0DgPH42o95ova7pLRWosXDTCbQGx6dksq7csl5UVqOCJ3QpgBX0ENE5QXjxn49AoGAf6VGUl1tWC5EG16suK6gDO4VN74x4a1quqczRIMjhJRpHoZSJyQDp+WQmVfmCWBPkDD5y3pTV7Ry34lqhcJOdVB1r53opIdjNuz/C+BfiDmJmFcYGEdtTsGzpHmbeBKZFKacII5rMacWM0J3BLiAonP6kO6aHudBcGcBxuyP3B0=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/Vivo/next.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/Vivo/next.html";

	// 签名方式
	public static String sign_type = "RSA";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

