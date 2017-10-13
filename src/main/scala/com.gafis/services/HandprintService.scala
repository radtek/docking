package com.gafis.services

import javax.jws.{WebMethod, WebService}

/**
  * 对接接口
  * rpc http client
  * Created by Administrator on 2017/9/17.
  */
@WebService(serviceName = "xkdocking", targetNamespace = "http://www.xkdocking.com")
trait HandprintService {
  /**
    * 数量获取服务
    * @param UserName
    * @param Password
    * @param UnitCode
    * @param KNO
    * @param UpdateTimeFrom
    * @param UpdateTimeTo
    * @return
    */
  @WebMethod def getOriginalDataCount(UserName: String, Password: String, UnitCode: String, KNO: String, UpdateTimeFrom: String, UpdateTimeTo: String): Int
}
