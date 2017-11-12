FROM openjdk
ENV H2_VERSION h2-2017-04-23

RUN wget http://www.h2database.com/${H2_VERSION}.zip
RUN unzip ${H2_VERSION}.zip

EXPOSE 9092 5435 8082
ENTRYPOINT java -cp /h2/bin/h2*.jar org.h2.tools.Server -webAllowOthers -tcpAllowOthers -pgAllowOthers
