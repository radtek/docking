package com.gafis

import com.gafis.internal.HttpClientImpl
import org.apache.tapestry5.ioc.ServiceBinder

/**
  * Created by Administrator on 2017/9/17.
  */
object ServiceModule {
  def bind(binder:ServiceBinder): Unit ={
    binder.bind(classOf[HttpClientImpl],classOf[HttpClientImpl]).eagerLoad()
  }
}
