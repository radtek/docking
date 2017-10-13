package com.gafis.config

import javax.xml.bind.annotation._

/**
  * Created by Administrator on 2017/9/17.
  */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebConfig")
@XmlRootElement
class WebConfig {

  @XmlElement(name = "web")
  var web: Web = new Web

  @XmlElement(name = "webservice")
  var webservice: Webservice = new Webservice
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "Web")
  class Web{
    @XmlElement(name = "bind")
    var bind: String = _
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "Webservice")
  class Webservice{
    @XmlElement(name = "cron")
    var cron: String = _
    @XmlElement(name = "url")
    var url: String = _
    @XmlElement(name = "target_namespace")
    var target_namespace: String = _
    @XmlElement(name = "username")
    var username: String = _
    @XmlElement(name = "password")
    var password: String = _
  }

