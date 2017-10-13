package com.gafis

import com.gafis.jettyserver.ServerSupport
import com.gafis.utils.{CommonUtils, Constant}
import org.slf4j.LoggerFactory

/**
  * Created by Administrator on 2017/9/17.
  */
object App extends ServerSupport{
  def main(args: Array[String]): Unit = {
    val logger = LoggerFactory getLogger getClass
    Constant.getWebConfig
    logger.info("Server Starting......")

    val classes = List[Class[_]](
      Class.forName("com.gafis.ServiceModule"),
      Class.forName("stark.webservice.StarkWebServiceModule")
    )
    val webConfig = Constant.webConfig
    webConfig match{
      case Some(m) =>
        startServer(m,"gafis",classes:_*)

        logger.info("Rest DOCK server started ")
        CommonUtils.printTextWithNative(logger,Constant.LOGO)
        join
      case _ =>
        logger.error("GET Config None")
    }
  }
}
