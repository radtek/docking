package com.gafis.internal

import java.io.{PrintWriter, StringWriter}

/**
  * Created by Administrator on 2017/9/18.
  */
object ExceptionUtil {
  /**
    * 获取异常信息
    *
    * @param e 异常
    */
  def getStackTraceInfo(e: Exception): String = {
    var info = ""
    val writer = new StringWriter
    val printWriter = new PrintWriter(writer,true)
    try{
      e.printStackTrace(printWriter)
      info = writer.toString
      printWriter.flush
      writer.flush
    }
    catch {
      case exception: Exception => {
        exception.printStackTrace()
      }
    } finally {
      if (printWriter != null) printWriter.close()
      if (writer != null) writer.close()
    }
    info
  }
}
