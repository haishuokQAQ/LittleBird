#!bin/sh

#init
pid=111
hostname=testhost
tarhost=localhost
tarport=12345

#cpu
pathcpu=/home/cpu.txt
top -n 1 -p $pid b > $pathcpu
cpu=`cat $pathcpu | grep $pid |awk 'END{ print $8 }'`
#发送

#mem
pathmem=/home/mem.txt
top -n 1 -p $pid b >$pathmem
mem=`cat $pathmem | grep $pid |awk 'END{ print $9 }'`
total=`free |grep Mem | awk 'END{ print $2 }'`
#发送

#disk
pathdisk=/home/disk.txt

iotop -p $pid > $pathdisk

diskread=`cat $pathdisk | grep $pid |  awk 'END{ print $3 }'`

diskwrite=`cat $pathdisk | grep $pid | awk 'END {print $4 }'`
#发送

#net

pathnet=/home/net.txt

#发送
