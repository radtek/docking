package com.gafis.internal

import com.gafis.services.HandprintService
import com.gafis.socket.Gafis6NetRequest
import com.gafis.utils.{Constant, Loggers}
import org.apache.tapestry5.ioc.annotations.PostInjection
import org.apache.tapestry5.ioc.services.cron.{CronSchedule, PeriodicExecutor}
import stark.webservice.services.StarkWebServiceClient

/**
  * Created by Administrator on 2017/9/17.
  */
class HttpClientImpl() extends Loggers{
  val url = Constant.webConfig.get.webservice.url
  val targetNamespace = Constant.webConfig.get.webservice.target_namespace
  val userId = Constant.webConfig.get.webservice.username
  val password = Constant.webConfig.get.webservice.password
  val client = StarkWebServiceClient.createClient(classOf[HandprintService], url, targetNamespace)


  /**
    * 定时器，调用海鑫现勘接口
    *
    * @param periodicExecutor
    */
  @PostInjection
  def startUp(periodicExecutor: PeriodicExecutor): Unit = {
    if (Constant.webConfig.get.webservice.cron != null)
      periodicExecutor.addJob(new CronSchedule(Constant.webConfig.get.webservice.cron), "httpclient-cron", new Runnable {
        override def run(): Unit = {
          info("begin sync-cron")
          try {
            info("after sync-cron")
            val int = client.getOriginalDataCount(userId, password, "123", "", "", "")
            info(int.toString)
            info("after sync-cron")
          } catch {
            case e: Exception =>
              error(ExceptionUtil.getStackTraceInfo(e))
          }
          info("end sync-cron")
        }
      })
  }
}

