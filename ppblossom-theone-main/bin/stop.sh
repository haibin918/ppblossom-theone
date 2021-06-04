#!/bin/sh

MAIN_JAR=ppblossom-theone-main
if [ $# -gt 0 ]; then
    PIDPROC=`ps -ef | grep "${MAIN_JAR}" | grep "$1" | grep -v 'grep'| awk '{print $2}'`
else
    PIDPROC=`ps -ef | grep "${MAIN_JAR}" | grep -v 'grep'| awk '{print $2}'`
fi

if [ -z "$PIDPROC" ];then
 echo "$MAIN_JAR is not running"
 exit 0
fi

echo "PIDPROC: "$PIDPROC
for PID in $PIDPROC
do
if kill -9 $PID
   then echo "process $MAIN_JAR (Pid:$PID) was force stopped at " `date`
fi
done
echo stop finished.
