package com.lupf.springboot.common.constent;

/**
 * @author LENOVO
 * @title: StatusTest
 * @projectName springcloud-mbb
 * @description: TODO
 * @date 2020/12/2 23:35
 */
public class StatusTest {
    public static void main(String[] args) {
        IStatusCode baseStatusCode = BaseStatusCode.ERR_9999;
        IStatusCode userStatusCode = UserStatusCode.ERR_2000;
        IStatusCode deviceStatusCode = DeviceStatusCode.ERR_3002;
    }
}
