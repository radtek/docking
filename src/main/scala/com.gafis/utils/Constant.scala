package com.gafis.utils

import java.io.File

import com.gafis.config.WebConfig
import com.gafis.java.XMLParser

/**
  * Created by Administrator on 2017/9/17.
  */
object Constant {
  var webConfig:Option[WebConfig] = None


  final val LOGO = """ #
    .___             __
  __| _/____   ____ |  | __
 / __ |/  _ \_/ ___\|  |/ /
/ /_/ (  <_> )  \___|    <
\____ |\____/ \___  >__|_ \ module : |@@|red %s|@#
     \/           \/     \/ version: |@@|green %s|@
                   """.replaceAll("#", "@|green ")

  final val EMPTY = ""

  def getWebConfig(): Unit ={
    val serverHome = System.getProperty("server.home","config")
    val file = new File(serverHome + "/webconfig.xml")
    val obj = XMLParser.xmlToBean(file,classOf[WebConfig])
    webConfig = Some(obj.asInstanceOf[WebConfig])
  }
}
