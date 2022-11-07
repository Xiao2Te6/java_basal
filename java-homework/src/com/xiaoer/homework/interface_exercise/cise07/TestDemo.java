package com.xiaoer.homework.interface_exercise.cise07;

/**
 * 现有中国电信(ChinaTelecom),中国移动(ChinaMobile),中国联通(ChinaUnicom)
 * 他们都属于网络运营商(NetworkOperator),   都有各自的网络类型(type),
 * 比如：
 * 中国电信的网络类型为LTE,
 * 中国移动的网络类型为TD-LTE,
 * 中国联通的网络类型为WCDMA.
 * 网络运营商都有安装宽带(installBroadband)和安装有线电视(installCableTV)的行为.
 * 网络运营商都实现了上网(IInternet)和打电话(ICall)的功能,
 * 此外,中国移动通过飞信实现了聊天(IChat)的功能.
 */
public class TestDemo  {
    public static void main(String[] args) {
        ChinaMobile chianMobile = new ChinaMobile("中国移动","TD-LTE");
        chianMobile.call();
        chianMobile.internet();
        chianMobile.chat();
        System.out.println("-----------------------------------");

        ChinaTelecom chinaTelecom = new ChinaTelecom("中国电信", "LTE");
        chinaTelecom.call();
        chinaTelecom.internet();
        System.out.println("-----------------------------------");

        ChinaUnicom chinaUnicom = new ChinaUnicom("中国联通", "WCDMA");
        chinaUnicom.call();
        chinaUnicom.internet();
    }
}
