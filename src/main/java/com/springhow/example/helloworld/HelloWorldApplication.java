package com.springhow.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorldApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HelloWorldApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class);
    }


    @RequestMapping("/")
    String helloWorld() {
        return "1. Install tomcat package from repository by yum command.
# yum install tomcat
2. Edit tomcat.conf file and append below line there by using vi editor.
# vim /usr/share/tomcat/conf/tomcat.conf
JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom -Djava.awt.headless=true -Xmx1026m 
-XX:MaxPermSize=256m -XX:+UseConcMarkSweepGC"
3. Install all other tomcat packages like tomcat webapps, tomcat docs etc.
# yum install tomcat*
4. Edit tomcat-user.xml file and write below (use less than symbol before starting this line and greater 
than symbol after) line there in tomcat-users section by vi editor, save it.
# vim /usr/share/tomcat/conf/tomcat-users.xml
user username="admin" password="password" roles="manager-gui,admin-gui"/
5. Start tomcat service now.
# systemctl start tomcat
6. Set tomcat service to start automatically after reboot.
# systemctl enable tomcat
7. Add port 8080 (to be used by tomcat) in firewall.
# firewall-cmd --permanent --zone=public --add-port=8080/tcp
8. Reload the firewall.
# firewall-cmd --reload
Now Test your configuration:
Open Firefox and write below line in address bar.
localhost:8080
or
Open any browser and write below line in address bar.
ip-address:8080
(where ip-address is the IP address of your tomcat server)
You should see a webpage showing successful configuration of Tomcat Apache.
You have successfully installed and configured Tomcat Apache in Linux";
    }

}
