一台电脑同时运行多个tomcat配置方法:

1.使用压缩版的tomcat不能使用安装版的。

2.第一个tomcat的配置不变。

3.增加环境变量CATALINA_HOME2，值为新的tomcat的地址。

4.修改新的tomcat中的startup.bat，把其中的CATALINA_HOME改为CATALINA_HOME2。

5.修改新的tomcat中的catalina.bat，把其中的CATALINA_HOME改为CATALINA_HOME2。

6.修改conf/server.xml文件：

      6.1 <Server port="8005" shutdown="SHUTDOWN">把端口改为没有是使用的端口，如8006。

      6.2 <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" /> 把端口改为没有是使用的端口，如8082。

       6.3<Connector port="8090" protocol="AJP/1.3" redirectPort="8443" /> 把端口改为没有是使用的端口，如8092。
7.这样就可以在同一台电脑上同时运行多个tomcat了。

vue.js
https://cn.vuejs.org/v2/guide/installation.html
    
