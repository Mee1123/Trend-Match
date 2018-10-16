FROM yutsuki/tomcat:latest

COPY ./SE18G2.war /opt/tomcat/webapps/
COPY ./server.xml /opt/tomcat/conf/server.xml
RUN source /etc/profile

CMD ["systemctl", "start", "tomcat"]