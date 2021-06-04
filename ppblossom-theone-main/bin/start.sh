#!/bin/sh
BASEDIR=`dirname $0`/..
BASEDIR=`(cd "$BASEDIR"; pwd)`
profile_active=${1:-prod}
MAIN_JAR=$BASEDIR"/ppblossom-theone-main-*.jar --spring.profiles.active=${profile_active}"

if [ $# -gt 1 ]; then
    MAIN_JAR=$MAIN_JAR" --server.port=$2"
fi
echo "MAIN_JAR: $MAIN_JAR"


# If a specific java binary isn't specified search for the standard 'java' binary
if [ -z "$JAVACMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
      JAVACMD="$JAVA_HOME/bin/java"
  else
    JAVACMD=`which java`
  fi
fi

if [ ! -x "$JAVACMD" ] ; then
  echo "Error: JAVA_HOME is not defined correctly."
  echo "  We cannot execute $JAVACMD"
  exit 1
fi

LOGDIR="/data/logs/ppblossom-theone/"

if [ -z "$OPTS_MEMORY" ] ; then
    OPTS_MEMORY="-server -Xms4G -Xmx4G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=128M"
fi

JAVA_OPTS="${JAVA_OPTS} -jar"
JAVA_OPTS="${JAVA_OPTS} -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC"
JAVA_OPTS="${JAVA_OPTS} -verbose:gc -Xloggc:/data/logs/ppblossom-theone/ppblossom-theone_gc_%p.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+PrintAdaptiveSizePolicy"
JAVA_OPTS="${JAVA_OPTS} -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=30m"

nohup $JAVACMD $JAVA_OPTS \
  $OPTS_MEMORY \
  -Dbasedir="$BASEDIR" \
  -Dfile.encoding="UTF-8" \
  -Djava.awt.headless="true" \
  -Dsun.net.client.defaultConnectTimeout="60000" \
  -Dsun.net.client.defaultReadTimeout="60000" \
  -Djmagick.systemclassloader="no" \
  -Dnetworkaddress.cache.ttl="300" \
  -Dsun.net.inetaddr.ttl=300 \
  -XX:CompileCommand="exclude,com/mysql/jdbc/ConnectionImpl::execSQL" \
  -XX:+HeapDumpOnOutOfMemoryError \
  -XX:HeapDumpPath="$LOGDIR/" \
  -XX:ErrorFile="$LOGDIR/java_error_%p.log" \
  $MAIN_JAR \
  "$@" >nohup_out.${profile_active} 2>&1 &
